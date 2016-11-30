package service.Order.InteractWithRoom;

public interface OrderProvidedServiceForRoom {

	public boolean setEndTime(String clientID, String hotelID, String outTime);

	public String getRoomNumber(String clientID,String hotelID);
}
