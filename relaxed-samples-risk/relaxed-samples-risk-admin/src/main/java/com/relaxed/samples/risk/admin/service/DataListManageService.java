package com.relaxed.samples.risk.admin.service;

import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.risk.model.entity.DataListMeta;
import com.relaxed.common.risk.model.entity.DataListRecords;
import com.relaxed.common.risk.model.entity.DataLists;
import com.relaxed.common.risk.model.qo.DataListMetaQO;
import com.relaxed.common.risk.model.qo.DataListRecordsQO;
import com.relaxed.common.risk.model.qo.DataListsQO;
import com.relaxed.common.risk.model.vo.DataListMetaVO;
import com.relaxed.common.risk.model.vo.DataListRecordsVO;
import com.relaxed.common.risk.model.vo.DataListsVO;

/**
 * @author Yakir
 * @Topic DataListManageService
 * @Description
 * @date 2021/9/28 9:48
 * @Version 1.0
 */
public interface DataListManageService {

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam}
	 * @param dataListsQO {@link DataListsQO}
	 * @return {@link PageResult<DataListsVO>}
	 */
	PageResult<DataListsVO> selectDataListByPage(PageParam pageParam, DataListsQO dataListsQO);

	/**
	 * 增加黑白名单数据列表
	 * @author yakir
	 * @date 2021/9/12 18:13
	 * @param dataLists
	 * @return boolean
	 */
	boolean addDataList(DataLists dataLists);

	/**
	 * 编辑数据列表
	 * @author yakir
	 * @date 2021/9/12 18:19
	 * @param dataLists
	 * @return boolean
	 */
	boolean editDataList(DataLists dataLists);

	/**
	 * 删除黑白名单数据列表 根据id
	 * @author yakir
	 * @date 2021/9/12 18:17
	 * @param id
	 * @return boolean
	 */
	boolean delDataList(Long id);

	/**
	 * 分页查询
	 * @param pageParam {@link PageParam}
	 * @param dataListRecordsQO {@link DataListRecordsQO}
	 * @return {@link PageResult<DataListRecordsVO>}
	 */
	PageResult<DataListRecordsVO> selectDataListRecordByPage(PageParam pageParam, DataListRecordsQO dataListRecordsQO);

	/**
	 * 添加黑白名单数据记录
	 * @author yakir
	 * @date 2021/9/28 10:41
	 * @param dataListRecords
	 * @return boolean
	 */
	boolean addDataListRecord(DataListRecords dataListRecords);

	/**
	 * 编辑黑白名单数据记录
	 * @author yakir
	 * @date 2021/9/28 10:42
	 * @param dataListRecords
	 * @return boolean
	 */
	boolean editDataListRecord(DataListRecords dataListRecords);

	/**
	 * 删除黑白名单数据记录
	 * @author yakir
	 * @date 2021/9/28 10:45
	 * @param id
	 * @return boolean
	 */
	boolean delDataListRecord(Long id);

	/**
	 * 分页查询数据列表元记录
	 * @author yakir
	 * @date 2021/9/28 10:48
	 * @param pageParam
	 * @param dataListMetaQO
	 * @return com.relaxed.common.model.domain.PageResult<com.relaxed.common.risk.model.vo.DataListMetaVO>
	 */
	PageResult<DataListMetaVO> selectDataListMetaByPage(PageParam pageParam, DataListMetaQO dataListMetaQO);

	/**
	 * 添加数据列表字段数据
	 * @author yakir
	 * @date 2021/9/28 10:51
	 * @param dataListMeta
	 * @return boolean
	 */
	boolean addDataListMeta(DataListMeta dataListMeta);

	/**
	 * 编辑数据列表字段定义
	 * @author yakir
	 * @date 2021/9/28 10:52
	 * @param dataListMeta
	 * @return boolean
	 */
	boolean editDataListMeta(DataListMeta dataListMeta);

	/**
	 * 删除数据列表字段定义
	 * @author yakir
	 * @date 2021/9/28 10:52
	 * @param id
	 * @return boolean
	 */
	boolean delDataListMeta(Long id);

}
