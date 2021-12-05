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
			String query = "insert into users_details(username, password, usertype, user_first_name, user_last_name, user_address, user_contact, user_removed)" 
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
			String query = "select * from employees_details where username="+usersPojo.getUserName()
							+" and password='"+usersPojo.getUserPassword()+"' and user_removed=false";
			
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

	@Override
	public void exitApplication() {
		DataBase.closeConnection();
	}


}
