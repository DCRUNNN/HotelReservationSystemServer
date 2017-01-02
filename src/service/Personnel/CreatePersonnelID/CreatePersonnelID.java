package service.Personnel.CreatePersonnelID;

import java.util.List;

import data.dao.PersonnelDAO;
import data.dao.impl.PersonnelDaoImpl;
import po.PersonnelPO;

public class CreatePersonnelID {

	/*
	 * 工作人员的编号规则是:
	 * 1(酒店工作人员)   + 酒店编号
	 * 2(网站营销人员)   + 五位序列号（从00001开始）
	 * */
	private PersonnelDAO personnelDao;
	
	public CreatePersonnelID(){
	
		personnelDao = PersonnelDaoImpl.getInstance();
	}
	
	public String nextHotelWorkerId(String hotelID){
		
		return "1"+hotelID;
	}
	
	public String nextWebSalerId(){
		
		synchronized(this){
			
			List<String> allids = personnelDao.getAllIds();
			if(allids.size()==0||allids==null){
				
				PersonnelPO po = new PersonnelPO();
				po.setPersonnelID("200001");
				if(!personnelDao.insert(po)){
					return "";
				}
				return "200001";
			}
			
			int max=0;
			for(String str:allids){//遍历所有id，找出网站营销人员的最大编号
			    if(str.charAt(0)=='2'){
			    	//找到网站营销人员的编号
			    	if(Integer.valueOf(str.substring(1))>max){
			    		max = Integer.valueOf(str.substring(1));
			    	}
			    }
			}
			
			if(max==9999){
				return "";
			}
			
			max++;//最大值加一
			String newID = String.valueOf(max);
			int i = newID.length();
			String zero="";
			for(int j=0;j<allids.get(0).length()-1-i;j++){
				zero+="0";
			}
			
			PersonnelPO po = new PersonnelPO();
			po.setPersonnelID("2"+zero+newID);
			if(!personnelDao.insert(po)){//创建id成功的同时写入数据库，防止并发下出现异常
				return "";
			}
			return "2"+zero+newID;
		}
	}
}
