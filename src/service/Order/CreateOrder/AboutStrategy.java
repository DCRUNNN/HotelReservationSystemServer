package service.Order.CreateOrder;

import service.Client.ProvidedService.ClientProvidedService;
import service.Client.ProvidedService.ClientProvidedServiceImpl;
import service.Strategy.ProvidedService.StrategyProvidedService;
import service.Strategy.ProvidedService.StrategyProvidedServiceImpl;

/**
 * 负责与client模块和strategy模块进行交互
 * @see StrategyProvidedService
 * @see ClientProvidedService
 * */
public class AboutStrategy {

	private StrategyProvidedService strategyservice;
	private ClientProvidedService clientservice;
	
	public AboutStrategy(){
		strategyservice = new StrategyProvidedServiceImpl();
		clientservice = new ClientProvidedServiceImpl();
	}
	
	/**
	 * @param clientID 客户编号
	 * @param hotelID 酒店编号
	 * @param roomTotal 房间总数
	 * @param hotelCBD 酒店所在的商圈
	 * @param hotelCity 酒店所在的城市
	 * @param hotelProvince 酒店所在的省份
	 * @return 得到客户在该酒店的综合的最优惠的策略 例如8折
	 * */
	public double getPriceByStrategy(String clientID,String hotelID,int roomTotal, String hotelProvince, String hotelCity, String hotelCBD){
		
		 double discount = 0;
		 String userType = clientservice.getUserType(clientID);
		 //对客户类型的简单判断逻辑放在这边
		 if("普通客户".equals(userType)){
			 //是普通客户的话，对应的折扣只能是在特定期间内预订或者是预订数目超过特定数字
			 discount = strategyservice.getBestStrategyForNormalUser(hotelID,roomTotal);
		 }else if("普通会员".equals(userType)){
			 //普通会员的话，对应的折扣包括：特定期间预订，预订数目超出，生日特惠，在特定商圈预订有折扣
			 String birthday = clientservice.getVipBirthday(clientID);
			 int vipGrade = clientservice.getVipGrade(clientID);
			 discount = strategyservice.getBestStrategyForNormalVip(hotelID,roomTotal,birthday,vipGrade,hotelProvince,hotelCity,hotelCBD);
		 }else if("企业会员".equals(userType)){
			 //企业会员的话，对应的折扣包括：特定期间预订，预订数目超出，在特定的酒店有优惠
			 if(clientservice.isCorrectCompanyVip(clientID,hotelID)){
				 //客户是在企业合作酒店入住 还需要判断酒店有没有提供这个企业的优惠策略
				 String companyAddress = clientservice.getCompanyAddress(clientID);
				 discount = strategyservice.getBestStrategyForCompanyVip(hotelID,roomTotal,companyAddress);
			 }
		 }else{
			 //三者都不是的话 那么就是普通会员和企业会员共存了
			 String birthday = clientservice.getVipBirthday(clientID);
			 int vipGrade = clientservice.getVipGrade(clientID);
			 String companyAddress = clientservice.getCompanyAddress(clientID);
			 double discount1 = strategyservice.getBestStrategyForNormalVip(hotelID,roomTotal,birthday,vipGrade,hotelProvince,hotelCity,hotelCBD);

			 double discount2 = strategyservice.getBestStrategyForCompanyVip(hotelID,roomTotal,companyAddress);
		     discount = Double.min(discount1, discount2);//找到两者的较小值
		 }
         
         return discount;
	}

	/**
	 * @return 判断客户的信用值是否大于等于0
	 * */
	public boolean checkCreditPoint(String clientID) {
		return clientservice.checkCreditPoint(clientID);
	}
}
