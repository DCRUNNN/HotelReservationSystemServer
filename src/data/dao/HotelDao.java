package data.dao;

import java.util.List;

import po.HotelPO;

public interface HotelDao {

	/**
	 * @param hotelProvince 酒店所在的省份 
	 * @param hotelCity 酒店所在的市
	 * @return 商圈1+"/"+商圈2
	 * */
	public String getCBDS(String hotelProvince, String hotelCity);

	/**
	 * @return 得到hotelPO
	 * */
	public HotelPO getHotelPO(String hotelID);

	/**
	 * @param hotelProvince 酒店所在的省份
	 * @param hotelCity 酒店所在的市
	 * @param hotelCBD 酒店所在的商圈
	 * @return 得到该商圈内的所有的酒店信息
	 * */
	public List<HotelPO> getAllHotel(String hotelProvince, String hotelCity, String hotelCBD);

	/**
	 * @param hotelPO
	 * @return 改变数据库的持久化对象
	 * */
	public boolean change(HotelPO po);

	/**
	 * @param hotelPO
	 * @return 插入新的酒店信息
	 * */
	public boolean insert(HotelPO po);

	/**
	 * @return 得到所有的省份(省份1+"/"+省份2)
	 * */
	public String getProvinces();

	/**
	 * @param 酒店所在的省份
	 * @return 得到省份的所有市(市1+"/"+市2)
	 * */
	public String getCities(String hotelProvince);

	/**
	 * @return 得到现有的所有的酒店id
	 * */
	public List<String> getAllIds();

}
