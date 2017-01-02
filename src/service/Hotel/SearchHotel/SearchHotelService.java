package service.Hotel.SearchHotel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.HotelVO;
import vo.OrderVO;
import vo.SearchVO;

public interface SearchHotelService extends Remote{

	/**
	 * @return �õ������оƵ��ʡ��
	 * */
	public String getAllProvinces ()throws RemoteException;
	
	/**
	 * @param hotelProvince �Ƶ����ڵ�ʡ��
	 * @return �õ���ʡ�ݵ������оƵ���� ��1+"/"+��2
	 * */
	public String getCities(String hotelProvince)throws RemoteException;
	
	/**
	 * @param hotelProvince �Ƶ�ʡ��
	 * @param hotelCity �Ƶ���
	 * @return �����ض���ַ��������Ȧ����Ȧ1+"/"+��Ȧ2��
	 * */
	public String getCBDS(String hotelProvince,String hotelCity)throws RemoteException;
	
	/**
	 * @param clientID
	 * @param hotelID
	 * @return ���ݾƵ�id ����һ��HotelVO,���صĿ���Ϊ��
	 * */
	public HotelVO getHotelVO(String clientID,String hotelID)throws RemoteException;
	
	/**
	 * @param SearchVO
	 * @return ���������������� ����������HotelVO�б� ���ؿ���Ϊ��
	 * */
	public List<HotelVO> search(SearchVO vo)throws RemoteException;
	
	/**
	 * @param clientID
	 * @param hotelID
	 * @return ���ؿͻ���ĳ���Ƶ��������ʷ�����б� ���ؿ���Ϊ��
	 * */
	public List<OrderVO> getAllOrders(String clientID,String hotelID)throws RemoteException;
	
	/**
	 * @param clientID �ͻ����
	 * @param hotelProvince �Ƶ����ڵ�ʡ��
	 * @param hotelCities �Ƶ����ڵ���
	 * @param hotelCBD �Ƶ����ڵ���Ȧ
	 * @return ��Ӧ���ǿͻ�ѡ��þƵ���Ȧ֮�� ��impl���ṩhotelCBD�������Ӧ�ĳ�ʼ������������ȷ����ť���¼�
	 * */
	public void initAllHotel(String clientID,String hotelProvince,String hotelCities,String hotelCBD)throws RemoteException;

	/**
	 * @param hotelID �Ƶ���
	 * @return ���ؾƵ��ͼƬ������null��û��ͼƬ
	 * */
	public byte[] getHotelPicture(String hotelID)throws RemoteException;
}
