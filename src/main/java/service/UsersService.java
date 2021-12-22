package service;

import exception.ApplicationException;
import pojo.UsersPojo;

public interface UsersService {
	UsersPojo register(UsersPojo userPojo) throws ApplicationException;
	UsersPojo validateUser(UsersPojo userPojo) throws ApplicationException;
	UsersPojo login(String userName, String userPassword);
	UsersPojo updateInfo(UsersPojo usersPojo) throws ApplicationException;
	void update(UsersPojo userspojo) throws ApplicationException;
	//void update(int userId, String userName, String userPassword, String userFirstName, String userLastName, String userAddress, String userContact) throws ApplicationException;
	void exitApplication();

	

}
