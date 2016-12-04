package service.Hotel.help;

import java.util.List;

import po.HotelPO;
import po.OrderPO;
import service.Order.InteractWithHotel.OrderProvidedServiceForHotel;
import service.Order.InteractWithHotel.OrderProvidedServiceForHotelImpl;
import vo.HotelVO;

/**
 * CreateHotelVO类 完成了和Order模块的交互 将HotelPO转换为HotelVO
 * @see OrderProvidedServiceForHotel
 * */
public class CreateHotelVO {

	private OrderProvidedServiceForHotel orderservice;
	
	public CreateHotelVO() {
	    
		orderservice = new OrderProvidedServiceForHotelImpl();
	}

	public HotelVO create(String clientID,HotelPO hotelPO) {
		
		List<OrderPO> polist = orderservice.getAllOrdersOfClientInaHotel(clientID, hotelPO.getHotelID());
		if(polist==null||polist.size()==0){
			return new HotelVO("//// ",hotelPO);
		}
		
		StringBuilder orderCreatedDate = new StringBuilder();
		StringBuilder orderStatus = new StringBuilder();
		StringBuilder orderid = new StringBuilder();
		StringBuilder price = new StringBuilder();
		String hotelID = hotelPO.getHotelID();
		
		for(OrderPO po:polist){
			orderCreatedDate.append(po.getOrderCreatedDate()+"|");
			orderStatus.append(po.getOrderStatus()+"|");
			orderid.append(po.getOrderID()+"|");
			price.append(po.getPrice()+"|");
		}
		
		String createddate = orderCreatedDate.toString().substring(0, orderCreatedDate.length()-1);
		String status = orderStatus.toString().substring(0, orderStatus.length()-1);
		String id = orderid.toString().substring(0, orderid.length()-1);
		String prices = price.toString().substring(0, price.length()-1);
		
		String orderInfo = createddate+"/"+status+"/"+id+"/"+prices+"/"+hotelID;
		return new HotelVO(orderInfo,hotelPO);
	}

	
	
}
