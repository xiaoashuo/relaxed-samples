package com.relaxed.samples.controller.excel;

import java.time.LocalDateTime;

import com.apifan.common.random.source.DateTimeSource;
import com.apifan.common.random.source.NumberSource;
import com.apifan.common.random.source.OtherSource;
import com.apifan.common.random.source.PersonInfoSource;
import com.relaxed.common.easyexcel.annotation.ResponseExcel;
import com.relaxed.common.easyexcel.annotation.Sheet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yakir
 * @Topic ExcelController
 * @Description
 * @date 2022/1/19 16:54
 * @Version 1.0
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

	@ResponseExcel(name = "单sheet模板")
	@GetMapping("/sheet")
	public List<ExcelModel> sheet() {
		return mockExcelModelList();
	}

	@ResponseExcel(name = "多sheet模板1", sheets = { @Sheet(sheetName = "sheet1"), @Sheet(sheetName = "sheet2") })
	@GetMapping("/sheet/many")
	public List<List<ExcelModel>> sheetMany() {
		List<List<ExcelModel>> datas = new ArrayList<>();
		datas.add(mockExcelModelList());
		datas.add(mockExcelModelList());
		return datas;
	}

	private static List<ExcelModel> mockExcelModelList() {
		List<ExcelModel> excelModels = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ExcelModel excelModel = new ExcelModel();
			excelModel.setId(NumberSource.getInstance().randomInt(1, 101));
			excelModel.setUsername(PersonInfoSource.getInstance().randomChineseName());
			excelModel.setAge(NumberSource.getInstance().randomInt(1, 101));
			excelModel.setCreateTime(DateTimeSource.getInstance().randomPastTime(7));
			excelModel.setUpdateTime(DateTimeSource.getInstance().randomFutureTime(7));

			excelModels.add(excelModel);
		}
		return excelModels;
	}

}
