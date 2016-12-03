package service.Order.help;

import po.OrderPO;
import service.Client.ProvidedService.ClientProvidedService;
import service.Client.ProvidedService.ClientProvidedServiceImpl;
import service.Hotel.ProvidedService.HotelProvidedServiceForOrderImpl;
import service.Order.InteractWithHotel.HotelProvidedServiceForOrder;
import vo.OrderVO;

public class CreateOrderVO {

	private HotelProvidedServiceForOrder hotelservice;
	private ClientProvidedService clientservice;

	public CreateOrderVO(){
		
		hotelservice = new HotelProvidedServiceForOrderImpl();
		clientservice = new ClientProvidedServiceImpl();
	}
	
	public OrderVO createOrderVO(OrderPO po){
		
		String clientID = po.getClientID();
		String hotelID = po.getHotelID();
		
		//name,sex,,identityid,phonenumber
		String clientName = clientservice.getClientName(clientID);
		String sex = clientservice.getSex(clientID);
		String identityID = clientservice.getIdentityID(clientID);
		String phoneNumber = clientservice.getPhoneNumber(clientID);
		
		String hotelProvince = hotelservice.getHotelProvince(hotelID);
		String hotelCity = hotelservice.getHotelCity(hotelID);
		String hotelCBD = hotelservice.getHotelCBD(hotelID);
		String hotelAddress = hotelservice.getHotelAddress(hotelID);
		String hotelName = hotelservice.getHotelName(hotelID);
		
		OrderVO vo = new OrderVO(po,hotelProvince,hotelCity,hotelCBD,hotelAddress,hotelName,clientName,sex,identityID,phoneNumber);
		return vo;
	}
}
