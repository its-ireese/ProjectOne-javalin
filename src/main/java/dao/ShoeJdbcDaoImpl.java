package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.ApplicationException;
import pojo.ShoePojo;

public class ShoeJdbcDaoImpl implements ShoeDao {
	
	private static final Logger logger = LogManager.getLogger(ShoeJdbcDaoImpl.class);

	@Override
	public ShoePojo addShoe(ShoePojo shoePojo) throws ApplicationException{
		logger.info("Entered addShoe() in dao.");
		
		shoePojo.setShoeAvailable(true);

		
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "insert into shoes_details(shoe_name, shoe_brand, shoe_cost, shoe_available)" + "values('"
					+ shoePojo.getShoeName() + "','" + "','" + shoePojo.getShoeBrand() + "'," + shoePojo.getShoeCost()
					+ "," + shoePojo.isShoeAvailable() + ") returning shoe_id";

			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			shoePojo.setShoeId(rs.getInt(1));
			
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited addShoe() in dao.");
		return shoePojo;
	}

	@Override
	public ShoePojo updateShoe(ShoePojo shoePojo) throws ApplicationException{

		
		try {
			Connection conn = DataBase.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "update shoes_details set shoe_cost=" + shoePojo.getShoeCost() + " where shoe_id="
					+ shoePojo.getShoeId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited updateShoe() in dao.");
		return shoePojo;
	}

	@Override
	public boolean deleteShoe(int shoeId) throws ApplicationException {
		logger.info("Entered deleteShoe() in dao.");
		
		boolean laces = false;
		int rowsAffected = 0;
			try {
				Connection conn = DataBase.makeConnection();
				Statement stmt = conn.createStatement();
				String query = "update shoes_details set shoe_available=false where shoe_id=" + shoeId;
				rowsAffected = stmt.executeUpdate(query);
				System.out.println(rowsAffected);
			}catch (SQLException e) {
				throw new ApplicationException(e.getMessage());
		}
		if (rowsAffected == 0)
			laces = false;
		logger.info("Exited deleteShoe() in dao.");
			return laces;
	}

	@Override
	public List<ShoePojo> getAllShoes() throws ApplicationException {
		logger.info("Entered getAllShoes() in dao.");
		List<ShoePojo> allAllShoes = new ArrayList<ShoePojo>();
		Statement stmt;
		
		try {
			Connection conn = DataBase.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from shoes_details where shoe_available=true";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ShoePojo shoePojo = new ShoePojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getBoolean(5));

				allAllShoes.add(shoePojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAllShoes() in dao.");
		return allAllShoes;


	}

	@Override
	public ShoePojo getAShoe(int shoeId) throws ApplicationException {
		logger.info("Entered getAShoe() in dao.");
		
		Statement stmt;
		ShoePojo shoePojo = null;
		
		try {
			Connection conn = DataBase.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from shoes_details where shoe_id="+shoeId
							+ "and shoe_available=true";
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				shoePojo = new ShoePojo(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(5), rs.getBoolean(5));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		logger.info("Exited getAShoe() in dao. ");
		return shoePojo;
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DataBase.closeConnection();
		logger.info("Exited exitApplication() in dao.");
		}
	
}
