package uidriver.strategy;

import service.Strategy.ProvidedService.StrategyProvidedService;
import service.Strategy.ProvidedService.StrategyProvidedServiceImpl;

public class StrategyProvidedServiceDriver {

	public static void main(String args[]){
		
		StrategyProvidedService service = new StrategyProvidedServiceImpl();
		String hotelID = "00001";
		//String clientID = "0000001";
		String hotelProvince = "广东省";
		String hotelCity = "茂名市";
		String hotelCBD = "化州商圈";
		String birthday = "12-01";
		int vipGrade = 4;
		int roomTotal = 3;
		
		//测试会员的最低折扣的话，要提供四种比较 特定期间预订 预订数目超出 生日特惠 在特定商圈预订
		System.out.println(service.getBestStrategyForNormalVip(hotelID, roomTotal, birthday, vipGrade, hotelProvince, hotelCity, hotelCBD));
	
		//测试普通用户的话，只是存在两种可能，一是特定时间预订，预订数目超出
		System.out.println(service.getBestStrategyForNormalUser(hotelID, roomTotal));
		
		//System.out.println(x);
	}
}
