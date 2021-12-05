package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.UsersDao;
import dao.UsersDaoImpl;
import exception.ApplicationException;
import pojo.UsersPojo;

public class UsersServiceImpl implements UsersService {
	
private static final Logger logger = LogManager.getLogger(UsersServiceImpl.class);
	
	UsersDao usersDao;
	
	public UsersServiceImpl() {
		usersDao = new UsersDaoImpl();
	}

	@Override
	public UsersPojo register(UsersPojo usersPojo) throws ApplicationException {
		logger.info("Entered register() in service.");
		UsersPojo returnUsersPojo = this.usersDao.register(usersPojo);
		logger.info("Exited register() in service.");
		return returnUsersPojo;	
	}

	@Override
	public UsersPojo validateUser(UsersPojo usersPojo) throws ApplicationException {
		logger.info("Entered validateUser() in service.");
		UsersPojo returnUsersPojo = this.usersDao.validateUser(usersPojo);
		logger.info("Exited validateUser() in service.");
		return returnUsersPojo;	
	}

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		usersDao.exitApplication();
		logger.info("Exited exitApplication() in service.");
	}


}
