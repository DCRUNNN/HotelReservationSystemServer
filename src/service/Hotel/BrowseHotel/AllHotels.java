package service.Hotel.BrowseHotel;

import java.util.ArrayList;
import java.util.List;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import service.Hotel.MyHotel.CreateHotelVO;
import vo.HotelVO;

/**
 * 主要负责与HotelDao进行交互
 * @see HotelDao
 * */
public class AllHotels {

	private String clientID;
	private String hotelProvince;
	private String hotelCity;
	private List<HotelVO> hotelVOList;
	private HotelDao hotelDao;
	
	/**
	 * 参数为clientID的构造函数
	 * */
	public AllHotels(String clientID){
		
		this.clientID = clientID;
		hotelDao = HotelDaoImpl.getInstance();
		
	}
	
	/**
	 * @return 返回特定地址特定商圈内的所有酒店信息
	 * */
	public List<HotelVO> getAllHotels(String hotelCBD){
		
		hotelVOList = new ArrayList<HotelVO>();
		List<HotelPO> polist = hotelDao.getAllHotel(hotelProvince,hotelCity, hotelCBD);
	    for(HotelPO po:polist){
	    	HotelVO vo = new CreateHotelVO().create(clientID,po);
	    	hotelVOList.add(vo);
	    }
	    
	    //默认对酒店列表进行按评分排序排序
	    
		return showByPoint();
	}
	
	/**
	 * @param hotelID
	 * @return 根据hotelID，返回一个HotelVO
	 * */
	public HotelVO getHotelVO(String hotelID){
		
		for(HotelVO vo:hotelVOList){
			if(hotelID.equals(vo.getHotelID())){
				return vo;
			}
		}
		return null;
	}
	
	/**
	 * @param hotelProvince
	 * @param hotelCity 
	 * @return 返回特定地址内的所有商圈（商圈1+"/"+商圈2）
	 * */
	public String getCBDS(String hotelProvince, String hotelCity){
		
		this.hotelProvince = hotelProvince;
		this.hotelCity = hotelCity;
		return hotelDao.getCBDS(hotelProvince,hotelCity);
	}

	/**
	 * 得到所有的省份
	 * */
	public String getProvinces() {
		
		return hotelDao.getProvinces();
	}

	/**
	 * 根据省份得到所有的市
	 * */
	public String getCities(String hotelProvince) {
		
		return hotelDao.getCities(hotelProvince);
	}

	/**
	 * @return 按酒店星级从高到低的顺序进行排列酒店信息
	 * */
	public List<HotelVO> showByStar() {
		
		HotelVO vo1;
		HotelVO vo2;
		int star1;
		int star2;
		for(int i=0;i<hotelVOList.size()-1;i++){
			for(int j=0;j<hotelVOList.size()-1-i;j++){
			    vo1 = hotelVOList.get(j);
			    vo2 = hotelVOList.get(j+1);
			    star1 = vo1.getHotelStar();
			    star2 = vo2.getHotelStar();
			    if(star1<star2){
			    	hotelVOList.set(j, vo2);
			    	hotelVOList.set(j+1, vo1);
			    }
			}
		}
		return hotelVOList;
	}

	/**
	 * @return 根据评分从高到低的顺序对酒店列表进行排序
	 * */
	public List<HotelVO> showByPoint(){
		
		HotelVO vo;
		HotelVO vo2;
		double point;
		double point2;
	    for(int i=0;i<hotelVOList.size()-1;i++){
	    	for(int j=0;j<hotelVOList.size()-1-i;j++){
	    		 vo = hotelVOList.get(j);
	    		 vo2 = hotelVOList.get(j+1);
	    		 point = vo.getPoint_facilities()+vo.getPoint_service()+vo.getPoint_surroundings();
	    		 point2 = vo2.getPoint_facilities()+vo2.getPoint_service()+vo2.getPoint_surroundings();
	    		if(point<point2){
	    			hotelVOList.set(j, vo2);
	    			hotelVOList.set(j+1, vo);//把两个vo进行交换
	    		}
	    	}
	    }
	    
	    return hotelVOList;
	}

	/**
	 * @return 根据酒店最低价格从低到高显示酒店信息
	 * */
	public List<HotelVO> showByprice() {
		
		HotelVO vo1;
		HotelVO vo2;
		double minPrice1;
		double minPrice2;
		String [] typeAndPrice1;
		String [] typeAndPrice2;
		for(int i=0;i<hotelVOList.size()-1;i++){
			for(int j=0;j<hotelVOList.size()-1-i;j++){
				vo1 = hotelVOList.get(j);
				vo2 = hotelVOList.get(j+1);
				typeAndPrice1 = vo1.getRoomTypeAndPrice().split("/");
				minPrice1 = Double.valueOf(typeAndPrice1[0].split("|")[1]);
				for(int k=0;k<typeAndPrice1.length;k++){
					String str = typeAndPrice1[k];
					double price = Double.valueOf(str.split("|")[1]);
					if(price<minPrice1){
						minPrice1 = price;
					}
				}//得到vo1的最低价格
				
				typeAndPrice2 = vo2.getRoomTypeAndPrice().split("/");
				minPrice2 = Double.valueOf(typeAndPrice2[0].split("|")[1]);
				for(int k=0;k<typeAndPrice2.length;k++){
					String str = typeAndPrice2[k];
					double price = Double.valueOf(str.split("|")[1]);
					if(price<minPrice2){
						minPrice2 = price;
					}
				}//得到vo2的最低价格
				
				if(minPrice1>minPrice2){
					hotelVOList.set(j, vo2);
					hotelVOList.set(j+1, vo1);
				}
			}
		}
		return hotelVOList;
	}

	/**
	 * @return 返回历史预订过的酒店信息列表
	 * */
	public List<HotelVO> showHotelOrdered() {
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:hotelVOList){
			String orderID = vo.getOrderID();
			String ids [] = orderID.split("/");
			if(ids.length>=1){
				list.add(vo);
			}//订单id多于一个，就是历史预订过
		}
		return list;
	}
}
