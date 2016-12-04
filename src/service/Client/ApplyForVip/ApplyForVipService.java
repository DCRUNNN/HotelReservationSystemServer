package service.Client.ApplyForVip;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.ClientVO;

/**
 * 对应申请会员用例的接口
 * */
public interface ApplyForVipService extends Remote{

	/**
	 * @param clientId 客户编号
	 * @return 在客户已经是会员的时候,可以显示客户的详细信息
	 * */
	public ClientVO getClientVO(String clientID)  throws RemoteException;

	/**
	 * @param clientID 客户编号
	 * @param birthday 客户生日 输入格式为(MM-dd)
	 * @return 申请普通会员
	 * */
	public boolean applyNormalVip(String clientID,String birthday)throws RemoteException;
	
	/**
	 * @param clientID 客户编号
	 * @param companyAddress 企业详细地址包括酒店的名称
	 * @param hotelID 申请的酒店编号
	 * @return 申请企业会员
	 * */
    public boolean applyBusinessVip(String clientID,String companyAddress,String hotelID)throws RemoteException;
    
    /**
     * @param clientID 客户编号
     * @return 判断客户是不是普通会员
     * */
    public boolean checkNormalVip(String clientID)throws RemoteException;
    
    /**
     * @param clientID 客户编号
     * @return 判断客户是不是企业会员
     * */
    public boolean checkBusinessVip(String clientID)throws RemoteException;
}
