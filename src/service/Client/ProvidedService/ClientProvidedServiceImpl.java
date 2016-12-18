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
			//扣除信用点之后等级发生了变化
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
			//增加信用点之后等级发生了变化
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
	public String getHotelIDs(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return "";
		}
		return po.getHotelIDs();
	}
	@Override
	public boolean isCorrectCompanyVip(String clientID, String hotelID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return false;
		}
		String hotelIDs = po.getHotelIDs();
		if(hotelIDs.contains(hotelID)){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public String getClientName(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return "";
		}
		return po.getName();
	}
	@Override
	public String getSex(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return "";
		}
		return po.getSex();
	}
	@Override
	public String getIdentityID(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return "";
		}
		return po.getIdentityID();
	}
	
	@Override
	public String getPhoneNumber(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return "";
		}
		return po.getPhoneNumber();
	}
	
	@Override
	public String getVIPInfo(String clientID) {
	
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			return "";
		}
		
		if(po.getClientType().equals("普通客户")){
			return po.getClientType();
		}else{
			return po.getClientType()+String.valueOf(po.getVipGrade());
		}
	}
	@Override
	public double getCredit(String clientID) {
		
		ClientPO po =clientDao.getClientPO(clientID);
		if(po==null){
			return 0;
		}
		return po.getCredit_point();
	}
	
}
