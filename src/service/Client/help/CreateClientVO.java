package service.Client.help;

import po.ClientPO;
import service.Client.InteractWithHotel.HotelProvidedServiceForClient;
import service.Hotel.ProvidedService.HotelProvidedServiceForClientImpl;
import vo.ClientVO;

public class CreateClientVO {

	private HotelProvidedServiceForClient hotelservice;
	
	public CreateClientVO(){
		hotelservice = new HotelProvidedServiceForClientImpl();
	}
	
	public ClientVO createClientVO(ClientPO po){

		String hotelIDs = po.getHotelIDs();
		if("".equals(hotelIDs)||"null".equals(hotelIDs)||hotelIDs==null){
			//不是企业会员或者没有合作企业的话,hotelInfo为空
			return new ClientVO(po,"");
		}else{
			String hotelInfos = "";
			String ids[] = hotelIDs.split("/");
			for(String str:ids){
				String hotelInfo = hotelservice.getHotelInfo(str);
				hotelInfos+=hotelInfo+"/";
			}
			hotelInfos = hotelInfos.substring(0,hotelInfos.length()-1);
			return new ClientVO(po,hotelInfos);
		}
	
	}
}
