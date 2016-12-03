package po;

/**
 * strategyID            策略编号
 * name                  策略名字
 * introduction          策略简介
 * beginTime             开始时间
 * endTime               结束时间
 * userType              对应的用户的类型(普通用户，vip_1,vip_2,vip_3,vip_4,vip_5,企业会员)
 * hotelProvince         指定的酒店省份
 * hotelCity             指定的酒店市
 * hotelCBD              指定的酒店商圈
 * isToBirthday          是否是针对会员的生日
 * strategyType          策略类型（网站营销策略，酒店营销策略）
 * hotelID               酒店ID
 * roomTotal             触发策略的房间数目
 * companyAddress        公司的详细地址(包括了公司名称例如 广东省茂名市化州商圈化州中学旁星河公司)
 * discount              策略的折扣           
 * */
public class StrategyPO {

	private String strategyID;
	private String name;
	private String introductuion;
	private String beginTime;
	private String endTime;
	private String userType;
	private String hotelProvince;
	private String hotelCity;
	private String hotelCBD;
	private boolean isToBirthday;
	private String strategyType;
	private String hotelID;
	private int roomTotal;
	private String companyAddress;
	private double discount;
	
	public String getCompanyAddress(){
		return companyAddress;
	}
	
	public void setCompanyAddress(String companyAddress){
		this.companyAddress = companyAddress;
	}
	
	public String getStrategyID() {
		return strategyID;
	}
	public void setStrategyID(String strategyID) {
		this.strategyID = strategyID;
	}
	public String getName() {
		return name;
	}
	public String getIntroductuion() {
		return introductuion;
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
	public String getHotelCBD() {
		return hotelCBD;
	}
	public String getStrategyType() {
		return strategyType;
	}
	public String getHotelID() {
		return hotelID;
	}
	public int getRoomTotal() {
		return roomTotal;
	}
	public double getDiscount() {
		return discount;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setIntroductuion(String introductuion) {
		this.introductuion = introductuion;
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
	public void setHotelCBD(String hotelCBD) {
		this.hotelCBD = hotelCBD;
	}
	public void setStrategyType(String strategyType) {
		this.strategyType = strategyType;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public void setRoomTotal(int roomTotal) {
		this.roomTotal = roomTotal;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public boolean isToBirthday() {
		return isToBirthday;
	}
	public void setToBirthday(boolean isToBirthday) {
		this.isToBirthday = isToBirthday;
	}
	public String getHotelProvince() {
		return hotelProvince;
	}
	public String getHotelCity() {
		return hotelCity;
	}
	public void setHotelProvince(String hotelProvince) {
		this.hotelProvince = hotelProvince;
	}
	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	
	
}
