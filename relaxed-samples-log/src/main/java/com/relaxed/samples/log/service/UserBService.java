package com.relaxed.samples.log.service;

import com.relaxed.common.log.biz.annotation.BizLog;
import com.relaxed.common.log.biz.context.LogRecordContext;
import com.relaxed.samples.log.domain.LogUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Yakir
 * @Topic UserBService
 * @Description
 * @date 2023/12/14 15:12
 * @Version 1.0
 */
@Slf4j
@Service
public class UserBService {

	@BizLog(systemName = "'业务B'", success = "'success exec b '", bizNo = "#user.bizNo",
			detail = "'将'+#user.username+'的商品状态,修改为了 '+#user.status+ifunc_test(#user.status)")
	public void updateUserStatus(LogUser user) {
		LogRecordContext.push("userB", "finish");
		log.info("UserB-service修改了用户状态");

	}

}
