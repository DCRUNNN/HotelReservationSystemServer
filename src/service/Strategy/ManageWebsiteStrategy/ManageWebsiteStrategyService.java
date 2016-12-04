package service.Strategy.ManageWebsiteStrategy;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.StrategyVO;

public interface ManageWebsiteStrategyService extends Remote{

	/**
	 * @return 得到网站的所有营销策略
	 * */
	public List<StrategyVO> getAllWebsiteStrategy()throws RemoteException;
	
	/**
	 * @param StrategyVO  营销策略
	 * @return 增加新的营销策略
	 * */
	public boolean addStrategy(StrategyVO strategyVO)throws RemoteException;
	
	/**
	 * @param StrategyVO 营销策略
	 * @return StrategyID不变，对网站营销策略进行修改
	 * */
	public boolean changeStrategy(StrategyVO strategyVO)throws RemoteException;
	
	/**
	 * @param strategyID 策略编号
	 * @return 对策略进行删除
	 * */
	public boolean deleteStrategy(String strategyID)throws RemoteException;
	
	
}
