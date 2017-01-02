package service.Hotel.BrowseHotel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.HotelVO;
import vo.OrderVO;

public interface BrowseHotelService extends Remote{

	/**
	 * @return �õ����ݿ���������оƵ��ʡ��(ʡ��1+"/"+ʡ��2)
	 * */
	public String getProvinces()throws RemoteException;
	
	/**
	 * @param �Ƶ�����ʡ��
	 * @return �õ����ݿ���������ض�ʡ�ݵľƵ����(��1+"/"+��2)
	 * */
	public String getCities(String hotelProvince)throws RemoteException;
	
	/**
	 * @param hotelProvince �Ƶ�ʡ��,hotelCity �Ƶ�������
	 * @return ���ݾƵ����ڵ�ʡ�ݺ;Ƶ����ڵ��У����ظõ����ڵ�������Ȧ(��Ȧ1+"/"+��Ȧ2)
	 * */
	public String getCBDS(String hotelProvince,String hotelCity)throws RemoteException;
	
	/**
	 * @param hotelProvince �Ƶ�ʡ�� hotelCity �Ƶ������� hotelCBD �Ƶ����ڵ���Ȧ
	 * @return ��������ľƵ��ַ�;Ƶ���Ȧ������һ���õ�ַ����Ȧ�ڵ����оƵ��HotelVO�б�Ĭ���ǰ�������˳��Ӹߵ��׷��ص�
	 * */
	public List<HotelVO> getAllHotels(String clientID,String hotelProvince,String hotelCity,String hotelCBD)throws RemoteException;
	
	/**
	 * @param hotelID
	 * @return ���������hotelID������һ��HotelVO
	 * */
	public HotelVO getHotelVO(String clientID,String hotelID)throws RemoteException;
	
	/**
	 * @param hotelID
	 * @return ���ݾƵ��ID����ÿͻ��ڸþƵ�����ж���
	 * */
	public List<OrderVO> getAllOrders(String clientID,String hotelID)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @return �õ��Ƶ��ͼƬ������null���û�оƵ��ͼƬ
	 * */
	public byte[] getHotelPicture(String hotelID) throws RemoteException;
}
