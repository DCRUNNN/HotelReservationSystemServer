package service.Hotel.MyHotel;

import java.util.List;

import vo.HotelVO;

public interface MyHotelService {

	/**
	 * @return ������ִ�еľƵ��HotelVO,��Ҫע�ⷵ��ֵ����Ϊ��
	 * */
	public List<HotelVO> getExecutedHotels();
	
	/**
	 * @return ����δִ�еľƵ��HotelVO,����ֵ����Ϊ��
	 * */
	public List<HotelVO> getUnexecutedHotels();
	
	/**
	 * @return �����ѳ����ľƵ��HotelVO������ֵ����Ϊ��
	 * */
	public List<HotelVO> getWithdrawnHotels();
	
	/**
	 * @return �����쳣�ľƵ��HotelVO������ֵ����Ϊ��
	 * */
	public List<HotelVO> getAbnormalHotels();
	
	/**
	 * @param hotelID ѡ�õľƵ���
	 * @return ����hotelID ����һ��HotelVO
	 * */
	public HotelVO getHotelVO(String hotelID);
}
