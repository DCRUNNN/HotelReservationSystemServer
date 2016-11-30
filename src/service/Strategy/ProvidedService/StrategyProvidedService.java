package service.Strategy.ProvidedService;

public interface StrategyProvidedService {

	/**
	 * @param hotelInfo 酒店信息(hotelID+hotelProvince+hotelCity+hotelCBD+hotelName)分隔符是"/"
	 * @param roomTotal 预订的房间数
	 * 普通客户对应的折扣只能是在特定期间内预订或者是预订数目超过特定数字
	 * @return 返回最低的折扣
	 * */
	public double getBestStrategyForNormalUser(String hotelInfo, int roomTotal);

	/**
	 * @param hotelInfo 酒店信息
	 * @param roomTotal 房间数目
	 * @param birthday 会员生日
	 * @param vipGrade 会员等级
	 * 普通会员对应的折扣包括：特定期间预订，预订数目超出，生日特惠，在特定商圈预订有折扣
	 * @return 返回最低折扣
	 * */
	public double getBestStrategyForNormalVip(String hotelInfo, int roomTotal, String birthday, int vipGrade);

	/**
	 * @param hotelInfo 酒店信息
	 * @param roomTotal 房间数目
	 * 企业会员对应的折扣包括：特定期间预订，预订数目超出，在酒店有优惠
	 * @return 返回最低折扣
	 * */
	public double getBestStrategyForCompanyVip(String hotelInfo, int roomTotal);
	
}
