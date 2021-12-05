package dao;

import exception.ApplicationException;
import pojo.UsersPojo;

public interface UsersDao {
	UsersPojo register(UsersPojo usersPojo) throws ApplicationException;
	UsersPojo validateUser(UsersPojo usersPojo) throws ApplicationException;
	void exitApplication();
	

}
