package service.Hotel.ProvidedService;

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

}
