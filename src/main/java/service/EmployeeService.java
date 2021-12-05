package service;

import exception.ApplicationException;
import pojo.ReimbursementPojo;
import pojo.UsersPojo;

public interface EmployeeService {
	
	UsersPojo viewInfo(int userId) throws ApplicationException;
	UsersPojo updateInfo(UsersPojo usersPojo) throws ApplicationException;
	ReimbursementPojo addRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	ReimbursementPojo updateRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException;
}
