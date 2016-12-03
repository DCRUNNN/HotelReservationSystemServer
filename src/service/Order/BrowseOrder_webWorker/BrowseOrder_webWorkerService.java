package service.Order.BrowseOrder_webWorker;

import java.util.List;

import vo.OrderVO;

public interface BrowseOrder_webWorkerService {
	
	/**
	 * @return �õ����е�δִ�ж���
	 * */
	public List<OrderVO> getAllUnexecutedOrders();
	
	/**
	 * @return �õ����е��쳣����
	 * */
	public List<OrderVO> getAllAbnormalOrders();
	
	/**
	 * @return ��һ���쳣����ת��Ϊ�ѳ�������
	 * */
	public boolean withdrawAbnormalOrder(String orderID);
	
	/**
	 * @return ���ݶ�����ŷ��ض�����Ϣ
	 * */
    public OrderVO getOrderVO(String orderID);
    
    /**
     * @return ���ݿͻ�id�õ��ͻ��������쳣����
     * */
    public List<OrderVO> getClientAbnormalOrders(String clientID);
    
    
}
