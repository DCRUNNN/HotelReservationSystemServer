package service.Client.ManageClientMessage_webManager;

import java.util.ArrayList;
import java.util.List;

import data.dao.ClientDAO;
import data.dao.impl.ClientDaoImpl;
import po.ClientPO;
import vo.ClientVO;

public class ClientMessage_webManagerServiceImpl implements ClientMessage_webManagerService{

	private List<ClientVO> allclients;
	private ClientDAO clientDao;
	
	public ClientMessage_webManagerServiceImpl(){
		
		clientDao = ClientDaoImpl.getInstance();
	}
	
	@Override
	public List<ClientVO> getAllClients() {
		
		List<ClientPO> polist = clientDao.getAllClient();
		if(polist==null){
			allclients = null;
			return null;
		}
		
		allclients = new ArrayList<ClientVO>();
		for(ClientPO po:polist){
			ClientVO vo = new ClientVO(po);
			allclients.add(vo);
		}
		
		return allclients;
	}

	@Override
	public List<ClientVO> getClientsByName(String name) {
	
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
	public List<ClientVO> getClientByPhoneNumber(String phoneNumber) {
		
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
	public boolean modifyClientMessage(ClientVO vo) {	
		
		ClientPO po = new ClientPO();
		//vo×ª»¯Îªpo
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
		
		return clientDao.change(po);}

	@Override
	public ClientVO getClientMessage(String clientID) {
		
		ClientVO vo =null;
		for(ClientVO clientVO:allclients){
			if(clientID.equals(clientVO.getId())){
				vo = clientVO;
			}
		}
		return vo;
	}

}
