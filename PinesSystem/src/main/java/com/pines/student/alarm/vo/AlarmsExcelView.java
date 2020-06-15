package com.pines.student.alarm.vo;

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

import com.pines.student.common.vo.Alarm;

public class AlarmsExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

		// change the file name
		response.setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xls\"");

		@SuppressWarnings("unchecked")
		List<Alarm> alarms = (List<Alarm>) model.get("alarms");

		// create excel xls sheet
		Sheet sheet = workbook.createSheet("Alarms Detail");
		sheet.setDefaultColumnWidth(30);

		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(IndexedColors.BLUE.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font.setBold(true);
		font.setColor(IndexedColors.WHITE.index);
		style.setFont(font);

		// create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("No");
		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("Message");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("Send Date");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Sender");
		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Read Date");
		header.getCell(4).setCellStyle(style);

		int rowCount = 1;
		int no = alarms.size();

		for (Alarm alarm : alarms) {
			Row userRow = sheet.createRow(rowCount++);
			userRow.createCell(0).setCellValue(no--);
			userRow.createCell(1).setCellValue(alarm.getMessage());
			userRow.createCell(2).setCellValue(alarm.getFormSendDate());
			userRow.createCell(3).setCellValue(alarm.getSender());
			userRow.createCell(4).setCellValue(alarm.getFormReadDate());
		}

	}

}

