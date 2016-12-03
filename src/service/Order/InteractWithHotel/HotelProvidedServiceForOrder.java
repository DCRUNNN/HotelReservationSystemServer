package service.Order.InteractWithHotel;

public interface HotelProvidedServiceForOrder {
	
	/**
	 * 
	 * @param hotelID �Ƶ���
	 * @param clientID �ͻ����
	 * @param orderID �������
	 * @param comment ����
	 * @param point_facilities ����ʩ������
	 * @param point_service �Է��������
	 * @param point_surroundings ���ܱ߻���������
	 * ʵ�ֵ�ʱ���ס����������һ
	 * @return �����Ƿ����۳ɹ�
	 * */
	public boolean addComment(String hotelID,String clientID,String orderID,String comment, int point_facilities,int point_service,int point_surroundings);
	
	/**
	 * @param hotelID �Ƶ���
	 * @param clientID �ͻ����
	 * @param comment ׷�ӵ�����
	 * �����Ĳ�����ԭ��������+"|"+׷�ӵ�����
	 * @return �����Ƿ�׷�ӳɹ�
	 * */
	public boolean addComment(String hotelID,String orderID,String comment);
	
	/**
	 * @param �Ƶ���
	 * @return ����һ���Ƶ��������ͺͼ۸���ַ���������+"|"+�۸�+"/"��
	 * */
	public String getRoomTypeAndPrice(String hotelID);
	
	/**
	 * @param hotelID �Ƶ���
	 * @return �õ��Ƶ��ʡ��
	 * */
	public String getHotelProvince(String hotelID);
	
	/**
	 * @param hotelID �Ƶ���
	 * @return �õ��Ƶ����ڵ���
	 * */
	public String getHotelCity(String hotelID);
	
	/**
	 * @param hotelID �Ƶ���
	 * @return �õ��Ƶ����ڵ���Ȧ
	 * */
	public String getHotelCBD(String hotelID);
	
	/**
	 * @param hotelID �Ƶ���
	 * @return �õ��Ƶ����ϸ��ַ
	 * */
	public String getHotelAddress(String hotelID);
	
	/**
	 * @param hotelID �Ƶ���
	 * @return �õ��Ƶ������
	 * */
	public String getHotelName(String hotelID);
	
}
