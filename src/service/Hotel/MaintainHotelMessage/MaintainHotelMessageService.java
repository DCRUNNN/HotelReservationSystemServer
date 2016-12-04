package service.Hotel.MaintainHotelMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.HotelVO;

public interface MaintainHotelMessageService extends Remote{

	/**
	 * @param hotelID 酒店编号
	 * @param hotelProvince 酒店省份
	 * @param hotelCity 酒店市
	 * @param hotelCBD 酒店商圈
	 * @param hotelAddress 酒店详细地址
	 * @param hotelName 酒店名称
	 * @param introduction 酒店简介
	 * @param facilities 酒店设施
	 * @param star 酒店星级
	 * @param roomTypeAndPrices 房间类型+"|"+价格+"/"+房间类型+"|"+价格
	 * 修改酒店的基本信息
	 * */
	public boolean changeHotelInfo(String hotelID,String hotelProvince,String hotelCity,String hotelCBD,String hotelAddress,String hotelName,String introduction,String facilities,int star,String roomTypeAndPrices)throws RemoteException;
	
	/**
	 * @param vo 修改后的酒店信息
	 * @return 返回是否修改成功
	 * */
	public boolean changeHotelInfo(String hotelID,HotelVO vo)throws RemoteException;
	
	/**
	 * @param hotelID 酒店编号
	 * @return 得到修改前的酒店信息,返回的HotelVO可能为空
	 * */
	public HotelVO getHotelVO(String hotelID)throws RemoteException;
	
	/**
	 * @param hotelID 酒店编号
	 * @param companyAddress 合作企业的详细地址
	 * @return 返回是否添加成功
	 * */
	public boolean addCompany(String hotelID,String companyAddress)throws RemoteException;
	
	/**
	 * @param hotelID 酒店编号
	 * @param companyAddress 合作企业的详细地址
	 * @return 返回是否删除成功
	 * */
	public boolean deleteCompany(String hotelID,String companyAddress)throws RemoteException;
}
