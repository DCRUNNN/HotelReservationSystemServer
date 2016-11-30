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

}
