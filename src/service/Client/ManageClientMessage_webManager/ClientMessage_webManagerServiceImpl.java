package service.Client.ManageClientMessage_webManager;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.dao.ClientDAO;
import data.dao.impl.ClientDaoImpl;
import po.ClientPO;
import service.Client.help.CreateClientVO;
import vo.ClientVO;

public class ClientMessage_webManagerServiceImpl implements ClientMessage_webManagerService{

	private List<ClientVO> allclients;
	private ClientDAO clientDao;
	
	public ClientMessage_webManagerServiceImpl(){
		
		clientDao = ClientDaoImpl.getInstance();
	}
	
	@Override
	public List<ClientVO> getAllClients() throws RemoteException{
		
		List<ClientPO> polist = clientDao.getAllClient();
		if(polist==null){
			allclients = null;
			return null;
		}
		
		allclients = new ArrayList<ClientVO>();
		CreateClientVO help = new CreateClientVO();
		for(ClientPO po:polist){
			ClientVO vo = help.createClientVO(po);
			allclients.add(vo);
		}
		
		return allclients;
	}

	@Override
	public List<ClientVO> getClientsByName(String name) throws RemoteException{
	
		if(allclients==null){
			return null;
		}
		List<ClientVO> result = new ArrayList<ClientVO>();
		for(ClientVO vo:allclients){
			if(name.equals(vo.getName())){
				result.add(vo);
			}
		}
		return result;
	}

	@Override
	public List<ClientVO> getClientByPhoneNumber(String phoneNumber) throws RemoteException{
		
		if(allclients==null){
			return null;
		}
		List<ClientVO> result = new ArrayList<ClientVO>();
		for(ClientVO vo:allclients){
			if(phoneNumber.equals(vo.getPhoneNumber())){
				result.add(vo);
			}
		}
		return result;
	}

	@Override
	public boolean modifyClientMessage(ClientVO vo) throws RemoteException{	
		
		//首先对allclients进行修改
		for(int i=0;i<allclients.size();i++){
			if(allclients.get(i).getId().equals(vo.getId())){
				allclients.set(i, vo);
				break;
			}
		}
		
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
	public ClientVO getClientMessage(String clientID) throws RemoteException{
		
		ClientVO vo =null;
		for(ClientVO clientVO:allclients){
			if(clientID.equals(clientVO.getId())){
				vo = clientVO;
			}
		}
		return vo;
	}

}
