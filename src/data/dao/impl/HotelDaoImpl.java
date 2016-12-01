package data.dao.impl;

/**
 * @author Cong Deng
 */
import java.util.List;

import data.dao.HotelDao;
import data.datahelper.DataFactory;
import data.datahelper.HotelDataHelper;
import data.datahelper.impl.DataFactoryImpl;
import po.HotelPO;

public class HotelDaoImpl implements HotelDao {
	
	private HotelDataHelper hotelDataHelper;
	
	private DataFactory dataFactory;
	
	private static final HotelDaoImpl INSTANCE=new HotelDaoImpl();
	
	//���õ���ģʽ ������ص�ʱ����ɳ�ʼ��,�������߳�ͬ������
	private HotelDaoImpl() {
	
		 	dataFactory=new DataFactoryImpl();
		 	hotelDataHelper=dataFactory.getHotelDataHelper();
	}
	
	public static HotelDaoImpl getInstance(){
		return INSTANCE;
	} //ͨ������static���������RoomDaoImpl��ʵ��
	
	@Override
	public String getCBDS(String hotelProvince, String hotelCity) {
		
		return hotelDataHelper.getCBDS(hotelProvince, hotelCity);
	}

	@Override
	public HotelPO getHotelPO(String hotelID) {
		
		return hotelDataHelper.getHotelPO(hotelID);
	}

	@Override
	public List<HotelPO> getAllHotel(String hotelProvince, String hotelCity, String hotelCBD) {
	
		return hotelDataHelper.getAllHotel(hotelProvince, hotelCity, hotelCBD);
	}

	@Override
	public boolean change(HotelPO po) {
		
		return hotelDataHelper.change(po);
	}

	@Override
	public boolean insert(HotelPO po) {
		
		return hotelDataHelper.insert(po);
	}

	@Override
	public String getProvinces() {
		
		return hotelDataHelper.getProvinces();
	}

	@Override
	public String getCities(String hotelProvince) {
	
		return hotelDataHelper.getCities(hotelProvince);
	}

	@Override
	public List<String> getAllIds() {
		
		return hotelDataHelper.getAllIds();
	}

	@Override
	public boolean isExist(String hotelProvince, String hotelCity, String hotelCBD, String hotelAddress,
			String hotelName) {
		
		return hotelDataHelper.isExist(hotelProvince,hotelCity,hotelCBD,hotelAddress,hotelName);
	}

}
