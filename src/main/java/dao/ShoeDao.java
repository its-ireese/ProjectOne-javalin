package dao;

import java.util.List;

import exception.ApplicationException;
import pojo.ShoePojo;

public interface ShoeDao {
	
	ShoePojo addShoe(ShoePojo shoePojo) throws ApplicationException;
	ShoePojo updateShoe(ShoePojo shoePojo) throws ApplicationException;
	boolean deleteShoe(int shoeId) throws ApplicationException;
	List<ShoePojo> getAllShoes() throws ApplicationException;
	ShoePojo getAShoe(int shoeId) throws ApplicationException;
	void exitApplication();

}
