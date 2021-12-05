package service;

import exception.ApplicationException;
import pojo.UsersPojo;

public interface UsersService {
	UsersPojo register(UsersPojo userPojo) throws ApplicationException;
	UsersPojo validateUser(UsersPojo userPojo) throws ApplicationException;
	void exitApplication();
	

}
