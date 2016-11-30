package service.Order.InteractWithHotel;

import java.util.List;

import po.OrderPO;

public interface OrderProvidedServiceForHotel {

	/**
	 * @param clientID
	 * @return û�еĻ����Ƿ���""�����򷵻�һ��list����������ͻ���ص����ж����Ĳ�����Ϣ orderInfo = orderCreatedDate+"/"+orderStatus+"/"+orderID+"/"+price+"/"+hotelID 
	 * */
	public List<String> getAllClientOrderInfo(String clientID);
	


	/**
	 * @param clinetID �ͻ����
	 * @param hotelID �Ƶ���
	 * @return ���ݿͻ���ź;Ƶ��ŷ��ؿͻ��ڸþƵ�����ж���
	 * */
	public List<OrderPO> getAllOrdersOfClientInaHotel(String clientID, String hotelID);
}
