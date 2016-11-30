package vo;

import po.RoomPO;

/**
 * hotelID            ���������ľƵ�����
 * roomType           ��������
 * price              ����Ļ����۸�
 * roomState          ����״̬�������С���������ס��������Ԥ������
 * bookDate           ���䱻Ԥ��ʱ��(ֻ����Ԥ��״̬�ķ����������ʱ��)
 * roomNumber         �������
 * roomIntroduction   ������
 * */

public class RoomVO {

    private String hotelID;
	
	private String roomType;
	
	private double price;
	
	private String roomState;
	
	private String bookDate;
	
	private String roomNumber;
	
	private String roomIntroduction;
	
	public RoomVO(RoomPO po){
		
		this.hotelID = po.getHotelID();
		this.roomType = po.getRoomType();
		this.price = po.getPrice();
		this.roomState = po.getRoomState();
		this.bookDate = po.getBookDate();
		this.roomNumber = po.getRoomNumber();
		this.roomIntroduction = po.getRoomIntroduction();
		
	}
	
	public RoomVO(String hotelID,String roomType,double price,String roomState,String bookDate,String roomNumber,String roomIntroduction){
		
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.price = price;
		this.roomState = roomState;
		this.bookDate = bookDate;
		this.roomNumber = roomNumber;
		this.roomIntroduction = roomIntroduction;
		
	}

	public String getHotelID() {
		return hotelID;
	}

	public String getRoomType() {
		return roomType;
	}

	public double getPrice() {
		return price;
	}

	public String getRoomState() {
		return roomState;
	}

	public String getBookDate(){
		return bookDate;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}

	public String getRoomIntroduction() {
		return roomIntroduction;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setRoomState(String roomState) {
		this.roomState = roomState;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setRoomIntroduction(String roomIntroduction) {
		this.roomIntroduction = roomIntroduction;
	}
	
	
}
