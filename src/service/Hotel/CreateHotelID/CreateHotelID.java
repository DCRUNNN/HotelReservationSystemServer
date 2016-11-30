package service.Hotel.CreateHotelID;

import java.util.List;

import data.dao.HotelDao;
import po.HotelPO;

public class CreateHotelID {

	
	/*
	 * �Ƶ�ı�Ź����ǣ���λ���кż��ɣ���00001��ʼһֱ����
	 * */
	private HotelDao hotelDao;
	
	public CreateHotelID(){
		//hotelDao��ʵ����
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
				return "00001";//���ݿ����滹û�оƵ�Ļ���ֱ�ӷ���00001
			}
			int maxId =0;
			for(String str:allIds){
				if(Integer.valueOf(str)>=maxId){
					maxId = Integer.valueOf(str);
				}
			}//�ҵ����е����id
			
			if(maxId==99999){
				return "";
			}
			maxId ++;
			String newID = String.valueOf(maxId);
			
			int i=newID.length();
			String zero ="";
			for(int j=0;j<allIds.get(0).length()-i;j++){
				zero+="0";
			}//�����к�ǰ��Ҫ���ϵ�0�ĸ���
			
			po.setHotelID(zero+newID);
			if(!hotelDao.insert(po)){
				return "";
			}else{
				return zero+newID;
			}
		}
	}
}
