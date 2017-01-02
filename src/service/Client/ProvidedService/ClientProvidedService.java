package service.Client.ProvidedService;

import vo.ClientVO;

public interface ClientProvidedService {

	/**
	 * @param  客户编号,要扣除的信用点
	 * @return 完成扣除客户的信用点
	 * */
	public boolean subClientCreditPoint(String clientID,double point);
	
	/**
	 * @param 客户编号，要增加的信用点
	 * @return 完成增加客户的信用点
	 * */
	public boolean addClientCreditPoint(String clientID,double point);
	
	/**
	 * @param 客户编号
	 * @return 返回客户类型
	 * */
	public String getUserType(String clientID);

	/**
	 * @param 客户编号
	 * @return 信用值大于0返回true，信用值小于0返回false
	 * */
	public boolean checkCreditPoint(String clientID);
	
	/**
	 * @param clientID 客户编号啊
	 * @return 得到客户的剩余信用点
	 * */
	public double getCreditPoint(String clientID);

	/**
	 * @param clientID 客户编号
	 * @return 得到客户的生日
	 * */
	public String getVipBirthday(String clientID);

	/**
	 * @param clientID 客户编号
	 * @return 得到客户的vip等级
	 * */
	public int getVipGrade(String clientID);

	/**
	 * @param clientID 客户编号
	 * @return 得到企业会员对应的企业详细地址 如果clientID错误的话返回""
	 * */
	public String getCompanyAddress(String clientID);
	
	/**
	 * @param clientID 客户编号
	 * @return 得到企业会员所有的合作酒店的编号 如果clientID错误的话返回""
	 * */
	public String getHotelIDs(String clientID);

	/**
	 * @param clientID 客户编号
	 * @param hotelID 酒店编号
	 * @return 企业会员的对应酒店包括hotelID的话，返回true，否则就是false
	 * */
	public boolean isCorrectCompanyVip(String clientID, String hotelID);

	/**
	 * @param clientID 客户编号
	 * @return 返回客户的姓名
	 * */
	public String getClientName(String clientID);
	
	/**
	 * @return 返回客户的性别
	 * */
	public String getSex(String clientID);
	
	/**
	 * @return 返回客户的身份证号
	 * */
	public String getIdentityID(String clientID);
	
	/**
	 * @return 返回客户的手机号码
	 * */
	public String getPhoneNumber(String clientID);
	
	/**
	 * @param clientID 客户编号
	 * @return 返回客户的vip信息
	 * */
	public String getVIPInfo(String clientID);
	
	/**
	 * @param clientID 客户编号
	 * @return 返回客户的信用点
	 * */
	public double getCredit(String clientID);

	/**
	 * @param clientID 客户编号
	 * @return 返回客户信息
	 * */
	public ClientVO getClientVO(String clientID);

	/**
	 * @param clientID 客户编号
	 * @return 判断id是否存在
	 * */
	public boolean checkID(String clientID);
}
