package service.Hotel.MaintainHotelMessage;

import java.rmi.RemoteException;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import service.Hotel.ProvidedService.HotelProvidedServiceForRoomImpl;
import service.Room.InteractWithHotel.RoomProvidedServiceForHotel;
import service.Room.InteractWithHotel.RoomProvidedServiceForHotelImpl;
import service.picture.Picture;
import vo.HotelVO;

/**
 * MaintainHotelMessageService接口的实现类
 * @see HotelDao
 * */
public class MaintainHotelMessageServiceImpl implements MaintainHotelMessageService{


	private HotelDao hotelDao;
	private RoomProvidedServiceForHotel roomservice;
	
	public MaintainHotelMessageServiceImpl(){

		hotelDao = HotelDaoImpl.getInstance();
		roomservice = new RoomProvidedServiceForHotelImpl();
	}
	
	@Override
	public boolean changeHotelInfo(String hotelID,String hotelProvince,String hotelCity, String hotelCBD,String hotelAddress,String hotelName, String introduction, String facilities,
			int star, String roomTypeAndPrices,String telephone) throws RemoteException{
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		po.setHotelID(hotelID);
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

	@Override
	public boolean addRoomTypeAndPrice(String hotelID, String roomType, double price) throws RemoteException {
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		if(po==null){
			return false;
		}
		
		String roomTypeAndPrice = po.getRoomTypeAndPrice();
		if(roomTypeAndPrice.contains(roomType)){
			//酒店之前就已经存在这样的房间，只是简单的修改房间的价格
			if(!changeRoomPrice(hotelID,roomType,price)){
				return false;
			}else{
				return true;
			}
			
		}else{
			String newRoomType = "";
			if(roomTypeAndPrice.equals("")||roomTypeAndPrice.equals(null)){
				//一开始没有房间时,roomTypeAndPrice为空,不应该有最前方的"/"
				newRoomType = roomType+"|"+price;
			}else{
				newRoomType = roomTypeAndPrice+"/"+roomType+"|"+price;
			}
			po.setRoomTypeAndPrice(newRoomType);
			if(!hotelDao.change(po)){
				return false;
			}
			return true;
		}
	
	}
	
	@Override
	public boolean changeRoomPrice(String hotelID, String roomType, double price) throws RemoteException {
		
		if(!new HotelProvidedServiceForRoomImpl().changeRoomTypeAndPrice(roomType, price, hotelID)){
			return false;
		}
		return roomservice.changeRoomPrice(hotelID, roomType, price);
	}

	@Override
	public byte[] getHotelPicture(String hotelID) throws RemoteException {
		
		return Picture.getHotelPicture(hotelID);
	}

	@Override
	public boolean uploadHotelPicture(byte[] b, String hotelID) throws RemoteException {
		
		return Picture.uploadHotelPicture(b, hotelID);
	}

	@Override
	public boolean changeHotelPicture(byte[] b, String hotelID) throws RemoteException {
		
		return Picture.changeHotelPicture(b,hotelID);
	}

}
