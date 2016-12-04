package service.Personnel.ManagePersonnelMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.PersonnelVO;

public interface ManagePersonnelMessageService extends Remote{

	/**
	 * @return 得到所有的酒店工作人员信息
	 * */
	public List<PersonnelVO> getAllHotelWorkers()throws RemoteException;
	
	/**
	 * @return 得到所有的网站营销人员的信息
	 * */
	public List<PersonnelVO> getAllWebSalers()throws RemoteException;
	
	/**
	 * @param hotelName 酒店名称
	 * @return 返回所有与名称符合的酒店工作人员的所有信息
	 * */
	public List<PersonnelVO> getHotelWorkersByHotelName(String hotelName)throws RemoteException;
	
	/**
	 * @param hotelID 酒店编号
	 * @return 根据酒店编号返回工作人员信息
	 * */
	public PersonnelVO getHotelWorkerByHotelID(String hotelID)throws RemoteException;
	
	/**
	 * @param personnelID 工作人员编号
	 * @return 返回工作人员信息
	 * */
	public PersonnelVO getPersonnelVO(String personnelID)throws RemoteException;
	
	/**
	 * @param personnelName 工作人员姓名
	 * @return 根据工作人员名字返回符合条件的工作人员信息
	 * */
	public List<PersonnelVO> getPersonnelVOByPersonnelName(String personnelName)throws RemoteException;
	
	/**
	 * @param vo 修改后的工作人员信息
	 * @return 返回是否修改成功
	 * */
	public boolean modifyPersonnel(PersonnelVO vo)throws RemoteException;
	
	/**
	 * @param vo 新的网站销售人员的信息
	 * @return 成功的话返回营销人员的id，否则就是""
	 * */
	public String addNewWebsalers(PersonnelVO vo)throws RemoteException;
	
	/**
	 * @param personnelID 工作人员编号
	 * @param password 密码
	 * @return 返回是否保存成功
	 * */
	public boolean savePassword(String personnelID,String password)throws RemoteException;
}
