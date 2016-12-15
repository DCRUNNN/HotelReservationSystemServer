package po;

/**
 * hotelID              酒店编号
 * hotelProvince        酒店所在省份
 * hotelCity            酒店所在的市
 * hotelCBD             酒店商圈
 * hotelAddress         酒店详细地址
 * hotelName            酒店名称
 * hotelStar            酒店星级
 * introduction         酒店简介
 * facilities           酒店设施
 * roomTypeAndPrice     房间类型和价格(type+"|"+price+"/"+type+"|"+price)
 * point_facilities     酒店的设施综合评分
 * point_service        酒店的服务综合评分
 * point_surroundings   酒店的周围环境综合评分
 * commentList          酒店的评价列表(clientID+":"+comment+"|"+extraComment+"%"+clientID+":"+comment+"|"+extraComment)
 * commentPeople        对酒店进行评价的人数
 * company              合作企业的记录(company1+"/"+company2)
 * telephone            酒店联系方式
 * @author Xihao Zeng
 * */
public class HotelPO {
    
	private String hotelID;
	
	private String hotelProvince;
	
	private String hotelCity;
	
	private String hotelCBD;
	
	private String hotelAddress;
	
	private String hotelName;
	
	private int hotelStar;

	private String introduction;
	
	private String facilities;
	
	private String roomTypeAndPrice;

	private double point_facilities;
	
	private double point_service;
	
	private double point_surroundings;
	
	private String commentList;
	
	private int commentPeople;
	
	private String company;
	
	private String telephone;
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelProvince() {
		return hotelProvince;
	}

	public String getHotelCity() {
		return hotelCity;
	}

	public void setHotelProvince(String hotelProvince) {
		this.hotelProvince = hotelProvince;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public String getRoomTypeAndPrice() {
		return roomTypeAndPrice;
	}

	public void setRoomTypeAndPrice(String roomTypeAndPrice) {
		this.roomTypeAndPrice = roomTypeAndPrice;
	}
	public int getHotelStar() {
		return hotelStar;
	}

	public void setHotelStar(int hotelStar) {
		this.hotelStar = hotelStar;
	}

	public int getCommentPeople() {
		return commentPeople;
	}

	public void setCommentPeople(int commentPeople) {
		this.commentPeople = commentPeople;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getHotelCBD() {
		return hotelCBD;
	}

	public void setHotelCBD(String hotelCBD) {
		this.hotelCBD = hotelCBD;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public double getPoint_facilities() {
		return point_facilities;
	}

	public void setPoint_facilities(double point_facilities) {
		this.point_facilities = point_facilities;
	}

	public double getPoint_service() {
		return point_service;
	}

	public void setPoint_service(double point_service) {
		this.point_service = point_service;
	}

	public double getPoint_surroundings() {
		return point_surroundings;
	}

	public void setPoint_surroundings(double point_surroundings){
		this.point_surroundings = point_surroundings;
	}
	public String getCommentList() {
		return commentList;
	}

	public void setCommentList(String commentList) {
		this.commentList = commentList;
	}
	
	public String getCompany(){
		return company;
	}
	
	public void setCompany(String company){
		this.company = company;
	}
}
