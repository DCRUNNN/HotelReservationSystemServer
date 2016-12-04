package service.Strategy.ManageHotelStrategy;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.StrategyVO;

public interface ManageHotelStrategyService extends Remote{

	/**
	 * @param hotelID 酒店编号
	 * @return 得到一个酒店的现在的所有营销策略
	 * */
	public List<StrategyVO> getAllHotelStrategy(String hotelID)throws RemoteException;
	
	/**
	 * @param strategyVO 酒店营销策略
	 * 新增策略的时候，对于空值一定要设置默认值 roomTotal是最低房间数目默认为1 string默认为"" isToBirthday默认false
	 * @return 增加新的酒店营销策略
	 * */
	public boolean addHotelStrategy(StrategyVO vo)throws RemoteException;
	
	/**
	 * @param strategyVO 酒店营销策略
	 * @return 返回是否成功修改酒店营销策略
	 * */
	public boolean changeHotelStrategy(StrategyVO vo)throws RemoteException;
	
	/**
	 * @param strategyID 策略编号
	 * @return 返回是否删除成功
	 * */
	public boolean deleteHotelStrategy(String strategyID)throws RemoteException;
}
