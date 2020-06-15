package com.pines.student.room;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pines.student.common.vo.StudentIdentify;
import com.pines.student.common.vo.StudentRoom;

@Repository
@Transactional(rollbackFor = Exception.class)
public class RoomDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<StudentRoom> registerRoomSettings(String staffId, List<StudentRoom> roomsExcel) {
		List<StudentRoom> result = new ArrayList<StudentRoom>();
		StudentRoom failedStudentRoom = null;

		List<StudentIdentify> failedStudentsIdentify = null;
		StudentIdentify failedStudent = null;

		boolean isSuccessed = false;
		for (StudentRoom studentRoom : roomsExcel) {
			failedStudentRoom = new StudentRoom();
			failedStudentsIdentify = new ArrayList<StudentIdentify>();

			for (StudentIdentify student : studentRoom.getStudents()) {
				isSuccessed = updateStudentRoomByName(staffId, studentRoom.getRoom(), student.getName());
				if (!isSuccessed) {
					failedStudent = new StudentIdentify();
					failedStudent.setName(student.getName());
					failedStudentsIdentify.add(failedStudent);
				}
			}

			if (!failedStudentsIdentify.isEmpty()) {
				failedStudentRoom.setRoom(studentRoom.getRoom());
				failedStudentRoom.setStudents(failedStudentsIdentify);
				result.add(failedStudentRoom);
			}
		}
		return result;
	}

	public boolean updateStudentRoomByName(String staffId, String room, String studentName) {
		int idx = 0;
		Object[] params = null;
		StringBuffer query = new StringBuffer();

		query.append("SELECT STUDENT_ID ");
		query.append("  FROM pia_students S ");
		query.append(" WHERE REPLACE(S.NAME, ' ', '') = REPLACE(?, ' ', '') ");
		query.append("   AND IS_DELETED IS FALSE ");
		query.append("   AND END_CONTRACT_DATE > NOW() ");

		idx = 0;
		params = new Object[1];
		params[idx++] = studentName;
		String studentId = null;
		try {
			studentId = jdbcTemplate.queryForObject(query.toString(), params, String.class);
		} catch (org.springframework.dao.IncorrectResultSizeDataAccessException ae) {
			return false;
		}

		return updateStudentRoom(staffId, room, studentId);

	}

	public boolean updateStudentRoom(String staffId, String room, String studentId) {
		int idx = 0;
		Object[] params = null;
		StringBuffer query = new StringBuffer();

		query.append("SELECT ROOM ");
		query.append("  FROM pia_students S ");
		query.append(" WHERE S.STUDENT_ID = ? ");
		query.append("   AND IS_DELETED IS FALSE ");
		query.append("   AND END_CONTRACT_DATE > NOW() ");

		idx = 0;
		params = new Object[1];
		params[idx++] = studentId;
		String previousRoom = jdbcTemplate.queryForObject(query.toString(), params, String.class);

		query.setLength(0);
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append("  ROOM = ? ");
		query.append(" WHERE STUDENT_ID = ? ");
		query.append("   AND IS_DELETED IS FALSE ");

		idx = 0;
		params = new Object[2];
		params[idx++] = room;
		params[idx++] = studentId;
		boolean isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		if (isSuccessed) {
			query.setLength(0);
			query.append("INSERT INTO pia_student_room_history (STUDENT_ID, PREVIOUS_ROOM, NEW_ROOM, STAFF_ID, REGISTER_DATE) ");
			query.append("VALUES (?, ?, ?, ?, NOW())");

			idx = 0;
			params = new Object[4];
			params[idx++] = studentId;
			params[idx++] = previousRoom;
			params[idx++] = room;
			params[idx++] = staffId;
			isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		}
		return isSuccessed;
	}
}
