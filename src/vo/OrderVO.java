package vo;

import java.io.Serializable;

import po.OrderPO;

/**
 * orderID            订单编号
 * clientID           客户编号
 * orderCreatedDate   生成订单时间
 * orderBeginDate     客户入住时间
 * orderEndDate       客户退房时间
 * orderLastDate      订单的最晚执行时间
 * price              订单总价格
 * roomTotal          房间数目
 * roomType           房间类型
 * roomNumber         房间号码
 * peopleNumber       房间对应的入住人数
 * hasChild           有无儿童
 * orderStatus        订单状态
 * withdrawTime       订单撤销时间
 * hotelID            酒店编号
 * hotelProvince      酒店省份
 * hotelCity          酒店市
 * hotelCBD           酒店商圈
 * hotelAddress       酒店详细地址
 * hotelName          酒店名称
 * clientName         客户姓名
 * sex                客户性别
 * identityID         客户身份证号
 * phoneNumber        客户手机号
 * comment            客户对订单的评价
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
	
	/**
	 * 传递OrderPO，酒店省份，酒店市，酒店商圈，酒店详细地址，酒店名称，
	 * 姓名，性别，身份证号，手机号码
	 * */
	public OrderVO(OrderPO po,String hotelProvince,String hotelCity,String hotelCBD,String hotelAddress,String hotelName,String clientName,String sex,String identityID,String phoneNummber){
		
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
		this.peopleNumber = phoneNumber;
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
	
	
}
