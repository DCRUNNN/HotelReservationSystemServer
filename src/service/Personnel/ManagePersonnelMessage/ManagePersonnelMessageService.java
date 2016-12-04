package service.Personnel.ManagePersonnelMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.PersonnelVO;

public interface ManagePersonnelMessageService extends Remote{

	/**
	 * @return �õ����еľƵ깤����Ա��Ϣ
	 * */
	public List<PersonnelVO> getAllHotelWorkers()throws RemoteException;
	
	/**
	 * @return �õ����е���վӪ����Ա����Ϣ
	 * */
	public List<PersonnelVO> getAllWebSalers()throws RemoteException;
	
	/**
	 * @param hotelName �Ƶ�����
	 * @return �������������Ʒ��ϵľƵ깤����Ա��������Ϣ
	 * */
	public List<PersonnelVO> getHotelWorkersByHotelName(String hotelName)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @return ���ݾƵ��ŷ��ع�����Ա��Ϣ
	 * */
	public PersonnelVO getHotelWorkerByHotelID(String hotelID)throws RemoteException;
	
	/**
	 * @param personnelID ������Ա���
	 * @return ���ع�����Ա��Ϣ
	 * */
	public PersonnelVO getPersonnelVO(String personnelID)throws RemoteException;
	
	/**
	 * @param personnelName ������Ա����
	 * @return ���ݹ�����Ա���ַ��ط��������Ĺ�����Ա��Ϣ
	 * */
	public List<PersonnelVO> getPersonnelVOByPersonnelName(String personnelName)throws RemoteException;
	
	/**
	 * @param vo �޸ĺ�Ĺ�����Ա��Ϣ
	 * @return �����Ƿ��޸ĳɹ�
	 * */
	public boolean modifyPersonnel(PersonnelVO vo)throws RemoteException;
	
	/**
	 * @param vo �µ���վ������Ա����Ϣ
	 * @return �ɹ��Ļ�����Ӫ����Ա��id���������""
	 * */
	public String addNewWebsalers(PersonnelVO vo)throws RemoteException;
	
	/**
	 * @param personnelID ������Ա���
	 * @param password ����
	 * @return �����Ƿ񱣴�ɹ�
	 * */
	public boolean savePassword(String personnelID,String password)throws RemoteException;
}
