package vo;

import po.StrategyPO;

/**
 * strategyID            策略编号
 * name                  策略名字
 * introduction          策略简介
 * beginTime             开始时间
 * endTime               结束时间
 * userType              对应的用户的类型(普通用户，vip_1,vip_2,vip_3,vip_4,vip_5,企业会员)
 * hotelAddress          指定的酒店地址（省份+"/"+市）
 * hotelCBD              指定的酒店商圈
 * isToBirthday          是否是针对会员的生日
 * strategyType          策略类型（网站营销策略，酒店营销策略）
 * hotelID               酒店ID
 * roomTotal             触发策略的房间数目
 * discount              策略的折扣           
 * */

public class StrategyVO {

	private String strategyID;
	private String name;
	private String introduction;
	private String beginTime;
	private String endTime;
	private String userType;
	private String hotelAddress;
	private String hotelCBD;
	private boolean isToBirthday;
	private double strategy_discount;
	private String hotelID;
	private int roomTotal;
	private String strategyType;
	
	public StrategyVO(StrategyPO po){
		
		this.strategyID = po.getStrategyID();
		this.name = po.getName();
		this.introduction = po.getIntroductuion();
		this.beginTime = po.getBeginTime();
		this.endTime = po.getEndTime();
		this.userType = po.getUserType();
		this.hotelAddress = po.getHotelAddress();
		this.hotelCBD = po.getHotelCBD();
		this.isToBirthday = po.isToBirthday();
		this.strategy_discount = po.getDiscount();
		this.hotelID = po.getHotelID();
		this.roomTotal = po.getRoomTotal();
		this.strategyType = po.getStrategyType();
	}
	
	public StrategyVO(String strategyID,String name, String introduction, String beginTime, String endTime, String userType,
			String hotelAddress, String hotelCBD, boolean isToBirthday, String strategyType,String hotelID,int roomTotal,double strategy_discount 
			) {
		this.strategyID = strategyID;
		this.name = name;
		this.introduction = introduction;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.userType = userType;
		this.hotelAddress = hotelAddress;
		this.hotelCBD = hotelCBD;
		this.isToBirthday = isToBirthday;
		this.strategy_discount = strategy_discount;
		this.hotelID = hotelID;
		this.roomTotal = roomTotal;
		this.strategyType = strategyType;
	}
	
	public String getStrategyID(){
		return strategyID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getIntroduction() {
		return introduction;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getUserType() {
		return userType;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public String getHotelCBD() {
		return hotelCBD;
	}

	public boolean isToBirthday() {
		return isToBirthday;
	}

	public double getStrategy_discount() {
		return strategy_discount;
	}
	
	public String getHotelID() {
		return hotelID;
	}

	public int getRoomTotal() {
		return roomTotal;
	}

	public String getStrategyType() {
		return strategyType;
	}

	public void setStrategyID(String strategyID) {
		this.strategyID = strategyID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public void setHotelCBD(String hotelCBD) {
		this.hotelCBD = hotelCBD;
	}

	public void setToBirthday(boolean isToBirthday) {
		this.isToBirthday = isToBirthday;
	}

	public void setStrategy_discount(double strategy_discount) {
		this.strategy_discount = strategy_discount;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public void setRoomTotal(int roomTotal) {
		this.roomTotal = roomTotal;
	}

	public void setStrategyType(String strategyType) {
		this.strategyType = strategyType;
	}
    	
}
