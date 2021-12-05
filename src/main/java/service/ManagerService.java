package service;

import java.util.List;

import exception.ApplicationException;
import pojo.EmployeePojo;
import pojo.ManagerPojo;
import pojo.ReimbursementPojo;

public interface ManagerService {
	ReimbursementPojo approveRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	ReimbursementPojo denyRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	ManagerPojo viewInfo(int mgrId) throws ApplicationException;
	ManagerPojo updateInfo(ManagerPojo managerPojo) throws ApplicationException;
	List<ReimbursementPojo> getAllRequests() throws ApplicationException;
	List<ReimbursementPojo> getAllPendingRequests() throws ApplicationException;
	List<ReimbursementPojo> getAllResolvedRequests() throws ApplicationException;
	List<ReimbursementPojo> getAllEmpRequests(int reimEmpId) throws ApplicationException;
	List<ReimbursementPojo> getAllEmpResolvedRequests(int reimEmpId) throws ApplicationException;
	List<ReimbursementPojo> getAllEmpPendingRequests(int reimEmpId) throws ApplicationException;
	List<EmployeePojo> getAllEmployees() throws ApplicationException;
	
}
