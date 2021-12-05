package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.ApplicationException;
import pojo.EmployeePojo;
import pojo.ManagerPojo;
import pojo.ReimbursementPojo;

public class ManagerDaoImpl implements ManagerDao {

	Statement stmt;
	ManagerPojo managerPojo = null;

	@Override
	public ReimbursementPojo approveRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "update reimbursement_details set reim_status=true, reim_approved=true where reim_id= "
					+ reimbursementPojo.getReimId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return reimbursementPojo;
	}

	@Override
	public ReimbursementPojo denyRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "update reimbursement_details set reim_status= true where reim_id= "
					+ reimbursementPojo.getReimId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return reimbursementPojo;
	}

	@Override
	public ManagerPojo viewInfo(int mgrId) throws ApplicationException {
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "select * from manager_details where mgr_id=" + mgrId;
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				managerPojo = new ManagerPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getBoolean(6));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return managerPojo;
	}

	@Override
	public ManagerPojo updateInfo(ManagerPojo managerPojo) throws ApplicationException {
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "update manager_details set mgr_contact= " + managerPojo.getMgrContact() + " where mgr_id= "
					+ managerPojo.getMgrId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return managerPojo;
	}

	@Override
	public List<ReimbursementPojo> getAllRequests() throws ApplicationException {
		List<ReimbursementPojo> allRequests = new ArrayList<ReimbursementPojo>();

		Statement stmt;
		try {
			Connection conn = DataBase.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimbursement_details";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getBoolean(4), rs.getBoolean(5));

				allRequests.add(reimbursementPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return allRequests;
	}

	@Override
	public List<ReimbursementPojo> getAllPendingRequests() throws ApplicationException {
		List<ReimbursementPojo> allPendingRequests = new ArrayList<ReimbursementPojo>();

		Statement stmt;
		try {
			Connection conn = DataBase.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimbursement_details where reim_status=false";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getBoolean(4), rs.getBoolean(5));

				allPendingRequests.add(reimbursementPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return allPendingRequests;
	}

	@Override
	public List<ReimbursementPojo> getAllResolvedRequests() throws ApplicationException {
		List<ReimbursementPojo> allResolvedRequests = new ArrayList<ReimbursementPojo>();

		Statement stmt;
		try {
			Connection conn = DataBase.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimbursement_details where reim_status=true";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getBoolean(4), rs.getBoolean(5));

				allResolvedRequests.add(reimbursementPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return allResolvedRequests;
	}

	@Override
	public List<ReimbursementPojo> getAllEmpRequests(int reimEmpId) throws ApplicationException {
		List<ReimbursementPojo> allEmpRequests = new ArrayList<ReimbursementPojo>();

		Statement stmt;
		try {
			Connection conn = DataBase.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimbursement_details where emp_id=" + reimEmpId;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getBoolean(4), rs.getBoolean(5));

				allEmpRequests.add(reimbursementPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return allEmpRequests;
	}

	@Override
	public List<ReimbursementPojo> getAllEmpResolvedRequests(int reimEmpId) throws ApplicationException {
		List<ReimbursementPojo> allEmpResolvedRequests = new ArrayList<ReimbursementPojo>();

		Statement stmt;
		try {
			Connection conn = DataBase.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimbursement_details where emp_id=" + reimEmpId + "and reim_status=true";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getBoolean(4), rs.getBoolean(5));

				allEmpResolvedRequests.add(reimbursementPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return allEmpResolvedRequests;
	}

	@Override
	public List<ReimbursementPojo> getAllEmpPendingRequests(int reimEmpId) throws ApplicationException {
		List<ReimbursementPojo> allEmpPendingRequests = new ArrayList<ReimbursementPojo>();

		Statement stmt;
		try {
			Connection conn = DataBase.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimbursement_details where emp_id=" + reimEmpId + "and reim_status=false";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getBoolean(4), rs.getBoolean(5));

				allEmpPendingRequests.add(reimbursementPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return allEmpPendingRequests;
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
	public ReimbursementPojo getARequest(int reimId) throws ApplicationException {

		Statement stmt;
		ReimbursementPojo reimbursementPojo = null;
		try {
			Connection conn = DataBase.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimbursement_details where reim_id=" + reimId;
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4),
						rs.getBoolean(5));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return reimbursementPojo;
	}

	@Override
	public void exitApplication() {
		DataBase.closeConnection();
	}

}
