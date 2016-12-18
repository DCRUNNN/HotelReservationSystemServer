package vo;

import java.io.Serializable;

import po.OrderPO;

/**
 * orderID            �������
 * clientID           �ͻ����
 * orderCreatedDate   ���ɶ���ʱ��
 * orderBeginDate     �ͻ���סʱ��
 * orderEndDate       �ͻ��˷�ʱ��
 * orderLastDate      ����������ִ��ʱ��
 * price              �����ܼ۸�
 * roomTotal          ������Ŀ
 * roomType           ��������
 * roomNumber         �������
 * peopleNumber       �����Ӧ����ס����
 * hasChild           ���޶�ͯ
 * orderStatus        ����״̬
 * withdrawTime       ��������ʱ��
 * checkOutTotal      �˷���Ŀ
 * hotelID            �Ƶ���
 * hotelProvince      �Ƶ�ʡ��
 * hotelCity          �Ƶ���
 * hotelCBD           �Ƶ���Ȧ
 * hotelAddress       �Ƶ���ϸ��ַ
 * hotelName          �Ƶ�����
 * clientName         �ͻ�����
 * sex                �ͻ��Ա�
 * identityID         �ͻ����֤��
 * phoneNumber        �ͻ��ֻ���
 * comment            �ͻ��Զ���������
 * */	
	
public class OrderVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5992777685418175892L;
	
	private String orderID;
	private String clientID;
	private String orderCreatedDate;
	private String orderBeginDate;
	private String orderEndDate;
	private String orderLastDate;
	private double price;
	private int roomTotal;
	private String roomType;
	private String roomNumber;
	private String peopleNumber;
	private String hasChild;
	private String orderStatus;
	private String withdrawTime;
	private String comment;
	private String hotelID;
	private String hotelProvince;
	private String hotelCity;
	private String hotelCBD;
	private String hotelAddress;
	private String hotelName;
	private String clientName;
	private String sex;
	private String identityID;
	private String phoneNumber;
	private int checkOutTotal;
	
	private double credit;
	private String vipInfo;
	
	/**
	 * ����OrderPO���Ƶ�ʡ�ݣ��Ƶ��У��Ƶ���Ȧ���Ƶ���ϸ��ַ���Ƶ����ƣ�
	 * �������Ա����֤�ţ��ֻ�����
	 * */
public OrderVO(OrderPO po,String hotelProvince,String hotelCity,String hotelCBD,String hotelAddress,String hotelName,String clientName,String sex,String identityID,String phoneNumber,double credit,String vipInfo){
		
		this.orderID = po.getOrderID();
		this.clientID = po.getClientID();
		this.orderCreatedDate = po.getOrderCreatedDate();
		this.orderBeginDate = po.getOrderBeginDate();
		this.orderEndDate = po.getOrderEndDate();
		this.orderLastDate = po.getOrderLastDate();
		this.price = po.getPrice();
		this.roomTotal = po.getRoomTotal();
		this.roomType = po.getRoomType();
		this.roomNumber = po.getRoomNumber();
		this.peopleNumber = po.getPeopleNumber();
		this.hasChild = po.getHasChild();
		this.orderStatus = po.getOrderStatus();
		this.withdrawTime = po.getWithdrawTime();
		this.checkOutTotal = po.getCheckOutTotal();
		
		this.comment = po.getComment();
		this.hotelID = po.getHotelID();
		this.hotelProvince = hotelProvince;
		this.hotelCity = hotelCity;
		this.hotelCBD = hotelCBD;
		this.hotelAddress = hotelAddress;
		this.hotelName = hotelName;
		
		this.clientName = clientName;
		this.sex = sex;
		this.identityID = identityID;
		this.phoneNumber = phoneNumber;
		this.credit=credit;
		this.vipInfo=vipInfo;
		
	}

	
	
	public String getOrderID() {
		return orderID;
	}
	public String getClientID() {
		return clientID;
	}
	public String getOrderCreatedDate() {
		return orderCreatedDate;
	}
	public String getOrderBeginDate() {
		return orderBeginDate;
	}
	public String getOrderEndDate() {
		return orderEndDate;
	}
	public String getOrderLastDate() {
		return orderLastDate;
	}
	public double getPrice() {
		return price;
	}
	public int getRoomTotal() {
		return roomTotal;
	}
	public String getRoomType() {
		return roomType;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public String getPeopleNumber() {
		return peopleNumber;
	}
	public String getHasChild() {
		return hasChild;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public String getWithdrawTime() {
		return withdrawTime;
	}
	public String getComment() {
		return comment;
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

	public void setOrderStatus(String status){
		this.orderStatus = status;
	}
	
	public void setWithdrawTime(String time){
		this.withdrawTime = time;
	}


	public String getClientName() {
		return clientName;
	}


	public String getSex() {
		return sex;
	}


	public String getIdentityID() {
		return identityID;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public int getCheckOutTotal(){
		return checkOutTotal;
	}
	
	public double getCredit(){
		return credit;
	}
	
	public String getVipInfo(){
		return vipInfo;
	}
}
