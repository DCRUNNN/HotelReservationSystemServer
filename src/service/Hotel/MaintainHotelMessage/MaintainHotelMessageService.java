package service.Hotel.MaintainHotelMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.HotelVO;

public interface MaintainHotelMessageService extends Remote{

	/**
	 * @param hotelID �Ƶ���
	 * @param hotelProvince �Ƶ�ʡ��
	 * @param hotelCity �Ƶ���
	 * @param hotelCBD �Ƶ���Ȧ
	 * @param hotelAddress �Ƶ���ϸ��ַ
	 * @param hotelName �Ƶ�����
	 * @param introduction �Ƶ���
	 * @param facilities �Ƶ���ʩ
	 * @param star �Ƶ��Ǽ�
	 * @param roomTypeAndPrices ��������+"|"+�۸�+"/"+��������+"|"+�۸�
	 * @param telephone �Ƶ���ϵ��ʽ
	 * �޸ľƵ�Ļ�����Ϣ
	 * */
	public boolean changeHotelInfo(String hotelID,String hotelProvince,String hotelCity,String hotelCBD,String hotelAddress,String hotelName,String introduction,String facilities,int star,String roomTypeAndPrices,String telephone)throws RemoteException;
	
	/**
	 * @param vo �޸ĺ�ľƵ���Ϣ
	 * @return �����Ƿ��޸ĳɹ�
	 * */
	public boolean changeHotelInfo(String hotelID,HotelVO vo)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @return �õ��޸�ǰ�ľƵ���Ϣ,���ص�HotelVO����Ϊ��
	 * */
	public HotelVO getHotelVO(String hotelID)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @param companyAddress ������ҵ����ϸ��ַ
	 * @return �����Ƿ���ӳɹ�
	 * */
	public boolean addCompany(String hotelID,String companyAddress)throws RemoteException;
	
	/**
	 * @param hotelID �Ƶ���
	 * @param companyAddress ������ҵ����ϸ��ַ
	 * @return �����Ƿ�ɾ���ɹ�
	 * */
	public boolean deleteCompany(String hotelID,String companyAddress)throws RemoteException;
	
	/**
	 * �����Ƶ귿������
	 * @param hotelID �Ƶ���
	 * @param roomType ��������
	 * @param price �۸�
	 * @return �����Ƿ���ӳɹ�
	 * */
	public boolean addRoomTypeAndPrice(String hotelID,String roomType,double price) throws RemoteException;

	/**
	 * �ı�ĳһ�ַ������͵ļ۸�
	 * @param hotelID �Ƶ���
	 * @param roomType ��������
	 * @param price �µļ۸�
	 * */
    public boolean changeRoomPrice (String hotelID,String roomType,double price) throws RemoteException;
    
    /**
     * @param hotelID �Ƶ���
     * @return �õ��Ƶ������ͼƬ,����null��������ͼƬ
     * */
    public byte[] getHotelPicture(String hotelID) throws RemoteException;
    
    /**
     * @param b �Ƶ�ͼƬ��byte����
     * @param hotelID �Ƶ���
     * @return �����Ƿ���ӳɹ�,�ɹ�����true��ʧ�ܷ���false
     * */
    public boolean uploadHotelPicture(byte[] b,String hotelID)throws RemoteException;
    
    /**
     * @param b �Ƶ�ͼƬ��byte����
     * @param hotelID �Ƶ���
     * @return �����Ƿ���ӳɹ����ɹ�����true��ʧ�ܷ���false
     * */
    public boolean changeHotelPicture(byte[] b,String hotelID)throws RemoteException;
}
