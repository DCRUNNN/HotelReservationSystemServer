package service.Hotel.SearchHotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.Order.CreateOrder.AllRooms;
import vo.HotelVO;
import vo.RoomVO;
import vo.SearchVO;

/**
 * 负责进行搜索相关的部分
 * @see AllRooms 
 * @see HotelVO
 * @see SearchVO
 * */
public class Search {
	
	private List<HotelVO> allHotels;
	private Map<Double,HotelVO> price = new HashMap<Double,HotelVO>();
	
	public Search(List<HotelVO> allHotels){
		this.allHotels = allHotels;
	}
	
	/**
	 * @param searchvo搜索条件
	 * @return 返回的是适合条件的酒店信息列表;
	 * 传进来的searchvo要满足一些默认条件：房间数目不小于1，最低价格和最高价格不输入的时候为-1，最低星级和最高星级不输入的时候为-1
	 * 最低评分最高评分都在0到100之间 入住时间和退房时间为空的话可以设置为"" 没有选择是否曾经预订的话默认就是false
	 * */
	public List<HotelVO> search(SearchVO searchvo){
		
		List<HotelVO> result;
		
		String hotelName = searchvo.getHotelName();
		result = searchByName(hotelName,allHotels);
		
		String bookDate = searchvo.getOrderBeginDate();///计划入住时间
		String roomType = searchvo.getRoomType();
		int roomTotal = searchvo.getRoomTotal();
		result = searchByRoomType(bookDate,roomType,roomTotal,result);
		
		double minPrice =searchvo.getMinprice();
		double maxPrice = searchvo.getMaxprice();
		result = searchByPrice(minPrice,maxPrice,result);
		
		int minStar = searchvo.getMinstar();
		int maxStar = searchvo.getMaxstar();
		result = searchByStar(minStar,maxStar,result);
		
		double minPoint = searchvo.getMinpoint();
		double maxPoint = searchvo.getMaxpoint();
		result = searchByPoint(minPoint,maxPoint,result);
		
		boolean hasOrdered = searchvo.isHasOrdered();
		result = searchByHasOrdered(hasOrdered,result);
		
		return result;
	}

	/**
	 * @param 酒店名称，要进行筛选的酒店vo
	 * @return 满足酒店名称相等的所有酒店vo
	 * */
	private List<HotelVO> searchByName(String hotelName,List<HotelVO> hotels) {
		
		List<HotelVO> result = new ArrayList<HotelVO>();
		if(!"".equals(hotelName)&&hotelName!=null){
			//hotelName不为空
			for(HotelVO vo:result){
				if(hotelName.equals(vo.getHotelName())){
					result.add(vo);//名称相同的话，就把hotelvo加到result里面
				}
			}
			return result;
		}else{
			//hotelName为空，就是直接拷贝
	        return hotels;
		}
	}

	/**
	 * @param 计划入住时间,房间类型,房间总数 
	 * @return 根据房间类型 对result进行筛选
	 * */
	private List<HotelVO> searchByRoomType(String bookDate,String roomType, int roomTotal,List<HotelVO> hotels) {
		
		List<HotelVO> result = new ArrayList<HotelVO>();
		//房间类型不为空的话，要找到对应类型的房间数目
		if(!"".equals(roomType)&&roomType!=null){
			
			for(HotelVO hotelvo:hotels){
				List<RoomVO> allroom = new AllRooms(hotelvo.getHotelID()).getAllRooms();
				List<RoomVO> allroomForaType = new ArrayList<RoomVO>();//保存特定类型的所有房间
				
				for(RoomVO roomvo:allroom){
					if(roomType.equals(roomvo.getRoomType())){
						allroomForaType.add(roomvo);
					}
				}
				if(allroomForaType.size()<roomTotal){
			        continue;//直接跳过
				}
				
				//判断时间是不是空，空的话就是直接计算allroomForaType里面的空闲房间数目就可以了
	            //时间非空的话，非空的话计算空闲房间和已预订的最晚执行时间在计划入住时间之前的房间数目
				int countFree = 0;
				for(RoomVO roomvo:allroomForaType){
					if("空闲".equals(roomvo.getRoomState())){
						countFree++;
					}
				}//countFree是空闲房间的数量
				if("".equals(bookDate)||bookDate==null){
					if(countFree<roomTotal){
						continue;
					}else{
						result.add(hotelvo);
					}
				}else{
					int countBook = 0;
			        for(RoomVO roomvo:allroomForaType){
			        	if("已预订".equals(roomvo.getRoomState())){
			        		
			        		String beginDate = roomvo.getBookDate();//预订时间
			        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        		Date lastDay = null;
			        		try {
								lastDay = sdf.parse(beginDate);
							} catch (ParseException e) {
								e.printStackTrace();
							}
			        		Calendar c1 = Calendar.getInstance();
			        		c1.setTime(lastDay);
			        		c1.add(Calendar.DAY_OF_YEAR, 7);//预订日期加上七天，c1现在是房间的最晚执行日期
			        		
			        		Calendar c2 = Calendar.getInstance();
			        		Date date2 = null;
			        		try {
								date2 = sdf.parse(sdf.format(new Date()));
							} catch (ParseException e) {
								e.printStackTrace();
							}
			        		c2.setTime(date2);//得到现在的系统日期
			        		
			        		if(c2.after(c1)){
			        			//最晚执行日期在当前时间之前
			        			countBook++;
			        		}else{
			        			continue;
			        		}
			        	}
			        }
			        //完成了对所有房间的遍历，并且计算已预订的符合日期的房间数目
			        if(countBook+countFree>=roomTotal){
			        	result.add(hotelvo);//符合条件的话就把hotelvo加到result
			        }
				}	
			}
		}else{
			//房间类型为空的话，对每个酒店的所有房间进行计算空闲房间数目，并且还有已预订的但是到时候会到期的房间数目
		    if("".equals(bookDate)||bookDate==null){
		    	//时间也为空的话，就是简单复制hotels
		    	for(HotelVO hotelvo:hotels){
		    		result.add(hotelvo);
		    	}
		    }else{
		    	//时间不为空的话，需要进行判断
		    	for(HotelVO hotelvo:hotels){
		    		List<RoomVO> allrooms = new AllRooms(hotelvo.getHotelID()).getAllRooms();
		    		int countFree=0,countBook=0;
		    		for(RoomVO roomvo:allrooms){
		    			if("空闲".equals(roomvo.getRoomState())){
		    				countFree++;
		    			}else if("已预订".equals(roomvo.getRoomState())){
			        		
			        		String beginDate = roomvo.getBookDate();//预订时间
			        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        		Date lastDay = null;
			        		try {
								lastDay = sdf.parse(beginDate);
							} catch (ParseException e) {
								e.printStackTrace();
							}
			        		Calendar c1 = Calendar.getInstance();
			        		c1.setTime(lastDay);
			        		c1.add(Calendar.DAY_OF_YEAR, 7);//预订日期加上七天，c1现在是房间的最晚执行日期
			        		
			        		Calendar c2 = Calendar.getInstance();
			        		Date date2 = null;
			        		try {
								date2 = sdf.parse(sdf.format(new Date()));
							} catch (ParseException e) {
								e.printStackTrace();
							}
			        		c2.setTime(date2);//得到现在的系统日期
			        		
			        		if(c2.after(c1)){
			        			//最晚执行日期在当前时间之前
			        			countBook++;
			        		}else{
			        			continue;
			        		}
			        	}
		    		}//完成了对allrooms的遍历
		    		if(countFree+countBook>=roomTotal){
		    			result.add(hotelvo);
		    		}
		    	}
		    }
		}
		
		
		//这个是得到result里面所有酒店的最低价格
		for(HotelVO vo:result){
			//遍历result，初始化价格HashMap
			String typeAndPrice[] = vo.getRoomTypeAndPrice().split("/");
			if(!"".equals(roomType)&&roomType!=null){
				for(String str:typeAndPrice){
					if(str.split("|")[0].equals(roomType)){
						//只有酒店有相同类型的房间才加
						price.put(Double.valueOf(str.split("|")[1]),vo);
					}
				}
			}else{
				//传进来的roomtype为空，确保房间数不小于1
				double minPrice = Double.valueOf(typeAndPrice[0].split("|")[1]) ;//最低价格，初始化为第一个类型的价格
				for(String str:typeAndPrice){
					//找到酒店房间的最低价格
					double roomPrice = Double.valueOf(str.split("|")[1]);
					if(roomPrice<minPrice){
						minPrice = roomPrice;
					}
				}
				price.put(minPrice,vo);
			}
		}
		
		return result;
	}

	/**
	 * @param 最低价格，最高价格，原酒店列表
	 * @return 根据最低价格和最高价格，对酒店进行搜索
	 * */
	private List<HotelVO> searchByPrice(double minPrice, double maxPrice,List<HotelVO> hotels) {
		
		List<HotelVO> result = new ArrayList<HotelVO>();
		if(maxPrice==-1){
			//缺少最大值的操作
			if(minPrice!=-1){
				//最小值不为-1的话
				for(double p:price.keySet()){
					if(p>=minPrice){
						result.add(price.get(p));
					}
				}
				return result;
			}else{
				//最大最小值同时没有，直接return hotels
				return hotels;
			}
		}else{
			if(minPrice==-1){
				//最大最小值同时缺少
				return hotels;
			}else{
				//存在最小值的话
				for(double p:price.keySet()){
					if(p>=minPrice||p<=maxPrice){
						result.add(price.get(p));
					}
				}
				return result;
			}
		}
	}

	/**
	 * @param minStar 最低星级,maxStar 最高星级,hotels 待搜索的酒店
	 * @return 返回搜索结果
	 * */
	private List<HotelVO> searchByStar(int minStar, int maxStar, List<HotelVO> hotels) {
		
		List<HotelVO> result = new ArrayList<HotelVO>();
		if(minStar!=-1){
			//存在最低星级
			if(maxStar!=-1){
				for(HotelVO hotelvo:hotels){
					if(hotelvo.getHotelStar()>=minStar&&hotelvo.getHotelStar()<=maxStar){
						result.add(hotelvo);
					}
				}
				return result;
			}else{
				for(HotelVO hotelvo:hotels){
					if(hotelvo.getHotelStar()>=minStar){
						result.add(hotelvo);
					}
				}
				return result;
			}
		}else{
			if(maxStar!=-1){
				for(HotelVO hotelvo:hotels){
					if(hotelvo.getHotelStar()<=maxStar){
						result.add(hotelvo);
					}
				}
				return result;
			}else{
				return hotels;
			}
		}
		
	}

	/**
	 * @param 最低评分，最高评分，待搜索的酒店
	 * @return 返回搜索结果
	 * */
	private List<HotelVO> searchByPoint(double minPoint, double maxPoint, List<HotelVO> hotels) {
		
		List<HotelVO> result = new ArrayList<HotelVO>();
		for(HotelVO hotelvo:hotels){
			double point = (hotelvo.getPoint_facilities()+hotelvo.getPoint_service()+hotelvo.getPoint_surroundings())/3;
			if(minPoint!=-1){
				if(maxPoint!=-1){
					if(point>=minPoint&&maxPoint<=maxPoint){
						result.add(hotelvo);
					}
				}else{
					if(maxPoint==-1){
						if(point>=minPoint){
							result.add(hotelvo);
						}
					}
				}
			}else{
				if(maxPoint!=-1){
					if(point<=maxPoint){
						result.add(hotelvo);
					}
				}else{
					result.add(hotelvo);
				}
			}
			}
		return result;
	}

	/**
	 * @param 是否曾经预订过，待搜索的所有酒店
	 * @return 返回搜索结果
	 * */
	private List<HotelVO> searchByHasOrdered(boolean hasOrdered, List<HotelVO> hotels) {
		
		List<HotelVO> result = new ArrayList<HotelVO>();
		if(hasOrdered==false){
			return hotels;
		}else{
			for(HotelVO hotelvo:hotels){
				String [] orderID = hotelvo.getOrderID().split("/");
				if(orderID.length!=0){
					result.add(hotelvo);
				}
			}
			return result;
		}
	}
}
