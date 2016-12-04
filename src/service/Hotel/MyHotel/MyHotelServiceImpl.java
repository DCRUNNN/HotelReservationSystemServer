package service.Hotel.MyHotel;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.dao.HotelDao;
import data.dao.impl.HotelDaoImpl;
import po.HotelPO;
import service.Hotel.help.CreateHotelVO;
import service.Order.InteractWithHotel.OrderProvidedServiceForHotel;
import service.Order.InteractWithHotel.OrderProvidedServiceForHotelImpl;
import vo.HotelVO;

/**
 * MyHotelService�ӿڵľ���ʵ����
 * @see AllClientHotel 
 * */
public class MyHotelServiceImpl implements MyHotelService{
	
	private HotelDao hotelDao;
	private OrderProvidedServiceForHotel orderservice;
	private List<HotelVO> allHotels;
	
	public MyHotelServiceImpl(){
		
		hotelDao = HotelDaoImpl.getInstance();
		orderservice = new OrderProvidedServiceForHotelImpl();
		allHotels = new ArrayList<HotelVO>();
	}
	
	@Override
	public List<HotelVO> getExecutedHotels(String clientID) throws RemoteException{
		
		if(allHotels.size()==0){
			initAllHotels(clientID);
		}
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:allHotels){
			//������ʵ�־���orderStatus������Ϊ"��ִ��"��"δִ��"��"�쳣"����"�ѳ���"
			if(vo.getOrderStatus().contains("��ִ��")){
				list.add(vo);
			}
		}
		return list;
	
	}

	private void initAllHotels(String clientID) {

		//��allHotels����û�����ݵ�ʱ��
		List<HotelPO> hotelPOList = new ArrayList<HotelPO>();
		List<String> allOrderInfo = orderservice.getAllClientOrderInfo(clientID);
		for(String orderinfo:allOrderInfo){
			String array[] = orderinfo.split("/");
			hotelPOList.add(hotelDao.getHotelPO(array[4]));//array[4]��hotelID
		}
		
		for(HotelPO po:hotelPOList){
			HotelVO vo = new CreateHotelVO().create(clientID, po);
			allHotels.add(vo);
		}//�ѿͻ������оƵ���Ϣ���뵽allHotels
	
	}

	@Override
	public List<HotelVO> getUnexecutedHotels(String clientID) throws RemoteException{
		
		if(allHotels.size()==0){
			initAllHotels(clientID);
		}
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:allHotels){
			//������ʵ�־���orderStatus������Ϊ"��ִ��"��"δִ��"��"�쳣"����"�ѳ���"
			if(vo.getOrderStatus().contains("δִ��")){
				list.add(vo);
			}
		}
		return list;
	
	}

	@Override
	public List<HotelVO> getWithdrawnHotels(String clientID)throws RemoteException {
		
		if(allHotels.size()==0){
			initAllHotels(clientID);
		}
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:allHotels){
			//������ʵ�־���orderStatus������Ϊ"��ִ��"��"δִ��"��"�쳣"����"�ѳ���"
			if(vo.getOrderStatus().contains("�ѳ���")){
				list.add(vo);
			}
		}
		return list;
	
	}

	@Override
	public List<HotelVO> getAbnormalHotels(String clientID) throws RemoteException{
		
		if(allHotels.size()==0){
			initAllHotels(clientID);
		}
		
		List<HotelVO> list = new ArrayList<HotelVO>();
		for(HotelVO vo:allHotels){
			//������ʵ�־���orderStatus������Ϊ"��ִ��"��"δִ��"��"�쳣"����"�ѳ���"
			if(vo.getOrderStatus().contains("�쳣")){
				list.add(vo);
			}
		}
		return list;
	
	}

	@Override
	public HotelVO getHotelVO(String clientID,String hotelID) throws RemoteException{
		
		HotelPO po = hotelDao.getHotelPO(hotelID);
		if(po==null){
			return null;
		}
		
		return new CreateHotelVO().create(clientID, po);
	}

}
