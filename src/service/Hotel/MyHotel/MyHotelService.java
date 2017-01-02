package service.Hotel.MyHotel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.HotelVO;

public interface MyHotelService extends Remote{
	
	/**
	 * @return 返回已执行的酒店的HotelVO,需要注意返回值可能为空
	 * */
	public List<HotelVO> getExecutedHotels(String clientID) throws RemoteException;
	
	/**
	 * @return 返回未执行的酒店的HotelVO,返回值可能为空
	 * */
	public List<HotelVO> getUnexecutedHotels(String clientID) throws RemoteException;
	
	/**
	 * @return 返回已撤销的酒店的HotelVO，返回值可能为空
	 * */
	public List<HotelVO> getWithdrawnHotels(String clientID) throws RemoteException;
	
	/**
	 * @return 返回异常的酒店的HotelVO，返回值可能为空
	 * */
	public List<HotelVO> getAbnormalHotels(String clientID) throws RemoteException;
	
	/**
	 * @param clientID 客户编号
	 * @param hotelID 选好的酒店编号
	 * @return 根据hotelID 返回一个HotelVO
	 * */
	public HotelVO getHotelVO(String clientID,String hotelID) throws RemoteException;
	
	/**
	 * @param hotelID 酒店编号
	 * @return 返回酒店图片
	 * */
	public byte[] getHotelPicture(String hotelID)throws RemoteException;
}
