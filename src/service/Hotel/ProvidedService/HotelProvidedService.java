package service.Hotel.ProvidedService;

import java.util.List;

public interface HotelProvidedService {

	public String getHotelName(String hotelID);

	public List<String> getAllProvinces();
		
	public List<String> getAllCities(String province);
	
	public List<String> getAllCBDS(String province,String city);
}
