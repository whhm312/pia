package com.pines.student.student.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pines.student.common.Tools;
import com.pines.student.common.upload.excel.ExcelRead;
import com.pines.student.common.upload.excel.ExcelReadOption;
import com.pines.student.common.vo.NewStudentExcel;

@Service
public class NewStudentExcelUploadService {

	public List<NewStudentExcel> getFreshmen(File destFile) throws Exception {
		ExcelReadOption excelReadOption = new ExcelReadOption();
		excelReadOption.setFilePath(destFile.getAbsolutePath());
		excelReadOption.setOutputColumns("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "AA", "AB", "AC");
		excelReadOption.setStartRow(2);
		List<NewStudentExcel> freshmen = new ArrayList<NewStudentExcel>();
		NewStudentExcel student = null;

		String studentName = "";
		List<Map<String, String>> excelContent = ExcelRead.read(excelReadOption);
		for (Map<String, String> article : excelContent) {
			student = new NewStudentExcel();
			student.setA_Batch(Tools.trim(article.get("A")));
			student.setB_Region(Tools.trim(article.get("B")));
			student.setC_Status(Tools.trim(article.get("C")));
			student.setD_Campus(Tools.getUpperCase(Tools.trim(article.get("D"))));
			student.setE_Nationality(Tools.getUpperCase(Tools.trim(article.get("E"))));

			studentName = Tools.trim(article.get("F"));
			studentName = studentName.replaceAll("\\(", "");
			studentName = studentName.replaceAll("\\)", "");
			studentName = studentName.replaceAll("[*]", "");
			studentName = studentName.replaceAll(",", "");
			studentName = studentName.replaceAll("-", " ");
			if (studentName.indexOf("_") > 0) {
				studentName = studentName.substring(0, studentName.indexOf("_"));
			}
			studentName = Tools.getUpperCase(studentName);
			studentName = Tools.getOnlyEnglishWithBirth(studentName);
			student.setF_Name(studentName);

			student.setG_Program(Tools.trim(article.get("G")));
			student.setH_RegistrationDate(Tools.trim(article.get("H")));
			student.setI_Gender(Tools.getUpperCase(Tools.trim(article.get("I"))));
			student.setJ_EngName(Tools.getUpperCase(Tools.trim(article.get("J"))));
			student.setK_Birthday(Tools.trim(article.get("K")));

			student.setL_EMail(Tools.trim(article.get("L")));
			student.setM_ContactNo(Tools.trim(article.get("M")));
			student.setN_ArrivalDate(Tools.trim(article.get("N")));
			student.setO_Period(Tools.trim(article.get("O")));
			student.setP_DepartDate(Tools.trim(article.get("P")));

			student.setQ_Agency(Tools.trim(article.get("Q")));
			student.setR_Dormitory(Tools.trim(article.get("R")));
			student.setS_FlightSchedule(Tools.trim(article.get("S")));
			student.setT_Remarks(Tools.trim(article.get("T")));
			student.setU_Remarks(Tools.trim(article.get("U")));

			student.setV_Major(Tools.trim(article.get("V")));
			student.setW_EnglishLevel(Tools.trim(article.get("W")));
			student.setX_OfficialScore(Tools.trim(article.get("X")));
			student.setY_ExperienceOfStudyingAbroad(Tools.trim(article.get("Y")));
			student.setZ_PlansOfStudyingAbroad(Tools.trim(article.get("Z")));

			student.setAA_PurposeOfStudying(Tools.trim(article.get("AA")));
			student.setAB_ZipCode(Tools.trim(article.get("AB")));
			student.setAC_Address(Tools.trim(article.get("AC")));

			if (isNotAddableStudentInfo(student)) {
				System.err.println("isNotAddableStudentInfo : " + printNotAddableStudentInfo(student));
				continue;
			}
			freshmen.add(student);
		}

		return freshmen;
	}

	private String printNotAddableStudentInfo(NewStudentExcel student) {
		StringBuffer result = new StringBuffer();
		result.append("A_Batch : ");
		result.append(student.getA_Batch());
		result.append(", B_Region : ");
		result.append(student.getB_Region());
		result.append(", C_Status : ");
		result.append(student.getC_Status());
		result.append(", D_Campus : ");
		result.append(student.getD_Campus());
		result.append(", E_Nationality : ");
		result.append(student.getE_Nationality());
		result.append(", F_Name : ");
		result.append(student.getF_Name());
//		result.append(", G_Program : ");
//		result.append(student.getG_Program());
		result.append(", I_Gender : ");
		result.append(student.getI_Gender());
		result.append(", K_Birthday : ");
		result.append(student.getK_Birthday());
		result.append(", N_ArrivalDate : ");
		result.append(student.getN_ArrivalDate());
		result.append(", O_Period : ");
		result.append(student.getO_Period());
		result.append(", P_DepartDate : ");
		result.append(student.getP_DepartDate());
		return result.toString();
	}

	private boolean isNotAddableStudentInfo(NewStudentExcel student) {
		if (Tools.isEmpty(student.getA_Batch()))
			return true;
		if (Tools.isEmpty(student.getB_Region()))
			return true;
		if (Tools.isEmpty(student.getC_Status()))
			return true;
		if (Tools.isEmpty(student.getD_Campus()))
			return true;
		if (Tools.isEmpty(student.getE_Nationality()))
			return true;
		if (Tools.isEmpty(student.getF_Name()))
			return true;
		if (Tools.isNotOnlyEnglishWithSpace(student.getF_Name()))
			return true;
		//if (Tools.isEmpty(student.getG_Program()))
			//return true;
		if (Tools.isEmpty(student.getI_Gender()))
			return true;
		if (Tools.isNotEmpty(student.getK_Birthday())) {
			if (Tools.isNotOnlyNumber(student.getK_Birthday())) {
				return true;
			}
		}
		if (Tools.isEmpty(student.getN_ArrivalDate()))
			return true;
		if (Tools.isEmpty(student.getO_Period()))
			return true;
		if (Tools.isEmpty(student.getP_DepartDate()))
			return true;

		return false;
	}

}
