package service.Order.InteractWithRoom;

import java.util.List;

import vo.RoomVO;

public interface RoomProvidedServiceForOrder {

	/**
	 * @param 酒店编号
	 * @return 返回该酒店的所有房间列表
	 * */
	public List<RoomVO> getAllRooms(String hotelID);

	/**
	 * @param 酒店编号,房间号码，房间状态
	 * @return 根据酒店编号 去改变酒店的房间状态,只是简单的改变房间状态
	 * */
	public boolean changeRoomState(String hotelID, String roomNumber,String state);
	
	/**
	 * @param 酒店编号，房间号码，预订时间
	 * @return 根据酒店编号，去改变酒店的预订时间
	 * */
	public boolean setBookDate(String hotelID,String roomNumber,String bookDate);

	/**
	 * @param hotelID 酒店编号
	 * @param roomType 房间类型
	 * @return 返回现在酒店可用的符合类型的房间号码 (roomNumebr1+"/"+roomNumber2)
	 * */
	public String getAvailableRoomNumbers(String hotelID, String roomType);

	/**
	 * @param hotelID 酒店编号
	 * @param roomNumber 房间号码
	 * @return 返回所有的房间对应的价格
	 * */
	public double getRoomPrice(String hotelID, String roomNumber);

	/**
	 * @param hotelID 酒店编号
	 * @param roomNumber 房间号码
	 * @return 如果房间状态为空闲，返回true，否则false
	 * */
	public boolean checkRoom(String hotelID, String roomNumber);

}
