package data.dao;

import java.util.List;

import po.ClientPO;

public interface ClientDAO {
	
	/**
	 * @param client_id 客户编号
	 * @return 得到客户的持久化对象
	 * */
	public ClientPO getClientPO(String client_id);


	/**
	 * @param clientID 客户编号
	 * @return 完成得到客户的当前信用点
	 * */
	public double getClientPoint(String clientID);

	/**
	 * @param clientID 客户编号
	 * @param vip等级
	 * @return 完成设置客户的vip等级
	 * */
	public boolean setVipGrade(String clientID, int grade);

	/**
	 * @param clientID 客户编号
	 * @param left 扣除之后的剩余信用点
	 * @return 返回扣除信用点是否成功
	 * */
	public boolean subClientCreditPoint(String clientID, double left);

	/**
	 * @param clientID 客户编号
	 * @param left 增加之后的信用点
	 * @return 返回增加信用点是否成功
	 * */
	public boolean addClientCreditPoint(String clientID, double left);

	/**
	 * @param clientID
	 * @return 得到客户的用户类型
	 * */
	public String getUserType(String clientID);

	/**
	 * @param 客户的持久化对象
	 * @return 返回是否成功改变客户的信息
	 * */
	public boolean change(ClientPO po);

	/**
	 * @return 得到所有的客户信息
	 * */
	public List<ClientPO> getAllClient();

	/**
	 * @return 得到所有的客户编号
	 * */
	public List<String> getAllIds();


	/**
	 * @param 客户信息
	 * @return 新添客户信息
	 * */
	public boolean insert(ClientPO po);

    /**
     * @param phoneNumber 手机号码
     * @return 存在返回true，不存在返回false
     * */
	public boolean isExistPhoneNumber(String phoneNumber);
}
