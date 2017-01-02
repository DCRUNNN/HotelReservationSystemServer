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
	 * @param telephone 酒店联系方式
	 * 修改酒店的基本信息
	 * */
	public boolean changeHotelInfo(String hotelID,String hotelProvince,String hotelCity,String hotelCBD,String hotelAddress,String hotelName,String introduction,String facilities,int star,String roomTypeAndPrices,String telephone)throws RemoteException;
	
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
	
	/**
	 * 新增酒店房间类型
	 * @param hotelID 酒店编号
	 * @param roomType 房间类型
	 * @param price 价格
	 * @return 返回是否添加成功
	 * */
	public boolean addRoomTypeAndPrice(String hotelID,String roomType,double price) throws RemoteException;

	/**
	 * 改变某一种房间类型的价格
	 * @param hotelID 酒店编号
	 * @param roomType 房间类型
	 * @param price 新的价格
	 * */
    public boolean changeRoomPrice (String hotelID,String roomType,double price) throws RemoteException;
    
    /**
     * @param hotelID 酒店编号
     * @return 得到酒店的已有图片,返回null当不存在图片
     * */
    public byte[] getHotelPicture(String hotelID) throws RemoteException;
    
    /**
     * @param b 酒店图片的byte数组
     * @param hotelID 酒店编号
     * @return 返回是否添加成功,成功返回true，失败返回false
     * */
    public boolean uploadHotelPicture(byte[] b,String hotelID)throws RemoteException;
    
    /**
     * @param b 酒店图片的byte数组
     * @param hotelID 酒店编号
     * @return 返回是否添加成功，成功返回true，失败返回false
     * */
    public boolean changeHotelPicture(byte[] b,String hotelID)throws RemoteException;
}
