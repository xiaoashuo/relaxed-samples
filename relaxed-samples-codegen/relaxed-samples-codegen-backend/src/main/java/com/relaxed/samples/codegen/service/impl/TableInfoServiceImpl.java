package com.relaxed.samples.codegen.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;

import com.relaxed.samples.codegen.mapper.TableInfoMapper;
import com.relaxed.samples.codegen.model.entity.ColumnInfo;
import com.relaxed.samples.codegen.model.entity.TableInfo;
import com.relaxed.samples.codegen.model.qo.TableInfoQO;
import com.relaxed.samples.codegen.model.vo.TableInfoVO;
import com.relaxed.samples.codegen.service.TableInfoService;
import com.relaxed.samples.codegen.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 表信息 业务层
 *
 * @author Yakir
 */
@RequiredArgsConstructor
@Service
@DS("#header.dsName")
public class TableInfoServiceImpl implements TableInfoService {

	private final TableInfoMapper tableInfoMapper;

	@Override
	public PageResult<TableInfoVO> selectTableByPage(PageParam pageParam, TableInfoQO tableInfoQO) {
		IPage<TableInfoVO> page = PageUtil.prodPage(pageParam);
		tableInfoMapper.selectByPage(page, tableInfoQO);
		return new PageResult<>(page.getRecords(), page.getTotal());
	}

	@Override
	public List<TableInfo> selectTableList(TableInfoQO tableInfoQO) {
		return tableInfoMapper.selectTableList(tableInfoQO);
	}

	@Override
	public TableInfo selectTableInfo(String tableName) {
		return tableInfoMapper.selectTableInfo(tableName);
	}

	@Override
	public List<ColumnInfo> listColumnInfo(String tableName) {
		return tableInfoMapper.listColumnInfo(tableName);
	}

}
