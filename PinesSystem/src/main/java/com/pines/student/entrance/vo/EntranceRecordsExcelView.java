package com.pines.student.entrance.vo;

import java.net.URLEncoder;
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

import com.pines.student.common.Tools;
import com.pines.student.common.vo.EntranceRecord;

public class EntranceRecordsExcelView extends AbstractXlsView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<EntranceRecord> entranceRecordExcels = (List<EntranceRecord>) model.get("entranceRecords");

		// create excel xls sheet
		Sheet sheet = workbook.createSheet("Entrance_Records_" + URLEncoder.encode(Tools.getTodayStringType("yyyy-MM-dd_HH:mm"), "UTF-8"));
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
		teacherTitle.createCell(cellCount).setCellValue("Entrance Records");
		teacherTitle.getCell(cellCount).setCellStyle(titleStyle);

		Row teacherHeader = sheet.createRow(rowCount++);
		teacherHeader.createCell(cellCount).setCellValue("No");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Branch");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Campus");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Name of Entrance");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Batch");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Room");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Name of Student");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Birthday");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Nationality");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Date of Out");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Date of In");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Gap");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		// teacherHeader.createCell(cellCount).setCellValue("Consulting staff");
		// teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		// teacherHeader.createCell(cellCount).setCellValue("Date of Consulting");
		// teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		// teacherHeader.createCell(cellCount).setCellValue("Content");
		// teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);

		int no = 0;
		Row newRow = null;
		if (entranceRecordExcels.size() > 0) {
			for (EntranceRecord entranceRecordExcel : entranceRecordExcels) {
				cellCount = 0;
				newRow = sheet.createRow(rowCount++);
				newRow.createCell(cellCount++).setCellValue(++no);
				newRow.createCell(cellCount++).setCellValue(entranceRecordExcel.getBranch());
				newRow.createCell(cellCount++).setCellValue(entranceRecordExcel.getCampus());
				newRow.createCell(cellCount++).setCellValue(entranceRecordExcel.getEntranceName());
				newRow.createCell(cellCount++).setCellValue(entranceRecordExcel.getTerm());
				newRow.createCell(cellCount++).setCellValue(entranceRecordExcel.getRoom());
				newRow.createCell(cellCount++).setCellValue(entranceRecordExcel.getStudentName() + " (" + entranceRecordExcel.getSex() + ")");
				newRow.createCell(cellCount++).setCellValue(entranceRecordExcel.getBirthday());
				newRow.createCell(cellCount++).setCellValue(entranceRecordExcel.getNationality());
				newRow.createCell(cellCount++).setCellValue(entranceRecordExcel.getFormOutDate() + " (" + Tools.getWeek("yyyy/MM/dd HH:mm", entranceRecordExcel.getFormOutDate()) + ")");
				newRow.createCell(cellCount++).setCellValue(entranceRecordExcel.getFormInDate() + " (" + Tools.getWeek("yyyy/MM/dd HH:mm", entranceRecordExcel.getFormInDate()) + ")");
				newRow.createCell(cellCount++).setCellValue(Tools.getTime(entranceRecordExcel.getOutInGapSeconds()));
				// newRow.createCell(cellCount++).setCellValue(entranceRecordExcel.getConsultStaffName());
				// newRow.createCell(cellCount++).setCellValue(entranceRecordExcel.getFormConsultDate());
				// newRow.createCell(cellCount++).setCellValue(entranceRecordExcel.getConsultResult());
			}
		} else {
			cellCount = 0;
			newRow = sheet.createRow(rowCount++);
			newRow.createCell(cellCount).setCellValue("None.");
		}

	}

}
