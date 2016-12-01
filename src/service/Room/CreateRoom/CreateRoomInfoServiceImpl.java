package service.Room.CreateRoom;

import data.dao.RoomDao;
import data.dao.impl.RoomDaoImpl;
import po.RoomPO;
import service.Hotel.ProvidedService.HotelProvidedService;
import service.Hotel.ProvidedService.HotelProvidedServiceImpl;
import vo.RoomVO;

public class CreateRoomInfoServiceImpl implements CreateRoomInfoService {
	
	private RoomDao roomDao;
	private HotelProvidedService hotelservice;
	
	public CreateRoomInfoServiceImpl() {
		
		roomDao=RoomDaoImpl.getInstance();
	    hotelservice = new HotelProvidedServiceImpl();
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
		roomPO.setBookDate(roomVO.getBookDate());
		return roomDao.addRoom(roomPO);
	}

	@Override
	public String getAllRoomTypeAndPrice(String hotelID) {
		
		return hotelservice.getRoomTypeAndPrice(hotelID);
	}

}
