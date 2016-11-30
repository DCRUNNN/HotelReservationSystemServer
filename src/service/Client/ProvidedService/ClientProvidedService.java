package service.Client.ProvidedService;

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
	 * @return 得到企业会员对应的企业地址
	 * */
	public String getCompanyAddress(String clientID);
	
	/**
	 * @param clientID 客户编号
	 * @return 得到企业会员对应的企业名称
	 * */
	public String getCompanyName(String clientID);
}
