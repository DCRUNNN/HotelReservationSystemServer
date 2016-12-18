package service.Client.InteractWithHotel;

import service.Client.ProvidedService.ClientProvidedServiceImpl;

public class ClientProvidedServiceForHotelImpl implements ClientProvidedServiceForHotel{

	private ClientProvidedServiceImpl service ;
	
	public ClientProvidedServiceForHotelImpl(){
		
		service = new ClientProvidedServiceImpl();
	}
	
	@Override
	public String getClientName(String clientID) {
		
		return service.getClientName(clientID);
	}

	@Override
	public String getSex(String clientID) {
		
		return service.getSex(clientID);
	}

	@Override
	public String getIdentityID(String clientID) {
		
		return service.getIdentityID(clientID);
	}

	@Override
	public String getPhoneNumber(String clientID) {
		
		return service.getPhoneNumber(clientID);
	}

	@Override
	public String getVIPInfo(String clientID) {
	
		return service.getVIPInfo(clientID);
	}
	
	@Override
	public double getCredit(String clientID) {
		
		return service.getCredit(clientID);
	}
}
