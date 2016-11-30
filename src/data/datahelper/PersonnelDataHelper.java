package data.datahelper;

import java.util.List;

import po.PersonnelPO;

public interface PersonnelDataHelper {
	public PersonnelPO getPersonnelPO(String Personnel_id);

	public List<PersonnelPO> getAllPersonnelPOList();
	
	public boolean insert(PersonnelPO po);
	
	public boolean isExist(String hotelID);
	
	public boolean change(PersonnelPO po);

	public List<String> getAllids();
}
