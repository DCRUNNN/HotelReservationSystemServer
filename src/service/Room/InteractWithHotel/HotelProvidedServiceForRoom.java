package service.Room.InteractWithHotel;

public interface HotelProvidedServiceForRoom{

	public String getRoomTypeAndPrice(String hotelID);

	public boolean changeRoomTypeAndPrice(String type, double price, String hotelId);

}
