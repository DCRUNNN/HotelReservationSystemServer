package service.Room.CheckOutRoom;

public interface CheckOutRoomService {

	/**
	 * @param clinetID 客户编号
	 * @param hotelID 酒店编号
	 * 退房时候必须把所有的房间都退了
	 * @return 返回是否成功更新信息
	 * */
	public boolean checkOutRoom(String clientID,String hotelID);
	
	
}
