package po;

/**
 * hotelID            ���������ľƵ�����
 * roomType           ��������
 * price              ����Ļ����۸�
 * roomState          ����״̬�������С�������Ԥ������������ס����
 * bookDate           ���䱻Ԥ��ʱ��
 * roomNumber         �������
 * roomIntroduction   ������
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
