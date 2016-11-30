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
		
		StrategyVO hstrategy1 = new StrategyVO(null, "���䷿�͸����Żݣ�", "���ͻ�Ԥ���ľƵ�����������������ϵĻ�����ͨ��Ա����8���Żݣ���ͨ�ͻ�����9���Ż�",
				"2016-09-20 15:20:20", null, "��ͨ�ͻ�", null, null, false, "�Ƶ�Ӫ������", hotelID, 3, 9);
		
		StrategyVO hstrategy2 = new StrategyVO(null,"���䷿�͸����Żݣ�","���ͻ�Ԥ���ľƵ�����������������ϵĻ�����ͨ��Ա����8���Żݣ���ͨ�ͻ�����9���Ż�",
				"2016-09-20 15:20:20", null, "��ͨ��Ա", null, null, false, "�Ƶ�Ӫ������", hotelID, 3, 8);
		
		StrategyVO hstrategy3 = new StrategyVO(null, "��Ա�����Żݣ�", "123����Ա����8�ۣ�45����Ա����7��!",
				null, null, "��ͨ��Ա_1", null, null, true, "�Ƶ�Ӫ������", hotelID, 1, 8);
		
		StrategyVO hstrategy4 = new StrategyVO(null, "��Ա�����Żݣ�", "123����Ա����8�ۣ�45����Ա����7��!",
				null, null, "��ͨ��Ա_2", null, null, true, "�Ƶ�Ӫ������", hotelID, 1, 8);
		
		StrategyVO hstrategy5 = new StrategyVO(null, "��Ա�����Żݣ�", "123����Ա����8�ۣ�45����Ա����7��!",
				null, null, "��ͨ��Ա_4", null, null, true, "�Ƶ�Ӫ������", hotelID, 1, 7);
		
		StrategyVO wstrategy1 = new StrategyVO(null, "һ����Ա�����Żݣ�", "һ����Ա�����Żݣ�", 
				null, null, "��ͨ��Ա_1", null, null, false, "website", null, 1, 8);
		
		StrategyDriver strategyDriver = new StrategyDriver();
		strategyDriver.addHotelStrategy(hstrategy1);
		strategyDriver.addHotelStrategy(hstrategy2);
		strategyDriver.addHotelStrategy(hstrategy3);
		strategyDriver.addHotelStrategy(hstrategy4);
		strategyDriver.addHotelStrategy(hstrategy5);
		strategyDriver.addWebStrategy(wstrategy1);//��������һЩ�Ƶ�Ӫ�����Ժ�һ��website
		System.out.println("Add Strategies are added!");
		
		List<StrategyVO> allHotelStrategies = strategyDriver.hotelstrategy.getAllHotelStrategy(hotelID);//�õ���վ������Ӫ������
		for(StrategyVO vo:allHotelStrategies){
			System.out.println(vo.getStrategyType()+": "+vo.getStrategyID()+"  :   "+vo.getIntroduction());
		}//������в��ԵĽ���
		System.out.println("-----------------------");
		
		StrategyVO newStrategy = allHotelStrategies.get(0);
		newStrategy.setEndTime("2016-11-29 24:00:00");
		strategyDriver.hotelstrategy.changeHotelStrategy(newStrategy);//�޸Ĳ���
		
		strategyDriver.hotelstrategy.deleteHotelStrategy(allHotelStrategies.get(3).getStrategyID());//ɾ������������
		
		List<StrategyVO> newStrategies = strategyDriver.hotelstrategy.getAllHotelStrategy(hotelID);
		for(StrategyVO vo:newStrategies){
			System.out.println(vo.getStrategyType()+": "+vo.getStrategyID()+"  :   "+vo.getIntroduction()+": "+vo.getEndTime());
		}//������в��ԵĽ���
		System.out.println("---------------------");
		
		List<StrategyVO> strlist = strategyDriver.webstrategy.getAllWebsiteStrategy();
		//System.out.println(strlist.size());
		StrategyVO newWebStrategy = strlist.get(0);
		newWebStrategy.setEndTime("2016-11-28 00:00:00");
		strategyDriver.webstrategy.changeStrategy(newWebStrategy);//�ı�website
		//System.out.println(newWebStrategy.getStrategyType());
		
		List<StrategyVO> list = strategyDriver.webstrategy.getAllWebsiteStrategy();
		for(StrategyVO vo:list){
			System.out.println(vo.getStrategyType()+": "+vo.getStrategyID()+"  :   "+vo.getIntroduction()+" :  "+vo.getEndTime());
		}//���website
		System.out.println("---------------");
		
	    strategyDriver.webstrategy.deleteStrategy(list.get(0).getStrategyID());//ɾ��website
	    list = strategyDriver.webstrategy.getAllWebsiteStrategy();
	    for(StrategyVO vo:list){
			System.out.println(vo.getStrategyType()+": "+vo.getStrategyID()+"  :   "+vo.getIntroduction());
		}//���website
		System.out.println("---------------");
		
		strategyDriver.webstrategy.addStrategy(newWebStrategy);
		list = strategyDriver.webstrategy.getAllWebsiteStrategy();
		 for(StrategyVO vo:list){
				System.out.println(vo.getStrategyType()+": "+vo.getStrategyID()+"  :   "+vo.getIntroduction());
			}//���website
		System.out.println("---------------");
		
	}
}
