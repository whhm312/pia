package com.pines.student.student.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pines.student.common.Tools;
import com.pines.student.common.upload.excel.ExcelRead;
import com.pines.student.common.upload.excel.ExcelReadOption;
import com.pines.student.common.vo.StudentNameExcel;

@Service
public class ChangStudentNameExcelUploadService {

	public List<StudentNameExcel> getContentInExcel(File destFile) throws Exception {
		ExcelReadOption excelReadOption = new ExcelReadOption();
		excelReadOption.setFilePath(destFile.getAbsolutePath());
		excelReadOption.setOutputColumns("A", "B", "C");
		excelReadOption.setStartRow(2);
		List<StudentNameExcel> studentNames = new ArrayList<StudentNameExcel>();
		StudentNameExcel studentName = null;

		List<Map<String, String>> excelContent = ExcelRead.read(excelReadOption);
		for (Map<String, String> article : excelContent) {
			studentName = new StudentNameExcel();
			studentName.setA_StudentId(Tools.trim(article.get("A")));
			studentName.setB_OriginalName(Tools.getUpperCase(Tools.trim(article.get("B"))));
			studentName.setC_NewName(Tools.getUpperCase(Tools.trim(article.get("C"))));

			if (isNotAddableStudentInfo(studentName)) {
				printNotAddableStudentInfo(studentName);
			}
			studentNames.add(studentName);
		}

		return studentNames;
	}

	private String printNotAddableStudentInfo(StudentNameExcel student) {
		StringBuffer result = new StringBuffer();
		result.append("A_StudentId : ");
		result.append(student.getA_StudentId());
		result.append(", B_OriginalName : ");
		result.append(student.getB_OriginalName());
		result.append(", C_NewNAme : ");
		result.append(student.getC_NewName());
		return result.toString();
	}

	private boolean isNotAddableStudentInfo(StudentNameExcel student) {
		if (Tools.isEmpty(student.getA_StudentId()))
			return true;
		if (Tools.isEmpty(student.getB_OriginalName()))
			return true;
		if (Tools.isEmpty(student.getC_NewName()))
			return true;

		return false;
	}

}
