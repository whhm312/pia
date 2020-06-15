package com.pines.student.notice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Attachment;
import com.pines.student.common.vo.Notice;
import com.pines.student.common.vo.SearchCondition;

@Repository
public class NoticeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Notice> getNotices(SearchCondition condition) {
		int whereCnt = 0;
		int limitedCnt = 2;

		StringBuffer query = new StringBuffer();
		query.append("SELECT A.* ");
		query.append("FROM ( ");
		query.append("SELECT N.*, ");
		query.append("(SELECT  B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = N.BRANCH_SEQ) as 'BRANCH', ");
		query.append("(SELECT  L.LANGUAGE_NAME FROM pia_languages L WHERE L.LANGUAGE_SEQ = N.LANGUAGE_SEQ) as  'LANGUAGE', ");
		query.append("GET_WRITER_NAME_WITH_TITLE(N.WRITER_ID) AS 'WRITER', ");
		query.append("IF(IS_POPUP, 'Popup', 'General') AS 'TYPE', ");
		query.append("IF(IS_TOP_OF_LIST, 'Top', 'General') AS 'TOP_OF_LIST', ");
		query.append("DATE_FORMAT(N.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(N.POPUP_START_DATE, '%Y/%m/%d') AS 'FORM_POPUP_START_DATE', ");
		query.append("DATE_FORMAT(N.POPUP_END_DATE, '%Y/%m/%d') AS 'FORM_POPUP_END_DATE' ");
		query.append("FROM pia_notices N ");
		query.append(") A ");

		StringBuffer queryWhere = new StringBuffer();
		queryWhere.append("WHERE IS_DELETED IS FALSE ");
		queryWhere.append("  AND BRANCH_SEQ = ? ");
		++whereCnt;
		if (condition.isLanguagesCondition()) {
			queryWhere.append("  AND ");
			if (condition.getIsForAll()) {
				queryWhere.append("  ( ");
			}
			queryWhere.append("  LANGUAGE_SEQ IN ( ");
			for (int i = 0; i < condition.getLanguageSeqs().length; i++) {
				queryWhere.append(" ? ");
				++whereCnt;
				if (i == 0 && condition.getLanguageSeqs().length > 1) {
					queryWhere.append(",");
				} else if (i > 0 && (condition.getLanguageSeqs().length - 1) > i) {
					queryWhere.append(",");
				}
			}

			queryWhere.append(" ) ");

			if (condition.getIsForAll()) {
				queryWhere.append("  OR IS_FOR_ALL IS TRUE )");
			}
		} else {
			if (condition.getIsForAll()) {
				queryWhere.append(" OR IS_FOR_ALL IS TRUE");
			}
		}

		if (condition.getIsPopup()) {
			queryWhere.append("  AND IS_POPUP IS TRUE ");
		}

		if (condition.isWriterCondition()) {
			queryWhere.append("  AND WRITER LIKE ? ");
			++whereCnt;
		}

		if (condition.isTitleContentCondition()) {
			queryWhere.append("  AND ( TITLE LIKE ? OR CONTENT LIKE ? )");
			whereCnt += 2;
		}

		query.append(queryWhere);

		StringBuffer queryOrder = new StringBuffer();
		queryOrder.append(" ORDER BY IS_TOP_OF_LIST DESC, IS_FOR_ALL DESC, REGISTER_DATE DESC, LANGUAGE_SEQ ");
		query.append(queryOrder);

		StringBuffer queryLimit = new StringBuffer();
		queryLimit.append(" LIMIT ?, ? ");
		query.append(queryLimit);

		int idx = 0;
		Object[] params = new Object[whereCnt + limitedCnt];
		params[idx++] = condition.getBranchSeq();

		if (condition.isLanguagesCondition()) {
			for (int seq : condition.getLanguageSeqs()) {
				params[idx++] = seq;
			}
		}

		if (condition.isWriterCondition()) {
			params[idx++] = "%" + condition.getWriter() + "%";
		}

		if (condition.isTitleContentCondition()) {
			params[idx++] = "%" + condition.getTitleContent() + "%";
			params[idx++] = "%" + condition.getTitleContent() + "%";
		}

		params[idx++] = condition.getStartIndex();
		params[idx++] = condition.getOffset();

		List<Notice> results = null;
		Integer totalCount = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Notice>(Notice.class));

			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("FROM ( ");
			query.append("SELECT N.*, ");
			query.append("(SELECT  B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = N.BRANCH_SEQ) as 'BRANCH', ");
			query.append("(SELECT  L.LANGUAGE_NAME FROM pia_languages L WHERE L.LANGUAGE_SEQ = N.LANGUAGE_SEQ) as  'LANGUAGE', ");
			query.append("GET_WRITER_NAME_WITH_TITLE(N.WRITER_ID) AS 'WRITER', ");
			query.append("DATE_FORMAT(N.REGISTER_DATE, '%Y/%m/%d %r') AS 'FORM_REGISTER_DATE', ");
			query.append("DATE_FORMAT(N.POPUP_START_DATE, '%Y/%m/%d') AS 'FORM_POPUP_START_DATE', ");
			query.append("DATE_FORMAT(N.POPUP_END_DATE, '%Y/%m/%d') AS 'FORM_POPUP_END_DATE' ");
			query.append("FROM pia_notices N ");
			query.append(") A ");
			query.append(queryWhere);

			idx = 0;
			params = new Object[whereCnt];
			params[idx++] = condition.getBranchSeq();

			if (condition.isLanguagesCondition()) {
				for (int seq : condition.getLanguageSeqs()) {
					params[idx++] = seq;
				}
			}

			if (condition.isWriterCondition()) {
				params[idx++] = "%" + condition.getWriter() + "%";
			}

			if (condition.isTitleContentCondition()) {
				params[idx++] = "%" + condition.getTitleContent() + "%";
				params[idx++] = "%" + condition.getTitleContent() + "%";
			}

			totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (results.size() > 0) {
				results.get(0).setTotalCount(Tools.getInt(totalCount));
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<Notice>();
		}

		return results;
	}

	public List<Notice> getNotices(int branchSeq, int languageSeq, int startIndex, int offset) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT N.*, ");
		query.append("(SELECT  B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = N.BRANCH_SEQ) as 'BRANCH', ");
		query.append("(SELECT  L.LANGUAGE_NAME FROM pia_languages L WHERE L.LANGUAGE_SEQ = N.LANGUAGE_SEQ) as  'LANGUAGE', ");
		query.append("GET_WRITER_NAME_WITH_TITLE(N.WRITER_ID) AS 'WRITER', ");
		query.append("DATE_FORMAT(N.REGISTER_DATE, '%m/%d') AS 'FORM_SHORT_REGISTER_DATE', ");
		query.append("DATE_FORMAT(N.REGISTER_DATE, '%Y/%m/%d %r') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(N.POPUP_START_DATE, '%Y/%m/%d') AS 'FORM_POPUP_START_DATE', ");
		query.append("DATE_FORMAT(N.POPUP_END_DATE, '%Y/%m/%d') AS 'FORM_POPUP_END_DATE' ");
		query.append("FROM pia_notices N ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND BRANCH_SEQ = ? ");
		query.append("  AND (LANGUAGE_SEQ = ? OR IS_FOR_ALL IS TRUE) ");
		query.append(" ORDER BY IS_TOP_OF_LIST DESC, IS_FOR_ALL DESC, REGISTER_DATE DESC, LANGUAGE_SEQ ");
		query.append(" LIMIT ?, ? ");

		int idx = 0;
		Object[] params = new Object[4];
		params[idx++] = branchSeq;
		params[idx++] = languageSeq;
		params[idx++] = startIndex;
		params[idx++] = offset;

		List<Notice> results = null;
		int totalCount = 0;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<Notice>(Notice.class));

			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("FROM pia_notices ");
			query.append("WHERE IS_DELETED IS FALSE ");
			query.append("  AND BRANCH_SEQ = ? ");
			query.append("  AND (LANGUAGE_SEQ = ? OR IS_FOR_ALL IS TRUE) ");

			idx = 0;
			params = new Object[2];
			params[idx++] = branchSeq;
			params[idx++] = languageSeq;

			totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (results.size() > 0) {
				results.get(0).setTotalCount(Tools.getInt(totalCount));
			}
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<Notice>();
		}
		return results;
	}

	public Notice getNotice(int branchSeq, int noticeSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT N.*, ");
		query.append("(SELECT  B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = N.BRANCH_SEQ) as 'BRANCH', ");
		query.append("(SELECT  L.LANGUAGE_NAME FROM pia_languages L WHERE L.LANGUAGE_SEQ = N.LANGUAGE_SEQ) as  'LANGUAGE', ");
		query.append("GET_WRITER_NAME_WITH_TITLE(N.WRITER_ID) AS 'WRITER', ");
		query.append("DATE_FORMAT(N.REGISTER_DATE, '%Y/%m/%d %r') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(N.POPUP_START_DATE, '%Y/%m/%d') AS 'FORM_POPUP_START_DATE', ");
		query.append("DATE_FORMAT(N.POPUP_END_DATE, '%Y/%m/%d') AS 'FORM_POPUP_END_DATE', ");
		query.append("A.FILE_DOWNLOAD_URL, ");
		query.append("A.ORIGINAL_FILENAME ");
		query.append("FROM pia_notices N LEFT JOIN pia_notice_attachments A ON A.NOTICE_SEQ = N.NOTICE_SEQ ");
		query.append("WHERE N.IS_DELETED IS FALSE ");
		query.append("  AND N.BRANCH_SEQ = ? ");
		query.append("  AND N.NOTICE_SEQ = ?");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = noticeSeq;

		Notice result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<Notice>(Notice.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new Notice();
		}
		return result;
	}

	@Transactional(rollbackFor = Exception.class)
	public int addNotice(Notice notice, Attachment attachment) {
		int noticeSeq = 0;
		StringBuffer query = new StringBuffer();
		if (notice.getIsPopup()) {
			query.append("INSERT INTO pia_notices ( ");
			query.append("BRANCH_SEQ, LANGUAGE_SEQ, TITLE, CONTENT, WRITER_ID, ");
			query.append("HAS_ATTACHMENT, IS_FOR_ALL, IS_TOP_OF_LIST, IS_POPUP, ");
			query.append("POPUP_START_DATE, POPUP_END_DATE, ");
			query.append("REGISTER_DATE, IS_DELETED ");
			query.append(") ");
			query.append("VALUES ");
			query.append("( ");
			query.append("?, ?, ?, ?, ?, ");
			query.append("?, ?, ?, ?, ");
			query.append("STR_TO_DATE(?, '%Y/%m/%d'), STR_TO_DATE(?, '%Y/%m/%d'), ");
			query.append("NOW(), 0 ");
			query.append(") ");

			int idx = 0;
			Object[] params = new Object[11];
			params[idx++] = notice.getBranchSeq();
			params[idx++] = notice.getLanguageSeq();
			params[idx++] = notice.getTitle();
			params[idx++] = notice.getContent();
			params[idx++] = notice.getWriterId();

			params[idx++] = notice.hasAttachment();
			params[idx++] = notice.getIsForAll();
			params[idx++] = notice.getIsTopOfList();
			params[idx++] = notice.getIsPopup();
			params[idx++] = notice.getPopupStartDate();
			params[idx++] = notice.getPopupEndDate();

			jdbcTemplate.update(query.toString(), params);
		} else {
			query.append("INSERT INTO pia_notices ( ");
			query.append("BRANCH_SEQ, LANGUAGE_SEQ, TITLE, CONTENT, WRITER_ID, ");
			query.append("HAS_ATTACHMENT, IS_FOR_ALL, IS_TOP_OF_LIST, IS_POPUP, ");
			query.append("REGISTER_DATE, IS_DELETED ");
			query.append(") ");
			query.append("VALUES ");
			query.append("( ");
			query.append("?, ?, ?, ?, ?, ");
			query.append("?, ?, ?, ?, ");
			query.append("NOW(), 0 ");
			query.append(") ");

			int idx = 0;
			Object[] params = new Object[9];
			params[idx++] = notice.getBranchSeq();
			params[idx++] = notice.getLanguageSeq();
			params[idx++] = notice.getTitle();
			params[idx++] = notice.getContent();
			params[idx++] = notice.getWriterId();

			params[idx++] = notice.hasAttachment();
			params[idx++] = notice.getIsForAll();
			params[idx++] = notice.getIsTopOfList();
			params[idx++] = notice.getIsPopup();

			jdbcTemplate.update(query.toString(), params);
		}

		query.setLength(0);
		query.append("SELECT LAST_INSERT_ID() ");
		noticeSeq = jdbcTemplate.queryForObject(query.toString(), Integer.class);

		if (notice.hasAttachment()) {

			query.setLength(0);
			query.append("INSERT INTO pia_notice_attachments ( ");
			query.append("NOTICE_SEQ, ORIGINAL_FILENAME, FILE_DOWNLOAD_URL, FILE_SIZE, REGISTER_DATE ");
			query.append(") ");
			query.append("VALUES ");
			query.append("( ");
			query.append("LAST_INSERT_ID(), ?, ?, ?, NOW() ");
			query.append(") ");

			int idx = 0;
			Object[] params = new Object[3];
			params[idx++] = attachment.getOriginalFilename();
			params[idx++] = attachment.getFileDownloadUrl();
			params[idx++] = attachment.getFileSize();

			jdbcTemplate.update(query.toString(), params);
		}
		return noticeSeq;
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean changeNotice(Notice notice, Attachment attachment) {
		StringBuffer query = new StringBuffer();
		int idx = 0;
		Object[] params = null;
		boolean isSuccessed = false;

		if (notice.getIsDeleteAttachment()) {
			query.setLength(0);
			query.append("DELETE FROM pia_notice_attachments ");
			query.append(" WHERE NOTICE_SEQ = ? ");

			idx = 0;
			params = new Object[1];
			params[idx++] = notice.getNoticeSeq();

			isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		}

		if (notice.hasAttachment() && Tools.isNotNull(attachment.getFileDownloadUrl())) {
			query.setLength(0);
			query.append("INSERT INTO pia_notice_attachments ( ");
			query.append("NOTICE_SEQ, ORIGINAL_FILENAME, FILE_DOWNLOAD_URL, FILE_SIZE, REGISTER_DATE ");
			query.append(") ");
			query.append("VALUES ");
			query.append("( ");
			query.append("?, ?, ?, ?, NOW() ");
			query.append(") ");
			query.append("ON DUPLICATE KEY UPDATE NOTICE_SEQ = ?, ");
			query.append(" ORIGINAL_FILENAME = ?, FILE_DOWNLOAD_URL = ?, FILE_SIZE = ?, REGISTER_DATE = NOW() ");

			idx = 0;
			params = new Object[8];
			params[idx++] = notice.getNoticeSeq();
			params[idx++] = attachment.getOriginalFilename();
			params[idx++] = attachment.getFileDownloadUrl();
			params[idx++] = attachment.getFileSize();

			params[idx++] = notice.getNoticeSeq();
			params[idx++] = attachment.getOriginalFilename();
			params[idx++] = attachment.getFileDownloadUrl();
			params[idx++] = attachment.getFileSize();

			isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		}

		query.setLength(0);
		query.append("UPDATE pia_notices SET ");
		query.append("TITLE = ?, CONTENT = ?, HAS_ATTACHMENT = (SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END hasAttachment FROM pia_notice_attachments  WHERE NOTICE_SEQ = ?), ");
		query.append("IS_FOR_ALL = ?, IS_TOP_OF_LIST = ?, IS_POPUP = ?, POPUP_START_DATE = ?, POPUP_END_DATE = ? ");
		query.append("WHERE BRANCH_SEQ = ? ");
		query.append("AND NOTICE_SEQ = ? ");

		idx = 0;
		params = new Object[10];
		params[idx++] = notice.getTitle();
		params[idx++] = notice.getContent();
		params[idx++] = notice.getNoticeSeq();

		params[idx++] = notice.getIsForAll();
		params[idx++] = notice.getIsTopOfList();
		params[idx++] = notice.getIsPopup();
		params[idx++] = notice.getPopupStartDate();
		params[idx++] = notice.getPopupEndDate();

		params[idx++] = notice.getBranchSeq();
		params[idx++] = notice.getNoticeSeq();

		isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		return isSuccessed;
	}

	public boolean removeNotice(int branchSeq, int noticeSeq) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_notices ");
		query.append("   SET ");
		query.append(" IS_DELETED = 1 ");
		query.append(" WHERE BRANCH_SEQ = ? ");
		query.append("   AND NOTICE_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = noticeSeq;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

	public boolean isValidWriter(int branchSeq, int noticeSeq, String writerId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT COUNT(*) ");
		query.append("FROM pia_notices N ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND BRANCH_SEQ = ? ");
		query.append("  AND NOTICE_SEQ = ?");
		query.append("  AND WRITER_ID = ?");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = branchSeq;
		params[idx++] = noticeSeq;
		params[idx++] = writerId;

		try {
			return jdbcTemplate.queryForObject(query.toString(), params, Integer.class) > 0;
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return false;
		}
	}

	public String getDeleteAttachmentPath(int noticeSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT FILE_DOWNLOAD_URL ");
		query.append("FROM pia_notice_attachments ");
		query.append("WHERE NOTICE_SEQ = ?");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = noticeSeq;
		try {
			return jdbcTemplate.queryForObject(query.toString(), params, String.class);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return "";
		}
	}

}
