package uidriver.room;

import java.rmi.RemoteException;
import java.util.List;

import service.Room.ChangeRoomInfo.ChangeRoomInfoService;
import service.Room.ChangeRoomInfo.ChangeRoomInfoServiceImpl;
import service.Room.CreateRoom.CreateRoomInfoServiceImpl;
import vo.RoomVO;

public class ChangeRoomInfoDriver {

	public static void main(String args[]) throws RemoteException{
		
		String hotelID = "00001";
		ChangeRoomInfoService service = new ChangeRoomInfoServiceImpl();
		
		//�ı�ĳһ���͵ķ���ļ۸�
		String roomTypeAndPrice = new CreateRoomInfoServiceImpl().getAllRoomTypeAndPrice(hotelID);
		String types[] = roomTypeAndPrice.split("/");//�ı䷿��۸��ͬʱ����Ҫ���¾Ƶ��Ӧ����Ϣ
		String type = types[0].split("[|]")[0];//�õ��ľ��ǵ�һ����������
		System.out.println(type);//�����������
		
		System.out.println(service.changeRoomPrice(type, 100, hotelID)?"�ɹ��ı䷿��۸�":"�ı䷿��۸�ʧ�ܣ�");
	    
		List<RoomVO> volist = service.getAllRoomList(hotelID);
		for(RoomVO vo:volist){
			show(vo);
		}//չʾ���еķ�����Ϣ
		
	    List<RoomVO> temp = service.getRoomByState(hotelID,"����");
	    for(RoomVO vo:temp){
	    	show(vo);
	    }//չʾ���еĿ��з�����Ϣ
	    
	    List<RoomVO> typeRoom = service.getRoomByType(hotelID,"�������˼�");
	    for(RoomVO vo:typeRoom){
	    	show(vo);
	    }//չʾ���еĺ������˼���Ϣ
	    
	    RoomVO vo1 = volist.get(2);
	    String roomID = vo1.getRoomNumber();
	    System.out.println(service.changeRoomState(hotelID, roomID, "����ס")?"�ɹ��ı�״̬��":"�ı�״̬ʧ�ܣ�");
		show(service.getRoomByNum(hotelID,roomID));//չʾ�޸ĺ�ķ�����Ϣ
		
		System.out.println(service.deleteRoom(hotelID, roomID)?"�ɹ�ɾ�����䣡":"ɾ������ʧ�ܣ�");//ɾ������
		volist = service.getAllRoomList(hotelID);
		for(RoomVO vo:volist){
			show(vo);
		}
		
	}
	
	public static void show(RoomVO vo){
		
		System.out.println("�Ƶ���:"+vo.getHotelID());
		System.out.println("�������:"+vo.getRoomNumber());
		System.out.println("��������:"+vo.getRoomType());
		System.out.println("����״̬:"+vo.getRoomState());
		System.out.println("���䱻Ԥ��ʱ��:"+vo.getBookDate());
		System.out.println("������:"+vo.getRoomIntroduction());
		System.out.println("-----------------");
	}
}
