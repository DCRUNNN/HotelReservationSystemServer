package service.Hotel.MaintainHotelMessage;

import vo.HotelVO;

public interface MaintainHotelMessageService {

	/**
	 * @param hotelProvince �Ƶ�ʡ��
	 * @param hotelCity �Ƶ���
	 * @param hotelCBD �Ƶ���Ȧ
	 * @param introduction �Ƶ���
	 * @param facilities �Ƶ���ʩ
	 * @param star �Ƶ��Ǽ�
	 * @param roomTypeAndPrices ��������+"|"+�۸�+"/"+��������+"|"+�۸�
	 * �޸ľƵ�Ļ�����Ϣ
	 * */
	public boolean changeHotelInfo(String hotelProvince,String hotelCity,String hotelCBD,String introduction,String facilities,int star,String roomTypeAndPrices);
	
	/**
	 * @return �õ��޸�ǰ�ľƵ���Ϣ,���ص�HotelVO����Ϊ��
	 * */
	public HotelVO getHotelVO();
}