package com.relaxed.samples.codegen.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.model.domain.SelectData;
import com.relaxed.common.datasource.toolkit.DynamicDataSourceHelper;
import com.relaxed.samples.codegen.mapper.DataSourceConfigMapper;
import com.relaxed.samples.codegen.model.converter.DataSourceConfigConverter;
import com.relaxed.samples.codegen.model.dto.DataSourceConfigDTO;
import com.relaxed.samples.codegen.model.entity.DataSourceConfig;
import com.relaxed.samples.codegen.model.qo.DataSourceConfigQO;
import com.relaxed.samples.codegen.model.vo.DataSourceConfigVO;
import com.relaxed.samples.codegen.service.DataSourceConfigService;
import com.relaxed.samples.codegen.util.PageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * 数据源配置实现
 *
 * @author Yakir
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class DataSourceConfigServiceImpl extends ServiceImpl<DataSourceConfigMapper, DataSourceConfig>
		implements DataSourceConfigService {

	@Autowired
	private DynamicDataSourceHelper dynamicDataSourceHelper;

	@Override
	public PageResult<DataSourceConfigVO> selectPageVo(PageParam pageParam, DataSourceConfigQO dataSourceConfigQO) {
		IPage<DataSourceConfig> iPage = PageUtil.prodPage(pageParam);
		Wrapper<DataSourceConfig> queryWrapper = Wrappers
				.lambdaQuery(DataSourceConfig.class).like(ObjectUtil.isNotNull(dataSourceConfigQO.getName()),
						DataSourceConfig::getName, dataSourceConfigQO.getName())
				.select(e -> !e.getColumn().equals("password"));
		this.baseMapper.selectPage(iPage, queryWrapper);
		IPage<DataSourceConfigVO> voPage = iPage.convert(DataSourceConfigConverter.INSTANCE::poToVo);
		return new PageResult<>(voPage.getCurrent(), voPage.getTotal(), voPage.getRecords());
	}

	@Override
	public List<SelectData<?>> listSelectData() {
		return baseMapper.listSelectData();
	}

	@Override
	public boolean saveDataSourceConfig(DataSourceConfigDTO dataSourceConfigDTO) {
		DataSourceProperty dataSourceProperty = dynamicDataSourceHelper.prodDataSourceProperty(
				dataSourceConfigDTO.getName(), dataSourceConfigDTO.getUrl(), dataSourceConfigDTO.getUsername(),
				dataSourceConfigDTO.getPassword());
		// 效验数据源是否正确
		if (dynamicDataSourceHelper.isErrorDataSourceProperty(dataSourceProperty)) {
			return false;
		}
		DataSourceConfig dataSourceConfig = DataSourceConfigConverter.INSTANCE.dtoToPo(dataSourceConfigDTO);
		String password = dataSourceConfigDTO.getPassword();
		dataSourceConfig.setPassword(dynamicDataSourceHelper.encryptPass(password));
		boolean flag = SqlHelper.retBool(baseMapper.insert(dataSourceConfig));
		// 落库存储失败
		if (!flag) {
			return false;
		}
		// 动态添加数据源
		dynamicDataSourceHelper.addDynamicDataSource(dataSourceProperty);
		return true;
	}

	@Override
	public boolean update(DataSourceConfigDTO dataSourceConfigDTO) {
		DataSourceConfig oldDataSourceConfig = baseMapper.selectById(dataSourceConfigDTO.getId());
		Assert.notNull(oldDataSourceConfig, "update data source config that does not exist");
		// 转换为实体
		DataSourceConfig updateDataSourceConfig = DataSourceConfigConverter.INSTANCE.dtoToPo(dataSourceConfigDTO);
		String password = updateDataSourceConfig.getPassword();
		// 若密码未修改 则 使用原始密码 否则 加密存储修改后的密码
		if (StrUtil.isBlank(password)) {
			password = dynamicDataSourceHelper.decryptPassword(oldDataSourceConfig.getPassword());
		}
		else {
			updateDataSourceConfig.setPassword(dynamicDataSourceHelper.encryptPass(password));
		}
		DataSourceProperty dataSourceProperty = dynamicDataSourceHelper.prodDataSourceProperty(
				dataSourceConfigDTO.getName(), dataSourceConfigDTO.getUrl(), dataSourceConfigDTO.getUsername(),
				password);
		if (dynamicDataSourceHelper.isErrorDataSourceProperty(dataSourceProperty)) {
			return false;
		}

		// 落库存储
		boolean flag = SqlHelper.retBool(baseMapper.updateById(updateDataSourceConfig));
		if (!flag) {
			return false;
		}

		// 先删除现有数据源
		dynamicDataSourceHelper.removeDataSource(oldDataSourceConfig.getName());
		// 再见加数据源
		dynamicDataSourceHelper.addDynamicDataSource(dataSourceProperty);
		return true;
	}

	@Override
	public boolean removeDataSourceConfigById(Integer id) {
		DataSourceConfig oldConfig = baseMapper.selectById(id);
		Assert.notNull(oldConfig, "delete data source config that does not exist");
		if (SqlHelper.retBool(baseMapper.deleteById(id))) {
			// 删除现有数据源
			dynamicDataSourceHelper.removeDataSource(oldConfig.getName());
			return true;
		}
		return false;
	}

}
