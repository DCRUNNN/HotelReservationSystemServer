package po;

/**
 * orderID             �������
 * hotelID             �Ƶ���
 * clientID            �ͻ����
 * orderCreatedDate    ��������ʱ��
 * orderBeginDate      �ͻ���סʱ��
 * orderEndDate        �ͻ��˷�ʱ��
 * orderLastDate       ��������ִ��ʱ��
 * price               �����ܼ۸�
 * roomTotal           ������Ŀ
 * roomType            ��������(����type+"/"+type��׼���ָ����������Ϣ)
 * roomNumber          �������(����number+"/"+number��׼���ָ����������Ϣ)
 * peopleNumber        �����Ӧ����ס����(����total+"/"+total��׼���ָ����������Ϣ)
 * hasChild            ���޶�ͯ(����hasChild+"/"+hasChild��׼���ָ����������Ϣ)
 * orderStatus         ����״̬
 * withdrawTime        ��������ʱ��
 * checkOutTotal       �ܹ��˷���Ŀ     
 * comment             �ͻ��Զ���������(comment+"|"+extraComment)
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

	private int checkOutTotal;
	
	private String comment;
	
	public int getCheckOutTotal() {
		return checkOutTotal;
	}

	public void setCheckOutTotal(int checkOutTotal) {
		this.checkOutTotal = checkOutTotal;
	}

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
