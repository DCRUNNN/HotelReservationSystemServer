package service.Strategy.ManageWebsiteStrategy;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.dao.StrategyDao;
import data.dao.impl.StrategyDaoImpl;
import po.StrategyPO;
import service.Strategy.CreateStrategyID.CreateStrategyID;
import vo.StrategyVO;

/**
 * ManageWebsiteStrategyService��ʵ����
 * @see StrategyDao
 * */
public class ManageWebsiteStrategyServiceImpl implements ManageWebsiteStrategyService{

	private StrategyDao strategyDao;
	
	public ManageWebsiteStrategyServiceImpl(){

		strategyDao = StrategyDaoImpl.getInstance();
	}
	
	@Override
	public List<StrategyVO> getAllWebsiteStrategy() throws RemoteException{
		
		List<StrategyVO> allStrategy = new ArrayList<StrategyVO>();
		List<StrategyPO> strategies = strategyDao.getAllWebsiteStrategies();
		for(StrategyPO po:strategies){
			StrategyVO vo = new StrategyVO(po);
			allStrategy.add(vo);
		}
		return allStrategy;
	}

	@Override
	public boolean addStrategy(StrategyVO strategyVO) throws RemoteException{
	
		StrategyPO po = new StrategyPO();
		String strategyID = new CreateStrategyID().nextWebsiteStrategyID();
		if("".equals(strategyID)){
			return false;
		}
		
		po.setStrategyID(strategyID);
		po.setName(strategyVO.getName());
		po.setIntroductuion(strategyVO.getIntroduction());
		po.setBeginTime(strategyVO.getBeginTime());
		po.setEndTime(strategyVO.getEndTime());
		po.setUserType(strategyVO.getUserType());
		po.setHotelProvince(strategyVO.getHotelProvince());
		po.setHotelCity(strategyVO.getHotelCity());
		po.setHotelCBD(strategyVO.getHotelCBD());
		po.setToBirthday(strategyVO.isToBirthday());
		po.setStrategyType(strategyVO.getStrategyType());
		po.setHotelID(strategyVO.getHotelID());
		po.setRoomTotal(strategyVO.getRoomTotal());
		po.setCompanyAddress(strategyVO.getCompanyAddress());
		po.setDiscount(strategyVO.getStrategy_discount());
		
		return strategyDao.changeStrategy(po);
	}

	@Override
	public boolean changeStrategy(StrategyVO strategyVO)throws RemoteException {
		
		StrategyPO po = new StrategyPO();
		po.setStrategyID(strategyVO.getStrategyID());
		po.setName(strategyVO.getName());
		po.setIntroductuion(strategyVO.getIntroduction());
		po.setBeginTime(strategyVO.getBeginTime());
		po.setEndTime(strategyVO.getEndTime());
		po.setUserType(strategyVO.getUserType());
		po.setHotelProvince(strategyVO.getHotelProvince());
		po.setHotelCity(strategyVO.getHotelCity());
		po.setHotelCBD(strategyVO.getHotelCBD());
		po.setToBirthday(strategyVO.isToBirthday());
		po.setStrategyType(strategyVO.getStrategyType());
		po.setHotelID(strategyVO.getHotelID());
		po.setRoomTotal(strategyVO.getRoomTotal());
		po.setCompanyAddress(strategyVO.getCompanyAddress());
		po.setDiscount(strategyVO.getStrategy_discount());
		
		return strategyDao.changeStrategy(po);
	}

	@Override
	public boolean deleteStrategy(String strategyID) throws RemoteException{
		
		return strategyDao.deleteStrategy(strategyID);
	}

}
