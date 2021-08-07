package com.relaxed.samples.codegen.service;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.samples.codegen.model.entity.ColumnInfo;
import com.relaxed.samples.codegen.model.entity.TableInfo;
import com.relaxed.samples.codegen.model.qo.TableInfoQO;
import com.relaxed.samples.codegen.model.vo.TableInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 表信息 业务层
 *
 * @author Yakir
 */
public interface TableInfoService {

	/**
	 * 分页查询
	 * @param pageParam {@code pageParam} 页面参数
	 * @param tableInfoQO {@code tableInfoQO} 条件参数
	 * @return {@code PageResult<TableInfo>}
	 */
	PageResult<TableInfoVO> selectTableByPage(PageParam pageParam, TableInfoQO tableInfoQO);

	/**
	 * 查询列表
	 * @param tableInfoQO {@code tableInfoQO} 条件参数
	 * @return {@code List<TableInfo>}
	 */
	List<TableInfo> selectTableList(TableInfoQO tableInfoQO);

	/**
	 * 根据表明查询表信息
	 * @param tableName {@code tableName}
	 * @return {@code TableInfo}
	 */
	TableInfo selectTableInfo(@Param("tableName") String tableName);

	/**
	 * 查询列信息根据表名
	 * @param tableName {@code tableName}
	 * @return {@code List<ColumnInfo>}
	 */
	List<ColumnInfo> listColumnInfo(String tableName);

}
