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
 * ApplyForVipService接口的实现类
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
			//如果客户之前是企业会员的话
			po.setClientType("企业会员/普通会员");
			po.setBirthday(birthday);
			Vip vip = new Vip();
			po.setVipGrade(vip.getGrade(po.getCredit_point()));
		}else{
			po.setClientType("普通会员");
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
			//客户同时是普通会员的话
			po.setClientType("普通会员/企业会员");
			po.setCompanyAddress(companyAddress);
			String hotelIDs = po.getHotelIDs();
			String newHotelIDs = "";
			if("".equals(hotelIDs)||"null".equals(hotelIDs)||hotelIDs==null){
				//客户还没有合作酒店
				newHotelIDs  = hotelID;
			}else{
				//客户有合作酒店
				if(hotelIDs.contains(hotelID)){
					//已经是该酒店的企业会员
					return false;
				}else{
					//新增酒店id
					newHotelIDs = hotelIDs+"/"+hotelID;
				}
			}
			po.setHotelIDs(newHotelIDs);
			po.setVipGrade(new Vip().getGrade(po.getCredit_point()));
			
		}else{
			po.setBirthday("");
			po.setClientType("企业会员");
			po.setCompanyAddress(companyAddress);
			po.setVipGrade(new Vip().getGrade(po.getCredit_point()));
			String hotelIDs = po.getHotelIDs();
			String newHotelIDs = "";
			if("".equals(hotelIDs)||"null".equals(hotelIDs)||hotelIDs==null){
				//客户还没有合作酒店
				newHotelIDs  = hotelID;
			}else{
				//客户有合作酒店
				if(hotelIDs.contains(hotelID)){
					//已经是该酒店的企业会员
					return false;
				}else{
					//新增酒店id
					newHotelIDs = hotelIDs+"/"+hotelID;
				}
			}
			
			po.setHotelIDs(newHotelIDs);
		}
		
		//改变好了客户模块之后 需要在对应的酒店添加一个合作企业
		
		return clientDao.change(po)&&hotelservice.addCompany(hotelID,companyAddress);
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
