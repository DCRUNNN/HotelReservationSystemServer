package service.Order.BrowseOrder_hotelWorker;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.OrderVO;

public interface BrowseOrder_hotelWorkerService extends Remote{

	/**
	 * @param orderID
	 * @return ���ݶ���id��������ϸ�Ķ�����Ϣ
	 * */
	public OrderVO getOrder(String orderID)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @return �õ��Ƶ��������ִ�ж���
	 * */
	public List<OrderVO> getExecutedOrders(String hotelID)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @return �õ��Ƶ������δִ�ж���
	 * */
	public List<OrderVO> getUnexecutedOrders(String hotelID)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @return �õ��Ƶ�������ѳ�������
	 * */
	public List<OrderVO> getWithdrawnOrders(String hotelID)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @return �õ��Ƶ�������쳣����
	 * */
	public List<OrderVO> getAbnormalOrders(String hotelID)throws RemoteException;
	
}
