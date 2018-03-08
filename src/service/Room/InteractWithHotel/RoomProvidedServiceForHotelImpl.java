package service.Room.InteractWithHotel;

import data.dao.RoomDao;
import data.dao.impl.RoomDaoImpl;

public class RoomProvidedServiceForHotelImpl implements RoomProvidedServiceForHotel {

	private RoomDao roomDao;
	
	public RoomProvidedServiceForHotelImpl(){
		
		roomDao = RoomDaoImpl.getInstance();
	}
	
	public boolean changeRoomPrice(String hotelID,String roomType,double price){
		
		return roomDao.changeRoomPrice(roomType, price, hotelID);
		
	}
}
