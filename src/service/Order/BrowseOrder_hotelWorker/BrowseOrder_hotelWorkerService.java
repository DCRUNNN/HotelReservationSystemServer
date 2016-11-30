package service.Order.BrowseOrder_hotelWorker;

import java.util.List;

import vo.OrderVO;

public interface BrowseOrder_hotelWorkerService {

	/**
	 * @param orderID
	 * @return ���ݶ���id��������ϸ�Ķ�����Ϣ
	 * */
	public OrderVO getOrder(String orderID);
	
	/**
	 * @return �õ��Ƶ��������ִ�ж���
	 * */
	public List<OrderVO> getExecutedOrders();
	
	/**
	 * @return �õ��Ƶ������δִ�ж���
	 * */
	public List<OrderVO> getUnexecutedOrders();
	
	/**
	 * @return �õ��Ƶ�������ѳ�������
	 * */
	public List<OrderVO> getWithdrawnOrders();
	
	/**
	 * @return �õ��Ƶ�������쳣����
	 * */
	public List<OrderVO> getAbnormalOrders();
	
}
