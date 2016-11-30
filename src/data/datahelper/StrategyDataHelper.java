package data.datahelper;

/**
 * @author Cong Deng
 */
import java.util.List;

import po.StrategyPO;

public interface StrategyDataHelper {

	public List<StrategyPO> getHotelStrategies(String hotelId);
	
	public boolean changeStrategy(StrategyPO po);
	
	public boolean addStrategy(StrategyPO po);
	
	public List<StrategyPO> getAllWebsiteStrategies();

	public boolean deleteStrategy(String strategyID);
	
	public List<String> getAllIds();
	
}
