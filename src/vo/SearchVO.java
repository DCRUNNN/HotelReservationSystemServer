package vo;

import java.io.Serializable;

/**
 * hotelName          酒店名称
 * roomType           房间类型
 * roomTatal          房间数目
 * minprice           最低价格
 * maxprice           最高价格
 * orderBeginDate     计划入住时间
 * minstar            最低星级
 * maxstar            最高星级
 * minpoint           最低评分
 * maxpoint           最高评分
 * hasOrdered         是否曾经预订
 * */
public class SearchVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2778105593297895677L;

	private String hotelName;
	
	private String roomType;
	
	private int roomTotal;
	
	private double minprice;
	
	private double maxprice;
	
	private String orderBeginDate;
	
	private int minstar;
	
	private int maxstar;
	
	private double minpoint;
	
	private double maxpoint;
	
	private boolean hasOrdered;
	
    public SearchVO(String hotelName,String roomType,int roomTotal,double minprice,double maxprice,String begin,int minstar,int maxstar,double minpoint,double maxpoint,boolean hasOrdered){
    	
    	this.hotelName = hotelName;
    	this.roomType = roomType;
    	this.roomTotal = roomTotal;
    	this.minprice = minprice;
    	this.maxprice = maxprice;
    	this.orderBeginDate = begin;
    	this.minstar = minstar;
    	this.maxstar = maxstar;
    	this.maxpoint = maxpoint;
    	this.minpoint = minpoint;
    	this.hasOrdered = hasOrdered;
    }

	public String getHotelName() {
		return hotelName;
	}

	public String getRoomType() {
		return roomType;
	}

	public int getRoomTotal() {
		return roomTotal;
	}

	public double getMinprice() {
		return minprice;
	}

	public double getMaxprice() {
		return maxprice;
	}

	public String getOrderBeginDate() {
		return orderBeginDate;
	}

	public int getMinstar() {
		return minstar;
	}

	public int getMaxstar() {
		return maxstar;
	}

	public double getMinpoint() {
		return minpoint;
	}

	public double getMaxpoint() {
		return maxpoint;
	}

	public boolean isHasOrdered() {
		return hasOrdered;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setRoomTotal(int roomTotal) {
		this.roomTotal = roomTotal;
	}

	public void setMinprice(double minprice) {
		this.minprice = minprice;
	}

	public void setMaxprice(double maxprice) {
		this.maxprice = maxprice;
	}

	public void setOrderBeginDate(String orderBeginDate) {
		this.orderBeginDate = orderBeginDate;
	}

	public void setMinstar(int minstar) {
		this.minstar = minstar;
	}

	public void setMaxstar(int maxstar) {
		this.maxstar = maxstar;
	}

	public void setMinpoint(double minpoint) {
		this.minpoint = minpoint;
	}

	public void setMaxpoint(double maxpoint) {
		this.maxpoint = maxpoint;
	}

	public void setHasOrdered(boolean hasOrdered) {
		this.hasOrdered = hasOrdered;
	}
    
    
}
