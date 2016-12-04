package service.Strategy.ManageWebsiteStrategy;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.StrategyVO;

public interface ManageWebsiteStrategyService extends Remote{

	/**
	 * @return �õ���վ������Ӫ������
	 * */
	public List<StrategyVO> getAllWebsiteStrategy()throws RemoteException;
	
	/**
	 * @param StrategyVO  Ӫ������
	 * @return �����µ�Ӫ������
	 * */
	public boolean addStrategy(StrategyVO strategyVO)throws RemoteException;
	
	/**
	 * @param StrategyVO Ӫ������
	 * @return StrategyID���䣬����վӪ�����Խ����޸�
	 * */
	public boolean changeStrategy(StrategyVO strategyVO)throws RemoteException;
	
	/**
	 * @param strategyID ���Ա��
	 * @return �Բ��Խ���ɾ��
	 * */
	public boolean deleteStrategy(String strategyID)throws RemoteException;
	
	
}
