package service.Client.ApplyForVip;

import vo.ClientVO;

/**
 * 对应申请会员用例的接口
 * */
public interface ApplyForVipService {

	/**
	 * @param clientId 客户编号
	 * @return 在客户已经是会员的时候,可以显示客户的详细信息
	 * */
	public ClientVO getClientVO(String clientID);

	/**
	 * @param clientID 客户编号
	 * @param birthday 客户生日 输入格式为(yyyy-MM-dd)
	 * @return 申请普通会员
	 * */
	public boolean applyNormalVip(String clientID,String birthday);
	
	/**
	 * @param clientID 客户编号,companyAddress 企业地址(省份+“/”+市+“/”+详细地址),companyName 企业名称
	 * @return 申请企业会员
	 * */
    public boolean applyBusinessVip(String clientID,String companyAddress,String companyName);
    
    /**
     * @param clientID 客户编号
     * @return 判断客户是不是普通会员
     * */
    public boolean checkNormalVip(String clientID);
    
    /**
     * @param clientID 客户编号
     * @return 判断客户是不是企业会员
     * */
    public boolean checkBusinessVip(String clientID);
}
