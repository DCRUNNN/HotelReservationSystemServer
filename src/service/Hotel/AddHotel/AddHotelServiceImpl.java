package service.Hotel.AddHotel;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import service.Account.ProvidedService.AccountProvidedService;
import service.Account.ProvidedService.AccountProvidedServiceImpl;
import service.Hotel.CreateHotelID.CreateHotelID;
import service.Personnel.providedservice.PersonnelProvidedService;
import service.Personnel.providedservice.PersonnelProvidedServiceImpl;
import vo.HotelVO;
import vo.PersonnelVO;

/**
 * AddHotelService��ʵ����
 * @see 
 * */
public class AddHotelServiceImpl implements AddHotelService{

	private HotelDao hoteldao;
	private PersonnelProvidedService personnelservice;
	private AccountProvidedService accountService;
	
	public AddHotelServiceImpl(){
		
		hoteldao = HotelDaoImpl.getInstance();
		personnelservice =  new PersonnelProvidedServiceImpl();
		accountService = new AccountProvidedServiceImpl();
	}
	
	@Override
	public String addHotel(HotelVO vo){ 
		
		HotelPO po = new HotelPO();
		//po.setCommentList(vo.getCommentList());
		//po.setCommentPeople(vo.getCommentPeople());������Ϣ�ǲ���Ҫ��
		po.setFacilities(vo.getFacilities());
		po.setHotelCBD(vo.getHotelCBD());
		po.setHotelCity(vo.getHotelCity());
		
	    String hotelID = new CreateHotelID().nextId();
	    if("".equals(hotelID)){
	    	//�Ƶ���Ŀ�ﵽ���޻������µ�idû�гɹ��������ݿ�
	    	return "";
	    }
	    po.setHotelID(hotelID);
		po.setHotelName(vo.getHotelName());
		po.setHotelProvince(vo.getHotelProvince());
		po.setHotelStar(vo.getHotelStar());
		po.setIntroduction(vo.getIntroduction());
		po.setRoomTypeAndPrice(vo.getRoomTypeAndPrice());
		
        if(!hoteldao.change(po)){
        	return "";
        }else{
        	return hotelID;
        }
	}

	@Override
	public boolean addHotelWorker(PersonnelVO vo) {
		
		String hotelID = vo.gethotelID();
		if(hoteldao.getHotelPO(hotelID)==null){
			return false;//�Ƶ겻����
		}
		return personnelservice.insert(vo);
	}

	@Override
	public boolean savePassword(String personnelID, String password) {
		
		return accountService.insert(personnelID, password);
	}

}
