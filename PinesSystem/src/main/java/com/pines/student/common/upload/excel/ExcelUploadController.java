package com.pines.student.common.upload.excel;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.response.CommonResponseResult;

@RestController
public class ExcelUploadController {
	@Value("${pia.file.upload.path}")
	private String FILE_UPLOAD_PATH;

	@PostMapping("/upload/excelFile")
	public CommonResponseResult registerStudentPicture(MultipartHttpServletRequest request) {
		CommonResponseResult result = new CommonResponseResult();

		MultipartFile excelFile = request.getFile("excelFile");
		if (excelFile == null || excelFile.isEmpty()) {
			result.setFailureHead(ResultCode.STATUS_204);
			return result;
		}

		File destFile = new File(FILE_UPLOAD_PATH + excelFile.getOriginalFilename());
		try {
			excelFile.transferTo(destFile);
			excelUpload(destFile);
		} catch (Exception e) {
			e.printStackTrace();

			result.setFailureHead(ResultCode.STATUS_500);
			return result;
		}

		result.setSuccessHead();
		result.setSuccessBody();
		return result;
	}

	public void excelUpload(File destFile) throws Exception {
		ExcelReadOption excelReadOption = new ExcelReadOption();
		excelReadOption.setFilePath(destFile.getAbsolutePath());
		excelReadOption.setOutputColumns("A", "B", "C", "D", "E", "F");
		excelReadOption.setStartRow(2);

		List<Map<String, String>> excelContent = ExcelRead.read(excelReadOption);

		for (Map<String, String> article : excelContent) {
			System.out.println(article.get("A"));
			System.out.println(article.get("B"));
			System.out.println(article.get("C"));
			System.out.println(article.get("D"));
			System.out.println(article.get("E"));
			System.out.println(article.get("F"));

		}
	}
	

	public void printRoom(File destFile) throws Exception {
		ExcelReadOption excelReadOption = new ExcelReadOption();
		excelReadOption.setFilePath(destFile.getAbsolutePath());
		excelReadOption.setOutputColumns("A", "B");
		excelReadOption.setStartRow(2);

		List<Map<String, String>> excelContent = ExcelRead.read(excelReadOption);

		String roomNumber = null;
		for (Map<String, String> article : excelContent) {
			roomNumber = Tools.isEmpty(article.get("A")) ? roomNumber : article.get("A");
			System.out.println(roomNumber);
			System.out.println(article.get("B"));

		}

	}
}
