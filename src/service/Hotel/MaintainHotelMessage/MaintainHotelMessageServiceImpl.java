package service.Hotel.MaintainHotelMessage;

import java.rmi.RemoteException;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import vo.HotelVO;

/**
 * MaintainHotelMessageService接口的实现类
 * @see HotelDao
 * */
public class MaintainHotelMessageServiceImpl implements MaintainHotelMessageService{


	private HotelDao hotelDao;
	
	public MaintainHotelMessageServiceImpl(){

		hotelDao = HotelDaoImpl.getInstance();
	}
	
	@Override
	public boolean changeHotelInfo(String hotelID,String hotelProvince,String hotelCity, String hotelCBD,String hotelAddress,String hotelName, String introduction, String facilities,
			int star, String roomTypeAndPrices,String telephone) throws RemoteException{
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		po.setHotelProvince(hotelProvince);
		po.setHotelCity(hotelCity);
		po.setHotelCBD(hotelCBD);
		po.setHotelAddress(hotelAddress);
		po.setHotelName(hotelName);
		po.setIntroduction(introduction);
		po.setFacilities(facilities);
		po.setHotelStar(star);
		po.setRoomTypeAndPrice(roomTypeAndPrices);
		po.setTelephone(telephone);
		return hotelDao.change(po);
	}

	@Override
	public HotelVO getHotelVO(String hotelID) throws RemoteException{
		
		HotelPO po = hotelDao.getHotelPO(hotelID);//可能为空的
		if(po==null){
			return null;
		}else{
			//这里需要注意一下，有控制耦合的
			HotelVO vo = new HotelVO("//// ",po);
			return vo;
		}
	}

	@Override
	public boolean changeHotelInfo(String hotelID,HotelVO vo)throws RemoteException {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		po.setHotelProvince(vo.getHotelProvince());
		po.setHotelCity(vo.getHotelCity());
		po.setHotelCBD(vo.getHotelCBD());
		po.setHotelAddress(vo.getHotelAddress());
		po.setHotelName(vo.getHotelName());
		po.setHotelStar(vo.getHotelStar());
		po.setFacilities(vo.getFacilities());
		po.setIntroduction(vo.getIntroduction());
		po.setRoomTypeAndPrice(vo.getRoomTypeAndPrice());
		return hotelDao.change(po);
	}

	@Override
	public boolean addCompany(String hotelID,String companyAddress) throws RemoteException{
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		String company = po.getCompany();
		if("".equals(company)||"null".equals(company)||company==null){
			//酒店没有合作企业，直接把企业地址加上去就可以了
			po.setCompany(companyAddress);
			return hotelDao.change(po);
		}else{
			if(company.contains(companyAddress)){
				//企业已经是酒店的合作企业
				return false;
			}else{
				//直接在company后面加上企业的地址
				String newCompany = company+"/"+companyAddress;
				po.setCompany(newCompany);
				return hotelDao.change(po);
			}
		}
	}

	@Override
	public boolean deleteCompany(String hotelID,String companyAddress)throws RemoteException {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		String company = po.getCompany();
		if("".equals(company)||"null".equals(company)||company==null){
			//没有合作企业
			return false;
		}else{
			if(!company.contains(companyAddress)){
				//酒店的合作企业不包括要删除的企业
				return false;
			}else{
				String [] companies = company.split("/");
				for(int i=0;i<companies.length;i++){
					if(companies[i].equals(companyAddress)){
						//找到企业地址 把数组中的元素改为""
						companies[i]="";
					}
				}
				
				String newCompany = "";
				for(String str:companies){
					if(!"".equals(str)){
						newCompany+=str+"/";
					}
				}
				newCompany = newCompany.substring(0,newCompany.length()-1);
				po.setCompany(newCompany);
				return hotelDao.change(po);
			}
		}
	}

}
