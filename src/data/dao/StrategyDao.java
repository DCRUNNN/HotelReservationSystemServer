package data.dao;

import java.util.List;

import po.StrategyPO;

public interface StrategyDao {
	
	public List<StrategyPO> getAllHotelStrategies(String hotelId);
	
	public boolean changeStrategy(StrategyPO po);
	
	public boolean addStrategy(StrategyPO po);
	
	public List<StrategyPO> getAllWebsiteStrategies();

	public boolean deleteStrategy(String strategyID);

	public List<String> getAllIDs();
	
}
