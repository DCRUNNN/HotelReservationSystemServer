package service.Order.InteractWithRoom;

import java.util.List;

public interface OrderProvidedServiceForRoom {

	/**
	 * 设置订单的退房时间
	 * @param clientID 客户编号
	 * @param hotelID 酒店编号
	 * @param roomNumber 房间号码
	 * */
	public boolean setEndTime(String clientID, String hotelID,String roomNumber);

	/**
	 * 返回客户在酒店的所有已入住的的房间
	 * @param clientID 客户编号
	 * @param hotelID 酒店编号
	 * */
	public List<String> getRoomNumber(String clientID,String hotelID);
	
}
