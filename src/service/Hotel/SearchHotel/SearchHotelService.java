package service.Hotel.SearchHotel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.HotelVO;
import vo.OrderVO;
import vo.SearchVO;

public interface SearchHotelService extends Remote{

	/**
	 * @return 得到所有有酒店的省份
	 * */
	public String getAllProvinces ()throws RemoteException;
	
	/**
	 * @param hotelProvince 酒店所在的省份
	 * @return 得到该省份的所有有酒店的市 市1+"/"+市2
	 * */
	public String getCities(String hotelProvince)throws RemoteException;
	
	/**
	 * @param hotelProvince 酒店省份
	 * @param hotelCity 酒店市
	 * @return 返回特定地址的所有商圈（商圈1+"/"+商圈2）
	 * */
	public String getCBDS(String hotelProvince,String hotelCity)throws RemoteException;
	
	/**
	 * @param clientID
	 * @param hotelID
	 * @return 根据酒店id 返回一个HotelVO,返回的可能为空
	 * */
	public HotelVO getHotelVO(String clientID,String hotelID)throws RemoteException;
	
	/**
	 * @param SearchVO
	 * @return 根据搜索条件返回 符合条件的HotelVO列表 返回可能为空
	 * */
	public List<HotelVO> search(SearchVO vo)throws RemoteException;
	
	/**
	 * @param clientID
	 * @param hotelID
	 * @return 返回客户在某个酒店的所有历史订单列表 返回可能为空
	 * */
	public List<OrderVO> getAllOrders(String clientID,String hotelID)throws RemoteException;
	
	/**
	 * @param clientID 客户编号
	 * @param hotelProvince 酒店所在的省份
	 * @param hotelCities 酒店所在的市
	 * @param hotelCBD 酒店所在的商圈
	 * @return 对应的是客户选择好酒店商圈之后 给impl类提供hotelCBD来完成相应的初始化操作，点下确定按钮的事件
	 * */
	public void initAllHotel(String clientID,String hotelProvince,String hotelCities,String hotelCBD)throws RemoteException;
}
