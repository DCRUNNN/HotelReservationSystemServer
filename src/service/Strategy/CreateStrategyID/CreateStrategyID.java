package service.Strategy.CreateStrategyID;

import java.util.List;

import data.dao.StrategyDao;
import data.dao.impl.StrategyDaoImpl;
import po.StrategyPO;

public class CreateStrategyID {

	/*
	 * 营销策略的编号逻辑
	 * 酒店营销策略的话 就是 酒店id+五位序列号(从00001开始)
	 * 网站营销策略的话 就是 W(大写)+五位序列号(从00001开始)
	 * */
	private StrategyDao strategyDao;
	private int lengthOfTheTailOfStrategy =5;//策略编号的尾数长度
	
	public CreateStrategyID(){
		
		strategyDao = StrategyDaoImpl.getInstance();
	}
	
	public String nextHotelStrategyID(String hotelID){
		
		synchronized(this){
			
			List<String> allids = strategyDao.getAllIDs();
			StrategyPO po = new StrategyPO();
			
			int max=0;
		    for(String str:allids){
		    	//遍历 allids 找出酒店现有的策略编号最大值
		    	if(hotelID.equals(str.substring(0,5))){
		    		int value = Integer.valueOf(str.substring(5));
		    		if(value>max){
		    			max=value;
		    		}
		    	}
		    }
		    if(max==99999){
		    	return "";
		    }
		    
		    max++;//最大值加一进行新的编号
		    String newID = String.valueOf(max);
		    int length = newID.length();
		    String zero = "";
		    for(int i=0;i<lengthOfTheTailOfStrategy-length;i++){
		    	zero+="0";
		    }
		    po.setStrategyID(hotelID+zero+newID);
		    if(!strategyDao.addStrategy(po)){
		    	return "";
		    }else{
		    	return hotelID+zero+newID;
		    }
		
		}
	}
	
	public String nextWebsiteStrategyID (){
		
		synchronized(this){
			
			List<String> allids = strategyDao.getAllIDs();
			StrategyPO po = new StrategyPO();
			int max=0;
			for(String str:allids){
				if(str.charAt(0)=='W'){
					int value = Integer.valueOf(str.substring(1));
					if(value>max){
						max=value;
					}
				
				}
			}//找出当前最大值
			
			if(max==99999){
				//达到了上限了
				return "";
			}
			
			max++;
			String zero = "";
			String newID = String.valueOf(max);
			int length = newID.length();
			for(int i=0;i<lengthOfTheTailOfStrategy-length;i++){
				zero+="0";
			}
			newID = "W"+zero+newID;//最大值加一 得到新的编号
			po.setStrategyID(newID);
			if(!strategyDao.addStrategy(po)){
				return "";
			}
			return newID;
		}
	}
}
