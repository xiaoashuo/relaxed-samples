package com.relaxed.samples.risk.admin.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.relaxed.common.model.domain.PageParam;
import com.relaxed.common.model.domain.PageResult;
import com.relaxed.common.risk.biz.distributor.event.EventDistributor;
import com.relaxed.common.risk.biz.distributor.event.subscribe.SubscribeEnum;
import com.relaxed.common.risk.biz.service.DataListMetaService;
import com.relaxed.common.risk.biz.service.DataListRecordsService;
import com.relaxed.common.risk.biz.service.DataListsService;
import com.relaxed.common.risk.model.converter.DataListMetaConverter;
import com.relaxed.common.risk.model.converter.DataListRecordsConverter;
import com.relaxed.common.risk.model.converter.DataListsConverter;
import com.relaxed.common.risk.model.entity.DataListMeta;
import com.relaxed.common.risk.model.entity.DataListRecords;
import com.relaxed.common.risk.model.entity.DataLists;
import com.relaxed.common.risk.model.qo.DataListMetaQO;
import com.relaxed.common.risk.model.qo.DataListRecordsQO;
import com.relaxed.common.risk.model.qo.DataListsQO;
import com.relaxed.common.risk.model.vo.DataListMetaVO;
import com.relaxed.common.risk.model.vo.DataListRecordsVO;
import com.relaxed.common.risk.model.vo.DataListsVO;
import com.relaxed.samples.risk.admin.service.DataListManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author Yakir
 * @Topic DataListManageServiceImpl
 * @Description
 * @date 2021/9/28 9:48
 * @Version 1.0
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class DataListManageServiceImpl implements DataListManageService {

	private final DataListsService dataListsService;

	private final DataListMetaService dataListMetaService;

	private final DataListRecordsService dataListRecordsService;

	private final EventDistributor eventDistributor;

	@Override
	public PageResult<DataListsVO> selectDataListByPage(PageParam pageParam, DataListsQO dataListsQO) {
		return dataListsService.selectByPage(pageParam, dataListsQO);
	}

	@Override
	public boolean addDataList(DataLists dataLists) {
		if (dataListsService.save(dataLists)) {
			// 发布订阅
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_DATALIST_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(DataListsConverter.INSTANCE.poToVo(dataLists)));
			return true;
		}
		return false;
	}

	@Override
	public boolean editDataList(DataLists dataLists) {
		DataLists sqlDataLists = dataListsService.getById(dataLists.getId());
		Assert.notNull(sqlDataLists, "data list not exists.");
		if (dataListsService.updateById(dataLists)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_DATALIST_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(DataListsConverter.INSTANCE.poToVo(dataLists)));
			return true;
		}
		return false;
	}

	@Override
	public boolean delDataList(Long id) {
		DataLists dataLists = dataListsService.getById(id);
		Assert.notNull(dataLists, "data list not exists.");
		if (dataListsService.removeById(id)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_DATALIST_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(DataListsConverter.INSTANCE.poToVo(dataLists)));
			return true;
		}
		return false;
	}

	@Override
	public PageResult<DataListRecordsVO> selectDataListRecordByPage(PageParam pageParam,
			DataListRecordsQO dataListRecordsQO) {
		return dataListRecordsService.selectByPage(pageParam, dataListRecordsQO);
	}

	@Override
	public boolean addDataListRecord(DataListRecords dataListRecords) {
		if (dataListRecordsService.save(dataListRecords)) {
			// 发布订阅
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_DATALIST_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(DataListRecordsConverter.INSTANCE.poToVo(dataListRecords)));
			return true;
		}
		return false;
	}

	@Override
	public boolean editDataListRecord(DataListRecords dataListRecords) {
		DataListRecords sqlData = dataListRecordsService.getById(dataListRecords.getId());
		Assert.notNull(sqlData, "data list record can not exists.");
		if (dataListRecordsService.updateById(dataListRecords)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_DATALIST_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(DataListRecordsConverter.INSTANCE.poToVo(dataListRecords)));
			return true;
		}
		return false;
	}

	@Override
	public boolean delDataListRecord(Long id) {
		DataListRecords dataListRecords = dataListRecordsService.getById(id);
		Assert.notNull(dataListRecords, "data list record can not exists.");
		if (dataListRecordsService.removeById(id)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_DATALIST_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(DataListRecordsConverter.INSTANCE.poToVo(dataListRecords)));
			return true;
		}
		return false;
	}

	@Override
	public PageResult<DataListMetaVO> selectDataListMetaByPage(PageParam pageParam, DataListMetaQO dataListMetaQO) {
		return dataListMetaService.selectByPage(pageParam, dataListMetaQO);
	}

	@Override
	public boolean addDataListMeta(DataListMeta dataListMeta) {
		if (dataListMetaService.save(dataListMeta)) {
			// 发布订阅
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_DATALIST_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(DataListMetaConverter.INSTANCE.poToVo(dataListMeta)));
			return true;
		}
		return false;
	}

	@Override
	public boolean editDataListMeta(DataListMeta dataListMeta) {
		DataListMeta sqlData = dataListMetaService.getById(dataListMeta.getId());
		Assert.notNull(sqlData, "data list meta can not exists.");
		if (dataListMetaService.updateById(dataListMeta)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_DATALIST_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(DataListMetaConverter.INSTANCE.poToVo(dataListMeta)));
			return true;
		}
		return false;
	}

	@Override
	public boolean delDataListMeta(Long id) {
		DataListMeta dataListMeta = dataListMetaService.getById(id);
		Assert.notNull(dataListMeta, "data list meta can not exists.");
		if (dataListMetaService.removeById(id)) {
			eventDistributor.distribute(SubscribeEnum.PUB_SUB_DATALIST_CHANNEL.getChannel(),
					JSONUtil.toJsonStr(DataListMetaConverter.INSTANCE.poToVo(dataListMeta)));
			return true;
		}
		return false;
	}

}
