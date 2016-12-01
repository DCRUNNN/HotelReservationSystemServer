package service.Strategy.ProvidedService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import data.dao.StrategyDao;
import data.dao.impl.StrategyDaoImpl;
import po.StrategyPO;

public class StrategyProvidedServiceImpl implements StrategyProvidedService{

	private StrategyDao strategyDao ;
	
	public StrategyProvidedServiceImpl(){
		
		strategyDao = StrategyDaoImpl.getInstance();
	}
	
	@Override
	public double getBestStrategyForNormalUser(String hotelID, int roomTotal) {
		
		List<Double> discounts = new ArrayList<Double>();//�ͻ����������������ۿ�
		List<StrategyPO> hotelStrategy = strategyDao.getAllHotelStrategies(hotelID);//�Ƶ������Ӫ������
		List<StrategyPO> websiteStrategy = strategyDao.getAllWebsiteStrategies();//��վ������Ӫ������
		
		for(StrategyPO po :hotelStrategy){
			if("��ͨ�ͻ�".equals(po.getUserType())){
				//�����Ƶ�Ӫ������,�ҵ��ʺ���ͨ�ͻ��Ĳ���
				if(checkTime(po.getBeginTime(),po.getEndTime())){
					if(roomTotal>=po.getRoomTotal()){
						discounts.add(po.getDiscount());
					}
				}
			}
		}
		
		for(StrategyPO po :websiteStrategy){
			if("��ͨ�ͻ�".equals(po.getUserType())){
				//������վӪ�����ԣ��ҵ��ʺ���ͨ�ͻ��Ĳ���
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
	public double getBestStrategyForNormalVip(String hotelID, int roomTotal, String birthday, int vipGrade,String hotelProvince,String hotelCity,String hotelCBD) {
		
		List<Double> discounts = new ArrayList<Double>();//�ͻ����������������ۿ�
		List<StrategyPO> hotelStrategy = strategyDao.getAllHotelStrategies(hotelID);//�Ƶ������Ӫ������
		List<StrategyPO> websiteStrategy = strategyDao.getAllWebsiteStrategies();//��վ������Ӫ������
		
		for(StrategyPO po:hotelStrategy){
			if(("��ͨ��Ա_"+vipGrade).equals(po.getUserType())){
				//�����Ƶ���ԣ��ҵ��ʺϵ�ǰ�ȼ�����ͨ��Ա�Ĳ���
				if(po.isToBirthday()){
					//��Ա���յ��ۿ�
					SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
					String today = sdf.format(new Date());
					if(today.equals(birthday)){//�Ƚϵ�ǰ���ں�����,��ͬ�Ļ���������
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
			if(("��ͨ��Ա_"+vipGrade).equals(po.getUserType())){
					
				//������վӪ�����ԣ��ҵ��ʺϵ�ǰ�ȼ�����ͨ��Ա�Ĳ���
				//���ݼ������ۿۣ��ڼ����Ӧ����Ȧ��Ԥ��Ҳ���ۿ�
				if(!"".equals(po.getHotelProvince())&&po.getHotelProvince()!=null&&!"null".equals(po.getHotelProvince())){
					//���Զ�Ӧ�ľƵ��ַ��Ϊ�յ�ʱ��
					if(hotelProvince.equals(po.getHotelProvince())&&hotelCBD.equals(po.getHotelCBD())&&hotelCity.equals(po.getHotelCity())){
						//��ԱԤ���ľƵ����ؼ���Ȧ֮�ڵĻ�
						if(checkTime(po.getBeginTime(),po.getEndTime())){
							//�ж����ںͷ�����Ŀ�Ƿ���������
							if(roomTotal>=po.getRoomTotal()){
								discounts.add(po.getDiscount());
							}
						}
					}
				}else{
					//û��ָ���ض���ַ����Ȧ
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
	public double getBestStrategyForCompanyVip(String hotelID, int roomTotal) {
		
		List<Double> discounts = new ArrayList<Double>();//�ͻ����������������ۿ�
		List<StrategyPO> hotelStrategy = strategyDao.getAllHotelStrategies(hotelID);//�Ƶ������Ӫ������
		List<StrategyPO> websiteStrategy = strategyDao.getAllWebsiteStrategies();//��վ������Ӫ������
		
		for(StrategyPO po :hotelStrategy){
			if("��ҵ��Ա".equals(po.getUserType())){
				//�����Ƶ�Ӫ������,�ҵ��ʺ���ҵ��Ա�Ĳ���
				if(checkTime(po.getBeginTime(),po.getEndTime())){
					if(roomTotal>=po.getRoomTotal()){
						discounts.add(po.getDiscount());
					}
				}
			}
		}
		
		for(StrategyPO po :websiteStrategy){
			if("��ҵ��Ա".equals(po.getUserType())){
				//������վӪ�����ԣ��ҵ��ʺ���ҵ��Ա�Ĳ���
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
	 * ˽�з������ҵ���С�ۿ�
	 * */
	private double findMin(List<Double> discounts) {
	
		
		double min = 10;
		for(Double d:discounts){
			System.out.println(d);//�����е��ۿ����
			if(d<min){
				min=d;
			}
		}
		return min;
	}

	/**
	 * ˽�з������ж������Ƿ��������
	 * */
	private boolean checkTime(String beginTime, String endTime) {
		
		//new Date()�õ�����jvm�ϵ�ʱ�� ��һ����ϵͳʱ��һ��
		//TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
		//TimeZone.setDefault(tz);
		//System.out.println(new Date());
		long current = new Date().getTime();
		long begin = 0;
		if(!"".equals(beginTime)&&beginTime!=null&&!"null".equals(beginTime)){
			//��ʼʱ��ǿյĻ�
			try {
				//�õ���ʼʱ��ĺ�����
				begin = ThreadLocalDateUtil.parse(beginTime).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if("".equals(endTime)||endTime==null||"null".equals(endTime)){
			//û�н���ʱ��
			if(current>=begin){
				return true;
			}
		}else{
			//���ڽ���ʱ��
			try {
				//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
				long end = ThreadLocalDateUtil.parse(endTime).getTime();
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
