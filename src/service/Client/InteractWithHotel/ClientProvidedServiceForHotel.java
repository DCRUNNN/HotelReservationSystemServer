package service.Client.InteractWithHotel;

public interface ClientProvidedServiceForHotel {

	public String getClientName(String clientID);
	
	public String getSex(String clientID);
	
	public String getIdentityID(String clientID);
	
	public String getPhoneNumber(String clientID);
}
