package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.datahelper.xmlhelper.XMLHelper;
import service.Client.ManageClientMessage_webManager.ClientMessage_webManagerService;
import service.Hotel.AddHotel.AddHotelService;
import service.Personnel.ManagePersonnelMessage.ManagePersonnelMessageService;
import vo.ClientVO;
import vo.HotelVO;
import vo.PersonnelVO;

public class WebManagerDataRemoteObject extends UnicastRemoteObject implements ClientMessage_webManagerService,
              ManagePersonnelMessageService,AddHotelService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6312220244715407989L;
	
	private ClientMessage_webManagerService manageClient;
	private ManagePersonnelMessageService managePersonnel;
	private AddHotelService addHotel;
	
	public WebManagerDataRemoteObject() throws RemoteException {
		
		super();
		String filePath = "./xml/servicexml/webmanagerservice.xml";
		try {
			manageClient = (ClientMessage_webManagerService) Class.forName(XMLHelper.getClass(filePath, "manageClient")).newInstance();
			managePersonnel = (ManagePersonnelMessageService) Class.forName(XMLHelper.getClass(filePath, "managePersonnel")).newInstance();
			addHotel = (AddHotelService) Class.forName(XMLHelper.getClass(filePath, "addHotel")).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String addHotel(HotelVO vo) throws RemoteException {
		
		return addHotel.addHotel(vo);
	}

	@Override
	public boolean addHotelWorker(PersonnelVO vo) throws RemoteException {
		
		return addHotel.addHotelWorker(vo);
	}

	@Override
	public boolean isExist(HotelVO vo) throws RemoteException {
		
		return addHotel.isExist(vo);
	}

	@Override
	public List<PersonnelVO> getAllHotelWorkers() throws RemoteException {
		
		return managePersonnel.getAllHotelWorkers();
	}

	@Override
	public List<PersonnelVO> getAllWebSalers() throws RemoteException {
		
		return managePersonnel.getAllWebSalers();
	}

	@Override
	public List<PersonnelVO> getHotelWorkersByHotelName(String hotelName) throws RemoteException {
	
		return managePersonnel.getHotelWorkersByHotelName(hotelName);
	}

	@Override
	public PersonnelVO getHotelWorkerByHotelID(String hotelID) throws RemoteException {
		
		return managePersonnel.getHotelWorkerByHotelID(hotelID);
	}

	@Override
	public PersonnelVO getPersonnelVO(String personnelID) throws RemoteException {
		
		return managePersonnel.getPersonnelVO(personnelID);
	}

	@Override
	public List<PersonnelVO> getPersonnelVOByPersonnelName(String personnelName) throws RemoteException {
	
		return managePersonnel.getPersonnelVOByPersonnelName(personnelName);
	}

	@Override
	public boolean modifyPersonnel(PersonnelVO vo) throws RemoteException {
	
		return managePersonnel.modifyPersonnel(vo);
	}

	@Override
	public String addNewWebsalers(PersonnelVO vo) throws RemoteException {
	
		return managePersonnel.addNewWebsalers(vo);
	}

	@Override
	public boolean savePassword(String personnelID, String password) throws RemoteException {
		
		return managePersonnel.savePassword(personnelID, password);
	}

	@Override
	public List<ClientVO> getAllClients() throws RemoteException {
		
		return manageClient.getAllClients();
	}

	@Override
	public List<ClientVO> getClientsByName(String name) throws RemoteException {
		
		return manageClient.getClientsByName(name);
	}

	@Override
	public List<ClientVO> getClientByPhoneNumber(String phoneNumber) throws RemoteException {
		
		return manageClient.getClientByPhoneNumber(phoneNumber);
	}

	@Override
	public ClientVO getClientMessage(String clientID) throws RemoteException {
		
		return manageClient.getClientMessage(clientID);
	}

	@Override
	public boolean modifyClientMessage(ClientVO vo) throws RemoteException {
		
		return manageClient.modifyClientMessage(vo);
	}

	@Override
	public byte[] getClientPicture(String clientID) throws RemoteException {
		
		return manageClient.getClientPicture(clientID);
	}

}
