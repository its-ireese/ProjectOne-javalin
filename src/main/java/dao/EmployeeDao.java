package dao;

import java.util.List;

import exception.ApplicationException;
import pojo.UsersPojo;
import pojo.EmployeePojo;
import pojo.ReimbursementPojo;

public interface EmployeeDao {
	UsersPojo viewInfo(int userId) throws ApplicationException;
	UsersPojo updateInfo(UsersPojo usersPojo) throws ApplicationException;
	ReimbursementPojo addRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	ReimbursementPojo updateRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	List<EmployeePojo> getAllEmployees() throws ApplicationException;
	void exitApplication();
//	EmployeePojo updateInfo(EmployeePojo employeePojo) throws ApplicationException;

}
