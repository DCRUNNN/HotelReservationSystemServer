package service.Client.ApplyForVip;

import data.dao.ClientDAO;
import data.dao.impl.ClientDaoImpl;
import po.ClientPO;
import service.Client.InteractWithHotel.HotelProvidedServiceForClient;
import service.Client.ProvidedService.Vip;
import service.Client.help.CreateClientVO;
import service.Hotel.ProvidedService.HotelProvidedServiceForClientImpl;
import vo.ClientVO;

/**
 * ApplyForVipService�ӿڵ�ʵ����
 * @see ClientDAO
 * @see Vip
 * */
public class ApplyForVipServiceImpl implements ApplyForVipService{

	private ClientDAO clientDao;
	private HotelProvidedServiceForClient hotelservice ;
	
	public ApplyForVipServiceImpl(){
		
		clientDao = ClientDaoImpl.getInstance();
		hotelservice = new HotelProvidedServiceForClientImpl();
	}
	
	@Override
	public ClientVO getClientVO(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		return new CreateClientVO().createClientVO(po);
	}

	@Override
	public boolean applyNormalVip(String clientID, String birthday) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		if(checkBusinessVip(clientID)){
			//����ͻ�֮ǰ����ҵ��Ա�Ļ�
			po.setClientType("��ҵ��Ա/��ͨ��Ա");
			po.setBirthday(birthday);
			Vip vip = new Vip();
			po.setVipGrade(vip.getGrade(po.getCredit_point()));
		}else{
			po.setClientType("��ͨ��Ա");
			po.setBirthday(birthday);
			Vip vip = new Vip();
			po.setVipGrade(vip.getGrade(po.getCredit_point()));
			po.setCompanyAddress("");
		}
		
		return clientDao.change(po);
	}

	@Override
	public boolean applyBusinessVip(String clientID, String companyAddress, String hotelID) {
	
		ClientPO po = clientDao.getClientPO(clientID);
		if(checkNormalVip(clientID)){
			//�ͻ�ͬʱ����ͨ��Ա�Ļ�
			po.setClientType("��ͨ��Ա/��ҵ��Ա");
			po.setCompanyAddress(companyAddress);
			String hotelIDs = po.getHotelIDs();
			String newHotelIDs = "";
			if("".equals(hotelIDs)||"null".equals(hotelIDs)||hotelIDs==null){
				//�ͻ���û�к����Ƶ�
				newHotelIDs  = hotelID;
			}else{
				//�ͻ��к����Ƶ�
				if(hotelIDs.contains(hotelID)){
					//�Ѿ��ǸþƵ����ҵ��Ա
					return false;
				}else{
					//�����Ƶ�id
					newHotelIDs = hotelIDs+"/"+hotelID;
				}
			}
			po.setHotelIDs(newHotelIDs);
			po.setVipGrade(new Vip().getGrade(po.getCredit_point()));
			
		}else{
			po.setBirthday("");
			po.setClientType("��ҵ��Ա");
			po.setCompanyAddress(companyAddress);
			po.setVipGrade(new Vip().getGrade(po.getCredit_point()));
			String hotelIDs = po.getHotelIDs();
			String newHotelIDs = "";
			if("".equals(hotelIDs)||"null".equals(hotelIDs)||hotelIDs==null){
				//�ͻ���û�к����Ƶ�
				newHotelIDs  = hotelID;
			}else{
				//�ͻ��к����Ƶ�
				if(hotelIDs.contains(hotelID)){
					//�Ѿ��ǸþƵ����ҵ��Ա
					return false;
				}else{
					//�����Ƶ�id
					newHotelIDs = hotelIDs+"/"+hotelID;
				}
			}
			
			po.setHotelIDs(newHotelIDs);
		}
		
		//�ı���˿ͻ�ģ��֮�� ��Ҫ�ڶ�Ӧ�ľƵ����һ��������ҵ
		
		return clientDao.change(po)&&hotelservice.addCompany(hotelID,companyAddress);
	}

	@Override
	public boolean checkNormalVip(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		String userType = po.getClientType();
		if(userType.contains("��ͨ��Ա")){
			return true;
		}
		return false;
	}

	@Override
	public boolean checkBusinessVip(String clientID) {
		
		ClientPO po = clientDao.getClientPO(clientID);
		String clientType = po.getClientType();
		if(clientType.contains("��ҵ��Ա")){
			return true;
		}
		return false;
	}

}
