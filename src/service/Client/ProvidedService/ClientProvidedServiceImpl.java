package service.Client.ProvidedService;

import data.dao.ClientDAO;
import data.dao.impl.ClientDaoImpl;
import po.ClientPO;

public class ClientProvidedServiceImpl implements ClientProvidedService{

	private ClientDAO clientDao;
	
	public ClientProvidedServiceImpl(){
		
		clientDao = ClientDaoImpl.getInstance();
	}
	@Override
	public boolean subClientCreditPoint(String clientID, double point) {
		
		double currentPoint = clientDao.getClientPoint(clientID);
		double left = currentPoint - point;
		Vip vip = new Vip();
		if(vip.getGrade(currentPoint)>vip.getGrade(left)){
			//�۳����õ�֮��ȼ������˱仯
			if(!clientDao.setVipGrade(clientID,vip.getGrade(left))){
				return false;
			}
		}
		return clientDao.subClientCreditPoint(clientID,left);
	}

	@Override
	public boolean addClientCreditPoint(String clientID, double point) {
		
		double currentPoint = clientDao.getClientPoint(clientID);
		double left = currentPoint + point;
		Vip vip = new Vip();
		if(vip.getGrade(currentPoint)<vip.getGrade(left)){
			//�������õ�֮��ȼ������˱仯
			if(!clientDao.setVipGrade(clientID,vip.getGrade(left))){
				return false;
			}
		}
		return clientDao.addClientCreditPoint(clientID,left);
	}

	@Override
	public String getUserType(String clientID) {
		return clientDao.getUserType(clientID);
	}

	@Override
	public boolean checkCreditPoint(String clientID) {
		double currentPoint  = clientDao.getClientPoint(clientID);
		if(currentPoint>=0){
			return true;
		}
		return false;
	}
	
	@Override
	public double getCreditPoint(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return 0;
		}
		return po.getCredit_point();
	}
	
	@Override
	public String getVipBirthday(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return "";
		}
		return po.getBirthday();
	}
	
	@Override
	public int getVipGrade(String clientID) {
	
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return -1;
		}
		return po.getVipGrade();
	}
	
	@Override
	public String getCompanyAddress(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return "";
		}
		return po.getCompanyAddress();
	}
	
	@Override
	public String getCompanyName(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return "";
		}
		return po.getCompanyName();
	}

}
