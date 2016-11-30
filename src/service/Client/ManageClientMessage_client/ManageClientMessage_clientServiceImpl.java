package service.Client.ManageClientMessage_client;

import data.dao.ClientDAO;
import data.dao.impl.ClientDaoImpl;
import po.ClientPO;
import vo.ClientVO;

public class ManageClientMessage_clientServiceImpl implements ManageClientMessage_clientService{

	private ClientDAO clientDao;
	
	public ManageClientMessage_clientServiceImpl(){
		
		clientDao = ClientDaoImpl.getInstance();
	}
	
	@Override
	public ClientVO getClientVO(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			//poΪ�յĻ�
			return null;
		}
		ClientVO vo = new ClientVO(po);
		return vo;
	}

	@Override
	public boolean changeClientMessage(ClientVO vo) {
		
		ClientPO po = new ClientPO();
		//voת��Ϊpo
		po.setId(vo.getId());
		po.setBirthday(vo.getBirthday());
		po.setClientType(vo.getClientType());
		po.setCompanyAddress(vo.getCompanyAddress());
		po.setCompanyName(vo.getCompanyName());
		po.setCredit_point(vo.getCredit_point());
		po.setIdentityID(vo.getIdentityID());
		po.setName(vo.getName());
		po.setPhoneNumber(vo.getPhoneNumber());
		po.setSex(vo.getSex());
		po.setVipGrade(vo.getVipGrade());
		
		return clientDao.change(po);
	}

}