package service.Personnel.providedservice;

import data.dao.PersonnelDAO;
import data.dao.impl.PersonnelDaoImpl;
import po.PersonnelPO;
import service.Personnel.CreatePersonnelID.CreatePersonnelID;
import vo.PersonnelVO;

public class PersonnelProvidedServiceImpl implements PersonnelProvidedService{

	private PersonnelDAO personnelDao;
	
	public PersonnelProvidedServiceImpl(){
		
		personnelDao = PersonnelDaoImpl.getInstance();
	}
	
	@Override
	public boolean insert(PersonnelVO vo) {

		PersonnelPO po = new PersonnelPO();
		po.setHotelID(vo.gethotelID());
		po.setName(vo.getname());
		po.setPhoneNumber(vo.getphoneNumber());
		po.setSex(vo.getsex());
		po.setType("酒店工作人员");
		String hotelID = vo.gethotelID();
		po.setPersonnelID(new CreatePersonnelID().nextHotelWorkerId(hotelID));
		return personnelDao.change(po);
	
	}

}
