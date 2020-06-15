package com.pines.student.pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pines.student.common.Tools;
import com.pines.student.common.code.ResultCode;
import com.pines.student.common.vo.PosTransaction;
import com.pines.student.common.vo.StudentIdCard;
import com.pines.student.common.vo.StudentPosBalance;

@Repository
@Transactional(rollbackFor = Exception.class)
public class PosDao {

	@Qualifier(value = "posDataSource")
	JdbcTemplate posJdbcTemplate;

	public PosDao(@Qualifier(value = "posDataSource") DataSource dataSource) {
		posJdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean isNotDuplicatedInPosSystem(String studentId) {
		return getAccountIdByStudentId(studentId) < 1;
	}

	public int getAccountIdByStudentId(String studentId) {
		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT AccountId FROM [dbo].[Entities] WHERE CustomData LIKE ? ");
			Object[] params = new Object[] { "%" + studentId + "%" };

			return posJdbcTemplate.queryForObject(query.toString(), params, Integer.class);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return 0;
		}
	}

	public boolean insertPosSystem(StudentIdCard studentIdCard) throws Exception {
		if (Tools.isEmpty(studentIdCard.getIdCardSerialNumber())) {
			throw new Exception(ResultCode.STATUS_10009.getMessage());
		}

		StringBuffer query = new StringBuffer();

		int idx = 0;
		Object[] params = new Object[1];

		try {

			query.append("INSERT INTO [dbo].[Accounts] (AccountTypeId, ForeignCurrencyId, Name) ");
			query.append("VALUES (5, 0, ?) ");

			params[idx++] = Tools.blankInsteadOfNull(studentIdCard.getStudentName()) + "-" + studentIdCard.getIdCardSerialNumber();

			KeyHolder keyHolder = new GeneratedKeyHolder();
			posJdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(query.toString(), new String[] { "id" });
					ps.setString(1, Tools.blankInsteadOfNull(studentIdCard.getStudentName()) + "-" + studentIdCard.getIdCardSerialNumber());
					return ps;
				}
			}, keyHolder);

			int accountId = keyHolder.getKey().intValue();

			if (accountId > 0) {
				query.setLength(0);
				query.append("INSERT INTO [dbo].[Entities] (EntityTypeId, LastUpdateTime, CustomData, AccountId, WarehouseId, Name) ");
				query.append("VALUES (1, GETDATE(), ?, ?, 0, ?) ");

				idx = 0;
				params = new Object[3];
				params[idx++] = getStudentSearchConditionFormInPos(studentIdCard);
				params[idx++] = accountId;
				params[idx++] = studentIdCard.getStudentName();

				boolean isSuccessed = posJdbcTemplate.update(query.toString(), params) > 0;
				if (!isSuccessed) {
					throw new Exception(ResultCode.STATUS_10008.getMessage());
				}

				return isSuccessed;
			} else {
				throw new Exception(ResultCode.STATUS_10007.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public boolean updatePosSystem(StudentIdCard studentIdCard) throws Exception {
		if (Tools.isEmpty(studentIdCard.getIdCardSerialNumber())) {
			throw new Exception(ResultCode.STATUS_10009.getMessage());
		}

		StringBuffer query = new StringBuffer();

		int idx = 0;
		Object[] params = new Object[2];

		try {

			int accountId = getAccountIdByStudentId(studentIdCard.getStudentId());

			query.append("UPDATE [dbo].[Accounts] SET Name = ? ");
			query.append("WHERE id = ? ");

			params[idx++] = Tools.blankInsteadOfNull(studentIdCard.getStudentName()) + "-" + studentIdCard.getIdCardSerialNumber();
			params[idx++] = accountId;

			boolean isSuccessed = posJdbcTemplate.update(query.toString(), params) > 0;
			if (isSuccessed) {
				query.setLength(0);
				query.append("UPDATE [dbo].[Entities] SET ");
				query.append("       LastUpdateTime = GETDATE(), CustomData = ?, Name = ? ");
				query.append(" WHERE AccountId = ? ");

				idx = 0;
				params = new Object[3];
				params[idx++] = getStudentSearchConditionFormInPos(studentIdCard);
				params[idx++] = studentIdCard.getStudentName();
				params[idx++] = accountId;

				isSuccessed = posJdbcTemplate.update(query.toString(), params) > 0;
				if (!isSuccessed) {
					throw new Exception(ResultCode.STATUS_10008.getMessage());
				}

				return isSuccessed;
			} else {
				throw new Exception(ResultCode.STATUS_10007.getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * POS에서 학생 검색할때 사용하는 키와 값. Name 항목의 값들이 POS 시스템에서 보여지는 항목과 다르면 POS 에서 안나타남.
	 * 
	 * @param studentIdCard
	 * @return
	 */
	private String getStudentSearchConditionFormInPos(StudentIdCard studentIdCard) {
		JSONObject customDataCardId = new JSONObject();
		customDataCardId.put("Name", "CardID");
		customDataCardId.put("Value", studentIdCard.getIdCardSerialNumber());

		JSONObject customDataAddress = new JSONObject();
		customDataAddress.put("Name", "Address");
		customDataAddress.put("Value", "");

		JSONObject customDataStudentId = new JSONObject();
		customDataStudentId.put("Name", "Student ID");
		customDataStudentId.put("Value", studentIdCard.getStudentId());

		List<JSONObject> customData = new ArrayList<JSONObject>();
		customData.add(customDataCardId);
		customData.add(customDataAddress);
		customData.add(customDataStudentId);

		return customData.toString();
	}

	public StudentPosBalance getBalance(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT A.*, ISNULL(A.CREDITS, 0) - ISNULL(A.DEBITS, 0) AS BALANCE ");
		query.append("  FROM ( ");
		query.append("     SELECT ");
		query.append("          (SELECT SUM(Debit) FROM [dbo].[AccountTransactionValues] WHERE AccountId = (SELECT AccountId FROM [dbo].[Entities] WHERE CustomData LIKE ?) AND AccountTransactionTypeId = 5) AS DEBITS, ");
		query.append("          (SELECT SUM(Credit) FROM [dbo].[AccountTransactionValues] WHERE AccountId = (SELECT AccountId FROM [dbo].[Entities] WHERE CustomData LIKE ?) AND AccountTransactionTypeId IN (6, 7)) AS CREDITS "); // cash and credit card
		query.append("  ) AS A ");
		Object[] params = new Object[] { "%" + studentId + "%", "%" + studentId + "%" };

		try {
			return posJdbcTemplate.queryForObject(query.toString(), params, new BeanPropertyRowMapper<StudentPosBalance>(StudentPosBalance.class));
		} catch (org.springframework.beans.TypeMismatchException e) {
			return new StudentPosBalance();
		}
	}

	public boolean registerStudent(StudentIdCard studentIdCard) throws Exception {
		boolean isNotDuplicated = isNotDuplicatedInPosSystem(studentIdCard.getStudentId());
		if (isNotDuplicated) {
			return insertPosSystem(studentIdCard);
		} else {
			return updatePosSystem(studentIdCard);
		}
	}

	public List<PosTransaction> getPosTransactions(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT AT.*, CONVERT(CHAR(19), TransactionDate, 20) AS TransactionDateForm ");
		query.append("  FROM ( ");
		query.append("       SELECT ATV.Id AS AtvId, ATV.Date AS TransactionDate, ATV.Debit, ATV.Credit, ATV.Name AS TransactionName, ISNULL(T.Id, 0) as TicketId ");
		query.append("         FROM [dbo].[AccountTransactionValues] ATV LEFT JOIN [Tickets] T ON ATV.AccountTransactionDocumentId = T.TransactionDocument_Id ");
		query.append("        WHERE ATV.AccountId = (SELECT AccountId FROM [dbo].[Entities] WHERE CustomData LIKE ?) ");
		query.append("       ) AS AT ");
		query.append("  ORDER BY TransactionDate DESC ");
		Object[] params = new Object[] { "%" + studentId + "%" };

		try {
			return posJdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<PosTransaction>(PosTransaction.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new ArrayList<PosTransaction>();
		}
	}

	public List<PosTransaction> getPosTransactionsWithOrders(String studentId) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT AT.*, O.MenuItemName, ISNULL(O.Price, 0) AS Price, ISNULL(O.Quantity, 0) AS Quantity, CONVERT(CHAR(19), TransactionDate, 20) AS TransactionDateForm ");
		query.append("  FROM ( ");
		query.append("       SELECT ATV.Id AS AtvId, ATV.Date AS TransactionDate, ATV.Debit, ATV.Credit, ATV.Name AS TransactionName, ISNULL(T.Id, 0) as TicketId ");
		query.append("         FROM [dbo].[AccountTransactionValues] ATV LEFT JOIN [Tickets] T ON ATV.AccountTransactionDocumentId = T.TransactionDocument_Id ");
		query.append("        WHERE ATV.AccountId = (SELECT AccountId FROM [dbo].[Entities] WHERE CustomData LIKE ?) ");
		query.append("       ) AS AT LEFT JOIN [Orders] O ON AT.TicketId = O.TicketId ");
		query.append("  ORDER BY TransactionDate DESC ");
		Object[] params = new Object[] { "%" + studentId + "%" };

		try {
			return posJdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<PosTransaction>(PosTransaction.class));
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return new ArrayList<PosTransaction>();
		}
	}

}
