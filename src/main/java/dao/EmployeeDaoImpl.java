package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.ApplicationException;
import pojo.EmployeePojo;
import pojo.ReimbursementPojo;
import pojo.UsersPojo;

public class EmployeeDaoImpl implements EmployeeDao {

	Statement stmt;
	EmployeePojo employeePojo = null;
	UsersPojo usersPojo = null; 

	@Override
	public UsersPojo viewInfo(int userId) throws ApplicationException {

		try {
			Connection conn = DataBase.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from employees_details where employee_id=" + userId;
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				usersPojo = new UsersPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return usersPojo;
	}

	@Override
	public UsersPojo updateInfo(UsersPojo usersPojo) throws ApplicationException {
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "update employee_details set user_contact= " + usersPojo.getUserContact()
					+ " where employee_id= " + usersPojo.getUserId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return usersPojo;
	}

	@Override
	public ReimbursementPojo addRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		reimbursementPojo.setReimStatus(false);
		reimbursementPojo.setReimApproved(false);

		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "insert into reimbursement_details(reim_id, emp_id, reim_amount, reim_status, reim_approved)"
					+ "values('" + reimbursementPojo.getReimId() + "','" + reimbursementPojo.getReimEmpId() + "','"
					+ reimbursementPojo.getReimAmount() + "'," + reimbursementPojo.isReimStatus() + ",'"
					+ reimbursementPojo.isReimApproved() + "') returning reim_id";

			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			reimbursementPojo.setReimId(rs.getInt(1));
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());

		}

		return reimbursementPojo;
	}

	@Override
	public ReimbursementPojo updateRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {

		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "update reimbursement_details set reim_amount= " + reimbursementPojo.getReimAmount()
					+ " where reim_id= " + reimbursementPojo.getReimId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return reimbursementPojo;
	}

	@Override
	public List<EmployeePojo> getAllEmployees() throws ApplicationException {

		List<EmployeePojo> allEmployees = new ArrayList<EmployeePojo>();

		Statement stmt;
		try {
			Connection conn = DataBase.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from employee_details";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				EmployeePojo employeePojo = new EmployeePojo(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getBoolean(6));

				allEmployees.add(employeePojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return allEmployees;
	}

	@Override
	public void exitApplication() {
		DataBase.closeConnection();
	}

}
