package service.Order.InteractWithHotel;

import java.util.List;

import po.OrderPO;

public interface OrderProvidedServiceForHotel {

	/**
	 * @param clientID
	 * @return 没有的话就是返回""，否则返回一个list，内容是与客户相关的所有订单的部分信息 orderInfo = orderCreatedDate+"/"+orderStatus+"/"+orderID+"/"+price+"/"+hotelID 
	 * */
	public List<String> getAllClientOrderInfo(String clientID);
	


	/**
	 * @param clinetID 客户编号
	 * @param hotelID 酒店编号
	 * @return 根据客户编号和酒店编号返回客户在该酒店的所有订单
	 * */
	public List<OrderPO> getAllOrdersOfClientInaHotel(String clientID, String hotelID);
}
