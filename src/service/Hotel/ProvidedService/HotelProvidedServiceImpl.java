package service.Hotel.ProvidedService;

import java.util.ArrayList;
import java.util.List;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;

public class HotelProvidedServiceImpl implements HotelProvidedService{

	private HotelDao hotelDao;
	
	public HotelProvidedServiceImpl(){
		
		hotelDao = HotelDaoImpl.getInstance();
	}
	@Override
	public String getHotelName(String hotelID) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		if(po==null){
			return "";
		}
		return po.getHotelName();
	}
	
	@Override
	public List<String> getAllProvinces() {
	
		List<String> result = new ArrayList<String>();
		String provinces = hotelDao.getProvinces();
		if("".equals(provinces)){
			return result;
		}
		
		String str[] = provinces.split("/");
		for(String s:str){
			result.add(s);
		}
		return result;
	}
	
	@Override
	public List<String> getAllCities(String province) {
	
		List<String> result = new ArrayList<String>();
		String cities = hotelDao.getCities(province);
		if("".equals(cities)){
			return result;
		}
		
		String str[] = cities.split("/");
		for(String s:str){
			result.add(s);
		}
		return result;
	}
	
	@Override
	public List<String> getAllCBDS(String province, String city) {
	
		List<String> result = new ArrayList<String>();
		String cbds = hotelDao.getCBDS(province, city);
		if("".equals(cbds)){
			return result;
		}
		
		String str[] = cbds.split("/");
		for(String s:str){
			result.add(s);
		}
		return result;
	}


}
