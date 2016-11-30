package service.Order.CreateOrder;

import java.util.List;

import service.Order.InteractWithRoom.RoomProvidedServiceForOrder;
import service.Room.ProvidedService.RoomProvidedServiceForOrderImpl;
import vo.RoomVO;

/**
 * 容器类 里面包含酒店所有的房间信息 并且负责与room模块的交互
 * @see RoomProvidedServiceForOrder
 * @see AboutStrategy
 * */
public class AllRooms {
	
	private String hotelID;
    private RoomProvidedServiceForOrder roomservice;
    private List<RoomVO> allrooms;
    
    public AllRooms(String hotelID){
    	
    	this.hotelID = hotelID;
    	roomservice = new RoomProvidedServiceForOrderImpl();
    	allrooms=roomservice.getAllRooms(hotelID);
    }
    
    /**
     * @return 得到一个酒店的所有房间
     * */
    public List<RoomVO> getAllRooms(){
    	return allrooms;
    }
    
    /**
     * @param 房间类型
     * @return 根据房间类型 返回符合条件的所有空闲房间号码 （号码1+"/"+号码2)
     * */
    public String getAllRoomNumber(String roomType){
    	
    	StringBuilder sb = new StringBuilder();
    	for(RoomVO vo:allrooms){
    		if("空闲".equals(vo.getRoomState())){
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
     * @param clientID 客户编号
     * @param hotelID 酒店编号
     * @param hotelCBD 酒店商圈
     * @param hotelCity 酒店所在城市
     * @param hotelProvince 酒店所在省份
     * @return 返回在最优策略下的总价
     * */
    public double getPriceByStrategy(String clientID,String hotelID,String roomNumber, String hotelProvince, String hotelCity, String hotelCBD){
    	
    	double total1 = 0;
        String numbers[] = roomNumber.split("/");
        
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
     * @param 房间号码,但是每一次只是改变一个房间的状态
     * @return 完成了改变持久化数据中的房间状态 
     * */
    public boolean changeRoomState (String roomNumber,String state){
    	
    	if(!roomservice.changeRoomState(hotelID, roomNumber,state)){
    		return false;
    	}
    	return true;
    }
    
    /**
     * @param 房间号码，预订时间
     * @return 完成了设置持久化数据中的房间的预订时间
     * */
    public boolean setBookDate(String roomNumber,String bookDate){
    	
    	if(!roomservice.setBookDate(hotelID, roomNumber, bookDate)){
    		return false;
    	}
    	return true;
    }
}
