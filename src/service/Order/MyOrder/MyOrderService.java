package service.Order.MyOrder;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.OrderVO;

public interface MyOrderService extends Remote{

	/**
	 * @return ��ÿͻ���������ִ�ж���
	 * */
	public List<OrderVO> getExecutedOrders(String clientID) throws RemoteException;
	
	/**
	 * @return ��ÿͻ�������δִ�ж���
	 * */
	public List<OrderVO> getUnexecutedOrders(String clientID) throws RemoteException;
	
	/**
	 * @return ��ÿͻ��������ѳ�������
	 * */
	public List<OrderVO> getWithdrawnOrders(String clientID) throws RemoteException;
	
	/**
	 * @return ��ÿͻ��������쳣����
	 * */
	public List<OrderVO> getAbnormalOrders(String clientID) throws RemoteException;
	
	/**
	 * @param �������
	 * @return ���ݶ�����Ż����ϸ������Ϣ
	 * */
	public OrderVO getOrderVO(String orderID) throws RemoteException;

	/**
	 * @param �ͻ����
	 * @param �������
	 * @return ���ݶ������ ��������
	 * */
	public boolean withdraw(String clientID,String orderID) throws RemoteException;
	
	
}
