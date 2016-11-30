package service.Client.ManageClientMessage_client;

import vo.ClientVO;

public interface ManageClientMessage_clientService {

	public ClientVO getClientVO(String clientID);
	
	public boolean changeClientMessage(ClientVO vo);
}
