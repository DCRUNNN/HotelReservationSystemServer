package service.Room.CreateRoom;

import vo.RoomVO;

public interface CreateRoomInfoService {
	
	
	/**
	 * @param roomVo
	 * @return 新建一个房间状态
	 */
	public boolean CreateRoom(RoomVO roomVO);
	
	/**
	 * @param hotelID 酒店编号
	 * @return 返回房间类型(类型1+"/"+类型2)
	 * */
	public String getAllRoomTypeAndPrice(String hotelID);
	
}
