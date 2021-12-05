package service;

import java.util.List;

import dao.ReimbursementDao;
import dao.ReimbursementJdbcImpl;
import pojo.ReimbursementPojo;
import dao.DataBase;
import presentation.ReimbursementMain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import exception.ApplicationException;


public class ReimbursementServiceImpl implements ReimbursementService{
	
	private static final Logger logger = LogManager.getLogger(ReimbursementServiceImpl.class);
	
	ReimbursementDao reimbursementDao;
	
	public ReimbursementServiceImpl() {
		this.reimbursementDao = new ReimbursementJdbcImpl();
	}

	@Override
	public ReimbursementPojo addRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		logger.info("Entered addRequest() in service.");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.addRequest(reimbursementPojo);
		logger.info("Exited addRequest() in service.");
		return returnReimbursementPojo;
		}

	@Override
	public ReimbursementPojo updateRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException  {
		logger.info("Entered updateRequest() in service.");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.updateRequest(reimbursementPojo);
		logger.info("Exited updateRequest() in service.");
		return returnReimbursementPojo;
		
	}

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
	public boolean deleteRequest(int reimId) throws ApplicationException {
		logger.info("Entered deleteRequest() in service.");
		boolean returnFlag = this.reimbursementDao.deleteRequest(reimId);
		logger.info("Exited deleteRequest() in service.");
		return returnFlag;
	}

	@Override
	public List<ReimbursementPojo> getAllRequests() throws ApplicationException {
		logger.info("Entered getAllRequests() in service.");
		List<ReimbursementPojo> allRequests = this.reimbursementDao.getAllRequests();
		logger.info("Exited getAllRequests() in service.");
		return allRequests;
	}
	@Override
	public List<ReimbursementPojo> getAllResolvedRequests() throws ApplicationException {
		logger.info("Entered getAllResolvedRequests() in service.");
		List<ReimbursementPojo> allResolvedRequests = this.reimbursementDao.getAllResolvedRequests();
		logger.info("Exited getAllResolvedRequests() in service.");
		return allResolvedRequests;
	}

	@Override
	public ReimbursementPojo getARequest(int reimId) throws ApplicationException {
		logger.info("Entered getARequest() in service.");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.getARequest(reimId);
		logger.info("Exited getARequest() in service.");
		return returnReimbursementPojo;
	}

	@Override
	public List<ReimbursementPojo> getAllPendingRequests() throws ApplicationException {
		logger.info("Entered getAllPendingRequests() in service.");
		List<ReimbursementPojo> allPendingRequests = this.reimbursementDao.getAllPendingRequests();
		logger.info("Exited getAllPendingRequests() in service.");
		return allPendingRequests;
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
	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		reimbursementDao.exitApplication();
		logger.info("Exited exitApplication() in service.");
	}
	
}