package service.Personnel.ManagePersonnelMessage;

import java.util.List;

import vo.PersonnelVO;

public interface ManagePersonnelMessageService {

	/**
	 * @return �õ����еľƵ깤����Ա��Ϣ
	 * */
	public List<PersonnelVO> getAllHotelWorkers();
	
	/**
	 * @return �õ����е���վӪ����Ա����Ϣ
	 * */
	public List<PersonnelVO> getAllWebSalers();
	
	/**
	 * @param hotelName �Ƶ�����
	 * @return �������������Ʒ��ϵľƵ깤����Ա��������Ϣ
	 * */
	public List<PersonnelVO> getHotelWorkersByHotelName(String hotelName);
	
	/**
	 * @param hotelID �Ƶ���
	 * @return ���ݾƵ��ŷ��ع�����Ա��Ϣ
	 * */
	public PersonnelVO getHotelWorkerByHotelID(String hotelID);
	
	/**
	 * @param personnelID ������Ա���
	 * @return ���ع�����Ա��Ϣ
	 * */
	public PersonnelVO getPersonnelVO(String personnelID);
	
	/**
	 * @param personnelName ������Ա����
	 * @return ���ݹ�����Ա���ַ��ط��������Ĺ�����Ա��Ϣ
	 * */
	public List<PersonnelVO> getPersonnelVOByPersonnelName(String personnelName);
	
	/**
	 * @param vo �޸ĺ�Ĺ�����Ա��Ϣ
	 * @return �����Ƿ��޸ĳɹ�
	 * */
	public boolean modifyPersonnel(PersonnelVO vo);
	
	/**
	 * @param vo �µ���վ������Ա����Ϣ
	 * @return �ɹ��Ļ�����Ӫ����Ա��id���������""
	 * */
	public String addNewWebsalers(PersonnelVO vo);
	
	/**
	 * @param personnelID ������Ա���
	 * @param password ����
	 * @return �����Ƿ񱣴�ɹ�
	 * */
	public boolean savePassword(String personnelID,String password);
}
