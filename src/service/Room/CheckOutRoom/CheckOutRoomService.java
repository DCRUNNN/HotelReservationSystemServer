package service.Room.CheckOutRoom;

public interface CheckOutRoomService {

	/**
	 * @param clinetID 客户编号
	 * @param hotelID 酒店编号
	 * 退房时候必须把所有的房间都退了
	 * @return 退房成功的话返回退得房间号 roomnumber1+"/"+roomnumber2 失败的话返回""
	 * */
	public String checkOutRoom(String clientID,String hotelID);
	
	
}
