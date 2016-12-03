package service.Hotel.ProvidedService;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import service.Client.InteractWithHotel.HotelProvidedServiceForClient;

public class HotelProvidedServiceForClientImpl implements HotelProvidedServiceForClient {
	
	private HotelDao hotelDao;
	
	public HotelProvidedServiceForClientImpl(){
		hotelDao = HotelDaoImpl.getInstance();
	}
	@Override
	public boolean addCompany(String hotelID, String companyAddress) {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		if(po==null){
			//�Ƶ�id�Ҳ�����Ӧ�ľƵ�
			return false;
		}
		
		String company = po.getCompany();
		if("".equals(company)||"null".equals(company)||company==null){
			po.setCompany(companyAddress);//ֱ������companyΪcompanyAddress�Ϳ�����
			return hotelDao.change(po);
		}else{
		    if(company.contains(companyAddress)){
		    	return true;//�Ѿ��ǾƵ�ĺ�����ҵ��
		    }else{
		    	String newCompany = company+"/"+companyAddress;
		    	po.setCompany(newCompany);
		    	return hotelDao.change(po);
		    }
		}

	}
	
	@Override
	public String getHotelInfo(String hotelID) {
		
	    HotelPO po = hotelDao.getHotelPO(hotelID);
	    if(po==null){
	    	//�Ƶ��Ӧ��id������
	    	return "";
	    }
	    
	    String hotelProvince = po.getHotelProvince();
	    String hotelCity = po.getHotelCity();
	    String hotelCBD = po.getHotelCBD();
	    String hotelAddress = po.getHotelAddress();
	    String hotelName = po.getHotelName();
	    String hotelInfo = hotelProvince+hotelCity+hotelCBD+hotelAddress+hotelName;
		return hotelInfo;
	}

 }
