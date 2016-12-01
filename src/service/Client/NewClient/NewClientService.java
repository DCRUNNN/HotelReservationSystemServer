package service.Client.NewClient;

import vo.ClientVO;

public interface NewClientService {

	/**
	 * @param 客户基本信息
	 * @return 注册成功的话返回客户的id，不成功返回"" ，首先输入客户信息看能不能得到编号，得到编号的话继续输入密码
	 * */
	public String insert(ClientVO vo);
	
	/**
	 * @param clientID
	 * @param pass 密码
	 * @return 保存密码
	 * */
	public boolean savePassword(String clientID,String pass);
	
	/**
	 * @param phoneNumber 手机号码
	 * @return 手机号码已经存在的话返回true，否则false
	 * */
	public boolean isExistPhoneNumber(String phoneNumber);
	
}
