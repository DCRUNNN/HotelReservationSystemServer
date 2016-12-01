package service.Hotel.MaintainHotelMessage;

import vo.HotelVO;

public interface MaintainHotelMessageService {

	/**
	 * @param hotelProvince �Ƶ�ʡ��
	 * @param hotelCity �Ƶ���
	 * @param hotelCBD �Ƶ���Ȧ
	 * @param hotelAddress �Ƶ���ϸ��ַ
	 * @param hotelName �Ƶ�����
	 * @param introduction �Ƶ���
	 * @param facilities �Ƶ���ʩ
	 * @param star �Ƶ��Ǽ�
	 * @param roomTypeAndPrices ��������+"|"+�۸�+"/"+��������+"|"+�۸�
	 * �޸ľƵ�Ļ�����Ϣ
	 * */
	public boolean changeHotelInfo(String hotelProvince,String hotelCity,String hotelCBD,String hotelAddress,String hotelName,String introduction,String facilities,int star,String roomTypeAndPrices);
	
	/**
	 * @param vo �޸ĺ�ľƵ���Ϣ
	 * @return �����Ƿ��޸ĳɹ�
	 * */
	public boolean changeHotelInfo(HotelVO vo);
	
	/**
	 * @return �õ��޸�ǰ�ľƵ���Ϣ,���ص�HotelVO����Ϊ��
	 * */
	public HotelVO getHotelVO();
	
	
}
