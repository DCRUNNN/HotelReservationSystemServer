package data.dao.impl;

import java.util.List;

import data.dao.PersonnelDAO;
import data.datahelper.DataFactory;
import data.datahelper.PersonnelDataHelper;
import data.datahelper.impl.DataFactoryImpl;
import po.PersonnelPO;

public class PersonnelDaoImpl implements PersonnelDAO{

	private PersonnelDataHelper personnelDataHelper;
	
	private DataFactory dataFactory;
	
	private static final PersonnelDaoImpl INSTANCE=new PersonnelDaoImpl();

	//���õ���ģʽ ������ص�ʱ����ɳ�ʼ�����������߳�ͬ������
	private PersonnelDaoImpl() {
		
		dataFactory=new DataFactoryImpl();
		personnelDataHelper=dataFactory.getPersonnelDataHelper();
	}
	
	public static PersonnelDaoImpl getInstance(){
		return INSTANCE;
	} //ͨ������static���������PersonnelDaoImpl��ʵ��
	
	public List<PersonnelPO> getAllPersonnelPOList() {
		
		return personnelDataHelper.getAllPersonnelPOList();
	}

	public PersonnelPO getPersonnelPO(String Personnel_id) {
		
		return personnelDataHelper.getPersonnelPO(Personnel_id);
	}

	@Override
	public boolean insert(PersonnelPO po) {
		
		return personnelDataHelper.insert(po);
	}

	@Override
	public boolean change(PersonnelPO po) {
	
		return personnelDataHelper.change(po);
	}

	@Override
	public List<String> getAllIds() {
		
		return personnelDataHelper.getAllids();
	}
}
