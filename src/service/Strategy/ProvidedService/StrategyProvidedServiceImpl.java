package service.Strategy.ProvidedService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.dao.StrategyDao;
import data.dao.impl.StrategyDaoImpl;
import po.StrategyPO;

public class StrategyProvidedServiceImpl implements StrategyProvidedService{

	private StrategyDao strategyDao ;
	
	public StrategyProvidedServiceImpl(){
		
		strategyDao = StrategyDaoImpl.getInstance();
	}
	
	@Override
	public double getBestStrategyForNormalUser(String hotelInfo, int roomTotal) {
		
		List<Double> discounts = new ArrayList<Double>();//客户满足条件的所有折扣
		String hotelID = hotelInfo.split("/")[0];
		List<StrategyPO> hotelStrategy = strategyDao.getAllHotelStrategies(hotelID);//酒店的所有营销策略
		List<StrategyPO> websiteStrategy = strategyDao.getAllWebsiteStrategies();//网站的所有营销策略
		
		for(StrategyPO po :hotelStrategy){
			if("普通客户".equals(po.getUserType())){
				//遍历酒店营销策略,找到适合普通客户的策略
				if(checkTime(po.getBeginTime(),po.getEndTime())){
					if(roomTotal>=po.getRoomTotal()){
						discounts.add(po.getDiscount());
					}
				}
			}
		}
		
		for(StrategyPO po :websiteStrategy){
			if("普通客户".equals(po.getUserType())){
				//遍历网站营销策略，找到适合普通客户的策略
				if(checkTime(po.getBeginTime(),po.getEndTime())){
					if(roomTotal>=po.getRoomTotal()){
						discounts.add(po.getDiscount());
					}
				}
			}
		}
		
		return findMin(discounts);
	}

	@Override
	public double getBestStrategyForNormalVip(String hotelInfo, int roomTotal, String birthday, int vipGrade) {
		
		List<Double> discounts = new ArrayList<Double>();//客户满足条件的所有折扣
		String hotelID = hotelInfo.split("/")[0];
		List<StrategyPO> hotelStrategy = strategyDao.getAllHotelStrategies(hotelID);//酒店的所有营销策略
		List<StrategyPO> websiteStrategy = strategyDao.getAllWebsiteStrategies();//网站的所有营销策略
		
		for(StrategyPO po:hotelStrategy){
			if(("普通会员_"+vipGrade).equals(po.getUserType())){
				//遍历酒店策略，找到适合当前等级的普通会员的策略
				if(po.isToBirthday()){
					//会员生日的折扣
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String today = sdf.format(new Date());
					if(today.equals(birthday)){//比较当前日期和生日,相同的话就是满足
						discounts.add(po.getDiscount());
						continue;
					}
				}else{
					if(checkTime(po.getBeginTime(),po.getEndTime())){
						if(roomTotal>=po.getRoomTotal()){
							discounts.add(po.getDiscount());
						}
					}
				}
			}
		}
		
		for(StrategyPO po:websiteStrategy){
			if(("普通会员_"+vipGrade).equals(po.getUserType())){
				//遍历网站营销策略，找到适合当前等级的普通会员的策略
				//根据级别有折扣，在级别对应的商圈内预订也有折扣
				if(!"".equals(po.getHotelAddress())&&po.getHotelAddress()!=null){
					//策略对应的酒店地址不为空的时候
					String infos[] = hotelInfo.split("/");
					String hotelAddress = infos[1]+"/"+infos[2];
					String hotelCBD = infos[3];
					if(hotelAddress.equals(po.getHotelAddress())&&hotelCBD.equals(po.getHotelCBD())){
						//会员预订的酒店在特价商圈之内的话
						if(checkTime(po.getBeginTime(),po.getEndTime())){
							//判断日期和房间数目是否满足条件
							if(roomTotal>=po.getRoomTotal()){
								discounts.add(po.getDiscount());
							}
						}
					}
				}else{
					//没有指定特定地址和商圈
					if(checkTime(po.getBeginTime(),po.getEndTime())){
						if(roomTotal>=po.getRoomTotal()){
							discounts.add(po.getDiscount());
						}
					}
				}
			}
		}
		
		return findMin(discounts);
	}

	@Override
	public double getBestStrategyForCompanyVip(String hotelInfo, int roomTotal) {
		
		List<Double> discounts = new ArrayList<Double>();//客户满足条件的所有折扣
		String hotelID = hotelInfo.split("/")[0];
		List<StrategyPO> hotelStrategy = strategyDao.getAllHotelStrategies(hotelID);//酒店的所有营销策略
		List<StrategyPO> websiteStrategy = strategyDao.getAllWebsiteStrategies();//网站的所有营销策略
		
		for(StrategyPO po :hotelStrategy){
			if("企业会员".equals(po.getUserType())){
				//遍历酒店营销策略,找到适合企业会员的策略
				if(checkTime(po.getBeginTime(),po.getEndTime())){
					if(roomTotal>=po.getRoomTotal()){
						discounts.add(po.getDiscount());
					}
				}
			}
		}
		
		for(StrategyPO po :websiteStrategy){
			if("企业会员".equals(po.getUserType())){
				//遍历网站营销策略，找到适合企业会员的策略
				if(checkTime(po.getBeginTime(),po.getEndTime())){
					if(roomTotal>=po.getRoomTotal()){
						discounts.add(po.getDiscount());
					}
				}
			}
		}
		
		return findMin(discounts);
	}

	/**
	 * 私有方法，找到最小折扣
	 * */
	private double findMin(List<Double> discounts) {
	
		double min = 10;
		for(Double d:discounts){
			if(d<min){
				min=d;
			}
		}
		return min;
	}

	/**
	 * 私有方法，判断日期是否符合条件
	 * */
	private boolean checkTime(String beginTime, String endTime) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		long current = new Date().getTime();
		long begin = 0;
		if(!"".equals(beginTime)&&beginTime!=null){
			//开始时间非空的话
			try {
				//得到开始时间的毫秒数
				begin = sdf.parse(beginTime).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if("".equals(endTime)||endTime==null){
			//没有结束时间
			if(current>=begin){
				return true;
			}
		}else{
			//存在结束时间
			try {
				long end = sdf.parse(endTime).getTime();
				if(begin<=current&&current<=end){
					return true;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}

	
}
