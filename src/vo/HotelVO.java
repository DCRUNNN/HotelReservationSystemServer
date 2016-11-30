package vo;

import po.HotelPO;

/**
 * orderCreateDate               订单生成日期
 * orderStatus                   订单状态
 * orderID                       订单编号（可以有多个订单，用orderID1+"/"+orderID2）
 * price                         订单价格
 * hotelID                       酒店ID
 * hotelProvince                 酒店省份
 * hotelCity                     酒店市
 * hotelCBD                      酒店商圈
 * hotelName                     酒店名称
 * hotelStar                     酒店星级
 * introduction                  酒店简介
 * facilities                    酒店设施
 * roomTypeAndPrice              房间类型和价格(type+"|"+price+"/"+type+"|"+price)
 * point_facilities              酒店的设施综合评分
 * point_service                 酒店的服务综合评分
 * point_surroundings            酒店的周围环境综合评分
 * commentList                   酒店的评价列表(clientID+":"+comment+extraComment"/"+clientID+":"+comment+extraComment)
 * commentPeople                 对酒店进行评价的人数
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
	 * orderInfo 一定要保证有四个"/" 
	 * 每个orderinfo包含多个订单信息的话 多个信息之间用"|"隔开 但是hotelID是唯一的
	 * 传递orderInfo，HotelPO 作为参数的构造函数
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

	public String getHotelCity(){
		return hotelCity;
	}
	
	public String getHotelCBD() {
		return hotelCBD;
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

	public void setOrderCreateDate(String orderCreateDate) {
		this.orderCreateDate = orderCreateDate;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public void setHotelProvince(String hotelProvince) {
		this.hotelProvince = hotelProvince;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public void setHotelCBD(String hotelCBD) {
		this.hotelCBD = hotelCBD;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public void setHotelStar(int hotelStar) {
		this.hotelStar = hotelStar;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public void setRoomTypeAndPrice(String roomTypeAndPrice) {
		this.roomTypeAndPrice = roomTypeAndPrice;
	}

	public void setPoint_facilities(double point_facilities) {
		this.point_facilities = point_facilities;
	}

	public void setPoint_service(double point_service) {
		this.point_service = point_service;
	}

	public void setPoint_surroundings(double point_surroundings) {
		this.point_surroundings = point_surroundings;
	}

	public void setCommentList(String commentList) {
		this.commentList = commentList;
	}

	public void setCommentPeople(int commentPeople) {
		this.commentPeople = commentPeople;
	}
	
	
}
