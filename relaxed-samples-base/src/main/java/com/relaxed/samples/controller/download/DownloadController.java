package com.relaxed.samples.controller.download;

import com.relaxed.starter.download.annotation.ResponseDownload;
import com.relaxed.starter.download.domain.DownloadModel;
import com.relaxed.starter.download.enums.DownTypeEnum;
import com.relaxed.starter.download.functions.DownloadCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public class DownloadController {

	@ResponseDownload(channel = DownTypeEnum.LOCAL)
	@GetMapping("local")
	public DownloadModel local() {
		DownloadModel downloadModel = new DownloadModel(
				"D:\\idea\\source\\person\\relaxed-samples\\relaxed-samples-base\\src\\main\\java\\com\\relaxed\\samples\\controller",
				"SftpController.java");
		// downloadModel.setDownloadCallback(new DownloadCallback() {
		// @Override
		// public void postProcess() {
		// System.out.println("开始执行结束收尾工作");
		// }
		// });
		return downloadModel;
	}

	@ResponseDownload(channel = DownTypeEnum.OSS)
	@GetMapping("oss")
	public DownloadModel oss() {
		DownloadModel downloadModel = new DownloadModel("img", "test3.jpg");
		return downloadModel;
	}

}
