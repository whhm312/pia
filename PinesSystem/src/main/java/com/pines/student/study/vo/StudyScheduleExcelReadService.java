package com.pines.student.study.vo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.pines.student.common.Tools;

@Service
public class StudyScheduleExcelReadService {

	@SuppressWarnings("resource")
	public Map<String, List<String>> readLevel(File FILE) {
		Map<String, List<String>> levelMap = new HashMap<String, List<String>>();
		String levelName = "";
		String studentName = "";

		List<String> studentList = new ArrayList<String>();
		try {
			FileInputStream excelFile = new FileInputStream(FILE);
			Workbook workbook = new XSSFWorkbook(excelFile);
			workbook.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

			Sheet sheet = workbook.getSheetAt(0);
			Row row = null;
			Cell cell = null;
			int lastRowNum = sheet.getLastRowNum();
			int lastCellNum = 0;

			for (int rownum = 0; rownum <= lastRowNum; rownum++) {
				row = sheet.getRow(rownum);
				if (row == null) {
					if (!studentList.isEmpty()) {
						levelName = studentList.get(0);
						studentList.remove(0);
						levelMap.put(Tools.trim(levelName), studentList);
						levelName = "";

						studentList = null;
						studentList = new ArrayList<String>();
					}
					continue;
				}

				// lastCellNum = row.getLastCellNum();
				lastCellNum = 1;
				for (int cellNum = 0; cellNum < lastCellNum; cellNum++) {
					cell = row.getCell(cellNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					if (cell != null && Tools.isNotEmpty(cell.toString())) {
						studentName = cell.toString();
						studentList.add(studentName);
						studentName = "";
					} else {
						if (studentList.isEmpty()) {
							continue;
						}

						levelName = studentList.get(0);
						studentList.remove(0);

						for (int studentIdx = 0; studentIdx < studentList.size(); studentIdx++) {
							studentName = studentList.get(studentIdx);
							studentName = studentName.replaceAll("\\(", "");
							studentName = studentName.replaceAll("\\)", "");
							studentName = studentName.replaceAll("[*]", "");
							studentName = studentName.replaceAll(",", "");
							studentName = studentName.replaceAll("-", " ");
							studentName = studentName.replaceAll("_", " ");
							studentName = Tools.getUpperCase(studentName);
							studentName = Tools.getOnlyEnglishWithBirth(studentName);
							studentList.set(studentIdx, studentName);
						}
						levelMap.put(Tools.trim(levelName), studentList);
						levelName = "";

						studentList = null;
						studentList = new ArrayList<String>();
					}
				}

				if (rownum == lastRowNum) {
					if (studentList.isEmpty()) {
						continue;
					}

					levelName = studentList.get(0);
					studentList.remove(0);

					for (int studentIdx = 0; studentIdx < studentList.size(); studentIdx++) {
						studentName = studentList.get(studentIdx);
						studentName = studentName.replaceAll("\\(", "");
						studentName = studentName.replaceAll("\\)", "");
						studentName = studentName.replaceAll("[*]", "");
						studentName = studentName.replaceAll(",", "");
						studentName = studentName.replaceAll("-", " ");
						studentName = studentName.replaceAll("_", " ");
						studentName = Tools.getUpperCase(studentName);
						studentName = Tools.getOnlyEnglishWithBirth(studentName);
						studentList.set(studentIdx, studentName);
					}

					levelMap.put(Tools.trim(levelName), studentList);
					levelName = "";

					studentList = null;
					studentList = new ArrayList<String>();
				}
			}

			if (studentList != null && !studentList.isEmpty()) {
				levelName = studentList.get(0);
				studentList.remove(0);
				levelMap.put(Tools.trim(levelName), studentList);

				studentList = null;
				studentList = new ArrayList<String>();
			}

			if (!levelMap.isEmpty()) {
				levelMap.keySet().iterator();
			}
			return levelMap;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return new HashMap<String, List<String>>();
		} catch (IOException e) {
			e.printStackTrace();
			return new HashMap<String, List<String>>();
		}
	}

	// wb.getSheetAt(0).getRow(9).getCell(CellReference.convertColStringToIndex("E"));
	@SuppressWarnings("resource")
	public Map<String, Map<String, String>> readTimetable(File FILE) {
		try {
			FileInputStream excelFile = new FileInputStream(FILE);
			Workbook workbook = new XSSFWorkbook(excelFile);
			workbook.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

			Sheet sheet = workbook.getSheetAt(0);
			int rowCnt = sheet.getPhysicalNumberOfRows();

			Row row = null;
			Cell cell = null;
			String cellValue = "";

			// get Time
			List<String> times = new ArrayList<String>();
			for (int i = 0; i < rowCnt; i++) {
				row = sheet.getRow(i);
				if (row != null) {
					cell = sheet.getRow(i).getCell(0);
					if (cell != null) {
						cellValue = cell.toString();
						if (Tools.isNotEmpty(cellValue)) {
							times.add(Tools.trim(cellValue));
						}
					}
				}
			}
			// System.out.println("times: " + times);

			// get Level
			List<String> levels = new ArrayList<String>();
			row = sheet.getRow(0);
			for (int cn = 0; cn < row.getLastCellNum(); cn++) {
				cell = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				if (cell != null) {
					cellValue = cell.toString();
					if (Tools.isNotEmpty(cellValue)) {
						levels.add(Tools.trim(cellValue));
					}
				}
			}
			// System.out.println("levels: " + levels);

			Map<String, Map<String, String>> allMap = new LinkedHashMap<String, Map<String, String>>();
			Map<String, String> timeAndSubject = new LinkedHashMap<String, String>();
			int levelTotalCount = levels.size();
			int timeTotalCount = times.size();
			int getRowNum = 1;
			int getCellNum = 1;
			Row oneRow = null;
			for (int j = 0; j < levelTotalCount; j++) {
				for (int i = 0; i < timeTotalCount; i++) {
					oneRow = sheet.getRow(getRowNum++);
					if (oneRow == null) {
						continue;
					}

					cell = oneRow.getCell(getCellNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					if (cell != null) {
						cellValue = cell.toString();
						cellValue = Tools.removeAllDoubleSpaces(cellValue);

						timeAndSubject.put(times.get(i), cellValue);
					}
				}
				allMap.put(levels.get(j), timeAndSubject);

				timeAndSubject = null;
				timeAndSubject = new LinkedHashMap<String, String>();
				getRowNum = 1;
				getCellNum++;
			}

			return allMap;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return new LinkedHashMap<String, Map<String, String>>();
		} catch (IOException e) {
			e.printStackTrace();
			return new LinkedHashMap<String, Map<String, String>>();
		}
	}

	@SuppressWarnings("resource")
	public Map<String, Map<String, String>> readTimetableByTimeBase(File FILE) {
		try {
			FileInputStream excelFile = new FileInputStream(FILE);
			Workbook workbook = new XSSFWorkbook(excelFile);
			workbook.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

			Sheet sheet = workbook.getSheetAt(0);
			int rowCnt = sheet.getPhysicalNumberOfRows();

			Row row = null;
			Cell cell = null;
			String cellValue = "";

			// get Time
			List<String> levels = new ArrayList<String>();
			for (int i = 0; i < rowCnt; i++) {
				row = sheet.getRow(i);
				if (row != null) {
					cell = sheet.getRow(i).getCell(0);
					if (cell != null) {
						cellValue = cell.toString();
						if (Tools.isNotEmpty(cellValue)) {
							levels.add(Tools.trim(cellValue));
						}
					}
				}
			}
			//System.out.println("levels: " + levels);

			// get Level
			List<String> times = new ArrayList<String>();
			row = sheet.getRow(0);
			for (int cn = 0; cn < row.getLastCellNum(); cn++) {
				cell = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				if (cell != null) {
					cellValue = cell.toString();
					if (Tools.isNotEmpty(cellValue)) {
						times.add(Tools.trim(cellValue));
					}
				}
			}
			//System.out.println("times: " + times);

			Map<String, Map<String, String>> allMap = new LinkedHashMap<String, Map<String, String>>();
			Map<String, String> timeAndSubject = new LinkedHashMap<String, String>();
			int levelTotalCount = levels.size();
			int timeTotalCount = times.size();
			int getRowNum = 1;
			int getCellNum = 1;
			Row oneRow = null;
			for (int j = 0; j < levelTotalCount; j++) {
				getCellNum = 1;

				for (int i = 0; i < timeTotalCount; i++) {
					oneRow = sheet.getRow(getRowNum);
					if (oneRow == null) {
						continue;
					}

					cell = oneRow.getCell(getCellNum++, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					if (cell != null) {
						cellValue = cell.toString();
						cellValue = Tools.removeAllDoubleSpaces(cellValue);

						timeAndSubject.put(times.get(i), cellValue);
					}
				}
				allMap.put(levels.get(j), timeAndSubject);

				timeAndSubject = null;
				timeAndSubject = new LinkedHashMap<String, String>();
				getRowNum++;
			}

			return allMap;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return new LinkedHashMap<String, Map<String, String>>();
		} catch (IOException e) {
			e.printStackTrace();
			return new LinkedHashMap<String, Map<String, String>>();
		}
	}

	@SuppressWarnings("resource")
	public List<Map<String, String>> readSchedules(File FILE) {
		try {
			FileInputStream excelFile = new FileInputStream(FILE);
			Workbook workbook = new XSSFWorkbook(excelFile);
			workbook.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

			Sheet sheet = workbook.getSheetAt(0);
			int rowCnt = sheet.getPhysicalNumberOfRows();

			Row row = null;
			Cell cell = null;
			String cellValue = null;

			// get Time
			List<String> times = new ArrayList<String>();
			for (int i = 1; i < rowCnt; i++) {
				row = sheet.getRow(i);
				if (row == null) {
					break;
				}

				cell = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				if (cell != null) {
					cellValue = cell.toString();
					if (Tools.isNotEmpty(cellValue)) {
						times.add(Tools.trim(cellValue));
					}
				}
			}
			// System.out.println("times : " + times);

			// get Room
			List<String> rooms = new ArrayList<String>();
			row = sheet.getRow(0);
			for (int cn = 1; cn < row.getLastCellNum(); cn++) {
				cell = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				if (cell != null) {
					cellValue = cell.toString();
					if (Tools.isNotEmpty(cellValue)) {
						rooms.add(Tools.trim(cellValue));
					}
				}
			}
			// System.out.println("Rooms: " + rooms);

			List<Map<String, String>> allSchedule = new ArrayList<Map<String, String>>();
			Map<String, String> timeAndSubject = new LinkedHashMap<String, String>();
			int roomTotalCount = rooms.size();
			int timeTotalCount = times.size();
			int getRowNum = 1;
			int getCellNum = 1;
			String[] students = null;
			String studentName = null;
			String teacherName = null;
			for (int j = 0; j < roomTotalCount; j++) {
				for (int i = 0; i < timeTotalCount; i++) {
					cell = sheet.getRow(getRowNum++).getCell(getCellNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					if (cell != null && Tools.isEmpty(cell.toString())) {
						getRowNum++;
						continue;
					}
					teacherName = cell.toString();

					cell = sheet.getRow(getRowNum++).getCell(getCellNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					studentName = cell.toString();

					if (studentName.indexOf("\n") > -1) {
						students = studentName.split("\n");

						for (int k = 0; k < students.length; k++) {
							studentName = students[k];
							studentName = studentName.replaceAll("\\(", "");
							studentName = studentName.replaceAll("\\)", "");
							studentName = studentName.replaceAll("[*]", "");
							studentName = studentName.replaceAll(",", "");
							studentName = studentName.replaceAll("-", " ");
							studentName = studentName.replaceAll("_", " ");
							studentName = Tools.removeAllDoubleSpaces(studentName);
							studentName = Tools.trim(studentName);

							timeAndSubject.put("memberCount", students.length + "");
							timeAndSubject.put("student", studentName);
							timeAndSubject.put("teacher", teacherName);
							timeAndSubject.put("time", times.get(i));
							timeAndSubject.put("room", rooms.get(j));

							// System.out.println("timeAndSubject : " + timeAndSubject);
							allSchedule.add(timeAndSubject);

							timeAndSubject = null;
							timeAndSubject = new LinkedHashMap<String, String>();
						}
					} else {
						studentName = studentName.replaceAll("\\(", "");
						studentName = studentName.replaceAll("\\)", "");
						studentName = studentName.replaceAll("[*]", "");
						studentName = studentName.replaceAll(",", "");
						studentName = studentName.replaceAll("-", " ");
						studentName = studentName.replaceAll("_", " ");
						studentName = Tools.removeAllDoubleSpaces(studentName);
						studentName = Tools.trim(studentName);

						timeAndSubject.put("memberCount", "1");
						timeAndSubject.put("student", studentName);
						timeAndSubject.put("teacher", teacherName);
						timeAndSubject.put("time", times.get(i));
						timeAndSubject.put("room", rooms.get(j));

						// System.out.println("timeAndSubject : " + timeAndSubject);
						allSchedule.add(timeAndSubject);

						timeAndSubject = null;
						timeAndSubject = new LinkedHashMap<String, String>();
					}
					students = null;
					studentName = null;
					teacherName = null;

				}
				getRowNum = 1;
				getCellNum++;
			}

			// System.out.println(allSchedule);

			return allSchedule;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		}
	}

	@SuppressWarnings("resource")
	public List<Map<String, String>> readSchedulesBack(File FILE) {
		try {
			FileInputStream excelFile = new FileInputStream(FILE);
			Workbook workbook = new XSSFWorkbook(excelFile);
			workbook.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

			Sheet sheet = workbook.getSheetAt(0);
			int rowCnt = sheet.getLastRowNum();
			Row row = null;
			Cell cell = null;
			String cellValue = null;

			// get Time
			List<String> times = new ArrayList<String>();
			for (int i = 1; i < rowCnt; i++) {
				row = sheet.getRow(i);
				if (row != null) {
					cell = sheet.getRow(i).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					if (cell != null) {
						cellValue = cell.toString();
						if (Tools.isNotEmpty(cellValue)) {
							times.add(cellValue);
						}
					}
				}
			}
			// System.out.println("times : " + times);

			// get Room
			List<String> rooms = new ArrayList<String>();
			row = sheet.getRow(0);
			for (int cn = 1; cn < row.getLastCellNum(); cn++) {
				cell = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				if (cell != null) {
					cellValue = cell.toString();
					if (Tools.isNotEmpty(cellValue)) {
						rooms.add(cellValue);
					}
				}
			}
			// System.out.println("Rooms: " + rooms);

			List<Map<String, String>> allSchedule = new ArrayList<Map<String, String>>();
			Map<String, String> timeAndSubject = new LinkedHashMap<String, String>();
			int roomTotalCount = rooms.size();
			int timeTotalCount = times.size();
			int getRowNum = 1;
			int getCellNum = 1;
			String[] students = null;
			String studentName = null;
			String teacherName = null;
			for (int j = 0; j < roomTotalCount; j++) {
				for (int i = 0; i < timeTotalCount; i++) {
					cell = sheet.getRow(getRowNum++).getCell(getCellNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					if (cell != null && Tools.isEmpty(cell.toString())) {
						getRowNum++;
						continue;
					}
					teacherName = cell.toString();

					cell = sheet.getRow(getRowNum++).getCell(getCellNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cellValue = cell.toString();
					if (cellValue.indexOf("\n") > -1) {
						students = cellValue.split("\n");

						for (int k = 0; k < students.length; k++) {
							cellValue = students[k];
							cellValue = cellValue.replaceAll("\\(", "");
							cellValue = cellValue.replaceAll("\\)", "");
							cellValue = cellValue.replaceAll("[*]", "");
							cellValue = cellValue.replaceAll(",", "");
							cellValue = cellValue.replaceAll("-", " ");
							cellValue = cellValue.replaceAll("_", " ");

							timeAndSubject.put("memberCount", students.length + "");
							timeAndSubject.put("student", cellValue);
							timeAndSubject.put("teacher", teacherName);
							timeAndSubject.put("time", times.get(i));
							timeAndSubject.put("room", rooms.get(j));
							// System.out.println("timeAndSubject : " + timeAndSubject);
						}

					} else {
						cellValue = cellValue.replaceAll("\\(", "");
						cellValue = cellValue.replaceAll("\\)", "");
						cellValue = cellValue.replaceAll("[*]", "");
						cellValue = cellValue.replaceAll(",", "");
						cellValue = cellValue.replaceAll("-", " ");
						cellValue = cellValue.replaceAll("_", " ");
						studentName = cellValue;

						timeAndSubject.put("memberCount", "1");
						timeAndSubject.put("student", studentName);
						timeAndSubject.put("teacher", teacherName);
						timeAndSubject.put("time", times.get(i));
						timeAndSubject.put("room", rooms.get(j));
						// System.out.println("timeAndSubject : " + timeAndSubject);
					}

					allSchedule.add(timeAndSubject);

					students = null;
					studentName = null;
					teacherName = null;
					timeAndSubject = null;
					timeAndSubject = new LinkedHashMap<String, String>();
				}
				getRowNum = 1;
				getCellNum++;
			}

			return allSchedule;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<Map<String, String>>();
		}
	}
}
