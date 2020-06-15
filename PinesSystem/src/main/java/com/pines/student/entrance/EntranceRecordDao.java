package com.pines.student.entrance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.EntranceConsult;
import com.pines.student.common.vo.EntranceRecord;
import com.pines.student.common.vo.EntranceRecordDetail;
import com.pines.student.common.vo.SearchCondition;
import com.pines.student.common.vo.Student;

@Repository
@Transactional(rollbackFor = Exception.class)
public class EntranceRecordDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<EntranceRecord> getEntranceRecoards(SearchCondition searchCondition) {
		int paramCount = 4;

		StringBuffer query = new StringBuffer();
		query.append("select ERC.*, ");
		query.append("       S.ROOM, ");
		query.append("       GET_NATIONALITY_CODE(S.NATIONALITY_SEQ) AS 'NATIONALITY', ");
		query.append("       GET_TERM_DETAIL_NAME(S.TERM_DETAIL_SEQ) AS 'TERM', ");
		query.append("       GET_WRITER_NAME_WITH_TITLE(ERC.STAFF_ID) AS 'STAFF_NAME', ");
		query.append("       S.NAME AS 'STUDENT_NAME', ");
		query.append("       S.ORIGINAL_BIRTHDAY AS 'BIRTHDAY', ");
		if (searchCondition.getIsExcelDownload()) {
			query.append("       S.SEX, ");
			query.append("       (SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = ERC.BRANCH_SEQ) AS 'BRANCH', ");
			query.append("       (SELECT C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = ERC.CAMPUS_SEQ) AS 'CAMPUS', ");
			query.append("       GET_WRITER_NAME_WITH_TITLE(ERC.CONSULT_STAFF_ID) AS 'CONSULT_STAFF_NAME', ");
			query.append("       DATE_FORMAT(ERC.CONSULT_DATE, '%Y/%m/%d %H:%i') AS 'FORM_CONSULT_DATE', ");
		}
		query.append("       DATE_FORMAT(ERC.OUT_DATE, '%Y/%m/%d %H:%i') AS 'FORM_OUT_DATE', ");
		query.append("       DATE_FORMAT(ERC.IN_DATE, '%Y/%m/%d %H:%i') AS 'FORM_IN_DATE', ");
		query.append("       GET_LEVEL(S.LEVEL_SEQ) AS 'LEVEL' ");
		query.append("  from ( ");
		query.append("SELECT ER.*, ");
		query.append("       IFNULL(C.CONSULT_SEQ, 0) AS CONSULT_SEQ, ");
		query.append("       C.CONSULT_RESULT, ");
		query.append("       C.CONSULT_DATE, ");
		query.append("       C.STAFF_ID AS 'CONSULT_STAFF_ID', ");
		query.append("       IFNULL(C.IS_EXCUSED, 0) AS 'IS_EXCUSED' ");
		query.append("  FROM ( ");
		if ("OUTING".equals(searchCondition.getSearchSection())) {
			query.append("          SELECT DISTINCT(R.STUDENT_ID), E.BRANCH_SEQ, E.CAMPUS_SEQ, E.ENTRANCE_SEQ, E.NAME AS 'ENTRANCE_NAME', ");
		} else {
			query.append("          SELECT R.STUDENT_ID, E.BRANCH_SEQ, E.CAMPUS_SEQ, E.ENTRANCE_SEQ, E.NAME AS 'ENTRANCE_NAME', ");
		}
		query.append("                 R.ENTRANCE_RECORD_SEQ, R.STAFF_ID, R.OUT_DATE, R.IN_DATE, R.OUT_IN_GAP_SECONDS  ");
		query.append("            FROM pia_entrances E, pia_entrance_records R ");
		query.append("           WHERE R.ENTRANCE_SEQ = E.ENTRANCE_SEQ ");
		query.append("             AND E.BRANCH_SEQ = ? ");
		query.append("             AND E.CAMPUS_SEQ = ? ");
		if (searchCondition.isEntranceSeqCondition()) {
			query.append("             AND R.ENTRANCE_SEQ = ? ");
			paramCount++;
		}

		if ("CURFEW".equals(searchCondition.getSearchSection())) {
			query.append("             AND R.IN_DATE BETWEEN STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') AND STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') ");
			query.append("             AND (ROUND(R.OUT_IN_GAP_SECONDS/60, 0) > ? OR R.OUT_IN_GAP_SECONDS = 0) "); // maximumMinute

			// query.append(" AND (R.OUT_DATE <= STR_TO_DATE(?, '%Y/%m/%d') OR R.IN_DATE >=
			// STR_TO_DATE(?, '%Y/%m/%d'))"); // searchDate
			// query.append(" AND (DATE_FORMAT(R.IN_DATE, '%H:%i%s') >= ? OR R.IN_DATE IS
			// NULL OR R.OUT_DATE IS NULL OR R.IN_DATE = '0000-00-00 00:00:00' OR R.OUT_DATE
			// = '0000-00-00 00:00:00') "); // limitedHour
			paramCount += 3;
		} else if ("ORVERTIME".equals(searchCondition.getSearchSection())) {
			query.append("             AND (R.OUT_DATE BETWEEN STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') AND STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') "); // startDate
			query.append("                  OR R.IN_DATE BETWEEN STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') AND STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s')) "); // endDate
			if (searchCondition.isOvertimeExceptionTimesCondition()) {
				query.append("             AND ( ");
				int loopCount = searchCondition.getOvertimeExceptionStartTimes().size();
				if (loopCount < 2) {
					query.append("                   (DATE_FORMAT(R.OUT_DATE, '%H:%i%s') NOT BETWEEN STR_TO_DATE(?, '%H:%i:%s') AND STR_TO_DATE(?, '%H:%i:%s')) "); // except time
					paramCount += 2;
				} else {
					for (int i = 0; i < loopCount; i++) {
						query.append("            (DATE_FORMAT(R.OUT_DATE, '%H:%i%s') NOT BETWEEN STR_TO_DATE(?, '%H:%i:%s') AND STR_TO_DATE(?, '%H:%i:%s'))");
						paramCount += 2;
						if (i < (loopCount - 1)) {
							query.append("AND");
						}
					}
				}
				query.append("                  )");
			}
			query.append("             AND ROUND(R.OUT_IN_GAP_SECONDS/60, 0) >= ? "); // maximumMinute
			// query.append(" AND DAYOFWEEK(R.OUT_DATE) NOT IN (1, 7) "); // except weekends
			paramCount += 5;
		} else if ("INCOMPLETE".equals(searchCondition.getSearchSection())) {
			query.append("             AND (R.OUT_DATE BETWEEN STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') AND STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') "); // startDate
			query.append("                  OR R.IN_DATE BETWEEN STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') AND STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s')) "); // endDate
			query.append("             AND R.OUT_IN_GAP_SECONDS < 1 "); // maximumMinute == 0
			paramCount += 4;
		} else if ("OUTING".equals(searchCondition.getSearchSection())) {
			query.append("             AND OUT_DATE BETWEEN CONCAT(DATE_FORMAT(NOW(), '%Y/%m/%d'), ' 00:00:00') AND DATE_FORMAT(NOW(), '%Y/%m/%d %H:%i:%s') ");
			query.append("             AND R.OUT_IN_GAP_SECONDS = 0 ");
			if (searchCondition.isSearchRoomCondition()) {
				query.append("             AND STUDENT_ID IN(SELECT STUDENT_ID FROM pia_students WHERE ROOM = ? AND END_CONTRACT_DATE >= NOW() AND IS_DELETED IS FALSE) ");
				paramCount += 1;
			}
		} else if ("RECORD".equals(searchCondition.getSearchSection())) {
			query.append("             AND (R.OUT_DATE BETWEEN STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') AND STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') "); // startDate
			query.append("                  OR R.IN_DATE BETWEEN STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') AND STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s')) "); // endDate
			paramCount += 4;
		}

		if (searchCondition.isSearchValueCondition()) {
			if ("STUDENT_ID".equals(searchCondition.getSearchType())) {
				query.append("    AND R.STUDENT_ID = ? ");
				paramCount++;
			} else if ("STUDENT_ID_CARD".equals(searchCondition.getSearchType())) {
				query.append("    AND R.STUDENT_ID = (SELECT S.STUDENT_ID FROM pia_students S WHERE S.ID_CARD_SERIAL_NUMBER = ?) ");
				paramCount++;
			} else if ("STUDENT_NAME".equals(searchCondition.getSearchType())) {
				query.append("    AND R.STUDENT_ID IN (SELECT STUDENT_ID FROM pia_students WHERE NAME LIKE ? AND IS_DELETED IS FALSE) ");
				paramCount++;
			}

		}

		if ("OUTING".equals(searchCondition.getSearchSection())) {
			query.append("    GROUP BY STUDENT_ID ");
			query.append("    ORDER BY OUT_DATE DESC ");
		}

		query.append("       ) ER LEFT JOIN pia_entrance_consults C ON ER.ENTRANCE_RECORD_SEQ = C.ENTRANCE_RECORD_SEQ AND C.IS_DELETED IS FALSE");
		query.append("  ) ERC, pia_students S ");
		query.append(" where ERC.STUDENT_ID = S.STUDENT_ID ");
		query.append("   and S.IS_DELETED IS FALSE ");

		if ("CURFEW".equals(searchCondition.getSearchSection())) {
			query.append(" ORDER BY IN_DATE DESC, OUT_DATE DESC, OUT_IN_GAP_SECONDS DESC ");
		} else if ("ORVERTIME".equals(searchCondition.getSearchSection())) {
			query.append(" ORDER BY IN_DATE DESC, OUT_IN_GAP_SECONDS DESC ");
		} else if ("INCOMPLETE".equals(searchCondition.getSearchSection())) {
			query.append(" ORDER BY ENTRANCE_RECORD_SEQ DESC ");
		} else if ("OUTING".equals(searchCondition.getSearchSection())) {
			query.append(" ORDER BY OUT_DATE DESC ");
		} else if ("RECORD".equals(searchCondition.getSearchSection())) {
			query.append(" ORDER BY ENTRANCE_RECORD_SEQ DESC ");
		}

		if (searchCondition.getIsExcelDownload() || searchCondition.getIsUnlimitedSearch()) {
			paramCount -= 2;
		} else {
			query.append(" LIMIT ?, ? ");
		}

		int idx = 0;
		Object[] params = new Object[paramCount];
		params[idx++] = searchCondition.getBranchSeq();
		params[idx++] = searchCondition.getCampusSeq();
		if (searchCondition.isEntranceSeqCondition()) {
			params[idx++] = searchCondition.getEntranceSeq();
		}

		if ("CURFEW".equals(searchCondition.getSearchSection())) {
			params[idx++] = searchCondition.getSearchDate() + " " + searchCondition.getLimitedHour() + ":" + searchCondition.getLimitedMinute() + ":59";
			params[idx++] = searchCondition.getSearchDate() + " 23:59:59";
			params[idx++] = searchCondition.getMaximumMinute();
		} else if ("ORVERTIME".equals(searchCondition.getSearchSection())) {
			params[idx++] = searchCondition.getStartDate() + " 00:00:00";
			params[idx++] = searchCondition.getEndDate() + " 23:59:59";
			params[idx++] = searchCondition.getStartDate() + " 00:00:00";
			params[idx++] = searchCondition.getEndDate() + " 23:59:59";
			if (searchCondition.isOvertimeExceptionTimesCondition()) {
				int loopCount = searchCondition.getOvertimeExceptionStartTimes().size();
				for (int i = 0; i < loopCount; i++) {
					params[idx++] = searchCondition.getOvertimeExceptionStartTimes().get(i) + ":00";
					params[idx++] = searchCondition.getOvertimeExceptionEndTimes().get(i) + ":00";
				}
			}
			params[idx++] = searchCondition.getMaximumMinute();
		} else if ("INCOMPLETE".equals(searchCondition.getSearchSection())) {
			params[idx++] = searchCondition.getStartDate() + " 00:00:00";
			params[idx++] = searchCondition.getEndDate() + " 23:59:59";
			params[idx++] = searchCondition.getStartDate() + " 00:00:00";
			params[idx++] = searchCondition.getEndDate() + " 23:59:59";
		} else if ("OUTING".equals(searchCondition.getSearchSection())) {
			if (searchCondition.isSearchRoomCondition()) {
				params[idx++] = searchCondition.getSearchRoom();
			}
		} else if ("RECORD".equals(searchCondition.getSearchSection())) {
			params[idx++] = searchCondition.getStartDate() + " 00:00:00";
			params[idx++] = searchCondition.getEndDate() + " 23:59:59";
			params[idx++] = searchCondition.getStartDate() + " 00:00:00";
			params[idx++] = searchCondition.getEndDate() + " 23:59:59";
		}

		if (searchCondition.isSearchValueCondition()) {
			if ("STUDENT_ID".equals(searchCondition.getSearchType()) || "STUDENT_ID_CARD".equals(searchCondition.getSearchType())) {
				params[idx++] = searchCondition.getSearchValue();
			} else if ("STUDENT_NAME".equals(searchCondition.getSearchType())) {
				params[idx++] = "%" + searchCondition.getSearchValue() + "%";
			}
		}

		if (!searchCondition.getIsExcelDownload() && !searchCondition.getIsUnlimitedSearch()) {
			params[idx++] = searchCondition.getStartIndex();
			params[idx++] = searchCondition.getOffset();
		}

		List<EntranceRecord> results = null;
		int totalCount = 0;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<EntranceRecord>(EntranceRecord.class));

			paramCount = 2;
			query.setLength(0);

			query.append("SELECT COUNT(*) ");
			query.append("  FROM ( ");
			if ("OUTING".equals(searchCondition.getSearchSection())) {
				query.append("          SELECT DISTINCT(R.STUDENT_ID), E.BRANCH_SEQ, E.CAMPUS_SEQ, E.ENTRANCE_SEQ, E.NAME AS 'ENTRANCE_NAME', ");
			} else {
				query.append("          SELECT R.STUDENT_ID, E.BRANCH_SEQ, E.CAMPUS_SEQ, E.ENTRANCE_SEQ, E.NAME AS 'ENTRANCE_NAME', ");
			}
			query.append("                 R.ENTRANCE_RECORD_SEQ, R.STAFF_ID, R.OUT_DATE, R.IN_DATE, R.OUT_IN_GAP_SECONDS  ");
			query.append("            FROM pia_entrances E, pia_entrance_records R ");
			query.append("           WHERE R.ENTRANCE_SEQ = E.ENTRANCE_SEQ ");
			query.append("             AND E.BRANCH_SEQ = ? ");
			query.append("             AND E.CAMPUS_SEQ = ? ");
			if (searchCondition.isEntranceSeqCondition()) {
				query.append("             AND R.ENTRANCE_SEQ = ? ");
				paramCount++;
			}

			if ("CURFEW".equals(searchCondition.getSearchSection())) {
				query.append("             AND R.IN_DATE BETWEEN STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') AND STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') ");
				query.append("             AND (ROUND(R.OUT_IN_GAP_SECONDS/60, 0) > ? OR R.OUT_IN_GAP_SECONDS = 0) "); // maximumMinute

				// query.append(" AND (R.OUT_DATE <= STR_TO_DATE(?, '%Y/%m/%d') OR R.IN_DATE >=
				// STR_TO_DATE(?, '%Y/%m/%d'))"); // searchDate
				// query.append(" AND (DATE_FORMAT(R.IN_DATE, '%H:%i%s') >= ? OR R.IN_DATE IS
				// NULL OR R.OUT_DATE IS NULL OR R.IN_DATE = '0000-00-00 00:00:00' OR R.OUT_DATE
				// = '0000-00-00 00:00:00') "); // limitedHour
				paramCount += 3;
			} else if ("ORVERTIME".equals(searchCondition.getSearchSection())) {
				query.append("             AND (R.OUT_DATE BETWEEN STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') AND STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') "); // startDate
				query.append("                  OR R.IN_DATE BETWEEN STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') AND STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s')) "); // endDate
				if (searchCondition.isOvertimeExceptionTimesCondition()) {
					query.append("             AND ( ");
					int loopCount = searchCondition.getOvertimeExceptionStartTimes().size();
					if (loopCount < 2) {
						query.append("                   (DATE_FORMAT(R.OUT_DATE, '%H:%i%s') NOT BETWEEN STR_TO_DATE(?, '%H:%i:%s') AND STR_TO_DATE(?, '%H:%i:%s')) "); // except time
						paramCount += 2;
					} else {
						for (int i = 0; i < loopCount; i++) {
							query.append("            (DATE_FORMAT(R.OUT_DATE, '%H:%i%s') NOT BETWEEN STR_TO_DATE(?, '%H:%i:%s') AND STR_TO_DATE(?, '%H:%i:%s'))");
							paramCount += 2;
							if (i < (loopCount - 1)) {
								query.append("AND");
							}
						}
					}
					query.append("                  )");
				}
				query.append("             AND ROUND(R.OUT_IN_GAP_SECONDS/60, 0) >= ? "); // maximumMinute
				// query.append(" AND DAYOFWEEK(R.OUT_DATE) NOT IN (1, 7) "); // except weekends
				paramCount += 5;
			} else if ("INCOMPLETE".equals(searchCondition.getSearchSection())) {
				query.append("             AND (R.OUT_DATE BETWEEN STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') AND STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') "); // startDate
				query.append("                  OR R.IN_DATE BETWEEN STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') AND STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s')) "); // endDate
				query.append("             AND R.OUT_IN_GAP_SECONDS < 1 "); // maximumMinute == 0
				paramCount += 4;
			} else if ("OUTING".equals(searchCondition.getSearchSection())) {
				query.append("             AND OUT_DATE BETWEEN CONCAT(DATE_FORMAT(NOW(), '%Y/%m/%d'), ' 00:00:00') AND DATE_FORMAT(NOW(), '%Y/%m/%d %H:%i:%s') ");
				query.append("             AND R.OUT_IN_GAP_SECONDS = 0 ");
				if (searchCondition.isSearchRoomCondition()) {
					query.append("             AND STUDENT_ID IN(SELECT STUDENT_ID FROM pia_students WHERE ROOM = ? AND END_CONTRACT_DATE >= NOW() AND IS_DELETED IS FALSE) ");
					paramCount += 1;
				}
			} else if ("RECORD".equals(searchCondition.getSearchSection())) {
				query.append("             AND (R.OUT_DATE BETWEEN STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') AND STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') "); // startDate
				query.append("                  OR R.IN_DATE BETWEEN STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s') AND STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s')) "); // endDate
				paramCount += 4;
			}

			if (searchCondition.isSearchValueCondition()) {
				if ("STUDENT_ID".equals(searchCondition.getSearchType())) {
					query.append("    AND R.STUDENT_ID = ? ");
					paramCount++;
				} else if ("STUDENT_ID_CARD".equals(searchCondition.getSearchType())) {
					query.append("    AND R.STUDENT_ID = (SELECT S.STUDENT_ID FROM pia_students S WHERE S.ID_CARD_SERIAL_NUMBER = ?) ");
					paramCount++;
				} else if ("STUDENT_NAME".equals(searchCondition.getSearchType())) {
					query.append("    AND R.STUDENT_ID IN (SELECT STUDENT_ID FROM pia_students WHERE NAME LIKE ? AND IS_DELETED IS FALSE) ");
					paramCount++;
				}

			}
			query.append("       ) ER ");

			params = new Object[paramCount];
			idx = 0;

			params[idx++] = searchCondition.getBranchSeq();
			params[idx++] = searchCondition.getCampusSeq();
			if (searchCondition.isEntranceSeqCondition()) {
				params[idx++] = searchCondition.getEntranceSeq();
			}

			if ("CURFEW".equals(searchCondition.getSearchSection())) {
				params[idx++] = searchCondition.getSearchDate() + " " + searchCondition.getLimitedHour() + ":" + searchCondition.getLimitedMinute() + ":59";
				params[idx++] = searchCondition.getSearchDate() + " 23:59:59";
				params[idx++] = searchCondition.getMaximumMinute();
			} else if ("ORVERTIME".equals(searchCondition.getSearchSection())) {
				params[idx++] = searchCondition.getStartDate() + " 00:00:00";
				params[idx++] = searchCondition.getEndDate() + " 23:59:59";
				params[idx++] = searchCondition.getStartDate() + " 00:00:00";
				params[idx++] = searchCondition.getEndDate() + " 23:59:59";
				if (searchCondition.isOvertimeExceptionTimesCondition()) {
					int loopCount = searchCondition.getOvertimeExceptionStartTimes().size();
					for (int i = 0; i < loopCount; i++) {
						params[idx++] = searchCondition.getOvertimeExceptionStartTimes().get(i) + ":00";
						params[idx++] = searchCondition.getOvertimeExceptionEndTimes().get(i) + ":00";
					}
				}
				params[idx++] = searchCondition.getMaximumMinute();
			} else if ("INCOMPLETE".equals(searchCondition.getSearchSection())) {
				params[idx++] = searchCondition.getStartDate() + " 00:00:00";
				params[idx++] = searchCondition.getEndDate() + " 23:59:59";
				params[idx++] = searchCondition.getStartDate() + " 00:00:00";
				params[idx++] = searchCondition.getEndDate() + " 23:59:59";
			} else if ("OUTING".equals(searchCondition.getSearchSection())) {
				if (searchCondition.isSearchRoomCondition()) {
					params[idx++] = searchCondition.getSearchRoom();
				}
			} else if ("RECORD".equals(searchCondition.getSearchSection())) {
				params[idx++] = searchCondition.getStartDate() + " 00:00:00";
				params[idx++] = searchCondition.getEndDate() + " 23:59:59";
				params[idx++] = searchCondition.getStartDate() + " 00:00:00";
				params[idx++] = searchCondition.getEndDate() + " 23:59:59";
			}

			if (searchCondition.isSearchValueCondition()) {
				if ("STUDENT_ID".equals(searchCondition.getSearchType()) || "STUDENT_ID_CARD".equals(searchCondition.getSearchType())) {
					params[idx++] = searchCondition.getSearchValue();
				} else if ("STUDENT_NAME".equals(searchCondition.getSearchType())) {
					params[idx++] = "%" + searchCondition.getSearchValue() + "%";
				}
			}

			totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (results.size() > 0) {
				results.get(0).setTotalCount(Tools.getInt(totalCount));
			}
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<EntranceRecord>();
		}
		return results;
	}

	public EntranceRecordDetail getEntranceConsult(int recordSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT ER.*, ");
		query.append("       IFNULL(C.CONSULT_SEQ, 0) AS 'CONSULT_SEQ', ");
		query.append("       (SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = ER.BRANCH_SEQ) AS 'BRANCH', ");
		query.append("       (SELECT C.CAMPUS_NAME FROM pia_campuses C WHERE C.CAMPUS_SEQ = ER.CAMPUS_SEQ) AS 'CAMPUS', ");
		query.append("       (SELECT S.NAME FROM pia_students S WHERE ER.STUDENT_ID = S.STUDENT_ID) AS 'STUDENT_NAME', ");
		query.append("       GET_WRITER_NAME_WITH_TITLE(ER.STAFF_ID) AS 'STAFF_NAME', ");
		query.append("       IFNULL(C.IS_EXCUSED, 0) AS 'IS_EXCUSED', ");
		query.append("       C.CONSULT_RESULT, ");
		query.append("       C.CONSULT_DATE, ");
		query.append("       DATE_FORMAT(C.CONSULT_DATE, '%Y/%m/%d %H:%i') AS 'FORM_CONSULT_DATE', ");
		query.append("       C.STAFF_ID AS 'CONSULT_STAFF_ID', ");
		query.append("       GET_WRITER_NAME_WITH_TITLE(C.STAFF_ID) AS 'CONSULT_STAFF_NAME', ");
		query.append("       DATE_FORMAT(ER.OUT_DATE, '%Y/%m/%d %H:%i') AS 'FORM_OUT_DATE', ");
		query.append("       DATE_FORMAT(ER.IN_DATE, '%Y/%m/%d %H:%i') AS 'FORM_IN_DATE' ");
		query.append("  FROM ( ");
		query.append("           SELECT E.BRANCH_SEQ, E.CAMPUS_SEQ, E.NAME AS 'ENTRANCE_NAME', ");
		query.append("                  R.ENTRANCE_RECORD_SEQ, R.STUDENT_ID, R.STAFF_ID, R.OUT_DATE, R.IN_DATE, R.OUT_IN_GAP_SECONDS ");
		query.append("             FROM pia_entrances E, pia_entrance_records R ");
		query.append("            WHERE R.ENTRANCE_SEQ = E.ENTRANCE_SEQ ");
		query.append("              AND R.ENTRANCE_RECORD_SEQ = ? ");
		query.append("        ) ER LEFT JOIN pia_entrance_consults C ON ER.ENTRANCE_RECORD_SEQ = C.ENTRANCE_RECORD_SEQ  AND C.IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = recordSeq;

		EntranceRecordDetail result = new EntranceRecordDetail();
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<EntranceRecordDetail>(EntranceRecordDetail.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new EntranceRecordDetail();
		}
		return result;
	}

	public boolean registerEntranceRecordConsult(EntranceConsult consult) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_entrance_consults ( ");
		query.append(" ENTRANCE_RECORD_SEQ, STUDENT_ID, STAFF_ID, IS_EXCUSED, CONSULT_RESULT, CONSULT_DATE, IS_DELETED ");
		query.append(") VALUES ( ");
		query.append(" ?, ?, ?, ?, ?, ?, 0 ");
		query.append(")");

		int idx = 0;
		Object[] params = new Object[6];
		params[idx++] = consult.getEntranceRecordSeq();
		params[idx++] = consult.getStudentId();
		params[idx++] = consult.getStaffId();
		params[idx++] = consult.getIsExcused();
		params[idx++] = consult.getConsultResult();
		params[idx++] = consult.getConsultDate();

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean removeEntranceRecordConsult(int recordSeq, String staffId) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_entrance_consults  ");
		query.append("   SET DELETE_STAFF_ID = ?, ");
		query.append("       IS_DELETED = 1 ");
		query.append("WHERE ENTRANCE_RECORD_SEQ = ? ");
		query.append("  AND IS_DELETED IS FALSE ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = staffId;
		params[idx++] = recordSeq;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean insertMockEntranceRecords(int campusSeq, int entranceSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT * FROM pia_students WHERE IS_DELETED IS FALSE AND END_CONTRACT_DATE >= NOW() AND CAMPUS_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = campusSeq;

		// select students
		List<Student> students = null;
		try {
			students = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Student>(Student.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			students = new ArrayList<Student>();
		}

		// insert out date
		List<Integer> entranceRecordSeqs = new ArrayList<Integer>();
		String outDate = "2018/07/29";
		int outHour = 0;
		int outMinute = 0;
		int outSecond = 0;
		query.setLength(0);
		query.append("INSERT INTO pia_entrance_records ( ");
		query.append(" ENTRANCE_SEQ, STUDENT_ID, OUT_DATE, STAFF_ID ");
		query.append(") VALUES ( ");
		query.append(" ?, ?, ?, 'mj' ");
		query.append(") ");
		for (Student student : students) {
			outHour = getRandom(8, 12);
			outMinute = getRandom(0, 59);
			outSecond = getRandom(0, 59);

			params = new Object[3];
			params[idx++] = entranceSeq;
			params[idx++] = student.getStudentId();
			params[idx++] = outDate + " " + outHour + ":" + outMinute + ":" + outSecond;
			jdbcTemplate.update(query.toString(), params);

			query.setLength(0);
			query.append("SELECT LAST_INSERT_ID() ");
			entranceRecordSeqs.add(jdbcTemplate.queryForObject(query.toString(), Integer.class));
		}

		// update in date
		int inHour = 0;
		int inMinute = 0;
		int inSecond = 0;
		query.setLength(0);
		query.append("UPDATE pia_entrance_records SET ");
		query.append("  IN_DATE = (SELECT DATE_ADD(OUT_DATE, INTERVAL ? HOUR_SECOND) FROM pia_entrance_records WHERE ENTRANCE_RECORD_SEQ = ?) ");
		query.append("WHERE ENTRANCE_RECORD_SEQ = ? ");
		params = new Object[3];
		for (Integer entranceRecordSeq : entranceRecordSeqs) {
			params[idx++] = inHour + ":" + inMinute + ":" + inSecond;
			params[idx++] = entranceRecordSeq;
			params[idx++] = entranceRecordSeq;
			jdbcTemplate.update(query.toString(), params);
		}

		// update gap minutes
		query.setLength(0);
		query.append("");
		params = new Object[1];
		for (Integer entranceRecordSeq : entranceRecordSeqs) {
			params[idx++] = entranceRecordSeq;
			jdbcTemplate.update(query.toString(), params);
		}

		return true;
	}

	private int getRandom(int start, int end) {
		return (int) (Math.random() * (end - start + 1)) + start;
	}
}
