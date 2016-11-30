package service.Hotel.AddHotel;

import vo.HotelVO;
import vo.PersonnelVO;

public interface AddHotelService {

	/**
	 * @param HotelPO
	 * ��ס����˳��һ��Ҫ������һ��hotel���������Ӷ�Ӧ��hotelworker
	 * @return ��ӳɹ��Ļ������ؾƵ��ţ����ɹ��Ļ�������""
	 * */
	public String addHotel(HotelVO vo);
	
	/**
	 * @param vo
	 * @return �����ݲ����һ���־û�����PersonnelPO,�ɹ��Ļ�����true������false
	 * */
	public boolean addHotelWorker(PersonnelVO vo);
	
	public boolean savePassword(String personnelID,String password);
}
