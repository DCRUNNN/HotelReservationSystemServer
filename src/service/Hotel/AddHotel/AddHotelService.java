package service.Hotel.AddHotel;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.HotelVO;
import vo.PersonnelVO;

public interface AddHotelService extends Remote{

	/**
	 * @param HotelPO
	 * ��ס����˳��һ��Ҫ������һ��hotel���������Ӷ�Ӧ��hotelworker
	 * @return ��ӳɹ��Ļ������ؾƵ��ţ����ɹ��Ļ�������""
	 * */
	public String addHotel(HotelVO vo)throws RemoteException;
	
	/**
	 * @param vo
	 * @return �����ݲ����һ���־û�����PersonnelPO,�ɹ��Ļ�����true������false
	 * */
	public boolean addHotelWorker(PersonnelVO vo)throws RemoteException;
	
	/**
	 * @param personnelID ������Ա���
	 * @param password ����
	 * @return ���ر��������Ƿ�ɹ�
	 * */
	public boolean savePassword(String personnelID,String password)throws RemoteException;
	
	/**
	 * @param vo �Ƶ���Ϣ
	 * @return ���ݾƵ�ʡ�ݣ��Ƶ������У��Ƶ�������Ȧ���Ƶ���ϸ��ַ�;Ƶ��������жϾƵ��Ƿ��Ѿ�����
	 * */
	public boolean isExist(HotelVO vo)throws RemoteException;
}
