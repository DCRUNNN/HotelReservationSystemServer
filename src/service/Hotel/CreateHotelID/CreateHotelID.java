package service.Hotel.CreateHotelID;

import java.util.List;

import data.dao.HotelDao;
import po.HotelPO;

public class CreateHotelID {

	
	/*
	 * 酒店的编号规则是：五位序列号即可，从00001开始一直递增
	 * */
	private HotelDao hotelDao;
	
	public CreateHotelID(){
		//hotelDao的实例化
	}
	
	public String nextId(){
		
		synchronized(this){
			
			List<String> allIds = hotelDao.getAllIds();
			HotelPO po = new HotelPO();
			if(allIds.size()==0){
				po.setHotelID("00001");
				if(!hotelDao.insert(po)){
					return "";
				}
				return "00001";//数据库里面还没有酒店的话，直接返回00001
			}
			int maxId =0;
			for(String str:allIds){
				if(Integer.valueOf(str)>=maxId){
					maxId = Integer.valueOf(str);
				}
			}//找到现有的最大id
			
			if(maxId==99999){
				return "";
			}
			maxId ++;
			String newID = String.valueOf(maxId);
			
			int i=newID.length();
			String zero ="";
			for(int j=0;j<allIds.get(0).length()-i;j++){
				zero+="0";
			}//在序列号前面要补上的0的个数
			
			po.setHotelID(zero+newID);
			if(!hotelDao.insert(po)){
				return "";
			}else{
				return zero+newID;
			}
		}
	}
}
