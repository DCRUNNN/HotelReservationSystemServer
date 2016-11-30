package service.Client.ApplyForVip;

import data.dao.ClientDAO;
import data.dao.impl.ClientDaoImpl;
import po.ClientPO;
import service.Client.ProvidedService.Vip;
import vo.ClientVO;

/**
 * ApplyForVipService接口的实现类
 * @see ClientDAO
 * @see Vip
 * */
public class ApplyForVipServiceImpl implements ApplyForVipService{

	private ClientDAO clientDao;
	
	public ApplyForVipServiceImpl(){
		
		clientDao = ClientDaoImpl.getInstance();
	}
	
	@Override
	public ClientVO getClientVO(String clientID) {
		ClientPO po = clientDao.getClientPO(clientID);
		return new ClientVO(po);
	}

	@Override
	public boolean applyNormalVip(String clientID, String birthday) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(checkBusinessVip(clientID)){
			//如果客户之前是企业会员的话
			po.setClientType("企业会员/普通会员");
			po.setClientType("普通会员");
			po.setBirthday(birthday);
			Vip vip = new Vip();
			po.setVipGrade(vip.getGrade(po.getCredit_point()));
		}else{
			po.setClientType("普通会员");
			po.setBirthday(birthday);
			Vip vip = new Vip();
			po.setVipGrade(vip.getGrade(po.getCredit_point()));
			po.setCompanyAddress("");
			po.setCompanyName("");
		}
		
		return clientDao.change(po);
	}

	@Override
	public boolean applyBusinessVip(String clientID, String companyAddress, String companyName) {
	
		ClientPO po = clientDao.getClientPO(clientID);
		if(checkNormalVip(clientID)){
			//客户同时是普通会员的话
			po.setClientType("普通会员/企业会员");
			po.setCompanyAddress(companyAddress);
			po.setCompanyName(companyName);
		}else{
			po.setBirthday("");
			po.setClientType("企业会员");
			po.setCompanyAddress(companyAddress);
			po.setCompanyName(companyName);
			po.setVipGrade(new Vip().getGrade(po.getCredit_point()));
		}
		return clientDao.change(po);
	}

	@Override
	public boolean checkNormalVip(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		String userType = po.getClientType();
		if(userType.contains("普通会员")){
			return true;
		}
		return false;
	}

	@Override
	public boolean checkBusinessVip(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		String clientType = po.getClientType();
		if(clientType.contains("企业会员")){
			return true;
		}
		return false;
	}

}
