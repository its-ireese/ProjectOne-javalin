package service;

import java.util.List;
import dao.ShoeDao;
import dao.ShoeJdbcDaoImpl;
import pojo.ShoePojo;
import exception.ApplicationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ShoeServiceImpl implements ShoeService {
	
	private static final Logger logger = LogManager.getLogger(ShoeServiceImpl.class);

	ShoeDao shoeDao;

	public ShoeServiceImpl() {
		this.shoeDao = new ShoeJdbcDaoImpl();
		
	}
	@Override
	public ShoePojo addShoe(ShoePojo shoePojo) throws ApplicationException {
		logger.info("Entered addShoe() in service.");
		ShoePojo returnShoePojo = this.shoeDao.addShoe(shoePojo);
		logger.info("Exited addShoe() in service.");
		return returnShoePojo;
	}
	@Override
	public ShoePojo updateShoe(ShoePojo shoePojo) throws ApplicationException{
		logger.info("Entered updateShoe() in service.");
		ShoePojo returnShoePojo = this.shoeDao.updateShoe(shoePojo);
		logger.info("Exited updateShoe() in service.");
		return returnShoePojo;
	}

	@Override
	public boolean deleteShoe(int shoeId) throws ApplicationException{
		logger.info("Entered deleteShoe() in service.");
		boolean returnLaces = this.shoeDao.deleteShoe(shoeId);
		logger.info("Exited deleteShoe() in service.");
		return returnLaces;
	}
	@Override
	public List<ShoePojo> getAllShoes() throws ApplicationException{
		logger.info("Entered getAllShoes() in service.");
		List<ShoePojo> allShoes = this.shoeDao.getAllShoes();
		logger.info("Exited getAllShoes() in service.");
		return allShoes;
	}
	@Override
	public ShoePojo getAShoe(int shoeId) throws ApplicationException {
		logger.info("Entered getAShoe() in service.");
		ShoePojo returnShoePojo = this.shoeDao.getAShoe(shoeId);
		logger.info("Exited getAShoe() in service.");
		return returnShoePojo;
	}
	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		shoeDao.exitApplication();
		logger.info("Exited exitApplication() in service.");
	}


}

