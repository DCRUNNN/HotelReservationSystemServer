package service.Strategy.ManageHotelStrategy;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.StrategyVO;

public interface ManageHotelStrategyService extends Remote{

	/**
	 * @param hotelID �Ƶ���
	 * @return �õ�һ���Ƶ�����ڵ�����Ӫ������
	 * */
	public List<StrategyVO> getAllHotelStrategy(String hotelID)throws RemoteException;
	
	/**
	 * @param strategyVO �Ƶ�Ӫ������
	 * �������Ե�ʱ�򣬶��ڿ�ֵһ��Ҫ����Ĭ��ֵ roomTotal����ͷ�����ĿĬ��Ϊ1 stringĬ��Ϊ"" isToBirthdayĬ��false
	 * @return �����µľƵ�Ӫ������
	 * */
	public boolean addHotelStrategy(StrategyVO vo)throws RemoteException;
	
	/**
	 * @param strategyVO �Ƶ�Ӫ������
	 * @return �����Ƿ�ɹ��޸ľƵ�Ӫ������
	 * */
	public boolean changeHotelStrategy(StrategyVO vo)throws RemoteException;
	
	/**
	 * @param strategyID ���Ա��
	 * @return �����Ƿ�ɾ���ɹ�
	 * */
	public boolean deleteHotelStrategy(String strategyID)throws RemoteException;
}
