package com.pines.student.study.vo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.StudyAllInOne;
import com.pines.student.common.vo.StudySchedule;
import com.pines.student.common.vo.StudyTimetable;
import com.pines.student.common.vo.TeacherScheduleDetail;

public class TeacherScheduleExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		StudyAllInOne studyAllInOne = (StudyAllInOne) model.get("schedule");

		// create excel xls sheet
		Sheet sheet = workbook.createSheet("Teachers Schedule");
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
		headerStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		headerFont.setColor(IndexedColors.WHITE.index);
		headerStyle.setFont(headerFont);

		// create header row
		int rowCount = 0;
		int cellCount = 0;
		Row teacherHeader = sheet.createRow(rowCount++);
		teacherHeader.createCell(cellCount).setCellValue("No");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
		teacherHeader.createCell(cellCount).setCellValue("Teacher Name");
		teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);

		List<StudyTimetable> timetable = studyAllInOne.getTimetables();
		if (!timetable.isEmpty()) {
			for (StudyTimetable studySchedule : timetable) {
				teacherHeader.createCell(cellCount).setCellValue(studySchedule.getStudyTime());
				teacherHeader.getCell(cellCount++).setCellStyle(headerStyle);
			}
		}

		CellStyle teacherNameCS = workbook.createCellStyle();
		teacherNameCS.setVerticalAlignment(VerticalAlignment.CENTER);

		CellStyle cs = workbook.createCellStyle();
		cs.setWrapText(true);
		cs.setVerticalAlignment(VerticalAlignment.TOP);

		int timetableSize = timetable.size();
		int scheduleSize = 0;
		int no = 0;
		Row newRow = null;
		List<StudySchedule> schedules = studyAllInOne.getSchedules();
		if (schedules.isEmpty()) {
			cellCount = 0;
			newRow = sheet.createRow(rowCount++);
			newRow.createCell(cellCount).setCellValue("None.");
		} else {

			StringBuffer sb = new StringBuffer();
			String studyTime = null;
			List<TeacherScheduleDetail> details = null;
			for (StudySchedule studySchedule : schedules) {
				cellCount = 0;

				newRow = sheet.createRow(rowCount++);
				newRow.setHeight((short) -1);

				newRow.createCell(cellCount++).setCellValue(++no);
				newRow.getCell(cellCount - 1).setCellStyle(teacherNameCS);
				sheet.autoSizeColumn(cellCount - 1);

				newRow.createCell(cellCount++).setCellValue(studySchedule.getTeacherName());
				newRow.getCell(cellCount - 1).setCellStyle(teacherNameCS);
				sheet.autoSizeColumn(cellCount - 1);

				details = studySchedule.getTeacherScheduleDetails();
				scheduleSize = details.size();
				for (int i = 0; i < timetableSize; i++) {
					if (Tools.isNull(teacherHeader.getCell(cellCount))) {
						break;
					}

					if (i == scheduleSize) {
						break;
					}

					studyTime = teacherHeader.getCell(cellCount).getStringCellValue();
					if (studyTime.equals(details.get(i).getStudyTime())) {
						sb.setLength(0);
						sb.append("[1:" + details.get(i).getStudyMember() + "] ");
						sb.append("(");
						sb.append(details.get(i).getStudyRoom());
						sb.append(") ");
						sb.append(details.get(i).getSubject());
						for (String studentName : details.get(i).getStudentNames()) {
							sb.append("\n");
							sb.append(studentName);
						}

						newRow.createCell(cellCount++).setCellValue(sb.toString());
						newRow.getCell(cellCount - 1).setCellStyle(cs);
						sheet.autoSizeColumn(cellCount - 1);
					} else {
						--i;
						newRow.createCell(cellCount++).setCellValue("");
					}
				}
			}
		}

	}
}
