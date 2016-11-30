package po;

/**
 * hotelID            房间所属的酒店名称
 * roomType           房间类型
 * price              房间的基础价格
 * roomState          房间状态（“空闲”，“已预订”，“已入住”）
 * bookDate           房间被预订时间
 * roomNumber         房间号码
 * roomIntroduction   房间简介
 * */
public class RoomPO {

	private String hotelID;
	
	private String roomType;
	
	private double price;
	
	private String roomState;
	
	private String bookDate;
	
	private String roomNumber;
	
	private String roomIntroduction;
	
	public String getBookDate(){
		return bookDate;
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

	public String getRoomNumber() {
		return roomNumber;
	}

	public String getRoomIntroduction() {
		return roomIntroduction;
	}
	
	public void setBookDate(String bookDate){
		this.bookDate = bookDate;
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

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setRoomIntroduction(String roomIntroduction) {
		this.roomIntroduction = roomIntroduction;
	}
	
	
}
