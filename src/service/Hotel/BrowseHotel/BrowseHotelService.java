package service.Hotel.BrowseHotel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.HotelVO;
import vo.OrderVO;

public interface BrowseHotelService extends Remote{

	/**
	 * @return 得到数据库里面的所有酒店的省份(省份1+"/"+省份2)
	 * */
	public String getProvinces()throws RemoteException;
	
	/**
	 * @param 酒店所在省份
	 * @return 得到数据库里面的在特定省份的酒店的市(市1+"/"+市2)
	 * */
	public String getCities(String hotelProvince)throws RemoteException;
	
	/**
	 * @param hotelProvince 酒店省份,hotelCity 酒店所在市
	 * @return 根据酒店所在的省份和酒店所在的市，返回该地区内的所有商圈(商圈1+"/"+商圈2)
	 * */
	public String getCBDS(String hotelProvince,String hotelCity)throws RemoteException;
	
	/**
	 * @param hotelProvince 酒店省份 hotelCity 酒店所在市 hotelCBD 酒店所在的商圈
	 * @return 根据输入的酒店地址和酒店商圈，返回一个该地址该商圈内的所有酒店的HotelVO列表，默认是按照评分顺序从高到底返回的
	 * */
	public List<HotelVO> getAllHotels(String clientID,String hotelProvince,String hotelCity,String hotelCBD)throws RemoteException;
	
	/**
	 * @param hotelID
	 * @return 根据输入的hotelID，返回一个HotelVO
	 * */
	public HotelVO getHotelVO(String clientID,String hotelID)throws RemoteException;
	
	/**
	 * @param hotelID
	 * @return 根据酒店的ID，获得客户在该酒店的所有订单
	 * */
	public List<OrderVO> getAllOrders(String clientID,String hotelID)throws RemoteException;
	
	
}
