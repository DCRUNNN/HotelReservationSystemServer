package service.Strategy.ProvidedService;

public interface StrategyProvidedService {

	/**
	 * @param hotelID 酒店编号
	 * @param roomTotal 预订的房间数
	 * 普通客户对应的折扣只能是在特定期间内预订或者是预订数目超过特定数字
	 * @return 返回最低的折扣
	 * */
	public double getBestStrategyForNormalUser(String hotelID, int roomTotal);

	/**
	 * @param hotelID 酒店编号
	 * @param roomTotal 房间数目
	 * @param birthday 会员生日
	 * @param vipGrade 会员等级
	 * 普通会员对应的折扣包括：特定期间预订，预订数目超出，生日特惠，在特定商圈预订有折扣
	 * @param hotelCBD 酒店所在的商圈
	 * @param hotelCity 酒店所在的城市
	 * @param hotelProvince 酒店所在的省份
	 * @return 返回最低折扣
	 * */
	public double getBestStrategyForNormalVip(String hotelID, int roomTotal, String birthday, int vipGrade, String hotelProvince, String hotelCity, String hotelCBD);

	/**
	 * @param hotelID 酒店编号
	 * @param roomTotal 房间数目
	 * @param companyAddress 企业的详细地址
	 * 企业会员对应的折扣包括：特定期间预订，预订数目超出，在酒店有优惠
	 * @return 返回最低折扣
	 * */
	public double getBestStrategyForCompanyVip(String hotelID, int roomTotal,String companyAddress);
	
}
