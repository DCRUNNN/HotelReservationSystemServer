package service.Order.InteractWithHotel;

public interface HotelProvidedServiceForOrder {

	/**
	 * @param hotelID
	 * @return ����һ��hotelInfo hotelInfo = hotelID+hotelProvince+hotelCity+hotelCBD+hotelName �ָ�����"/"
	 * */
	public String getHotelInfo(String hotelID);
	
	/**
	 * @param hotelID,clientID,���۵����ݣ��ԾƵ���ʩ�����֣��ԾƵ��������֣��ԾƵ��ܱ߻���������
	 * ʵ�ֵ�ʱ���ס����������һ
	 * @return �����Ƿ����۳ɹ�
	 * */
	public boolean addComment(String hotelID,String clientID,String comment,int point_facilities,int point_service,int point_surroundings);
	
	/**
	 * @param hotelID,clientID,׷�ӵ���������
	 * �����Ĳ�����ԭ��������+"|"+׷�ӵ�����
	 * @return �����Ƿ�׷�ӳɹ�
	 * */
	public boolean addComment(String hotelID,String clientID,String comment);
	
	/**
	 * @param �Ƶ���
	 * @return ����һ���Ƶ��������ͺͼ۸���ַ���������+"|"+�۸�+"/"��
	 * */
	public String getRoomTypeAndPrice(String hotelID);
}
