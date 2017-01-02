package service.Client.ManageClientMessage_client;

import java.rmi.RemoteException;

import data.dao.ClientDAO;
import data.dao.impl.ClientDaoImpl;
import po.ClientPO;
import service.Client.help.CreateClientVO;
import service.picture.Picture;
import vo.ClientVO;

public class ManageClientMessage_clientServiceImpl implements ManageClientMessage_clientService{

	private ClientDAO clientDao;
	
	public ManageClientMessage_clientServiceImpl(){
		
		clientDao = ClientDaoImpl.getInstance();
	}
	
	@Override
	public ClientVO getClientVO(String clientID) throws RemoteException {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(po==null){
			//po为空的话
			return null;
		}
		ClientVO vo = new CreateClientVO().createClientVO(po);
		return vo;
	}

	@Override
	public boolean changeClientMessage(ClientVO vo) throws RemoteException{
		
		ClientPO po = new ClientPO();
		//vo转化为po
		po.setId(vo.getId());
		po.setBirthday(vo.getBirthday());
		po.setClientType(vo.getClientType());
		po.setCompanyAddress(vo.getCompanyAddress());
		po.setHotelIDs(vo.getHotelIDS());
		po.setCredit_point(vo.getCredit_point());
		po.setIdentityID(vo.getIdentityID());
		po.setName(vo.getName());
		po.setPhoneNumber(vo.getPhoneNumber());
		po.setSex(vo.getSex());
		po.setVipGrade(vo.getVipGrade());
		
		return clientDao.change(po);
	}

	@Override
	public boolean uploadPicture(byte[] picture,String clientID) throws RemoteException {
		
		return Picture.uploadPicture(picture, clientID);
		
	}

	@Override
	public byte[] getClientPicture(String clientID) throws RemoteException {
		
		return Picture.getClientPicture(clientID);
	}

	@Override
	public boolean changeClientPicture(byte[] picture, String clientID) throws RemoteException {
		
		return Picture.changeClientPicture(picture, clientID);
	}
}
