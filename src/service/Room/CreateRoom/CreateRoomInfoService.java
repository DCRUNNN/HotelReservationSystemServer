package service.Room.CreateRoom;

import vo.RoomVO;

public interface CreateRoomInfoService {
	
	
	/**
	 * @param roomVo
	 * @return �½�һ������״̬
	 */
	public boolean CreateRoom(RoomVO roomVO);
	
	/**
	 * @param hotelID �Ƶ���
	 * @return ���ط�������(����1+"/"+����2)
	 * */
	public String getAllRoomTypeAndPrice(String hotelID);
	
}
