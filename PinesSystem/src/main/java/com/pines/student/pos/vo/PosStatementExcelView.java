package com.pines.student.pos.vo;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.pines.student.common.vo.PosTransaction;
import com.pines.student.common.vo.StudentPosBalance;

public class PosStatementExcelView extends AbstractXlsView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<PosTransaction> posTransactions = (List<PosTransaction>) model.get("posTransactions");
		List<PosTransaction> posTransactionsWithOrders = (List<PosTransaction>) model.get("posTransactionsWithOrders");
		StudentPosBalance posBalance = (StudentPosBalance) model.get("posBalance");

		// create excel xls sheet
		Sheet sheet = workbook.createSheet("PosStatement_" + URLEncoder.encode(Tools.getTodayStringType("yyyy-MM-dd_HH:mm"), "UTF-8"));
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
		Row title = sheet.createRow(rowCount++);
		title.createCell(cellCount).setCellValue("Statement");
		title.getCell(cellCount++).setCellStyle(titleStyle);
		title.createCell(cellCount).setCellValue("Balance : " + Tools.getPesoFormat(posBalance.getBalance()));
		title.getCell(cellCount).setCellStyle(titleStyle);

		Row row = sheet.createRow(rowCount++);
		if (posTransactions.size() > 0) {
			List<Integer> keys = new ArrayList<Integer>();
			for (PosTransaction posTransaction : posTransactions) {
				if (posTransaction.getTicketId() > 0) {
					if (keys.indexOf(posTransaction.getTicketId()) < 0) {
						keys.add(posTransaction.getTicketId());
					}
				}
			}

			List<PosTransaction> details = new ArrayList<PosTransaction>();
			Map<Integer, List<PosTransaction>> detailsMap = new HashMap<Integer, List<PosTransaction>>();
			for (Integer key : keys) {
				for (PosTransaction posTransaction : posTransactionsWithOrders) {
					if (key == posTransaction.getTicketId()) {
						details.add(posTransaction);
					}
				}
				detailsMap.put(key, details);
				details = null;
				details = new ArrayList<PosTransaction>();
			}

			cellCount = 0;

			int detailNo = 1;
			int transactionNo = 1;
			String outputText = "";
			System.out.println("-------------------- print orders by ticketid ------------------------");
			for (PosTransaction transaction : posTransactions) {
				if (transactionNo == 0) {
					outputText = (transactionNo++) + ". " + transaction.getTransactionDateForm() + "    " + transaction.getTransactionName() + "   Debit : " + Tools.getPesoFormat(transaction.getDebit()) + ", Credit : " + Tools.getPesoFormat(transaction.getCredit());

					System.out.println(outputText);
					row = sheet.createRow(rowCount++);
					row = sheet.createRow(rowCount++);
					row.createCell(cellCount).setCellValue(outputText);
				} else {
					outputText = (transactionNo++) + ". " + transaction.getTransactionDateForm() + "   Debit : " + Tools.getPesoFormat(transaction.getDebit()) + ", Credit : " + Tools.getPesoFormat(transaction.getCredit());

					System.out.println(outputText);
					row = sheet.createRow(rowCount++);
					row = sheet.createRow(rowCount++);
					row.createCell(cellCount).setCellValue(outputText);
				}

				if (detailsMap.get(transaction.getTicketId()) != null) {
					for (PosTransaction posTransaction : detailsMap.get(transaction.getTicketId())) {
						outputText = "       " + detailNo++ + ". " + posTransaction.getMenuItemName() + ", " + Tools.getPesoFormat(posTransaction.getPrice()) + " * " + Tools.getCommaFormat(posTransaction.getQuantity());

						System.out.println(outputText);
						row = sheet.createRow(rowCount++);
						row.createCell(cellCount).setCellValue(outputText);
					}
				}
				detailNo = 1;
			}

		} else {
			cellCount = 0;
			row = sheet.createRow(rowCount++);
			row.createCell(cellCount).setCellValue("None.");
		}

	}

}
