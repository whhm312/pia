package com.pines.student.common.upload.excel;

import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ExcelCellRef {
	/**
	 * Cell에 해당하는 Column Name을 가젼온다(A,B,C..) 만약 Cell이 Null이라면 int cellIndex의 값으로
	 * Column Name을 가져온다.
	 * 
	 * @param cell
	 * @param cellIndex
	 * @return
	 */
	public static String getName(Cell cell, int cellIndex) {
		int cellNum = 0;
		if (cell != null) {
			cellNum = cell.getColumnIndex();
		} else {
			cellNum = cellIndex;
		}

		return CellReference.convertNumToColString(cellNum);
	}

	public static String getValue(Cell cell) {
		String value = "";

		if (cell == null) {
			value = "";
		} else {
			if (cell.getCellTypeEnum() == CellType.FORMULA) {
				value = cell.getCellFormula();
			} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					value = sdf.format(cell.getDateCellValue());
				} else {
					value = NumberToTextConverter.toText(cell.getNumericCellValue()); 
				}
			} else if (cell.getCellTypeEnum() == CellType.STRING) {
				value = cell.getStringCellValue();
			} else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
				value = cell.getBooleanCellValue() + "";
			} else if (cell.getCellTypeEnum() == CellType.ERROR) {
				value = cell.getErrorCellValue() + "";
			} else if (cell.getCellTypeEnum() == CellType.BLANK) {
				value = "";
			} else {
				value = cell.getStringCellValue();
			}
		}

		return value;
	}

}
