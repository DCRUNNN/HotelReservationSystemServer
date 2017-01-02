package service.Hotel.ProvidedService;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;

public class HotelProvidedServiceForRoomImpl implements service.Room.InteractWithHotel.HotelProvidedServiceForRoom{

	private HotelDao hotelDao;
	
	public HotelProvidedServiceForRoomImpl(){
		
		hotelDao = HotelDaoImpl.getInstance();
	}
	
	
	@Override
	public String getRoomTypeAndPrice(String hotelID) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		if(po==null){
			return "";
		}
		return po.getRoomTypeAndPrice();
	}

	@Override
	public boolean changeRoomTypeAndPrice(String type, double price, String hotelId) {
		
		HotelPO po = hotelDao.getHotelPO(hotelId);
		if(po==null){
			return false;
		}
		String result ="";
		String []typeAndPrice = po.getRoomTypeAndPrice().split("/");
		for(String str:typeAndPrice){
			if(type.equals(str.split("[|]")[0])){
				//遍历typeAndPrice 找到房间类型
				result+=type+"|"+price+"/";
			}else{
				result+=str+"/";
			}
		}
		
		po.setRoomTypeAndPrice(result.substring(0,result.length()-1));
		
		return hotelDao.change(po);
	}

	

}
