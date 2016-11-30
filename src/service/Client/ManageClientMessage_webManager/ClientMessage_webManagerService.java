package service.Client.ManageClientMessage_webManager;

import java.util.List;

import vo.ClientVO;

public interface ClientMessage_webManagerService {

	public List<ClientVO> getAllClients();
	
	public List<ClientVO> getClientsByName(String name);
	
	public List<ClientVO> getClientByPhoneNumber(String phoneNumber);
	
	public ClientVO getClientMessage(String clientID);
	
	public boolean modifyClientMessage(ClientVO vo);
}
