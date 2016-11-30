package service.Hotel.AddHotel;

import vo.HotelVO;
import vo.PersonnelVO;

public interface AddHotelService {

	/**
	 * @param HotelPO
	 * 记住调用顺序，一定要先增添一个hotel，才能增加对应的hotelworker
	 * @return 添加成功的话，返回酒店编号，不成功的话，返回""
	 * */
	public String addHotel(HotelVO vo);
	
	/**
	 * @param vo
	 * @return 往数据层添加一个持久化数据PersonnelPO,成功的话返回true，否则false
	 * */
	public boolean addHotelWorker(PersonnelVO vo);
	
	public boolean savePassword(String personnelID,String password);
}
