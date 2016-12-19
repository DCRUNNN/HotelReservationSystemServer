package vo;

import java.io.Serializable;

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
 * hotelAddress                  酒店详细地址
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
 * company                       酒店的所有合作企业(company1+"/"+company2)
 * telephone                     酒店联系方式
 * @author Xihao Zeng
 * */
public class HotelVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2122926414648553490L;

	private String orderCreateDate;
	
	private String orderStatus;
	
	private String orderID;
	
	private String price;
	
	private String hotelID;
	
	private String hotelProvince;
	
	private String hotelCity;
	
	private String hotelCBD;
	
	private String hotelAddress;
	
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
	
	private String company;
	
	private String telephone;
	
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
		this.price = array[3];	
	    this.hotelID = po.getHotelID();
	    this.hotelProvince = po.getHotelProvince();
	    this.hotelCity = po.getHotelCity();
	    this.hotelCBD = po.getHotelCBD();
	    this.hotelAddress = po.getHotelAddress();
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
	    this.company = po.getCompany();
	    this.telephone = po.getTelephone();
	}

	/**
	 * 传递酒店省份，酒店城市，酒店商圈，酒店详细地址，酒店名字，酒店星级，酒店介绍，酒店设施，酒店的房间类型和价格作为构造函数的参数
	 * */
	public HotelVO(String hotelProvince, String hotelCity, String hotelCBD,String hotelAddress, String hotelName, int hotelStar,
			String introduction, String facilities, String roomTypeAndPrice,String company,String telephone) {
		
		this.hotelProvince = hotelProvince;
		this.hotelCity = hotelCity;
		this.hotelCBD = hotelCBD;
		this.hotelAddress = hotelAddress;
		this.hotelName = hotelName;
		this.hotelStar = hotelStar;
		this.introduction = introduction;
		this.facilities = facilities;
		this.roomTypeAndPrice = roomTypeAndPrice;
		this.company = company;
		this.telephone = telephone;
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

	public String getPrice() {
		return price;
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

    public String getCompany(){
    	return company;
    }
	
    public String getTelephone(){
    	return telephone;
    }
}
