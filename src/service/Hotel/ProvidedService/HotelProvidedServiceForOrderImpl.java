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
		
		double pfac = po.getPoint_facilities();//�õ��Ƶ��ԭ�����������͵��ۺ�����
		double pser = po.getPoint_service();
		double psur = po.getPoint_surroundings();
		double newPfac = (commentNumber*pfac+point_facilities)/(commentNumber+1);//�¼�������Ķ���ʩ�����ֵ�ƽ��ֵ
		double newPser = (commentNumber*pser+point_service)/(commentNumber+1);
		double newPsur = (commentNumber*psur+point_surroundings)/(commentNumber+1);
		
	    commentNumber++;//����������һ
	    
	    String clientComment = clientID+":"+comment;//�γɿͻ�������
	    String old_comment = po.getCommentList();//�õ��Ƶ��ԭ��������
	    String new_comment = old_comment+"%"+clientComment;//�γ��µ�����
	    
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
		String [] commentArray = commentList.split("%");//�õ����е�����
		
		StringBuilder sb = new StringBuilder();//����׷��֮����µ�����
		for(String str:commentArray){
			//������������
			String comments[] = str.split(":");
			if(clientID.equals(comments[0])){
				str=str+"|"+comment;
				//���������ۺ������׷�ӵ�����
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
