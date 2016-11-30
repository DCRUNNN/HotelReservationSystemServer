package data.dao;

import java.util.List;

import po.PersonnelPO;

public interface PersonnelDAO {
	
	public PersonnelPO getPersonnelPO(String Personnel_id);
	
	public List<PersonnelPO> getAllPersonnelPOList();

	/**
	 * @param po 工作人员的持久化信息
	 * @return 往数据层插入一个工作人员的持久化信息，返回是否成功插入
	 * */
	public boolean insert(PersonnelPO po);

	/**
	 * @param po 工作人员信息
	 * @return 返回是否修改成功
	 * */
	public boolean change(PersonnelPO po);

	/**
	 * @return 返回所有的工作人员id
	 * */
	public List<String> getAllIds();

}
