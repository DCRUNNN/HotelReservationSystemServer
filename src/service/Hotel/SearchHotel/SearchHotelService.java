package service.Hotel.SearchHotel;

import java.util.List;

import vo.HotelVO;
import vo.OrderVO;
import vo.SearchVO;

public interface SearchHotelService {

	/**
	 * @return �õ������оƵ��ʡ��
	 * */
	public String getAllProvinces ();
	
	/**
	 * @param hotelProvince �Ƶ����ڵ�ʡ��
	 * @return �õ���ʡ�ݵ������оƵ���� ��1+"/"+��2
	 * */
	public String getCities(String hotelProvince);
	
	/**
	 * @param hotelProvince �Ƶ�ʡ��
	 * @param hotelCity �Ƶ���
	 * @return �����ض���ַ��������Ȧ����Ȧ1+"/"+��Ȧ2��
	 * */
	public String getCBDS(String hotelProvince,String hotelCity);
	
	/**
	 * @param hotelID
	 * @return ���ݾƵ�id ����һ��HotelVO,���صĿ���Ϊ��
	 * */
	public HotelVO getHotelVO(String hotelID);
	
	/**
	 * @param SearchVO
	 * @return ���������������� ����������HotelVO�б� ���ؿ���Ϊ��
	 * */
	public List<HotelVO> search(SearchVO vo);
	
	/**
	 * @param hotelID
	 * @return ���ؿͻ���ĳ���Ƶ��������ʷ�����б� ���ؿ���Ϊ��
	 * */
	public List<OrderVO> getAllOrders(String hotelID);
	
	/**
	 * @param hotelProvince �Ƶ����ڵ�ʡ��
	 * @param hotelCities �Ƶ����ڵ���
	 * @param hotelCBD �Ƶ����ڵ���Ȧ
	 * @return ��Ӧ���ǿͻ�ѡ��þƵ���Ȧ֮�� ��impl���ṩhotelCBD�������Ӧ�ĳ�ʼ������������ȷ����ť���¼�
	 * */
	public void getAllHotels(String hotelProvince,String hotelCities,String hotelCBD);
}
