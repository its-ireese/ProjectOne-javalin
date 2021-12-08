package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import exception.ApplicationException;

import presentation.ReimbursementMain;
import pojo.ReimbursementPojo;

public class ReimbursementJdbcImpl implements ReimbursementDao {
	
	ReimbursementPojo reimbursementPojo = null;

	private static final Logger logger = LogManager.getLogger(ReimbursementJdbcImpl.class);

	@Override
	public ReimbursementPojo addRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		logger.info("Entered addRequest() in dao");
		reimbursementPojo.setReimStatus(false);
		reimbursementPojo.setReimApproved(false);

		
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "insert into reimbursement_details(emp_id, reim_amount, reim_status, reim_approved)"
					+ "values(" + reimbursementPojo.getReimEmpId()
					+ "," + reimbursementPojo.getReimAmount() + "," + reimbursementPojo.isReimStatus() +"," + reimbursementPojo.isReimApproved() + ") returning reim_id";

			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			reimbursementPojo.setReimId(rs.getInt(1));
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());

		}

		
		logger.info("Exited addRequest() in dao.");
		return reimbursementPojo;

	}          
	
	@Override
	public ReimbursementPojo approveRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		logger.info("Entered approveRequest() in dao.");

		
		
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "update reimbursement_details set reim_status=true, reim_approved=true where reim_id= "
					+ reimbursementPojo.getReimId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		logger.info("Exited approveRequest() in dao.");
		return reimbursementPojo;
	}

	@Override
	public ReimbursementPojo denyRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		logger.info("Entered denyRequest() in dao.");

		
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "update reimbursement_details set reim_status= true where reim_id= "
					+ reimbursementPojo.getReimId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		logger.info("Exited denyRequest() in dao.");
		return reimbursementPojo;
	}

	@Override
	public ReimbursementPojo updateRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		logger.info("Entered updateRequest() in dao.");

		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "update reimbursement_details set reim_amount= " + reimbursementPojo.getReimAmount() + " where reim_id= "
					+ reimbursementPojo.getReimId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		logger.info("Exited updateRequest() in dao.");
		return reimbursementPojo;
	}

	@Override
	public boolean deleteRequest(int reimId) throws ApplicationException {
		logger.info("Entered deleteRequest() in dao.");

		boolean flag = false;
		
		int rowsAffected = 0;
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "update reimbursement_details set reim_status=true where reim_id=" + reimId;
			rowsAffected = stmt.executeUpdate(query);
			System.out.println(rowsAffected);

		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		if (rowsAffected == 0)
			flag = true;

		logger.info("Exited deleteRequest() in dao.");
		return flag;
	}

	@Override
	public List<ReimbursementPojo> getAllRequests() throws ApplicationException {
		logger.info("Entered getAllRequests() in dao.");

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
		logger.info("Exited getAllRequests() in dao.");
		return allRequests;
	}
	
	public List<ReimbursementPojo> getAllResolvedRequests() throws ApplicationException {
		logger.info("Entered getAllResolvedRequests() in dao.");

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
		logger.info("Exited getAllResolvedRequests() in dao.");
		return allResolvedRequests;
	}
	@Override
	public ReimbursementPojo getARequest(int reimId) throws ApplicationException {
		logger.info("Entered getARequest() in dao.");

		
		Statement stmt;
		ReimbursementPojo reimbursementPojo = null;
		try {
			Connection conn = DataBase.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimbursement_details where reim_id=" + reimId;
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getBoolean(4), rs.getBoolean(5));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getARequest() in dao.");
		return reimbursementPojo;
	}

	@Override
	public List<ReimbursementPojo> getAllPendingRequests() throws ApplicationException {
		logger.info("Entered getAllPendingRequests() in dao.");

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
		logger.info("Exited getAllPendingRequests() in dao.");
		return allPendingRequests;
	}

	@Override
	public List<ReimbursementPojo> getAllEmpRequests(int reimEmpId) throws ApplicationException {
		logger.info("Entered getAllEmpRequests() in dao.");

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
		logger.info("Exited getAllRequests() in dao.");
		return allEmpRequests;
	}

	@Override
	public List<ReimbursementPojo> getAllEmpResolvedRequests(int reimEmpId) throws ApplicationException {
		logger.info("Entered getAllEmpResolvedRequests() in dao.");

		List<ReimbursementPojo> allEmpResolvedRequests = new ArrayList<ReimbursementPojo>();

		
		Statement stmt;
		try {
			Connection conn = DataBase.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimbursement_details where emp_id="+reimEmpId + "reim_status=true";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getBoolean(4), rs.getBoolean(5));

				allEmpResolvedRequests.add(reimbursementPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAllResolvedRequests() in dao.");
		return allEmpResolvedRequests;
	}

	@Override
	public List<ReimbursementPojo> getAllEmpPendingRequests(int reimEmpId) throws ApplicationException {
		logger.info("Entered getAllEmpPendingRequests() in dao.");

		List<ReimbursementPojo> allEmpPendingRequests = new ArrayList<ReimbursementPojo>();
		
		Statement stmt;
		try {
			Connection conn = DataBase.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimbursement_details where emp_id=" + reimEmpId+ "and reim_status=false";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getBoolean(4), rs.getBoolean(5));

				allEmpPendingRequests.add(reimbursementPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAllEmpPendingRequests() in dao.");
		return allEmpPendingRequests;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DataBase.closeConnection();
		logger.info("Exited exitApplication() in dao.");
	}

}