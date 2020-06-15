package com.pines.student.guide;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pines.student.common.Tools;
import com.pines.student.common.vo.Attachment;
import com.pines.student.common.vo.FreshmanGuide;
import com.pines.student.common.vo.SearchCondition;

@Repository
@Transactional(rollbackFor = Exception.class)
public class FreshmanGuideDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<FreshmanGuide> getFreshmanGuides(SearchCondition condition) {
		StringBuffer query = new StringBuffer();
		int totalCnt = 3;
		query.append("SELECT A.*  ");
		query.append("FROM ( ");
		query.append("SELECT G.*, ");
		query.append("(SELECT N.GROUP_NAME FROM pia_student_groups N WHERE N.STUDENT_GROUP_SEQ = G.STUDENT_GROUP_SEQ) AS 'GROUP_NAME', ");
		query.append("(SELECT B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = G.BRANCH_SEQ) AS 'BRANCH', ");
		query.append("GET_NATIONALITY(G.NATIONALITY_SEQ) AS 'NATIONALITY', ");
		query.append("CONVERT(GET_WRITER_NAME_WITH_TITLE(G.WRITER_ID) USING utf8) AS 'WRITER', ");
		query.append("DATE_FORMAT(G.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE' ");
		query.append("FROM pia_freshman_guides G ");
		query.append(") A ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND BRANCH_SEQ = ? ");

		if (condition.isNationalitiesCondition()) {
			query.append("  AND NATIONALITY_SEQ IN ( ");
			for (int i = 0; i < condition.getNationalitySeqs().length; i++) {
				query.append(" ? ");
				++totalCnt;
				if (i == 0 && condition.getNationalitySeqs().length > 1) {
					query.append(",");
				} else if (i > 0 && (condition.getNationalitySeqs().length - 1) > i) {
					query.append(",");
				}
			}

			query.append(" ) ");
		}

		if (condition.isWriterCondition()) {
			query.append("  AND WRITER LIKE ? ");
			++totalCnt;
		}
		if (condition.isTitleContentCondition()) {
			query.append("  AND ( TITLE LIKE ? OR CONTENT LIKE ? )");
			totalCnt += 2;
		}
		if (condition.isGroupCondition()) {
			query.append("  AND STUDENT_GROUP_SEQ = ? ");
			++totalCnt;
		}
		query.append(" ORDER BY REGISTER_DATE DESC, NATIONALITY_SEQ ");
		query.append(" LIMIT ?, ? ");

		int idx = 0;
		Object[] params = new Object[totalCnt];
		params[idx++] = condition.getBranchSeq();
		if (condition.isNationalitiesCondition()) {
			for (int seq : condition.getNationalitySeqs()) {
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

		if (condition.isGroupCondition()) {
			params[idx++] = condition.getGroupSeq();
		}
		params[idx++] = condition.getStartIndex();
		params[idx++] = condition.getOffset();

		List<FreshmanGuide> results = null;
		Integer totalCount = null;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<FreshmanGuide>(FreshmanGuide.class));

			totalCnt = 1;
			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("FROM ( ");
			query.append("SELECT G.*, ");
			query.append("CONVERT(GET_WRITER_NAME_WITH_TITLE(G.WRITER_ID) USING utf8) AS 'WRITER' ");
			query.append("FROM pia_freshman_guides G ");
			query.append(") A ");
			query.append("WHERE IS_DELETED IS FALSE ");
			query.append("  AND BRANCH_SEQ = ? ");
			if (condition.isNationalitiesCondition()) {
				query.append("  AND NATIONALITY_SEQ IN ( ");
				for (int i = 0; i < condition.getNationalitySeqs().length; i++) {
					query.append(" ? ");
					++totalCnt;
					if (i == 0 && condition.getNationalitySeqs().length > 1) {
						query.append(",");
					} else if (i > 0 && (condition.getNationalitySeqs().length - 1) > i) {
						query.append(",");
					}
				}

				query.append(" ) ");
			}
			if (condition.isWriterCondition()) {
				query.append("  AND WRITER LIKE ? ");
				++totalCnt;
			}
			if (condition.isTitleContentCondition()) {
				query.append("  AND ( TITLE LIKE ? OR CONTENT LIKE ? )");
				totalCnt += 2;
			}
			if (condition.isGroupCondition()) {
				query.append("  AND STUDENT_GROUP_SEQ = ? ");
				++totalCnt;
			}

			idx = 0;
			params = new Object[totalCnt];
			params[idx++] = condition.getBranchSeq();
			if (condition.isNationalitiesCondition()) {
				for (int seq : condition.getNationalitySeqs()) {
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
			if (condition.isGroupCondition()) {
				params[idx++] = condition.getGroupSeq();
			}

			totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (results.size() > 0) {
				results.get(0).setTotalCount(Tools.getInt(totalCount));
			}

		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<FreshmanGuide>();
		}

		return results;
	}

	public List<FreshmanGuide> getFreshmanGuides(int branchSeq, int nationalitySeq, int startIndex, int offset) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT G.*, ");
		query.append("(SELECT  B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = G.BRANCH_SEQ) as 'BRANCH', ");
		query.append("GET_NATIONALITY(G.NATIONALITY_SEQ) as  'NATIONALITY', ");
		query.append("GET_WRITER_NAME_WITH_TITLE(G.WRITER_ID) AS 'WRITER', ");
		query.append("DATE_FORMAT(G.REGISTER_DATE, '%Y/%m/%d') AS 'FORM_REGISTER_DATE', ");
		query.append("DATE_FORMAT(G.REGISTER_DATE, '%m/%d') AS 'SHORT_FORM_REGISTER_DATE' ");
		query.append("FROM pia_freshman_guides G ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND BRANCH_SEQ = ? ");
		query.append("  AND NATIONALITY_SEQ = ? ");
		query.append(" ORDER BY REGISTER_DATE DESC, NATIONALITY_SEQ ");
		query.append(" LIMIT ?, ? ");

		int idx = 0;
		Object[] params = new Object[4];
		params[idx++] = branchSeq;
		params[idx++] = nationalitySeq;
		params[idx++] = startIndex;
		params[idx++] = offset;

		List<FreshmanGuide> results = null;
		int totalCount = 0;
		try {
			results = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<FreshmanGuide>(FreshmanGuide.class));

			query.setLength(0);
			query.append("SELECT COUNT(*) ");
			query.append("FROM pia_freshman_guides ");
			query.append("WHERE IS_DELETED IS FALSE ");
			query.append("  AND BRANCH_SEQ = ? ");
			query.append("  AND NATIONALITY_SEQ = ? ");

			idx = 0;
			params = new Object[2];
			params[idx++] = branchSeq;
			params[idx++] = nationalitySeq;

			totalCount = jdbcTemplate.queryForObject(query.toString(), params, Integer.class);
			if (results.size() > 0) {
				results.get(0).setTotalCount(Tools.getInt(totalCount));
			}
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			results = new ArrayList<FreshmanGuide>();
		}
		return results;
	}

	public FreshmanGuide getFreshmanGuide(int branchSeq, int guideSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT N.*, ");
		query.append("(SELECT  B.BRANCH_NAME FROM pia_branches B WHERE B.BRANCH_SEQ = N.BRANCH_SEQ) as 'BRANCH', ");
		query.append("(SELECT  G.GROUP_NAME FROM pia_student_groups G WHERE G.STUDENT_GROUP_SEQ = N.STUDENT_GROUP_SEQ) as  'GROUP_NAME', ");
		query.append("GET_NATIONALITY(N.NATIONALITY_SEQ) as  'NATIONALITY', ");
		query.append("GET_WRITER_NAME_WITH_TITLE(N.WRITER_ID) AS 'WRITER', ");
		query.append("DATE_FORMAT(N.REGISTER_DATE, '%Y/%m/%d %r') AS 'FORM_REGISTER_DATE', ");
		query.append("A.FILE_DOWNLOAD_URL, ");
		query.append("A.ORIGINAL_FILENAME ");
		query.append("FROM pia_freshman_guides N left join pia_freshman_guide_attachments A on A.FRESHMAN_GUIDE_SEQ = N.FRESHMAN_GUIDE_SEQ ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND BRANCH_SEQ = ? ");
		query.append("  AND N.FRESHMAN_GUIDE_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = guideSeq;

		FreshmanGuide result = null;
		try {
			result = jdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<FreshmanGuide>(FreshmanGuide.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			result = new FreshmanGuide();
		}
		return result;
	}

	public int addFreshmanGuide(FreshmanGuide guide, Attachment attachment) {
		int guideSeq = 0;
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO pia_freshman_guides ( ");
		query.append("BRANCH_SEQ, NATIONALITY_SEQ, TITLE, CONTENT, WRITER_ID, HAS_ATTACHMENT, ");
		query.append("STUDENT_GROUP_SEQ, REGISTER_DATE, IS_DELETED ");
		query.append(") ");
		query.append("VALUES ");
		query.append("( ");
		query.append("?, ?, ?, ?, ?, ?, ");
		query.append("?, NOW(), 0 ");
		query.append(") ");

		int idx = 0;
		Object[] params = new Object[7];
		params[idx++] = guide.getBranchSeq();
		params[idx++] = guide.getNationalitySeq();
		params[idx++] = guide.getTitle();
		params[idx++] = guide.getContent();
		params[idx++] = guide.getWriterId();
		params[idx++] = guide.hasAttachment();
		params[idx++] = guide.getStudentGroupSeq();

		jdbcTemplate.update(query.toString(), params);

		query.setLength(0);
		query.append("SELECT LAST_INSERT_ID() ");
		guideSeq = jdbcTemplate.queryForObject(query.toString(), Integer.class);

		if (guide.hasAttachment()) {
			query.setLength(0);
			query.append("INSERT INTO pia_freshman_guide_attachments ( ");
			query.append("FRESHMAN_GUIDE_SEQ, ORIGINAL_FILENAME, FILE_DOWNLOAD_URL, FILE_SIZE, REGISTER_DATE ");
			query.append(") ");
			query.append("VALUES ");
			query.append("( ");
			query.append("LAST_INSERT_ID(), ?, ?, ?, NOW() ");
			query.append(") ");

			idx = 0;
			params = new Object[3];
			params[idx++] = attachment.getOriginalFilename();
			params[idx++] = attachment.getFileDownloadUrl();
			params[idx++] = attachment.getFileSize();

			jdbcTemplate.update(query.toString(), params);
		}

		return guideSeq;
	}

	public boolean isValidWriter(int branchSeq, int guideSeq, String writerId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT COUNT(*) ");
		query.append("FROM pia_freshman_guides ");
		query.append("WHERE IS_DELETED IS FALSE ");
		query.append("  AND BRANCH_SEQ = ? ");
		query.append("  AND FRESHMAN_GUIDE_SEQ = ? ");
		query.append("  AND WRITER_ID = ? ");

		int idx = 0;
		Object[] params = new Object[3];
		params[idx++] = branchSeq;
		params[idx++] = guideSeq;
		params[idx++] = writerId;

		try {
			return jdbcTemplate.queryForObject(query.toString(), params, Integer.class) > 0;
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return false;
		}
	}

	public String getDeleteAttachmentPath(int guideSeq) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT FILE_DOWNLOAD_URL ");
		query.append("FROM pia_freshman_guide_attachments ");
		query.append("WHERE FRESHMAN_GUIDE_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[1];
		params[idx++] = guideSeq;
		try {
			return jdbcTemplate.queryForObject(query.toString(), params, String.class);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return "";
		}
	}

	public boolean changeFreshmanGuide(FreshmanGuide guide, Attachment attachment) {
		StringBuffer query = new StringBuffer();
		int idx = 0;
		Object[] params = null;
		boolean isSuccessed = false;

		if (guide.getIsDeleteAttachment()) {
			query.setLength(0);
			query.append("DELETE FROM pia_freshman_guide_attachments ");
			query.append(" WHERE FRESHMAN_GUIDE_SEQ = ? ");

			idx = 0;
			params = new Object[1];
			params[idx++] = guide.getFreshmanGuideSeq();

			isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		}

		if (guide.hasAttachment() && Tools.isNotNull(attachment.getFileDownloadUrl())) {
			query.setLength(0);
			query.append("INSERT INTO pia_freshman_guide_attachments ( ");
			query.append("FRESHMAN_GUIDE_SEQ, ORIGINAL_FILENAME, FILE_DOWNLOAD_URL, FILE_SIZE, REGISTER_DATE ");
			query.append(") ");
			query.append("VALUES ");
			query.append("( ");
			query.append("?, ?, ?, ?, NOW() ");
			query.append(") ");
			query.append("ON DUPLICATE KEY UPDATE FRESHMAN_GUIDE_SEQ = ?, ");
			query.append(" ORIGINAL_FILENAME = ?, FILE_DOWNLOAD_URL = ?, FILE_SIZE = ?, REGISTER_DATE = NOW() ");

			idx = 0;
			params = new Object[8];
			params[idx++] = guide.getFreshmanGuideSeq();
			params[idx++] = attachment.getOriginalFilename();
			params[idx++] = attachment.getFileDownloadUrl();
			params[idx++] = attachment.getFileSize();

			params[idx++] = guide.getFreshmanGuideSeq();
			params[idx++] = attachment.getOriginalFilename();
			params[idx++] = attachment.getFileDownloadUrl();
			params[idx++] = attachment.getFileSize();

			isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;
		}

		query.setLength(0);
		query.append("UPDATE pia_freshman_guides SET ");
		query.append("TITLE = ?, CONTENT = ?, HAS_ATTACHMENT = (SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END hasAttachment FROM pia_freshman_guide_attachments  WHERE FRESHMAN_GUIDE_SEQ = ?)  ");
		query.append("WHERE BRANCH_SEQ = ? ");
		query.append("AND FRESHMAN_GUIDE_SEQ = ? ");

		idx = 0;
		params = new Object[5];
		params[idx++] = guide.getTitle();
		params[idx++] = guide.getContent();
		params[idx++] = guide.getFreshmanGuideSeq();
		params[idx++] = guide.getBranchSeq();
		params[idx++] = guide.getFreshmanGuideSeq();

		isSuccessed = jdbcTemplate.update(query.toString(), params) > 0;

		return isSuccessed;
	}

	public boolean removeFreshmanGuide(int branchSeq, int guideSeq) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE pia_freshman_guides ");
		query.append("   SET ");
		query.append(" IS_DELETED = 1 ");
		query.append(" WHERE BRANCH_SEQ = ? ");
		query.append("   AND FRESHMAN_GUIDE_SEQ = ? ");

		int idx = 0;
		Object[] params = new Object[2];
		params[idx++] = branchSeq;
		params[idx++] = guideSeq;

		return jdbcTemplate.update(query.toString(), params) > 0;
	}

}
