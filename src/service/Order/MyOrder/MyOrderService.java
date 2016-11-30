package service.Order.MyOrder;

import java.util.List;

import vo.OrderVO;

public interface MyOrderService {

	/**
	 * @return ��ÿͻ���������ִ�ж���
	 * */
	public List<OrderVO> getExecutedOrders();
	
	/**
	 * @return ��ÿͻ�������δִ�ж���
	 * */
	public List<OrderVO> getUnexecutedOrders();
	
	/**
	 * @return ��ÿͻ��������ѳ�������
	 * */
	public List<OrderVO> getWithdrawnOrders();
	
	/**
	 * @return ��ÿͻ��������쳣����
	 * */
	public List<OrderVO> getAbnormalOrders();
	
	/**
	 * @param �������
	 * @return ���ݶ�����Ż����ϸ������Ϣ
	 * */
	public OrderVO getOrderVO(String orderID);

	/**
	 * @param �������
	 * @return ���ݶ������ ��������
	 * */
	public boolean withdraw(String orderID);
	
	
}
