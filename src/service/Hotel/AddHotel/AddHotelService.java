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
	
	/**
	 * @param personnelID ������Ա���
	 * @param password ����
	 * @return ���ر��������Ƿ�ɹ�
	 * */
	public boolean savePassword(String personnelID,String password);
	
	/**
	 * @param vo �Ƶ���Ϣ
	 * @return ���ݾƵ�ʡ�ݣ��Ƶ������У��Ƶ�������Ȧ���Ƶ���ϸ��ַ�;Ƶ��������жϾƵ��Ƿ��Ѿ�����
	 * */
	public boolean isExist(HotelVO vo);
}
