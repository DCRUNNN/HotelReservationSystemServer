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
		
		ManageHotelStrategyService service2 = new ManageHotelStrategyServiceImpl();
		StrategyVO vo = new StrategyVO(null, "聪少公司工作人员优惠！", "聪少公司的工作人员都可以有6折优惠",
				null, null, "企业会员", null, null, null, false, "酒店营销策略", hotelID, 1, "江苏省南京市仙林商圈南京大学旁聪少公司", 6);
		
		System.out.println(service2.addHotelStrategy(vo)?"成功添加酒店营销策略":"添加酒店营销策略失败！");
		
		//测试企业会员的话，三种可能：特定时间预订，预订数目超出，酒店提供特定的企业优惠
		System.out.println(service.getBestStrategyForCompanyVip(hotelID, 1, "广东省茂名市化州商圈化州一中旁星河公司"));
	
		
	}
}
