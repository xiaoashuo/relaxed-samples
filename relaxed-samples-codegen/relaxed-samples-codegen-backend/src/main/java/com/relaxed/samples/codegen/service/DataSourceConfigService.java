package com.relaxed.samples.codegen.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.relaxed.common.core.domain.PageParam;
import com.relaxed.common.core.domain.PageResult;
import com.relaxed.common.core.domain.SelectData;
import com.relaxed.samples.codegen.model.dto.DataSourceConfigDTO;
import com.relaxed.samples.codegen.model.entity.DataSourceConfig;
import com.relaxed.samples.codegen.model.qo.DataSourceConfigQO;
import com.relaxed.samples.codegen.model.vo.DataSourceConfigVO;

import java.util.List;

/**
 * 数据源配置
 *
 * @author Yakir
 */
public interface DataSourceConfigService extends IService<DataSourceConfig> {

	/**
	 * 查询分页VO
	 * @param pageParam {@code pageParam } 分页参数
	 * @param dataSourceConfigQO {@code dataSourceConfigQO} 条件参数
	 * @return {@code PageResult<DataSourceConfigVO>} 查询结果
	 */
	PageResult<DataSourceConfigVO> selectPageVo(PageParam pageParam, DataSourceConfigQO dataSourceConfigQO);

	/**
	 * 保存数据源信息
	 * @param dataSourceConfigDTO {@code dataSourceConfigDTO }
	 * @return {@code boolean}
	 */
	boolean saveDataSourceConfig(DataSourceConfigDTO dataSourceConfigDTO);

	/**
	 * 更新参数
	 * @param dataSourceConfigDTO {@code dataSourceConfigDTO } 条件参数
	 * @return
	 */
	boolean update(DataSourceConfigDTO dataSourceConfigDTO);

	/**
	 * 删除数据源配置根据id
	 * @param id {@code id}
	 * @return
	 */
	boolean removeDataSourceConfigById(Integer id);

	/**
	 * 展示下拉选择数据
	 * @return {@link List<SelectData<?>}
	 */
	List<SelectData<?>> listSelectData();

}
