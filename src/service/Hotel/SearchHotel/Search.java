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
 * �������������صĲ���
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
	 * @param searchvo��������
	 * @return ���ص����ʺ������ľƵ���Ϣ�б�;
	 * ��������searchvoҪ����һЩĬ��������������Ŀ��С��1����ͼ۸����߼۸������ʱ��Ϊ-1������Ǽ�������Ǽ��������ʱ��Ϊ-1
	 * �������������ֶ���0��100֮�� ��סʱ����˷�ʱ��Ϊ�յĻ���������Ϊ"" û��ѡ���Ƿ�����Ԥ���Ļ�Ĭ�Ͼ���false
	 * */
	public List<HotelVO> search(SearchVO searchvo){
		
		List<HotelVO> result;
		
		String hotelName = searchvo.getHotelName();
		result = searchByName(hotelName,allHotels);
		
		String bookDate = searchvo.getOrderBeginDate();///�ƻ���סʱ��
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
	 * @param �Ƶ����ƣ�Ҫ����ɸѡ�ľƵ�vo
	 * @return ����Ƶ�������ȵ����оƵ�vo
	 * */
	private List<HotelVO> searchByName(String hotelName,List<HotelVO> hotels) {
		
		List<HotelVO> result = new ArrayList<HotelVO>();
		if(!"".equals(hotelName)&&hotelName!=null){
			//hotelName��Ϊ��
			for(HotelVO vo:result){
				if(hotelName.equals(vo.getHotelName())){
					result.add(vo);//������ͬ�Ļ����Ͱ�hotelvo�ӵ�result����
				}
			}
			return result;
		}else{
			//hotelNameΪ�գ�����ֱ�ӿ���
	        return hotels;
		}
	}

	/**
	 * @param �ƻ���סʱ��,��������,�������� 
	 * @return ���ݷ������� ��result����ɸѡ
	 * */
	private List<HotelVO> searchByRoomType(String bookDate,String roomType, int roomTotal,List<HotelVO> hotels) {
		
		List<HotelVO> result = new ArrayList<HotelVO>();
		//�������Ͳ�Ϊ�յĻ���Ҫ�ҵ���Ӧ���͵ķ�����Ŀ
		if(!"".equals(roomType)&&roomType!=null){
			
			for(HotelVO hotelvo:hotels){
				List<RoomVO> allroom = new AllRooms(hotelvo.getHotelID()).getAllRooms();
				List<RoomVO> allroomForaType = new ArrayList<RoomVO>();//�����ض����͵����з���
				
				for(RoomVO roomvo:allroom){
					if(roomType.equals(roomvo.getRoomType())){
						allroomForaType.add(roomvo);
					}
				}
				if(allroomForaType.size()<roomTotal){
			        continue;//ֱ������
				}
				
				//�ж�ʱ���ǲ��ǿգ��յĻ�����ֱ�Ӽ���allroomForaType����Ŀ��з�����Ŀ�Ϳ�����
	            //ʱ��ǿյĻ����ǿյĻ�������з������Ԥ��������ִ��ʱ���ڼƻ���סʱ��֮ǰ�ķ�����Ŀ
				int countFree = 0;
				for(RoomVO roomvo:allroomForaType){
					if("����".equals(roomvo.getRoomState())){
						countFree++;
					}
				}//countFree�ǿ��з��������
				if("".equals(bookDate)||bookDate==null){
					if(countFree<roomTotal){
						continue;
					}else{
						result.add(hotelvo);
					}
				}else{
					int countBook = 0;
			        for(RoomVO roomvo:allroomForaType){
			        	if("��Ԥ��".equals(roomvo.getRoomState())){
			        		
			        		String beginDate = roomvo.getBookDate();//Ԥ��ʱ��
			        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        		Date lastDay = null;
			        		try {
								lastDay = sdf.parse(beginDate);
							} catch (ParseException e) {
								e.printStackTrace();
							}
			        		Calendar c1 = Calendar.getInstance();
			        		c1.setTime(lastDay);
			        		c1.add(Calendar.DAY_OF_YEAR, 7);//Ԥ�����ڼ������죬c1�����Ƿ��������ִ������
			        		
			        		Calendar c2 = Calendar.getInstance();
			        		Date date2 = null;
			        		try {
								date2 = sdf.parse(sdf.format(new Date()));
							} catch (ParseException e) {
								e.printStackTrace();
							}
			        		c2.setTime(date2);//�õ����ڵ�ϵͳ����
			        		
			        		if(c2.after(c1)){
			        			//����ִ�������ڵ�ǰʱ��֮ǰ
			        			countBook++;
			        		}else{
			        			continue;
			        		}
			        	}
			        }
			        //����˶����з���ı��������Ҽ�����Ԥ���ķ������ڵķ�����Ŀ
			        if(countBook+countFree>=roomTotal){
			        	result.add(hotelvo);//���������Ļ��Ͱ�hotelvo�ӵ�result
			        }
				}	
			}
		}else{
			//��������Ϊ�յĻ�����ÿ���Ƶ�����з�����м�����з�����Ŀ�����һ�����Ԥ���ĵ��ǵ�ʱ��ᵽ�ڵķ�����Ŀ
		    if("".equals(bookDate)||bookDate==null){
		    	//ʱ��ҲΪ�յĻ������Ǽ򵥸���hotels
		    	for(HotelVO hotelvo:hotels){
		    		result.add(hotelvo);
		    	}
		    }else{
		    	//ʱ�䲻Ϊ�յĻ�����Ҫ�����ж�
		    	for(HotelVO hotelvo:hotels){
		    		List<RoomVO> allrooms = new AllRooms(hotelvo.getHotelID()).getAllRooms();
		    		int countFree=0,countBook=0;
		    		for(RoomVO roomvo:allrooms){
		    			if("����".equals(roomvo.getRoomState())){
		    				countFree++;
		    			}else if("��Ԥ��".equals(roomvo.getRoomState())){
			        		
			        		String beginDate = roomvo.getBookDate();//Ԥ��ʱ��
			        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        		Date lastDay = null;
			        		try {
								lastDay = sdf.parse(beginDate);
							} catch (ParseException e) {
								e.printStackTrace();
							}
			        		Calendar c1 = Calendar.getInstance();
			        		c1.setTime(lastDay);
			        		c1.add(Calendar.DAY_OF_YEAR, 7);//Ԥ�����ڼ������죬c1�����Ƿ��������ִ������
			        		
			        		Calendar c2 = Calendar.getInstance();
			        		Date date2 = null;
			        		try {
								date2 = sdf.parse(sdf.format(new Date()));
							} catch (ParseException e) {
								e.printStackTrace();
							}
			        		c2.setTime(date2);//�õ����ڵ�ϵͳ����
			        		
			        		if(c2.after(c1)){
			        			//����ִ�������ڵ�ǰʱ��֮ǰ
			        			countBook++;
			        		}else{
			        			continue;
			        		}
			        	}
		    		}//����˶�allrooms�ı���
		    		if(countFree+countBook>=roomTotal){
		    			result.add(hotelvo);
		    		}
		    	}
		    }
		}
		
		
		//����ǵõ�result�������оƵ����ͼ۸�
		for(HotelVO vo:result){
			//����result����ʼ���۸�HashMap
			String typeAndPrice[] = vo.getRoomTypeAndPrice().split("/");
			if(!"".equals(roomType)&&roomType!=null){
				for(String str:typeAndPrice){
					if(str.split("|")[0].equals(roomType)){
						//ֻ�оƵ�����ͬ���͵ķ���ż�
						price.put(Double.valueOf(str.split("|")[1]),vo);
					}
				}
			}else{
				//��������roomtypeΪ�գ�ȷ����������С��1
				double minPrice = Double.valueOf(typeAndPrice[0].split("|")[1]) ;//��ͼ۸񣬳�ʼ��Ϊ��һ�����͵ļ۸�
				for(String str:typeAndPrice){
					//�ҵ��Ƶ귿�����ͼ۸�
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
	 * @param ��ͼ۸���߼۸�ԭ�Ƶ��б�
	 * @return ������ͼ۸����߼۸񣬶ԾƵ��������
	 * */
	private List<HotelVO> searchByPrice(double minPrice, double maxPrice,List<HotelVO> hotels) {
		
		List<HotelVO> result = new ArrayList<HotelVO>();
		if(maxPrice==-1){
			//ȱ�����ֵ�Ĳ���
			if(minPrice!=-1){
				//��Сֵ��Ϊ-1�Ļ�
				for(double p:price.keySet()){
					if(p>=minPrice){
						result.add(price.get(p));
					}
				}
				return result;
			}else{
				//�����Сֵͬʱû�У�ֱ��return hotels
				return hotels;
			}
		}else{
			if(minPrice==-1){
				//�����Сֵͬʱȱ��
				return hotels;
			}else{
				//������Сֵ�Ļ�
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
	 * @param minStar ����Ǽ�,maxStar ����Ǽ�,hotels �������ľƵ�
	 * @return �����������
	 * */
	private List<HotelVO> searchByStar(int minStar, int maxStar, List<HotelVO> hotels) {
		
		List<HotelVO> result = new ArrayList<HotelVO>();
		if(minStar!=-1){
			//��������Ǽ�
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
	 * @param ������֣�������֣��������ľƵ�
	 * @return �����������
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
	 * @param �Ƿ�����Ԥ�����������������оƵ�
	 * @return �����������
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
