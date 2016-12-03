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
			//������ҵ��Ա����û�к�����ҵ�Ļ�,hotelInfoΪ��
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
