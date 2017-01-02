package service.Hotel.MyHotel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.HotelVO;

public interface MyHotelService extends Remote{
	
	/**
	 * @return ������ִ�еľƵ��HotelVO,��Ҫע�ⷵ��ֵ����Ϊ��
	 * */
	public List<HotelVO> getExecutedHotels(String clientID) throws RemoteException;
	
	/**
	 * @return ����δִ�еľƵ��HotelVO,����ֵ����Ϊ��
	 * */
	public List<HotelVO> getUnexecutedHotels(String clientID) throws RemoteException;
	
	/**
	 * @return �����ѳ����ľƵ��HotelVO������ֵ����Ϊ��
	 * */
	public List<HotelVO> getWithdrawnHotels(String clientID) throws RemoteException;
	
	/**
	 * @return �����쳣�ľƵ��HotelVO������ֵ����Ϊ��
	 * */
	public List<HotelVO> getAbnormalHotels(String clientID) throws RemoteException;
	
	/**
	 * @param clientID �ͻ����
	 * @param hotelID ѡ�õľƵ���
	 * @return ����hotelID ����һ��HotelVO
	 * */
	public HotelVO getHotelVO(String clientID,String hotelID) throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @return ���ؾƵ�ͼƬ
	 * */
	public byte[] getHotelPicture(String hotelID)throws RemoteException;
}
