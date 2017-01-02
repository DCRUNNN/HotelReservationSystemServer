package service.Personnel.CreatePersonnelID;

import java.util.List;

import data.dao.PersonnelDAO;
import data.dao.impl.PersonnelDaoImpl;
import po.PersonnelPO;

public class CreatePersonnelID {

	/*
	 * ������Ա�ı�Ź�����:
	 * 1(�Ƶ깤����Ա)   + �Ƶ���
	 * 2(��վӪ����Ա)   + ��λ���кţ���00001��ʼ��
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
			for(String str:allids){//��������id���ҳ���վӪ����Ա�������
			    if(str.charAt(0)=='2'){
			    	//�ҵ���վӪ����Ա�ı��
			    	if(Integer.valueOf(str.substring(1))>max){
			    		max = Integer.valueOf(str.substring(1));
			    	}
			    }
			}
			
			if(max==9999){
				return "";
			}
			
			max++;//���ֵ��һ
			String newID = String.valueOf(max);
			int i = newID.length();
			String zero="";
			for(int j=0;j<allids.get(0).length()-1-i;j++){
				zero+="0";
			}
			
			PersonnelPO po = new PersonnelPO();
			po.setPersonnelID("2"+zero+newID);
			if(!personnelDao.insert(po)){//����id�ɹ���ͬʱд�����ݿ⣬��ֹ�����³����쳣
				return "";
			}
			return "2"+zero+newID;
		}
	}
}
