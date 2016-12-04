package service.Order.BrowseOrder_webWorker;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.OrderVO;

public interface BrowseOrder_webWorkerService extends Remote{
	
	/**
	 * @return �õ����е�δִ�ж���
	 * */
	public List<OrderVO> getAllUnexecutedOrders()throws RemoteException;
	
	/**
	 * @return �õ����е��쳣����
	 * */
	public List<OrderVO> getAllAbnormalOrders()throws RemoteException;
	
	/**
	 * @return ��һ���쳣����ת��Ϊ�ѳ�������
	 * */
	public boolean withdrawAbnormalOrder(String orderID)throws RemoteException;
	
	/**
	 * @return ���ݶ�����ŷ��ض�����Ϣ
	 * */
    public OrderVO getOrderVO(String orderID)throws RemoteException;
    
    /**
     * @return ���ݿͻ�id�õ��ͻ��������쳣����
     * */
    public List<OrderVO> getClientAbnormalOrders(String clientID)throws RemoteException;
    
    
}
