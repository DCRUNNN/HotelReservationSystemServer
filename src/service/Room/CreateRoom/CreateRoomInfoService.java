package service.Room.CreateRoom;

import vo.RoomVO;

public interface CreateRoomInfoService {
	
	
	/**
	 * @param roomVo
	 * @return 新建一个房间状态
	 */
	public boolean CreateRoom(RoomVO roomVO);
	

}
