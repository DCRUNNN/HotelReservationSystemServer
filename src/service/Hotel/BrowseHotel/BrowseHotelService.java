package service.Hotel.BrowseHotel;

import java.util.List;

import vo.HotelVO;
import vo.OrderVO;

public interface BrowseHotelService {

	/**
	 * @return �õ����ݿ���������оƵ��ʡ��(ʡ��1+"/"+ʡ��2)
	 * */
	public String getProvinces();
	
	/**
	 * @param �Ƶ�����ʡ��
	 * @return �õ����ݿ���������ض�ʡ�ݵľƵ����(��1+"/"+��2)
	 * */
	public String getCities(String hotelProvince);
	
	/**
	 * @param hotelProvince �Ƶ�ʡ��,hotelCity �Ƶ�������
	 * @return ���ݾƵ����ڵ�ʡ�ݺ;Ƶ����ڵ��У����ظõ����ڵ�������Ȧ(��Ȧ1+"/"+��Ȧ2)
	 * */
	public String getCBDS(String hotelProvince,String hotelCity);
	
	/**
	 * @param hotelProvince �Ƶ�ʡ�� hotelCity �Ƶ������� hotelCBD �Ƶ����ڵ���Ȧ
	 * @return ��������ľƵ��ַ�;Ƶ���Ȧ������һ���õ�ַ����Ȧ�ڵ����оƵ��HotelVO�б�Ĭ���ǰ�������˳��Ӹߵ��׷��ص�
	 * */
	public List<HotelVO> getAllHotels(String hotelProvince,String hotelCity,String hotelCBD);
	
	/**
	 * @param hotelID
	 * @return ���������hotelID������һ��HotelVO
	 * */
	public HotelVO getHotelVO(String hotelID);
	
	/**
	 * @param hotelID
	 * @return ���ݾƵ��ID����ÿͻ��ڸþƵ�����ж���
	 * */
	public List<OrderVO> getAllOrders(String hotelID);
	
	/**
	 * @return ��Ҫע�����ֻ���ڵ���getAllHotels����֮����ܵ�����Щ����
	 * ���Ǽ��Ӵ�С��˳����ʾ�Ƶ���Ϣ
	 * */
	public List<HotelVO> showHotelByStar();
	
	/**
	 * @return ���ۺ�����˳����ʾ�Ƶ���Ϣ
	 * */
	public List<HotelVO> showHotelByPoint();
	
	/**
	 * @return ���Ƶ���ͼ۸���ʾ�Ƶ���Ϣ
	 * */
	public  List<HotelVO> showHotelByPrice();
	
	/**
	 * @return ��������Ԥ�����ľƵ��б�
	 * */
	public List<HotelVO> showHotelOrdered();
}
