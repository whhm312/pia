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

public class StudentsForMakingScheduleExcelView extends AbstractXlsView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<StudentsForMakingSchedule> students = (List<StudentsForMakingSchedule>) model.get("students");

		// create excel xls sheet
		Sheet sheet = workbook.createSheet("Students");
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
		teacherTitle.createCell(cellCount).setCellValue("Students");
		teacherTitle.getCell(cellCount).setCellStyle(titleStyle);

		Row teacherHeader = sheet.createRow(rowCount++);
		teacherHeader.createCell(cellCount).setCellValue("No");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Campus");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Batch");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Name of Student");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Nationality");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Sex");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Request Course");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Pre Level");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Arrival Date");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Depature Date");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);

		int no = 0;
		Row newRow = null;
		if (students.size() > 0) {
			for (StudentsForMakingSchedule student : students) {
				cellCount = 0;
				newRow = sheet.createRow(rowCount++);
				newRow.createCell(cellCount++).setCellValue(++no);
				newRow.createCell(cellCount++).setCellValue(student.getCampus());
				newRow.createCell(cellCount++).setCellValue(student.getTerm());
				newRow.createCell(cellCount++).setCellValue(student.getStudentName());
				newRow.createCell(cellCount++).setCellValue(student.getNationality());
				newRow.createCell(cellCount++).setCellValue(student.getSex());
				newRow.createCell(cellCount++).setCellValue(student.getCourse());
				newRow.createCell(cellCount++).setCellValue(student.getPreLevel());
				newRow.createCell(cellCount++).setCellValue(student.getArrivalDate());
				newRow.createCell(cellCount++).setCellValue(student.getDepartureDate());
			}
		} else {
			cellCount = 0;
			newRow = sheet.createRow(rowCount++);
			newRow.createCell(cellCount).setCellValue("None.");
		}

	}
}
