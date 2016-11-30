package service.Personnel.providedservice;

import vo.PersonnelVO;

public interface PersonnelProvidedService {

	/**
	 * @param vo 酒店工作人员信息
	 * @return 插入一个酒店工作人员信息
	 * */
	public boolean insert(PersonnelVO vo);
}
