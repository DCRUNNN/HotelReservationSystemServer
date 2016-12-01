package service.Hotel.ProvidedService;

public interface HotelProvidedService {
	
	public String getHotelName(String hotelID);

	public String getRoomTypeAndPrice(String hotelID);

	public boolean changeRoomTypeAndPrice(String type, double price, String hotelId);
}
