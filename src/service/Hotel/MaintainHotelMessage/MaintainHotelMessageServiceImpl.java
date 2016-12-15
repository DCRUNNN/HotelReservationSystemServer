package service.Hotel.MaintainHotelMessage;

import java.rmi.RemoteException;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import vo.HotelVO;

/**
 * MaintainHotelMessageService�ӿڵ�ʵ����
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
		
		HotelPO po = hotelDao.getHotelPO(hotelID);//����Ϊ�յ�
		if(po==null){
			return null;
		}else{
			//������Ҫע��һ�£��п�����ϵ�
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
			//�Ƶ�û�к�����ҵ��ֱ�Ӱ���ҵ��ַ����ȥ�Ϳ�����
			po.setCompany(companyAddress);
			return hotelDao.change(po);
		}else{
			if(company.contains(companyAddress)){
				//��ҵ�Ѿ��ǾƵ�ĺ�����ҵ
				return false;
			}else{
				//ֱ����company���������ҵ�ĵ�ַ
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
			//û�к�����ҵ
			return false;
		}else{
			if(!company.contains(companyAddress)){
				//�Ƶ�ĺ�����ҵ������Ҫɾ������ҵ
				return false;
			}else{
				String [] companies = company.split("/");
				for(int i=0;i<companies.length;i++){
					if(companies[i].equals(companyAddress)){
						//�ҵ���ҵ��ַ �������е�Ԫ�ظ�Ϊ""
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
