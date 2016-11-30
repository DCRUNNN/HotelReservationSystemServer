package po;

/**
 * orderID             订单编号
 * hotelID             酒店编号
 * clientID            客户编号
 * orderCreatedDate    订单生成时间
 * orderBeginDate      客户入住时间
 * orderEndDate        客户退房时间
 * orderLastDate       订单最晚执行时间
 * price               订单总价格
 * roomTotal           房间数目
 * roomType            房间类型(采用type+"/"+type标准来分隔多个房间信息)
 * roomNumber          房间号码(采用number+"/"+number标准来分隔多个房间信息)
 * peopleNumber        房间对应的入住人数(采用total+"/"+total标准来分隔多个房间信息)
 * hasChild            有无儿童(采用hasChild+"/"+hasChild标准来分隔多个房间信息)
 * orderStatus         订单状态
 * withdrawTime        订单撤销时间
 * comment             客户对订单的评价(comment+"|"+extraComment)
 * @author Xihao Zeng
 * */
public class OrderPO {

	private String orderID;
	
	private String hotelID;
	
	private String clientID;
	
	private String orderCreatedDate;
	
	private String orderBeginDate;
	
	private String orderEndDate;
	
	private String orderLastDate;
	
	private double price;
	
	private String roomType;
	
	private int roomTotal;
	
	private String roomNumber;
	
	private String peopleNumber;
	
	private String hasChild;
	
	private String orderStatus;
	
	private String withdrawTime;

	private String comment;

	public String getWithdrawTime() {
		return withdrawTime;
	}

	public void setWithdrawTime(String withdrawTime) {
		this.withdrawTime = withdrawTime;
	}
	
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getOrderCreatedDate() {
		return orderCreatedDate;
	}

	public void setOrderCreatedDate(String orderCreatedDate) {
		this.orderCreatedDate = orderCreatedDate;
	}

	public String getOrderBeginDate() {
		return orderBeginDate;
	}

	public void setOrderBeginDate(String orderBeginDate) {
		this.orderBeginDate = orderBeginDate;
	}

	public String getOrderEndDate() {
		return orderEndDate;
	}

	public void setOrderEndDate(String orderEndDate) {
		this.orderEndDate = orderEndDate;
	}

	public String getOrderLastDate() {
		return orderLastDate;
	}

	public void setOrderLastDate(String orderLastDate) {
		this.orderLastDate = orderLastDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public int getRoomTotal() {
		return roomTotal;
	}

	public void setRoomTotal(int roomTotal) {
		this.roomTotal = roomTotal;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getPeopleNumber() {
		return peopleNumber;
	}

	public void setPeopleNumber(String peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public String getHasChild() {
		return hasChild;
	}

	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
