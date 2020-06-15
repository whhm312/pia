package com.pines.student.room;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.pines.student.common.Tools;
import com.pines.student.common.upload.excel.ExcelRead;
import com.pines.student.common.upload.excel.ExcelReadOption;
import com.pines.student.common.vo.StudentIdentify;
import com.pines.student.common.vo.StudentRoom;

@Service
public class RoomExcelUploadService {
	public List<StudentRoom> getStudentRoomSettings(File destFile) throws Exception {
		List<StudentRoom> results = new ArrayList<StudentRoom>();
		List<StudentIdentify> students = new ArrayList<StudentIdentify>();
		StudentRoom result = null;
		StudentIdentify student = null;

		ExcelReadOption excelReadOption = new ExcelReadOption();
		excelReadOption.setFilePath(destFile.getAbsolutePath());
		excelReadOption.setOutputColumns("A");
		excelReadOption.setStartRow(0);

		List<Map<String, String>> excelContent = ExcelRead.read(excelReadOption);
		int index = 0;
		boolean nextIsRoom = false;
		for (Map<String, String> article : excelContent) {

			// 0번째는 방번호다
			if (index == 0) {
				result = new StudentRoom();
				result.setRoom(Tools.trim(article.get("A")));
				// System.out.println("Room : " + Tools.trim(article.get("A")));

				student = new StudentIdentify();
				index++;
				continue;
			} else if (nextIsRoom) {
				result = new StudentRoom();
				result.setRoom(Tools.trim(article.get("A")));
				// System.out.println("Room : " + Tools.trim(article.get("A")));

				student = new StudentIdentify();
				nextIsRoom = false;
				index++;
				continue;
			}

			// 공백 이후로 방번호다
			if (Tools.isEmpty(Tools.trim(article.get("A")))) {
				result.setStudents(students);
				results.add(result);

				nextIsRoom = true;
				students = new ArrayList<StudentIdentify>();
				continue;
			}

			// 그 외에는 학생 이름이다
			// System.out.println("Student : " + Tools.trim(article.get("A")));
			student.setName(Tools.getUpperCase(Tools.trim(article.get("A"))));
			students.add(student);

			student = new StudentIdentify();
			nextIsRoom = false;
			index++;
		}

		printResults(results);
		return results;
	}

	private void printResults(List<StudentRoom> results) {
		for (StudentRoom studentRoom : results) {
			System.err.println("Room : " + studentRoom.getRoom());
			for (StudentIdentify studentIdentify : studentRoom.getStudents()) {
				System.err.println(studentIdentify.getName());
			}
		}
	}

	@SuppressWarnings("resource")
	public List<StudentRoom> getRoomSettings(File FILE) {
		Map<String, List<String>> roomMap = new HashMap<String, List<String>>();
		String roomName = "";
		String studentName = "";

		List<String> studentList = new ArrayList<String>();
		try {
			FileInputStream excelFile = new FileInputStream(FILE);
			Workbook workbook = new XSSFWorkbook(excelFile);
			workbook.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

			Sheet sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());
			Row row = null;
			Cell cell = null;
			int lastRowNum = sheet.getLastRowNum();
			int lastCellNum = 0;

			for (int rownum = 0; rownum <= lastRowNum; rownum++) {
				row = sheet.getRow(rownum);
				if (row == null) {
					if (!studentList.isEmpty()) {
						roomName = studentList.get(0);
						studentList.remove(0);
						roomMap.put(roomName, studentList);
						roomName = "";

						studentList = null;
						studentList = new ArrayList<String>();
					}
					continue;
				}

				// lastCellNum = row.getLastCellNum();
				lastCellNum = 1;
				for (int cellNum = 0; cellNum < lastCellNum; cellNum++) {
					cell = row.getCell(cellNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					if (cell != null && Tools.isNotEmpty(cell.toString())) {
						studentName = cell.toString();
						studentList.add(studentName);
						studentName = "";
					} else {
						if (studentList.size() < 1) {
							continue;
						}

						roomName = studentList.get(0);
						studentList.remove(0);

						for (int studentIdx = 0; studentIdx < studentList.size(); studentIdx++) {
							studentName = studentList.get(studentIdx);
							studentName = studentName.replaceAll("\\(", "");
							studentName = studentName.replaceAll("\\)", "");
							studentName = studentName.replaceAll("[*]", "");
							studentName = studentName.replaceAll(",", "");
							studentName = studentName.replaceAll("-", " ");
							studentName = studentName.replaceAll("_", " ");
							studentList.set(studentIdx, studentName);
						}
						roomMap.put(roomName, studentList);
						roomName = "";

						studentList = null;
						studentList = new ArrayList<String>();
					}
				}

				if (rownum == lastRowNum) {
					if (studentList.size() < 1) {
						continue;
					}

					roomName = studentList.get(0);
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

					roomMap.put(roomName, studentList);
					roomName = "";

					studentList = null;
					studentList = new ArrayList<String>();
				}
			}

			if (studentList != null && !studentList.isEmpty()) {
				roomName = studentList.get(0);
				studentList.remove(0);
				roomMap.put(roomName, studentList);

				studentList = null;
				studentList = new ArrayList<String>();
			}

			if (!roomMap.isEmpty()) {
				roomMap.keySet().iterator();
			}

			List<StudentRoom> results = new ArrayList<StudentRoom>();
			List<StudentIdentify> students = new ArrayList<StudentIdentify>();
			StudentRoom result = null;
			StudentIdentify student = null;
			for (Map.Entry<String, List<String>> entry : roomMap.entrySet()) {
				if (entry.getValue().isEmpty()) {
					continue;
				}

				result = new StudentRoom();
				result.setRoom(entry.getKey());
				for (String name : entry.getValue()) {
					name = name.replaceAll("\\(", "");
					name = name.replaceAll("\\)", "");
					name = name.replaceAll("[*]", "");
					name = name.replaceAll(",", "");
					name = name.replaceAll("-", " ");
					name = name.replaceAll("_", " ");
					name = Tools.getUpperCase(name);
					name = Tools.getOnlyEnglishWithBirth(name);
					name = Tools.removeAllDoubleSpaces(name);
					name = Tools.trim(name);

					student = new StudentIdentify();
					student.setName(name);
					students.add(student);
				}
				result.setStudents(students);
				results.add(result);

				students = new ArrayList<StudentIdentify>();
			}
			return results;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return new ArrayList<StudentRoom>();
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<StudentRoom>();
		}
	}
}
