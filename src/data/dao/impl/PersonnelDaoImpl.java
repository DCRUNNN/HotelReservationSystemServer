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

	//运用单例模式 在类加载的时候完成初始化，不存在线程同步问题
	private PersonnelDaoImpl() {
		
		dataFactory=new DataFactoryImpl();
		personnelDataHelper=dataFactory.getPersonnelDataHelper();
	}
	
	public static PersonnelDaoImpl getInstance(){
		return INSTANCE;
	} //通过调用static方法来获得PersonnelDaoImpl的实例
	
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
