package vo;

import java.util.Vector;

import po.HotelPO;
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
 * hotelID            �Ƶ���
 * hotelProvince      �Ƶ�ʡ��
 * hotelCity          �Ƶ���
 * hotelCBD           �Ƶ���Ȧ
 * hotelName          �Ƶ�����
 * comment            �ͻ��Զ���������
 * */	
	
public class OrderVO extends Vector<String>{

	/**
	 * ����OrderPO,HotelInfo��Ϊ���캯���Ĳ���
	 * */
	public OrderVO(OrderPO orderPO,String hotelInfo){
		
		String hotelArray[] = hotelInfo.split("/");
		this.add(orderPO.getOrderID());
		this.add(orderPO.getClientID());
		this.add(orderPO.getOrderCreatedDate());
		this.add(orderPO.getOrderBeginDate());
		this.add(orderPO.getOrderEndDate());
		this.add(orderPO.getOrderLastDate());
		this.add(String.valueOf(orderPO.getPrice()));
		this.add(String.valueOf(orderPO.getRoomTotal()));
		this.add(orderPO.getRoomType());
		this.add(orderPO.getRoomNumber());
		this.add(orderPO.getPeopleNumber());
		this.add(orderPO.getHasChild());
		this.add(orderPO.getOrderStatus());
		this.add(orderPO.getWithdrawTime());
		this.add(hotelArray[0]);
		this.add(hotelArray[1]);
		this.add(hotelArray[2]);
		this.add(hotelArray[3]);
		this.add(hotelArray[4]);
		this.add(orderPO.getComment());
	}
	
	/**
	 * ����OrderVO��Ҫ�Ĳ����Ĺ��캯��
	 * */
	public OrderVO(String orderID,String clientID,String orderCreatedDate,String orderBeginDate,String orderEndDate,
			String orderLastDate,double price,int roomTotal,String roomType,String roomNumber,String peopleNumber,
			String hasChild,String orderStatus,String withdrawTime,String hotelID,String hotelAddress,String hotelCBD,String hotelName,String comment){
		
		this.add(orderID);
		this.add(clientID);
		this.add(orderCreatedDate);
		this.add(orderBeginDate);
		this.add(orderEndDate);
		this.add(orderLastDate);
		this.add(String.valueOf(price));
		this.add(String.valueOf(roomTotal));
		this.add(roomType);
		this.add(roomNumber);
		this.add(peopleNumber);
		this.add(hasChild);
		this.add(orderStatus);
		this.add(withdrawTime);
		this.add(hotelID);
		this.add(hotelAddress);
		this.add(hotelCBD);
		this.add(hotelName);
		this.add(comment);
	}
	
	public String getOrderID(){
		return this.get(0);
	}
	
	public String getClientID(){
		return this.get(1);
	}
	
	public String getOrderCreatedDate(){
		return this.get(2);
	}
	
	public String getOrderBeginDate(){
		return this.get(3);
	}
	
	public String getOrderEndDate(){
		return this.get(4);
	}
	
	public String getOrderLastDate(){
		return this.get(5);
	}
	
	public double getPrice(){
		return Double.valueOf(this.get(6));
	}
	
	public int getRoomTotal(){
		return Integer.valueOf(this.get(7));
	}
	
	public String getRoomType(){
		return this.get(8);
	}
	
	public String getRoomNumber(){
		return this.get(9);
	}
	
	public String getPeopleNumber(){
		return this.get(10);
	}
	
	public String getHasChild(){
		return this.get(11);
	}
	
	public String getOrderStatus(){
		return this.get(12);
	}
	
	public String getWithdrawTime(){
		return this.get(13);
	}
	public String getHotelID(){
		return this.get(14);
	}
	
	public String getHotelProvince(){
		return this.get(15);
	}
	
	public String getHotelCity(){
		return this.get(16);
	}
	
	public String getHotelCBD(){
		return this.get(17);
	}
	
	public String getHotelName(){
		return this.get(18);
	}
	
	public String getComment(){
		return this.get(19);
	}
	
	public void setOrderStatus(String status){
		this.setElementAt(status, 12);
	}
	
	public void setWithdrawTime(String withdrawTime){
		this.setElementAt(withdrawTime, 13);
	}
}
