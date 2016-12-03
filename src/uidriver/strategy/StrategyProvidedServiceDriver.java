package uidriver.strategy;

import service.Strategy.ManageHotelStrategy.ManageHotelStrategyService;
import service.Strategy.ManageHotelStrategy.ManageHotelStrategyServiceImpl;
import service.Strategy.ProvidedService.StrategyProvidedService;
import service.Strategy.ProvidedService.StrategyProvidedServiceImpl;
import vo.StrategyVO;

public class StrategyProvidedServiceDriver {

	public static void main(String args[]){
		
		StrategyProvidedService service = new StrategyProvidedServiceImpl();
		String hotelID = "00001";
		//String clientID = "0000001";
		String hotelProvince = "�㶫ʡ";
		String hotelCity = "ï����";
		String hotelCBD = "������Ȧ";
		String birthday = "12-01";
		int vipGrade = 4;
		int roomTotal = 3;
		
		//���Ի�Ա������ۿ۵Ļ���Ҫ�ṩ���ֱȽ� �ض��ڼ�Ԥ�� Ԥ����Ŀ���� �����ػ� ���ض���ȦԤ��
		System.out.println(service.getBestStrategyForNormalVip(hotelID, roomTotal, birthday, vipGrade, hotelProvince, hotelCity, hotelCBD));
	
		//������ͨ�û��Ļ���ֻ�Ǵ������ֿ��ܣ�һ���ض�ʱ��Ԥ����Ԥ����Ŀ����
		System.out.println(service.getBestStrategyForNormalUser(hotelID, roomTotal));
		
		ManageHotelStrategyService service2 = new ManageHotelStrategyServiceImpl();
		StrategyVO vo = new StrategyVO(null, "���ٹ�˾������Ա�Żݣ�", "���ٹ�˾�Ĺ�����Ա��������6���Ż�",
				null, null, "��ҵ��Ա", null, null, null, false, "�Ƶ�Ӫ������", hotelID, 1, "����ʡ�Ͼ���������Ȧ�Ͼ���ѧ�Դ��ٹ�˾", 6);
		
		System.out.println(service2.addHotelStrategy(vo)?"�ɹ���ӾƵ�Ӫ������":"��ӾƵ�Ӫ������ʧ�ܣ�");
		
		//������ҵ��Ա�Ļ������ֿ��ܣ��ض�ʱ��Ԥ����Ԥ����Ŀ�������Ƶ��ṩ�ض�����ҵ�Ż�
		System.out.println(service.getBestStrategyForCompanyVip(hotelID, 1, "�㶫ʡï���л�����Ȧ����һ�����Ǻӹ�˾"));
	
		
	}
}
