package service.Room.CreateRoom;

import java.rmi.RemoteException;

import data.dao.RoomDao;
import data.dao.impl.RoomDaoImpl;
import po.RoomPO;
import service.Hotel.ProvidedService.HotelProvidedServiceForRoomImpl;
import service.Room.InteractWithHotel.HotelProvidedServiceForRoom;
import vo.RoomVO;

public class CreateRoomInfoServiceImpl implements CreateRoomInfoService {
	
	private RoomDao roomDao;
	private HotelProvidedServiceForRoom hotelservice;
	
	public CreateRoomInfoServiceImpl() {
		
		roomDao=RoomDaoImpl.getInstance();
	    hotelservice = new HotelProvidedServiceForRoomImpl();
	}
	
	@Override
	public boolean CreateRoom(RoomVO roomVO) throws RemoteException{
		
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
	public String getAllRoomTypeAndPrice(String hotelID) throws RemoteException{
		
		return hotelservice.getRoomTypeAndPrice(hotelID);
	}

}
