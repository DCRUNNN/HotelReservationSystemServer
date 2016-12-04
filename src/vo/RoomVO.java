package vo;

import java.io.Serializable;

import po.RoomPO;

/**
 * hotelID            房间所属的酒店名称
 * roomType           房间类型
 * price              房间的基础价格
 * roomState          房间状态（“空闲”，“已入住”，“已预订”）
 * bookDate           房间被预订时间(只有已预订状态的房间才能设置时间)
 * roomNumber         房间号码
 * roomIntroduction   房间简介
 * */

public class RoomVO implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6202517090083043103L;

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
