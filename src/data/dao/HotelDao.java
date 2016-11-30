package data.dao;

import java.util.List;

import po.HotelPO;

public interface HotelDao {

	/**
	 * @param hotelProvince �Ƶ����ڵ�ʡ�� 
	 * @param hotelCity �Ƶ����ڵ���
	 * @return ��Ȧ1+"/"+��Ȧ2
	 * */
	public String getCBDS(String hotelProvince, String hotelCity);

	/**
	 * @return �õ�hotelPO
	 * */
	public HotelPO getHotelPO(String hotelID);

	/**
	 * @param hotelProvince �Ƶ����ڵ�ʡ��
	 * @param hotelCity �Ƶ����ڵ���
	 * @param hotelCBD �Ƶ����ڵ���Ȧ
	 * @return �õ�����Ȧ�ڵ����еľƵ���Ϣ
	 * */
	public List<HotelPO> getAllHotel(String hotelProvince, String hotelCity, String hotelCBD);

	/**
	 * @param hotelPO
	 * @return �ı����ݿ�ĳ־û�����
	 * */
	public boolean change(HotelPO po);

	/**
	 * @param hotelPO
	 * @return �����µľƵ���Ϣ
	 * */
	public boolean insert(HotelPO po);

	/**
	 * @return �õ����е�ʡ��(ʡ��1+"/"+ʡ��2)
	 * */
	public String getProvinces();

	/**
	 * @param �Ƶ����ڵ�ʡ��
	 * @return �õ�ʡ�ݵ�������(��1+"/"+��2)
	 * */
	public String getCities(String hotelProvince);

	/**
	 * @return �õ����е����еľƵ�id
	 * */
	public List<String> getAllIds();

}
