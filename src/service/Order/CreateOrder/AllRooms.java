package service.Order.CreateOrder;

import java.util.List;

import service.Order.InteractWithRoom.RoomProvidedServiceForOrder;
import service.Room.ProvidedService.RoomProvidedServiceForOrderImpl;
import vo.RoomVO;

/**
 * ������ ��������Ƶ����еķ�����Ϣ ���Ҹ�����roomģ��Ľ���
 * @see RoomProvidedServiceForOrder
 * @see AboutStrategy
 * */
public class AllRooms {
	
	private String hotelID;
    private RoomProvidedServiceForOrder roomservice;
  
    public AllRooms(String hotelID){
    	
    	this.hotelID = hotelID;
    	roomservice = new RoomProvidedServiceForOrderImpl();

    }
    
    /**
     * @return �õ�һ���Ƶ�����з���
     * */
    public List<RoomVO> getAllRooms(){
    	return roomservice.getAllRooms(hotelID);
    }
    
    /**
     * @param ��������
     * @return ���ݷ������� ���ط������������п��з������ ������1+"/"+����2)
     * */
    public String getAllRoomNumber(String roomType){
    	
    	List<RoomVO> allrooms = roomservice.getAllRooms(hotelID);
    	StringBuilder sb = new StringBuilder();
    	for(RoomVO vo:allrooms){
    		if("����".equals(vo.getRoomState())){
    			if(roomType.equals(vo.getRoomType())){
    				sb.append(vo.getRoomNumber()+"/");
    			}
    		}
    	}
    	
    	if(sb.length()==0){
    		return "";
    	}else{
    		String result = sb.toString().substring(0, sb.length()-1);
        	return result;
    	}
    }   
    
    /**
     * @param clientID �ͻ����
     * @param hotelID �Ƶ���
     * @param hotelCBD �Ƶ���Ȧ
     * @param hotelCity �Ƶ����ڳ���
     * @param hotelProvince �Ƶ�����ʡ��
     * @return ���������Ų����µ��ܼ�
     * */
    public double getPriceByStrategy(String clientID,String hotelID,String roomNumber, String hotelProvince, String hotelCity, String hotelCBD){
    	
    	double total1 = 0;
        String numbers[] = roomNumber.split("/");
        List<RoomVO> allrooms = roomservice.getAllRooms(hotelID);
        
        for(int i=0;i<numbers.length;i++){
       	 for(RoomVO vo:allrooms){
       		 if(numbers[i].equals(vo.getRoomNumber())){
       			 total1+=vo.getPrice();
       		 }
       	 }
        }
        
        double discount = new AboutStrategy().getPriceByStrategy(clientID, hotelID,numbers.length,hotelProvince,hotelCity,hotelCBD);
        return total1*discount/10;
    }
    
    /**
     * @param �������,����ÿһ��ֻ�Ǹı�һ�������״̬
     * @return ����˸ı�־û������еķ���״̬ 
     * */
    public boolean changeRoomState (String roomNumber,String state){
    	
    	if(!roomservice.changeRoomState(hotelID, roomNumber,state)){
    		return false;
    	}
    	return true;
    }
    
    /**
     * @param ������룬Ԥ��ʱ��
     * @return ��������ó־û������еķ����Ԥ��ʱ��
     * */
    public boolean setBookDate(String roomNumber,String bookDate){
    	
    	if(!roomservice.setBookDate(hotelID, roomNumber, bookDate)){
    		return false;
    	}
    	return true;
    }
}
