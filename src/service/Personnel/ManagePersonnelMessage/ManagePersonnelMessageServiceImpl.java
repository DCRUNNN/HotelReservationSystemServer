package service.Personnel.ManagePersonnelMessage;

import java.rmi.RemoteException;
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
	private HotelProvidedService hotelService;
	private AccountProvidedService accountService;
	
	public ManagePersonnelMessageServiceImpl(){
		
		personnelDao = PersonnelDaoImpl.getInstance();
		accountService = new AccountProvidedServiceImpl();
		hotelService = new HotelProvidedServiceImpl();
	}
	
	
	@Override
	public List<PersonnelVO> getAllHotelWorkers()throws RemoteException {
		
		List<PersonnelVO> volist = new ArrayList<PersonnelVO>();
		List<PersonnelPO> polist = personnelDao.getAllPersonnelPOList();
		for(PersonnelPO po:polist){
			if("酒店工作人员".equals(po.getType())){
				volist.add(new PersonnelVO(po));
			}
		}
		return volist;
	}

	@Override
	public List<PersonnelVO> getAllWebSalers()throws RemoteException {
		
		List<PersonnelVO> volist = new ArrayList<PersonnelVO>();
		List<PersonnelPO> polist = personnelDao.getAllPersonnelPOList();
		for(PersonnelPO po:polist){
			if("网站营销人员".equals(po.getType())){
				volist.add(new PersonnelVO(po));
			}
		}
		return volist;
	}

	@Override
	public List<PersonnelVO> getHotelWorkersByHotelName(String hotelName) throws RemoteException{
		
		List<PersonnelVO> volist = new ArrayList<PersonnelVO>();
		List<PersonnelPO> polist = personnelDao.getAllPersonnelPOList();
		for(PersonnelPO po:polist){
			if("酒店工作人员".equals(po.getType())){
				String hname = hotelService.getHotelName(po.getHotelID());
				if(hotelName.equals(hname)){
					volist.add(new PersonnelVO(po));
				}
			}
		}
		return volist;
	}

	@Override
	public PersonnelVO getHotelWorkerByHotelID(String hotelID) throws RemoteException{
		
		List<PersonnelPO> polist = personnelDao.getAllPersonnelPOList();
		for(PersonnelPO po:polist){
			if(hotelID.equals(po.getHotelID())){
				return new PersonnelVO(po);
			}
		}
		return null;
	}

	@Override
	public PersonnelVO getPersonnelVO(String personnelID)throws RemoteException {
		
		List<PersonnelPO> polist = personnelDao.getAllPersonnelPOList();
		for(PersonnelPO po:polist){
			if(personnelID.equals(po.getPersonnelID())){
				return new PersonnelVO(po);
			}
		}
		return null;
	}

	@Override
	public List<PersonnelVO> getPersonnelVOByPersonnelName(String personnelName)throws RemoteException {
		
		List<PersonnelVO> volist = new ArrayList<PersonnelVO>();
		List<PersonnelPO> polist = personnelDao.getAllPersonnelPOList();
		
		for(PersonnelPO po:polist){
			if(personnelName.equals(po.getName())){
				volist.add(new PersonnelVO(po));
			}
		}
		return volist;
	}

	@Override
	public boolean modifyPersonnel(PersonnelVO vo)throws RemoteException {
		
		PersonnelPO po = new PersonnelPO();
		po.setHotelID(vo.gethotelID());
		po.setPersonnelID(vo.getpersonnelID());
		po.setType(vo.getType());
		po.setName(vo.getname());
		po.setPhoneNumber(vo.getphoneNumber());
		po.setSex(vo.getsex());
		return personnelDao.change(po);
	}

	@Override
	public String addNewWebsalers(PersonnelVO vo)throws RemoteException {
		
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
	public boolean savePassword(String personnelID, String password)throws RemoteException {
		
		return accountService.insert(personnelID, password);
	}

}
