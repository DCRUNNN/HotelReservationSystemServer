package data.datahelper;

/**
 * @author Cong Deng
 */
import java.util.List;

import po.HotelPO;

public interface HotelDataHelper {
	
	public String getCBDS(String hotelProvince, String hotelCity);

	public HotelPO getHotelPO(String hotelID);

	public List<HotelPO> getAllHotel(String hotelProvince, String hotelCity, String hotelCBD);

	public boolean change(HotelPO po);

	public boolean insert(HotelPO po);

	public String getProvinces();

	public String getCities(String hotelProvince);
	
	public List<String> getAllIds();

	public boolean isExist(String hotelProvince, String hotelCity, String hotelCBD, String hotelAddress,
			String hotelName);

}
