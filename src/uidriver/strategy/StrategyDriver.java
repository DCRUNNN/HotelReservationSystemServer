package uidriver.strategy;

import java.util.List;

import service.Strategy.ManageHotelStrategy.ManageHotelStrategyService;
import service.Strategy.ManageHotelStrategy.ManageHotelStrategyServiceImpl;
import service.Strategy.ManageWebsiteStrategy.ManageWebsiteStrategyService;
import service.Strategy.ManageWebsiteStrategy.ManageWebsiteStrategyServiceImpl;
import vo.StrategyVO;

public class StrategyDriver {

	ManageHotelStrategyService hotelstrategy= new ManageHotelStrategyServiceImpl();
    ManageWebsiteStrategyService webstrategy = new ManageWebsiteStrategyServiceImpl();
	//StrategyProvidedService providedservice = new StrategyProvidedServiceImpl();
	
	public boolean addWebStrategy(StrategyVO vo){
		return webstrategy.addStrategy(vo);
	}
	
	public boolean addHotelStrategy(StrategyVO vo){
		return hotelstrategy.addHotelStrategy(vo);
	}
	
	public static void main(String args[]){
		
		String hotelID = "00001";
		
		StrategyVO hstrategy1 = new StrategyVO(null, "三间房就给你优惠！", "当客户预订的酒店在三间或者三间以上的话，普通会员给予8折优惠，普通客户给予9折优惠",
				"2016-09-20 15:20:20", null, "普通客户",null, null, null, false, "酒店营销策略", hotelID, 3, 9);
		
		StrategyVO hstrategy2 = new StrategyVO(null,"三间房就给你优惠！","当客户预订的酒店在三间或者三间以上的话，普通会员给予8折优惠，普通客户给予9折优惠",
				"2016-09-20 15:20:20", null, "普通会员", null,null, null, false, "酒店营销策略", hotelID, 3, 8);
		
		StrategyVO hstrategy3 = new StrategyVO(null, "会员生日优惠！", "123级会员生日8折，45级会员生日7折!",
				null, null, "普通会员_1",null, null, null, true, "酒店营销策略", hotelID, 1, 8);
		
		StrategyVO hstrategy4 = new StrategyVO(null, "会员生日优惠！", "123级会员生日8折，45级会员生日7折!",
				null, null, "普通会员_2",null, null, null, true, "酒店营销策略", hotelID, 1, 8);
		
		StrategyVO hstrategy5 = new StrategyVO(null, "会员生日优惠！", "123级会员生日8折，45级会员生日7折!",
				null, null, "普通会员_4", null,null, null, true, "酒店营销策略", hotelID, 1, 7);
		
		StrategyVO wstrategy1 = new StrategyVO(null, "一级会员八折优惠！", "一级会员八折优惠！", 
				null, null, "普通会员_1",null, null, null, false, "website", null, 1, 8);
		
		StrategyVO wstrategy2 = new StrategyVO(null, "一级会员特定商圈优惠！", "一级会员在广东省茂名市化州商圈有6折优惠！", 
				null, null, "普通会员_1","广东省", "茂名市", "化州商圈", false, "website", null, 1, 8);
		
		StrategyDriver strategyDriver = new StrategyDriver();
		strategyDriver.addHotelStrategy(hstrategy1);
		strategyDriver.addHotelStrategy(hstrategy2);
		strategyDriver.addHotelStrategy(hstrategy3);
		strategyDriver.addHotelStrategy(hstrategy4);
		strategyDriver.addHotelStrategy(hstrategy5);
		strategyDriver.addWebStrategy(wstrategy1);
		strategyDriver.addWebStrategy(wstrategy2);//完成了添加一些酒店营销策略和一条website
		
		System.out.println("Add Strategies are added!");
		
		List<StrategyVO> allHotelStrategies = strategyDriver.hotelstrategy.getAllHotelStrategy(hotelID);//得到网站的所有营销策略
		for(StrategyVO vo:allHotelStrategies){
			show(vo);
		}//输出所有策略
		
		if(allHotelStrategies.size()==0){
			System.out.println("The number of hotel strategies is 0!");
			System.exit(0);
		}
		
		StrategyVO newStrategy = allHotelStrategies.get(0);
		newStrategy.setEndTime("2016-11-30 24:00:00");
		strategyDriver.hotelstrategy.changeHotelStrategy(newStrategy);//修改策略
		
		strategyDriver.hotelstrategy.deleteHotelStrategy(allHotelStrategies.get(3).getStrategyID());//删除第三条策略
		
		List<StrategyVO> newStrategies = strategyDriver.hotelstrategy.getAllHotelStrategy(hotelID);
		for(StrategyVO vo:newStrategies){
			show(vo);
		}//输出所有策略的介绍
		
		List<StrategyVO> strlist = strategyDriver.webstrategy.getAllWebsiteStrategy();
		StrategyVO newWebStrategy = strlist.get(0);
		newWebStrategy.setEndTime("2016-11-28 00:00:00");
		strategyDriver.webstrategy.changeStrategy(newWebStrategy);//改变website
		
		List<StrategyVO> list = strategyDriver.webstrategy.getAllWebsiteStrategy();
		for(StrategyVO vo:list){
			show(vo);
		}//输出网站营销策略
		
	    strategyDriver.webstrategy.deleteStrategy(list.get(0).getStrategyID());//删除website
	    list = strategyDriver.webstrategy.getAllWebsiteStrategy();
	    for(StrategyVO vo:list){
			show(vo);
	    	//System.out.println(vo.getStrategyType()+": "+vo.getStrategyID()+"  :   "+vo.getIntroduction());
		}//输出website
		
		strategyDriver.webstrategy.addStrategy(newWebStrategy);//再次添加一个网站营销策略
		list = strategyDriver.webstrategy.getAllWebsiteStrategy();
		 for(StrategyVO vo:list){
				show(vo);
			}//输出website
		//System.out.println("---------------");
		
	}
	
	public static void show(StrategyVO vo){
		
		System.out.print("id:"+vo.getStrategyID());
		System.out.println("type:"+vo.getStrategyType());
		System.out.println("name:"+vo.getName());
		System.out.println("introduction:"+vo.getIntroduction());
		System.out.println("beginTime:"+vo.getBeginTime());
		System.out.println("endTime:"+vo.getEndTime());
		System.out.println("userType:"+vo.getUserType());
		System.out.println("---------------------");
	}
}
