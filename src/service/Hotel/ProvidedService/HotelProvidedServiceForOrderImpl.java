package service.Hotel.ProvidedService;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import service.Order.InteractWithHotel.HotelProvidedServiceForOrder;

public class HotelProvidedServiceForOrderImpl implements HotelProvidedServiceForOrder{

	private HotelDao hotelDao;
	
	public HotelProvidedServiceForOrderImpl(){
		
		hotelDao = HotelDaoImpl.getInstance();
	}

	@Override
	public boolean addComment(String hotelID, String clientID, String comment, int point_facilities, int point_service,
			int point_surroundings) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		int commentNumber = po.getCommentPeople();
		
		double pfac = po.getPoint_facilities();//得到酒店的原来的三种类型的综合评分
		double pser = po.getPoint_service();
		double psur = po.getPoint_surroundings();
		double newPfac = (commentNumber*pfac+point_facilities)/(commentNumber+1);//新计算出来的对设施的评分的平均值
		double newPser = (commentNumber*pser+point_service)/(commentNumber+1);
		double newPsur = (commentNumber*psur+point_surroundings)/(commentNumber+1);
		
	    commentNumber++;//评论人数加一
	    
	    String clientComment = clientID+":"+comment;//形成客户的评论
	    String old_comment = po.getCommentList();//得到酒店的原来的评论
	    String new_comment = old_comment+"%"+clientComment;//形成新的评论
	    
	    po.setCommentPeople(commentNumber);
	    po.setPoint_facilities(newPfac);
	    po.setPoint_service(newPser);
	    po.setPoint_surroundings(newPsur);
	    po.setCommentList(new_comment);
	    
		return hotelDao.change(po);
	}

	@Override
	public boolean addComment(String hotelID, String clientID, String comment) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		String commentList = po.getCommentList();
		String [] commentArray = commentList.split("%");//得到所有的评论
		
		StringBuilder sb = new StringBuilder();//插入追加之后的新的评论
		for(String str:commentArray){
			//遍历已有评论
			String comments[] = str.split(":");
			if(clientID.equals(comments[0])){
				str=str+"|"+comment;
				//往已有评论后面加上追加的评论
			}
			sb.append(str+"%");
		}
		
		String newComment = sb.toString().substring(0, sb.length()-1);
		po.setCommentList(newComment);
		return hotelDao.change(po);
	}

	@Override
	public String getRoomTypeAndPrice(String hotelID) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		if(po==null){
			return "";
		}
		String roomTypeAndPrice = po.getRoomTypeAndPrice();
		return roomTypeAndPrice;
	}

	@Override
	public String getHotelProvince(String hotelID) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		if(po==null){
			return "";
		}
		String hotelProvince = po.getHotelProvince();
		return hotelProvince;
	}

	@Override
	public String getHotelCity(String hotelID) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		if(po==null){
			return "";
		}
		String hotelCity = po.getHotelCity();
		return hotelCity;
	}

	@Override
	public String getHotelCBD(String hotelID) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		if(po==null){
			return "";
		}
		String hotelCBD = po.getHotelCBD();
		return hotelCBD;
	}

	@Override
	public String getHotelAddress(String hotelID) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		if(po==null){
			return "";
		}
		String hotelAddress = po.getHotelAddress();
		return hotelAddress;
	}

	@Override
	public String getHotelName(String hotelID) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		if(po==null){
			return "";
		}
		String hotelName = po.getHotelName();
		return hotelName;
	}

}
