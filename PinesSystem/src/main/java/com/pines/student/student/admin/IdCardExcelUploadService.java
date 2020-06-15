package com.pines.student.student.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pines.student.common.Tools;
import com.pines.student.common.upload.excel.ExcelRead;
import com.pines.student.common.upload.excel.ExcelReadOption;
import com.pines.student.common.vo.IdCardExcel;

@Service
public class IdCardExcelUploadService {

	public List<IdCardExcel> getIdCards(File destFile) throws Exception {
		ExcelReadOption excelReadOption = new ExcelReadOption();
		excelReadOption.setFilePath(destFile.getAbsolutePath());
		excelReadOption.setOutputColumns("A", "B", "C");
		excelReadOption.setStartRow(2);
		List<IdCardExcel> idCardExcels = new ArrayList<IdCardExcel>();
		IdCardExcel idCardExcel = null;

		List<Map<String, String>> excelContent = ExcelRead.read(excelReadOption);
		for (Map<String, String> article : excelContent) {
			idCardExcel = new IdCardExcel();
			idCardExcel.setA_Name(Tools.trim(article.get("A")));
			idCardExcel.setB_StudentId(Tools.trim(article.get("B")));
			idCardExcel.setC_CardSerialNumber(Tools.trim(article.get("C")));

			if (isNotAddableStudentInfo(idCardExcel)) {
				printNotAddableStudentInfo(idCardExcel);
			}
			idCardExcels.add(idCardExcel);
		}

		return idCardExcels;
	}

	private String printNotAddableStudentInfo(IdCardExcel student) {
		StringBuffer result = new StringBuffer();
		result.append("A_Name : ");
		result.append(student.getA_Name());
		result.append(", B_StudentId : ");
		result.append(student.getB_StudentId());
		result.append(", C_CardSerialNumber : ");
		result.append(student.getC_CardSerialNumber());
		return result.toString();
	}

	private boolean isNotAddableStudentInfo(IdCardExcel student) {
		if (Tools.isEmpty(student.getB_StudentId()))
			return true;
		if (Tools.isEmpty(student.getC_CardSerialNumber()))
			return true;

		return false;
	}

}
