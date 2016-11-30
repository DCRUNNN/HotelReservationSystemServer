package service.Personnel.ManagePersonnelMessage;

import java.util.ArrayList;
import java.util.List;
import data.dao.PersonnelDAO;
import data.dao.impl.PersonnelDaoImpl;
import po.PersonnelPO;
import service.Account.ProvidedService.AccountProvidedService;
import service.Account.ProvidedService.AccountProvidedServiceImpl;
import service.Hotel.ProvidedService.HotelProvidedService;
import service.Hotel.ProvidedService.HotelProvidedServiceImpl;
import service.Personnel.CreatePersonnelID.CreatePersonnelID;
import vo.PersonnelVO;

public class ManagePersonnelMessageServiceImpl implements ManagePersonnelMessageService{

	private PersonnelDAO personnelDao;
	private List<PersonnelVO> allPersonnels;
	private HotelProvidedService hotelService;
	private AccountProvidedService accountService;
	
	public ManagePersonnelMessageServiceImpl(){
		
		personnelDao = PersonnelDaoImpl.getInstance();
		accountService = new AccountProvidedServiceImpl();
		hotelService = new HotelProvidedServiceImpl();
		initAllPersonnels();
	}
	
	/**
	 * 私有方法，初始化allPersonnels
	 * */
	private void initAllPersonnels() {
		
		List<PersonnelPO> polist = personnelDao.getAllPersonnelPOList();
		allPersonnels = new ArrayList<PersonnelVO>();
		for(PersonnelPO po:polist){
			PersonnelVO vo = new PersonnelVO(po);
			allPersonnels.add(vo);
		}
	}
	
	@Override
	public List<PersonnelVO> getAllHotelWorkers() {
		
		List<PersonnelVO> volist = new ArrayList<PersonnelVO>();
		for(PersonnelVO vo:allPersonnels){
			if("酒店工作人员".equals(vo.getType())){
				volist.add(vo);
			}
		}
		return volist;
	}

	@Override
	public List<PersonnelVO> getAllWebSalers() {

		List<PersonnelVO> volist = new ArrayList<PersonnelVO>();
		for(PersonnelVO vo:allPersonnels){
			if("网站营销人员".equals(vo.getType())){
				volist.add(vo);
			}
		}
		return volist;
	}

	@Override
	public List<PersonnelVO> getHotelWorkersByHotelName(String hotelName) {
		
		List<PersonnelVO> volist = new ArrayList<PersonnelVO>();
		
		for(PersonnelVO vo:allPersonnels){
			if("酒店工作人员".equals(vo.getType())){
				String hname = hotelService.getHotelName(vo.gethotelID());
				if(hotelName.equals(hname)){
					volist.add(vo);
				}
			}
		}
		return volist;
	}

	@Override
	public PersonnelVO getHotelWorkerByHotelID(String hotelID) {
		
		for(PersonnelVO vo:allPersonnels){
			if(hotelID.equals(vo.gethotelID())){
				return vo;
			}
		}
		return null;
	}

	@Override
	public PersonnelVO getPersonnelVO(String personnelID) {
		
		for(PersonnelVO vo:allPersonnels){
			if(personnelID.equals(vo.getpersonnelID())){
				return vo;
			}
		}
		return null;
	}

	@Override
	public List<PersonnelVO> getPersonnelVOByPersonnelName(String personnelName) {
		
		List<PersonnelVO> volist = new ArrayList<PersonnelVO>();
		for(PersonnelVO vo:allPersonnels){
			if(personnelName.equals(vo.getname())){
				volist.add(vo);
			}
		}
		return volist;
	}

	@Override
	public boolean modifyPersonnel(PersonnelVO vo) {
		
		PersonnelPO po = new PersonnelPO();
		po.setName(vo.getname());
		po.setPhoneNumber(vo.getphoneNumber());
		po.setSex(vo.getsex());
		return personnelDao.change(po);
	}

	@Override
	public String addNewWebsalers(PersonnelVO vo) {
		
		PersonnelPO po = new PersonnelPO();
		po.setName(vo.getname());
		po.setPhoneNumber(vo.getphoneNumber());
		po.setType("网站营销人员");
		po.setSex(vo.getsex());
		
		String personnelID = new CreatePersonnelID().nextWebSalerId();
		if("".equals(personnelID)){
			//达到上限或者是数据库插入没有成功
			return "";
		}
		po.setPersonnelID(personnelID);
		if(!personnelDao.change(po)){
			return "";
		}
		return personnelID;
	}

	@Override
	public boolean savePassword(String personnelID, String password) {
		
		return accountService.insert(personnelID, password);
	}

}
