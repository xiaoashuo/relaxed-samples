package com.relaxed.samples.test;

import cn.hutool.core.thread.ThreadUtil;
import com.relaxed.common.core.batch.AbstractBatchOps;
import com.relaxed.common.core.batch.functions.BatchConsumer;
import com.relaxed.common.core.batch.functions.BatchSupplier;
import com.relaxed.common.core.batch.params.BatchGroup;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Yakir
 * @Topic BatchOps
 * @Description
 * @date 2021/7/9 20:47
 * @Version 1.0
 */
public class BatchOps extends AbstractBatchOps {

	/**
	 * 核心线程池大小
	 */
	private static int coreSize = Runtime.getRuntime().availableProcessors();

	/**
	 * 最大线程池大小
	 */
	private static int maxSize = coreSize * 2 + 1;

	private static ThreadPoolExecutor executor = ThreadUtil.newExecutor(coreSize, maxSize);

	public BatchOps(BatchGroup batchGroup, BatchConsumer batchConsumer, BatchSupplier batchSupplier) {
		super(batchGroup, batchConsumer, batchSupplier);
	}

	public BatchOps(String taskName, BatchGroup batchGroup, BatchConsumer batchConsumer, BatchSupplier batchSupplier) {
		super(taskName, batchGroup, batchConsumer, batchSupplier);
	}

	/**
	 * 执行器
	 * @return
	 */
	@Override
	protected ThreadPoolExecutor executor() {
		return executor;
	}

}
