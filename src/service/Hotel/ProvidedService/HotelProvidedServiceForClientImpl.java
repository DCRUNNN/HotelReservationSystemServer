package service.Hotel.ProvidedService;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import service.Client.InteractWithHotel.HotelProvidedServiceForClient;

public class HotelProvidedServiceForClientImpl implements HotelProvidedServiceForClient {
	
	private HotelDao hotelDao;
	
	public HotelProvidedServiceForClientImpl(){
		hotelDao = HotelDaoImpl.getInstance();
	}
	@Override
	public boolean addCompany(String hotelID, String companyAddress) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		if(po==null){
			//酒店id找不到对应的酒店
			return false;
		}
		
		String company = po.getCompany();
		if("".equals(company)||"null".equals(company)||company==null){
			po.setCompany(companyAddress);//直接设置company为companyAddress就可以了
			return hotelDao.change(po);
		}else{
		    if(company.contains(companyAddress)){
		    	return true;//已经是酒店的合作企业了
		    }else{
		    	String newCompany = company+"/"+companyAddress;
		    	po.setCompany(newCompany);
		    	return hotelDao.change(po);
		    }
		}

	}
	
	@Override
	public String getHotelInfo(String hotelID) {
		
	    HotelPO po = hotelDao.getHotelPO(hotelID);
	    if(po==null){
	    	//酒店对应的id不存在
	    	return "";
	    }
	    
	    String hotelProvince = po.getHotelProvince();
	    String hotelCity = po.getHotelCity();
	    String hotelCBD = po.getHotelCBD();
	    String hotelAddress = po.getHotelAddress();
	    String hotelName = po.getHotelName();
	    String hotelInfo = hotelProvince+hotelCity+hotelCBD+hotelAddress+hotelName;
		return hotelInfo;
	}

 }
