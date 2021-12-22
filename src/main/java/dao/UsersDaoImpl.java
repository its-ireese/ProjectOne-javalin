package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.ApplicationException;

import pojo.UsersPojo;


public class UsersDaoImpl implements UsersDao{
	
	private static final Logger logger = LogManager.getLogger(UsersDaoImpl.class);
	
	@Override
	public UsersPojo register(UsersPojo usersPojo) throws ApplicationException {
		logger.info("Entered register() in dao.");
		
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "insert into employees_details(username, password, usertype, user_first_name, user_last_name, user_address, user_contact, user_removed)" 
							+ "values('" + usersPojo.getUserName() +"','" + usersPojo.getUserPassword()+"','" + usersPojo.getUserType()+"','"
							+"',"+usersPojo.isUserRemoved();
			
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		logger.info("Exited register() in dao.");
		return usersPojo;
	}

	@Override
	public UsersPojo validateUser(UsersPojo usersPojo) throws ApplicationException {
		logger.info("Entered validateUser() in dao.");
		
		
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "select * from employees_details where username='"+usersPojo.getUserName()
							+"' and password='"+usersPojo.getUserPassword()+"' and user_removed=false";
			
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				usersPojo.setUserId(rs.getInt(1));
				usersPojo.setUserType(rs.getString(4));
				usersPojo.setUserFirstName(rs.getString(5));
				usersPojo.setUserLastName(rs.getString(6));;
				usersPojo.setUserAddress(rs.getString(7));
				usersPojo.setUserContact(rs.getString(8));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		logger.info("Exited validateUser() in dao.");
		return usersPojo;
	}

	

//	@Override
	public UsersPojo login(String userName, String userPassword) {
		UsersPojo usersPojo = null;
		
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "select * from employees_details where username='"+usersPojo.getUserName()
							+"' and password='"+usersPojo.getUserPassword()+"' and user_removed=false";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				usersPojo = new UsersPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9));
			}
		} catch (SQLException e) {
			logger.fatal("Login Failed with username " + userName);
		}
		
		return usersPojo;
	}

	@Override
	public UsersPojo updateInfo(UsersPojo usersPojo) throws ApplicationException {
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "update employees_details set username= '"+usersPojo.getUserName()+
					"', password='"+usersPojo.getUserPassword()+"', user_first_name='"+usersPojo.getUserFirstName()
					+"', user_last_name='"+usersPojo.getUserLastName() +"', user_address='"+usersPojo.getUserAddress() +"',"
							+ "user_contact= '" + usersPojo.getUserContact() + "' where employee_id= "
					+ usersPojo.getUserId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		return usersPojo;
	}
	@Override
	public void update(int userId, String userName, String userPassword, String userFirstName,
			String userLastName, String userAddress, String userContact) throws ApplicationException {
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
		String query = "update employees_details set username='"+userName+"', password='"+userPassword+"', user_first_name='"+userFirstName+
				"', user_last_name='"+userLastName+"', user_address='"+userAddress+
				"', user_contact='" + userContact+"' where employee_id=" + userId + ";";
	    stmt.executeUpdate(query);
	} catch (SQLException e) {
		throw new ApplicationException(e.getMessage());
		}
	}
	
	@Override
	public void exitApplication() {
		DataBase.closeConnection();
	}

	


}
