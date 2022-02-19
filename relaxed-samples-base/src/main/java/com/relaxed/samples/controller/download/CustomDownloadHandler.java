package com.relaxed.samples.controller.download;

import com.relaxed.starter.download.annotation.ResponseDownload;
import com.relaxed.starter.download.domain.DownloadModel;
import com.relaxed.starter.download.handler.AbstractDownloadHandler;
import com.relaxed.starter.download.handler.DownloadHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class CustomDownloadHandler implements DownloadHandler {

	@Override
	public boolean support(DownloadModel downloadModel, ResponseDownload responseDownload) {
		return false;
	}

	@Override
	public void download(DownloadModel downloadModel, HttpServletResponse httpServletResponse,
			ResponseDownload responseDownload) {

	}

}
