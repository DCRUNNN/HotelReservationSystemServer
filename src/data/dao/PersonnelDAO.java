package data.dao;

import java.util.List;

import po.PersonnelPO;

public interface PersonnelDAO {
	
	public PersonnelPO getPersonnelPO(String Personnel_id);
	
	public List<PersonnelPO> getAllPersonnelPOList();

	/**
	 * @param po ������Ա�ĳ־û���Ϣ
	 * @return �����ݲ����һ��������Ա�ĳ־û���Ϣ�������Ƿ�ɹ�����
	 * */
	public boolean insert(PersonnelPO po);

	/**
	 * @param po ������Ա��Ϣ
	 * @return �����Ƿ��޸ĳɹ�
	 * */
	public boolean change(PersonnelPO po);

	/**
	 * @return �������еĹ�����Աid
	 * */
	public List<String> getAllIds();

}
