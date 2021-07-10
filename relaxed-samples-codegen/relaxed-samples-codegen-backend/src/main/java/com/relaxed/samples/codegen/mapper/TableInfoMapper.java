package com.relaxed.samples.codegen.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.relaxed.samples.codegen.model.entity.ColumnInfo;
import com.relaxed.samples.codegen.model.entity.TableInfo;
import com.relaxed.samples.codegen.model.qo.TableInfoQO;
import com.relaxed.samples.codegen.model.vo.TableInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据库管理
 *
 * @author Yakir
 */
public interface TableInfoMapper {

	/**
	 * 分页查询
	 * @param page {@code page}
	 * @param tableInfoQO {@code tableInfoQO}
	 * @return {@code IPage<TableInfoVO>}
	 */
	IPage<TableInfoVO> selectByPage(IPage<TableInfoVO> page, @Param("tableInfo") TableInfoQO tableInfoQO);

	/**
	 * 查询表数据列表
	 * @param tableInfoQO {@code tableInfoQO}
	 * @return {@code List<TableInfoVO>}
	 */
	List<TableInfo> selectTableList(@Param("tableInfo") TableInfoQO tableInfoQO);

	/**
	 * 查询表信息根据表名称
	 * @param tableName {@code tableName}
	 * @return {@code TableInfo}
	 */
	TableInfo selectTableInfo(String tableName);

	/**
	 * 查询列信息根据表名称
	 * @param tableName {@code tableName}
	 * @return {@code List<ColumnInfo>}
	 */
	List<ColumnInfo> listColumnInfo(@Param("tableName") String tableName);

}