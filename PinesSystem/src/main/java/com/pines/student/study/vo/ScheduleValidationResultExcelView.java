package com.pines.student.study.vo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class ScheduleValidationResultExcelView extends AbstractXlsView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<StudyScheduleTeacherVaildateResult> teacherResults = (List<StudyScheduleTeacherVaildateResult>) model.get("teacherResults");
		List<StudyScheduleStudentVaildateResult> studentResults = (List<StudyScheduleStudentVaildateResult>) model.get("studentResults");

		// create excel xls sheet
		Sheet sheet = workbook.createSheet("Validation Result Detail");
		sheet.setDefaultColumnWidth(30);

		// create style for header cells
		CellStyle titleStyle = workbook.createCellStyle();
		Font titleFont = workbook.createFont();
		titleFont.setBold(true);
		titleFont.setFontHeight((short) (20 * 20));
		titleStyle.setFont(titleFont);

		CellStyle headerStyle = workbook.createCellStyle();
		Font headerFont = workbook.createFont();
		headerStyle.setFillForegroundColor(IndexedColors.BLUE.index);
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerFont.setColor(IndexedColors.WHITE.index);
		headerStyle.setFont(headerFont);

		// create header row
		int rowCount = 0;
		int cellCount = 0;
		Row teacherTitle = sheet.createRow(rowCount++);
		teacherTitle.createCell(cellCount).setCellValue("Result of Duplication Teachers.");
		teacherTitle.getCell(cellCount).setCellStyle(titleStyle);

		Row teacherHeader = sheet.createRow(rowCount++);
		teacherHeader.createCell(cellCount).setCellValue("No");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Class Time");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Class Room");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Name of Teacher");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);

		int no = 0;
		Row newRow = null;
		if (teacherResults.size() > 0) {
			for (StudyScheduleTeacherVaildateResult teacherResult : teacherResults) {
				cellCount = 0;
				newRow = sheet.createRow(rowCount++);
				newRow.createCell(cellCount++).setCellValue(++no);
				newRow.createCell(cellCount++).setCellValue(teacherResult.getStudyTime());
				newRow.createCell(cellCount++).setCellValue(teacherResult.getStudyRoom());
				newRow.createCell(cellCount++).setCellValue(teacherResult.getTeacherName());
			}
		} else {
			cellCount = 0;
			newRow = sheet.createRow(rowCount++);
			newRow.createCell(cellCount).setCellValue("None.");
		}

		sheet.createRow(rowCount++);
		cellCount = 0;
		Row studentTitle = sheet.createRow(rowCount++);
		studentTitle.createCell(cellCount).setCellValue("Result of Duplication Students.");
		studentTitle.getCell(cellCount).setCellStyle(titleStyle);

		Row studentHeader = sheet.createRow(rowCount++);
		studentHeader.createCell(cellCount).setCellValue("No");
		studentHeader.getCell(cellCount++).setCellStyle(headerStyle);
		studentHeader.createCell(cellCount).setCellValue("Class Time");
		studentHeader.getCell(cellCount++).setCellStyle(headerStyle);
		studentHeader.createCell(cellCount).setCellValue("Class Room");
		studentHeader.getCell(cellCount++).setCellStyle(headerStyle);
		studentHeader.createCell(cellCount).setCellValue("Name of Student");
		studentHeader.getCell(cellCount++).setCellStyle(headerStyle);

		if (studentResults.size() > 0) {
			no = 0;
			for (StudyScheduleStudentVaildateResult studentResult : studentResults) {
				cellCount = 0;
				newRow = sheet.createRow(rowCount++);
				newRow.createCell(cellCount++).setCellValue(++no);
				newRow.createCell(cellCount++).setCellValue(studentResult.getStudyTime());
				newRow.createCell(cellCount++).setCellValue(studentResult.getStudyRoom());
				newRow.createCell(cellCount++).setCellValue(studentResult.getStudentName());
			}
		} else {
			cellCount = 0;
			newRow = sheet.createRow(rowCount++);
			newRow.createCell(cellCount).setCellValue("None.");
		}
	}
}
