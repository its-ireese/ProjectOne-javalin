package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exception.ApplicationException;
import pojo.EmployeePojo;
import pojo.ReimbursementPojo;
import pojo.UsersPojo;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	@Override
	public UsersPojo viewInfo(int userId) throws ApplicationException {
		return this.employeeDao.viewInfo(userId);
	}

	@Override
	public UsersPojo updateInfo(UsersPojo usersPojo) throws ApplicationException {
		return this.employeeDao.updateInfo(usersPojo);
	}

	@Override
	public ReimbursementPojo addRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbursementPojo updateRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
