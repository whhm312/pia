package com.pines.student.student.admin.vo;

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

import com.pines.student.common.vo.Student;

public class StudentsExcelView extends AbstractXlsView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Student> students = (List<Student>) model.get("students");

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
		teacherHeader.createCell(cellCount).setCellValue("Student ID");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Name of Student");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Date of Birthday");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Nationality");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Date of Start");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Date of End");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);

		int no = 0;
		Row newRow = null;
		if (students.size() > 0) {
			for (Student student : students) {
				cellCount = 0;
				newRow = sheet.createRow(rowCount++);
				newRow.createCell(cellCount++).setCellValue(++no);
				newRow.createCell(cellCount++).setCellValue(student.getCampus());
				newRow.createCell(cellCount++).setCellValue(student.getTerm());
				newRow.createCell(cellCount++).setCellValue(student.getStudentId());
				newRow.createCell(cellCount++).setCellValue(student.getName());
				newRow.createCell(cellCount++).setCellValue(student.getFormDateOfBirth());
				newRow.createCell(cellCount++).setCellValue(student.getNationalityCode());
				newRow.createCell(cellCount++).setCellValue(student.getFormDateOfStartContract());
				newRow.createCell(cellCount++).setCellValue(student.getFormDateOfEndContract());
			}
		} else {
			cellCount = 0;
			newRow = sheet.createRow(rowCount++);
			newRow.createCell(cellCount).setCellValue("None.");
		}

	}

}
