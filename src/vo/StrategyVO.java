package vo;

import po.StrategyPO;

/**
 * strategyID            ���Ա��
 * name                  ��������
 * introduction          ���Լ��
 * beginTime             ��ʼʱ��
 * endTime               ����ʱ��
 * userType              ��Ӧ���û�������(��ͨ�û���vip_1,vip_2,vip_3,vip_4,vip_5,��ҵ��Ա)
 * hotelProvince         �Ƶ����ڵ�ʡ��
 * hotelCity             �Ƶ����ڵĳ���
 * hotelCBD              ָ���ľƵ���Ȧ
 * isToBirthday          �Ƿ�����Ի�Ա������
 * strategyType          �������ͣ���վӪ�����ԣ��Ƶ�Ӫ�����ԣ�
 * hotelID               �Ƶ�ID
 * roomTotal             �������Եķ�����Ŀ
 * companyAddress        ���Զ�Ӧ����ҵ��ϸ��ַ
 * discount              ���Ե��ۿ�           
 * */

public class StrategyVO {

	private String strategyID;
	private String name;
	private String introduction;
	private String beginTime;
	private String endTime;
	private String userType;
	private String hotelProvince;
	private String hotelCity;
	private String hotelCBD;
	private boolean isToBirthday;
	private double strategy_discount;
	private String hotelID;
	private int roomTotal;
	private String companyAddress;
	private String strategyType;
	
	public StrategyVO(StrategyPO po){
		
		this.strategyID = po.getStrategyID();
		this.name = po.getName();
		this.introduction = po.getIntroductuion();
		this.beginTime = po.getBeginTime();
		this.endTime = po.getEndTime();
		this.userType = po.getUserType();
		this.hotelProvince = po.getHotelProvince();
		this.hotelCity = po.getHotelCity();
		this.hotelCBD = po.getHotelCBD();
		this.isToBirthday = po.isToBirthday();
		this.strategy_discount = po.getDiscount();
		this.hotelID = po.getHotelID();
		this.roomTotal = po.getRoomTotal();
		this.companyAddress = po.getCompanyAddress();
		this.strategyType = po.getStrategyType();
	}
	
	public StrategyVO(String strategyID,String name, String introduction, String beginTime, String endTime, String userType,
			String hotelProvince,String hotelCity, String hotelCBD, boolean isToBirthday, String strategyType,String hotelID,int roomTotal,String companyAddress,double strategy_discount 
			) {
		
		this.strategyID = strategyID;
		this.name = name;
		this.introduction = introduction;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.userType = userType;
		this.hotelProvince = hotelProvince;
		this.hotelCity = hotelCity;
		this.hotelCBD = hotelCBD;
		this.isToBirthday = isToBirthday;
		this.strategy_discount = strategy_discount;
		this.hotelID = hotelID;
		this.roomTotal = roomTotal;
		this.companyAddress = companyAddress;
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

	public String getHotelProvince() {
		return hotelProvince;
	}

	public String getHotelCity(){
		return hotelCity;
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

	public void setHotelProvince(String hotelProvince){
		this.hotelProvince = hotelProvince;
	}

	public void setHotelCity(String hotelCity){
		this.hotelCity = hotelCity;
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
    
	public void setCompanyAddress(String companyAddress){
		this.companyAddress = companyAddress;
	}
	
	public String getCompanyAddress(){
		return companyAddress;
	}
}
