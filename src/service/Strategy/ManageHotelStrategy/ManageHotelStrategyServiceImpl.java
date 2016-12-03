package service.Strategy.ManageHotelStrategy;

import java.util.ArrayList;
import java.util.List;

import data.dao.StrategyDao;
import data.dao.impl.StrategyDaoImpl;
import po.StrategyPO;
import service.Strategy.CreateStrategyID.CreateStrategyID;
import vo.StrategyVO;

/**
 * MangeHotelStrategyService的实现类
 * @see StrategyDao
 * */
public class ManageHotelStrategyServiceImpl implements ManageHotelStrategyService{

	private StrategyDao dao;
	
	public ManageHotelStrategyServiceImpl(){
		
		dao = StrategyDaoImpl.getInstance();
	}
	@Override
	public List<StrategyVO> getAllHotelStrategy(String hotelID) {
		
		List<StrategyPO> polist = dao.getAllHotelStrategies(hotelID);
		List<StrategyVO> volist = new ArrayList<StrategyVO>();
		for(StrategyPO po:polist){
			StrategyVO vo = new StrategyVO(po);
			volist.add(vo);
		}
		return volist;
	}

	@Override
	public boolean addHotelStrategy(StrategyVO strategyVO) {
		
		StrategyPO po = new StrategyPO();
		
		String hotelID = strategyVO.getHotelID();
		String strategyID = new CreateStrategyID().nextHotelStrategyID(hotelID);
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
		return dao.changeStrategy(po);
	}

	@Override
	public boolean changeHotelStrategy(StrategyVO strategyVO) {
		
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
		return dao.changeStrategy(po);
	}

	@Override
	public boolean deleteHotelStrategy(String strategyID) {
		
		return dao.deleteStrategy(strategyID);
	}

}
