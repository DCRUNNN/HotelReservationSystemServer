package uidriver.strategy;

import service.Strategy.ProvidedService.StrategyProvidedService;
import service.Strategy.ProvidedService.StrategyProvidedServiceImpl;

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
		
		//System.out.println(x);
	}
}
