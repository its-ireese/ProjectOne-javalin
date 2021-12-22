package dao;

import exception.ApplicationException;
import pojo.UsersPojo;

public interface UsersDao {
	UsersPojo register(UsersPojo usersPojo) throws ApplicationException;
	UsersPojo validateUser(UsersPojo usersPojo) throws ApplicationException;
	UsersPojo login(String userName, String userPassword);
	UsersPojo updateInfo(UsersPojo usersPojo) throws ApplicationException;
	void update(int userId, String userName, String userPassword, String userFirstName, String userLastName, String userAddress, String userContact) throws ApplicationException;
	void exitApplication();
	
}
