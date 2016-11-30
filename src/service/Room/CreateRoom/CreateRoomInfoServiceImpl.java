package service.Room.CreateRoom;

import data.dao.RoomDao;
import data.dao.impl.RoomDaoImpl;
import po.RoomPO;
import vo.RoomVO;

public class CreateRoomInfoServiceImpl implements CreateRoomInfoService {
	
	private RoomDao roomDao;
	
	public CreateRoomInfoServiceImpl() {
		
		roomDao=RoomDaoImpl.getInstance();
	
	}
	
	@Override
	public boolean CreateRoom(RoomVO roomVO) {
		
		RoomPO roomPO=new RoomPO();
		roomPO.setHotelID(roomVO.getHotelID());
		roomPO.setPrice(roomVO.getPrice());
		roomPO.setRoomIntroduction(roomVO.getRoomIntroduction());
		roomPO.setRoomNumber(roomVO.getRoomNumber());
		roomPO.setRoomState(roomVO.getRoomState());
		roomPO.setRoomType(roomVO.getRoomType());
		return roomDao.addRoom(roomPO);
	}

}
