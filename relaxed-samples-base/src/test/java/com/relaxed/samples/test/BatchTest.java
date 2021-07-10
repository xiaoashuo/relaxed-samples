package com.relaxed.samples.test;

import com.relaxed.common.core.batch.functions.BatchConsumer;
import com.relaxed.common.core.batch.functions.BatchSupplier;
import com.relaxed.common.core.batch.params.BatchConsumerParam;
import com.relaxed.common.core.batch.params.BatchExceptionParam;
import com.relaxed.common.core.batch.params.BatchGroup;
import com.relaxed.common.core.batch.params.BatchParam;
import com.relaxed.common.core.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author Yakir
 * @Topic BatchTest
 * @Description
 * @date 2021/7/9 19:57
 * @Version 1.0
 */
@Slf4j
public class BatchTest {

	public void makeException() {
		int m = 0;
		int t = 5 / m;
	}

	public void runBatch() {
		BatchGroup batchGroup = new BatchGroup(1000, 500);
		BatchSupplier batchSupplier = (currentStepPosition, size) -> {
			log.info("当前线程{} -当前步进位置{}-批次大小{}", Thread.currentThread(), currentStepPosition, size);
			if (currentStepPosition == 0) {
				makeException();
			}
			List<String> strs = new ArrayList<>();
			strs.add("1");
			return strs;
		};
		BatchConsumer batchConsumer = (batchConsumerParam) -> {
			List<String> strs = batchConsumerParam.getData();

			log.info("开始消费{}", batchConsumerParam);
		};
		BatchParam batchParam = BatchParam.ofRun(batchGroup, batchSupplier, batchConsumer);
		batchParam.setTaskName("测试任务");
		BatchOps batchTest = new BatchOps();
		// log.info("同步执行任务开始");
		// batchTest.runBatch(batchParam);
		// log.info("同步执行任务结束");
		//
		Consumer<BatchExceptionParam> errorHandle = (batchExceptionParam) -> {
			log.info("发生异常{}", batchExceptionParam, batchExceptionParam.getThrowable());
		};
		log.info("异步执行任务开始");
		batchParam.setAsync(true);
		batchTest.setErrorHandler(errorHandle);
		batchTest.runBatch(batchParam);
		System.out.println("我是下一步任务");
		log.info("异步执行任务结束");

	}

	public static void main(String[] args) {
		BatchTest batchTest = new BatchTest();
		batchTest.runBatch();
	}

}
