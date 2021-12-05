package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ReimbursementDao;
import exception.ApplicationException;
import pojo.EmployeePojo;
import pojo.ManagerPojo;
import pojo.ReimbursementPojo;
import dao.ReimbursementJdbcImpl;
import dao.ManagerDao;
import dao.ManagerDaoImpl;

public class ManagerServiceImpl implements ManagerService{
	
private static final Logger logger = LogManager.getLogger(ManagerServiceImpl.class);
	
ManagerDao managerdao = new ManagerDaoImpl();
ReimbursementDao reimbursementDao = new ReimbursementJdbcImpl();

	@Override
	public ReimbursementPojo approveRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		logger.info("Entered approveRequest() in service.");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.approveRequest(reimbursementPojo);
		logger.info("Exited approveRequest() in service.");
		return returnReimbursementPojo;
	}

	@Override
	public ReimbursementPojo denyRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		logger.info("Entered denyRequest() in service.");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.denyRequest(reimbursementPojo);
		logger.info("Exited denyRequest() in service.");
		return returnReimbursementPojo;
	}

	@Override
	public ManagerPojo viewInfo(int mgrId) throws ApplicationException {
		return this.managerdao.viewInfo(mgrId);
	}

	@Override
	public ManagerPojo updateInfo(ManagerPojo managerPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementPojo> getAllRequests() throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementPojo> getAllPendingRequests() throws ApplicationException {
		logger.info("Entered getAllPendingRequests() in service.");
		List<ReimbursementPojo> allPendingRequests = this.reimbursementDao.getAllPendingRequests();
		logger.info("Exited getAllPendingRequests() in service.");
		return allPendingRequests;
	}

	@Override
	public List<ReimbursementPojo> getAllResolvedRequests() throws ApplicationException {
		logger.info("Entered getAllResolvedRequests() in service.");
		List<ReimbursementPojo> allResolvedRequests = this.reimbursementDao.getAllResolvedRequests();
		logger.info("Exited getAllResolvedRequests() in service.");
		return allResolvedRequests;
	}

	@Override
	public List<ReimbursementPojo> getAllEmpRequests(int reimEmpId) throws ApplicationException {
		logger.info("Entered getAllEmpRequests() in service.");
		List<ReimbursementPojo> allEmpRequests = this.reimbursementDao.getAllEmpRequests(reimEmpId);
		logger.info("Exited getAllEmpRequests() in service.");
		return allEmpRequests;
	}

	@Override
	public List<ReimbursementPojo> getAllEmpResolvedRequests(int reimEmpId) throws ApplicationException {
		logger.info("Entered getAllEmpResolvedRequests() in service.");
		List<ReimbursementPojo> allEmpResolvedRequests = this.reimbursementDao.getAllEmpResolvedRequests(reimEmpId);
		logger.info("Exited getAllEmpResolvedRequests() in service.");
		return allEmpResolvedRequests;
	}

	@Override
	public List<ReimbursementPojo> getAllEmpPendingRequests(int reimEmpId) throws ApplicationException {
		logger.info("Entered getAllEmpPendingRequests() in service.");
		List<ReimbursementPojo> allEmpPendingRequests = this.reimbursementDao.getAllEmpPendingRequests(reimEmpId);
		logger.info("Exited getAllEmpPendingRequests() in service.");
		return allEmpPendingRequests;
	}

	@Override
	public List<EmployeePojo> getAllEmployees() throws ApplicationException {
		List<EmployeePojo> allEmployees = this.managerdao.getAllEmployees();
		return allEmployees;
	}

}
