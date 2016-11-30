package vo;

import po.HotelPO;

/**
 * orderCreateDate               ������������
 * orderStatus                   ����״̬
 * orderID                       ������ţ������ж����������orderID1+"/"+orderID2��
 * price                         �����۸�
 * hotelID                       �Ƶ�ID
 * hotelProvince                 �Ƶ�ʡ��
 * hotelCity                     �Ƶ���
 * hotelCBD                      �Ƶ���Ȧ
 * hotelAddress                  �Ƶ���ϸ��ַ
 * hotelName                     �Ƶ�����
 * hotelStar                     �Ƶ��Ǽ�
 * introduction                  �Ƶ���
 * facilities                    �Ƶ���ʩ
 * roomTypeAndPrice              �������ͺͼ۸�(type+"|"+price+"/"+type+"|"+price)
 * point_facilities              �Ƶ����ʩ�ۺ�����
 * point_service                 �Ƶ�ķ����ۺ�����
 * point_surroundings            �Ƶ����Χ�����ۺ�����
 * commentList                   �Ƶ�������б�(clientID+":"+comment+extraComment"/"+clientID+":"+comment+extraComment)
 * commentPeople                 �ԾƵ�������۵�����
 * @author Xihao Zeng
 * */
public class HotelVO {

	private String orderCreateDate;
	
	private String orderStatus;
	
	private String orderID;
	
	private double price;
	
	private String hotelID;
	
	private String hotelProvince;
	
	private String hotelCity;
	
	private String hotelCBD;
	
	private String hotelAddress;
	
	private String hotelName;
	
	private int hotelStar;
	
	private String introduction;
	
	private String facilities;
	
	private String roomTypeAndPrice;
	
	private double point_facilities;
	
	private double point_service;
	
	private double point_surroundings;
	
	private String commentList;
	
	private int commentPeople;
	
	/**
	 * orderInfo һ��Ҫ��֤���ĸ�"/" 
	 * ÿ��orderinfo�������������Ϣ�Ļ� �����Ϣ֮����"|"���� ����hotelID��Ψһ��
	 * ����orderInfo��HotelPO ��Ϊ�����Ĺ��캯��
	 * */
	public HotelVO(String orderInfo,HotelPO po){
		
		String array[] = orderInfo.split("/");
		this.orderCreateDate = array[0];
		this.orderStatus = array[1];
		this.orderID = array[2];
		this.price = Double.valueOf(array[3]);	
	    this.hotelID = po.getHotelID();
	    this.hotelProvince = po.getHotelProvince();
	    this.hotelCity = po.getHotelCity();
	    this.hotelCBD = po.getHotelCBD();
	    this.hotelAddress = po.getHotelAddress();
	    this.hotelName = po.getHotelName();
	    this.hotelStar = po.getHotelStar();
	    this.introduction = po.getIntroduction();
	    this.facilities = po.getFacilities();
	    this.roomTypeAndPrice = po.getRoomTypeAndPrice();
	    this.point_facilities = po.getPoint_facilities();
	    this.point_service = po.getPoint_service();
	    this.point_surroundings = po.getPoint_surroundings();
	    this.commentList = po.getCommentList();
	    this.commentPeople = po.getCommentPeople();
	}

	/**
	 * ���ݾƵ�ʡ�ݣ��Ƶ���У��Ƶ���Ȧ���Ƶ���ϸ��ַ���Ƶ����֣��Ƶ��Ǽ����Ƶ���ܣ��Ƶ���ʩ���Ƶ�ķ������ͺͼ۸���Ϊ���캯���Ĳ���
	 * */
	public HotelVO(String hotelProvince, String hotelCity, String hotelCBD,String hotelAddress, String hotelName, int hotelStar,
			String introduction, String facilities, String roomTypeAndPrice) {
		
		this.hotelProvince = hotelProvince;
		this.hotelCity = hotelCity;
		this.hotelCBD = hotelCBD;
		this.hotelAddress = hotelAddress;
		this.hotelName = hotelName;
		this.hotelStar = hotelStar;
		this.introduction = introduction;
		this.facilities = facilities;
		this.roomTypeAndPrice = roomTypeAndPrice;
	}

	public String getOrderCreateDate() {
		return orderCreateDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public String getOrderID() {
		return orderID;
	}

	public double getPrice() {
		return price;
	}

	public String getHotelID() {
		return hotelID;
	}

	public String getHotelProvince() {
		return hotelProvince;
	}

	public String getHotelCity() {
		return hotelCity;
	}

	public String getHotelCBD() {
		return hotelCBD;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public String getHotelName() {
		return hotelName;
	}

	public int getHotelStar() {
		return hotelStar;
	}

	public String getIntroduction() {
		return introduction;
	}

	public String getFacilities() {
		return facilities;
	}

	public String getRoomTypeAndPrice() {
		return roomTypeAndPrice;
	}

	public double getPoint_facilities() {
		return point_facilities;
	}

	public double getPoint_service() {
		return point_service;
	}

	public double getPoint_surroundings() {
		return point_surroundings;
	}

	public String getCommentList() {
		return commentList;
	}

	public int getCommentPeople() {
		return commentPeople;
	}


	
	
}
