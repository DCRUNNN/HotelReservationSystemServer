package service.Strategy.CreateStrategyID;

import java.util.List;

import data.dao.StrategyDao;
import data.dao.impl.StrategyDaoImpl;
import po.StrategyPO;

public class CreateStrategyID {

	/*
	 * Ӫ�����Եı���߼�
	 * �Ƶ�Ӫ�����ԵĻ� ���� �Ƶ�id+��λ���к�(��00001��ʼ)
	 * ��վӪ�����ԵĻ� ���� W(��д)+��λ���к�(��00001��ʼ)
	 * */
	private StrategyDao strategyDao;
	private int lengthOfTheTailOfStrategy =5;//���Ա�ŵ�β������
	
	public CreateStrategyID(){
		
		strategyDao = StrategyDaoImpl.getInstance();
	}
	
	public String nextHotelStrategyID(String hotelID){
		
		synchronized(this){
			
			List<String> allids = strategyDao.getAllIDs();
			StrategyPO po = new StrategyPO();
			
			int max=0;
		    for(String str:allids){
		    	//���� allids �ҳ��Ƶ����еĲ��Ա�����ֵ
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
		    
		    max++;//���ֵ��һ�����µı��
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
			}//�ҳ���ǰ���ֵ
			
			if(max==99999){
				//�ﵽ��������
				return "";
			}
			
			max++;
			String zero = "";
			String newID = String.valueOf(max);
			int length = newID.length();
			for(int i=0;i<lengthOfTheTailOfStrategy-length;i++){
				zero+="0";
			}
			newID = "W"+zero+newID;//���ֵ��һ �õ��µı��
			po.setStrategyID(newID);
			if(!strategyDao.addStrategy(po)){
				return "";
			}
			return newID;
		}
	}
}
