package dao;

import java.util.List;
import pojo.ReimbursementPojo;
import exception.ApplicationException;

public interface ReimbursementDao {
	
	ReimbursementPojo addRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	ReimbursementPojo updateRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	ReimbursementPojo approveRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	ReimbursementPojo denyRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	boolean deleteRequest(int reimId) throws ApplicationException;
	List<ReimbursementPojo> getAllRequests() throws ApplicationException;
	List<ReimbursementPojo> getAllPendingRequests() throws ApplicationException;
	List<ReimbursementPojo> getAllResolvedRequests() throws ApplicationException;
	List<ReimbursementPojo> getAllEmpRequests(int reimEmpId) throws ApplicationException;
	List<ReimbursementPojo> getAllEmpResolvedRequests(int reimEmpId) throws ApplicationException;
	List<ReimbursementPojo> getAllEmpPendingRequests(int reimEmpId) throws ApplicationException;
	ReimbursementPojo getARequest(int reimId) throws ApplicationException;
	void exitApplication();

}
