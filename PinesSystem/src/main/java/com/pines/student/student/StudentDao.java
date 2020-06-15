package com.pines.student.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pines.student.common.MD5Tools;
import com.pines.student.common.vo.Student;
import com.pines.student.common.vo.UploadFile;

@Repository
@Transactional(rollbackFor = Exception.class)
public class StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Student getStudent(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT S.*, ");
		query.append("(SELECT C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = S.CAMPUS_SEQ) AS 'CAMPUS', ");
		query.append("(SELECT T.TERM_NAME FROM pia_term_details T WHERE T.TERM_DETAIL_SEQ = S.TERM_DETAIL_SEQ) AS 'TERM', ");
		query.append("(SELECT DATE_FORMAT(T.START_DATE, '%Y/%m/%d') FROM pia_term_details T WHERE T.TERM_DETAIL_SEQ = S.TERM_DETAIL_SEQ) AS 'FORM_TERM_START_DATE', ");
		query.append("(SELECT DATE_FORMAT(T.END_DATE, '%Y/%m/%d') FROM pia_term_details T WHERE T.TERM_DETAIL_SEQ = S.TERM_DETAIL_SEQ) AS 'FORM_TERM_END_DATE', ");
		query.append("DATE_FORMAT(S.START_CONTRACT_DATE, '%Y/%m/%d') AS 'FORM_DATE_OF_START_CONTRACT', ");
		query.append("DATE_FORMAT(S.END_CONTRACT_DATE, '%Y/%m/%d') AS 'FORM_DATE_OF_END_CONTRACT', ");
		query.append("DATE_FORMAT(S.DATE_OF_BIRTH, '%Y/%m/%d') AS 'FORM_DATE_OF_BIRTH', ");
		query.append("DATE_FORMAT(S.DATE_OF_BIRTH, '%Y%m%d') AS 'NONE_FORM_DATE_OF_BIRTH', ");
		query.append("DATE_FORMAT(S.DATE_OF_BIRTH, '%y%m%d') AS 'BIRTHDAY', ");
		query.append("(SELECT C.COURSE_NAME FROM pia_courses C WHERE C.COURSE_SEQ = S.COURSE_SEQ) AS 'COURSE', ");
		query.append("(SELECT C.LEVEL_NAME FROM pia_study_levels C WHERE C.LEVEL_SEQ = S.LEVEL_SEQ) AS 'LEVEL', ");
		query.append("GET_NATIONALITY(S.NATIONALITY_SEQ) AS 'NATIONALITY' ");
		query.append("FROM pia_students S ");
		query.append("WHERE S.STUDENT_ID = '");
		query.append(studentId);
		query.append("'");

		Student result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), new BeanPropertyRowMapper<Student>(Student.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new Student();
		}
		return result;
	}

	public String resetStudentPassword(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append(" PASSWORD = ?");
		query.append(" WHERE STUDENT_ID = ?");

		String birthday = getStudent(studentId).getBirthday();
		String password = MD5Tools.makeMD5(birthday);

		Object[] params = new Object[] { password, studentId };
		jdbcTemplate.update(query.toString(), params);

		return birthday;
	}

	public boolean changeStudentPassword(String studentId, String newPassword) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append(" PASSWORD = ?");
		query.append(" WHERE STUDENT_ID = ?");

		Object[] params = new Object[] { newPassword, studentId };
		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean changeStudentLanguage(String studentId, int languageSeq) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append(" LANGUAGE_SEQ = ?");
		query.append(" WHERE STUDENT_ID = ?");

		Object[] params = new Object[] { languageSeq, studentId };
		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean changeExtraInformation(String studentId, Student student) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_students ");
		query.append("   SET ");
		query.append(" EMERGENCY_CONTACT = ?, ");
		query.append(" RELATIONSHIP_WITH_CONTACT = ?, ");
		query.append(" LOCAL_CONTACT = ?, ");
		query.append(" EMAIL = ?, ");
		query.append(" MESSENGER_TYPE = ?, ");
		query.append(" MESSENGER_ID = ?, ");
		query.append(" ENGLISH_NAME = ? ");
		query.append(" WHERE STUDENT_ID = ?");

		int idx = 0;
		Object[] params = new Object[8];
		params[idx++] = student.getEmergencyContact();
		params[idx++] = student.getRelationshipWithContact();
		params[idx++] = student.getLocalContact();
		params[idx++] = student.getEmail();
		params[idx++] = student.getMessengerType();
		params[idx++] = student.getMessengerId();
		params[idx++] = student.getEnglishName();
		params[idx++] = studentId;
		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean registerStudentPicture(String studentId, UploadFile uploadFile) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_student_picture (");
		query.append(" STUDENT_ID, REGISTER_DATE, ORIGINAL_FILENAME, FILE_SIZE, FILE_PATH ");
		query.append(") VALUES ( ");
		query.append(" ?, NOW(), ?, ?, ? ");
		query.append(") ");
		query.append("ON DUPLICATE KEY UPDATE STUDENT_ID = ?, ");
		query.append(" REGISTER_DATE = NOW(), ORIGINAL_FILENAME = ?, FILE_SIZE = ?, FILE_PATH = ? ");

		int idx = 0;
		Object[] params = new Object[8];
		params[idx++] = studentId;
		params[idx++] = uploadFile.getOriginalFilename();
		params[idx++] = uploadFile.getFileSize();
		params[idx++] = uploadFile.getFilePath();

		params[idx++] = studentId;
		params[idx++] = uploadFile.getOriginalFilename();
		params[idx++] = uploadFile.getFileSize();
		params[idx++] = uploadFile.getFilePath();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

}
