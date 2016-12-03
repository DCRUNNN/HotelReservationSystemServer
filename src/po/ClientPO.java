package po;
/**
 * id               客户编号
 * name             客户姓名
 * sex              客户性别
 * identityID       客户身份证号码
 * phoneNumber      客户手机号码
 * credit_point     客户剩余信用点
 * clientType       客户类型（普通客户，普通会员，企业会员）
 * birthday         客户是普通vip的话会有客户生日(格式是"MM-dd")
 * vipGrade         vip等级(1,2,3,4,5)
 * companyAddress   公司地址(公司名称例如 广东省茂名市化州商圈化州中学旁星河公司)
 * hotelID          表示的是	客户与客户所在企业有合作的所有的酒店的id(hotelid1+"/"+hotelid2)
 * */
public class ClientPO {

	private String id;
	private String name;
	private String sex;
	private String identityID;
	private String phoneNumber;
	private double credit_point;
	private String clientType;
	private String birthday;
	private int vipGrade;
	private String companyAddress;
	private String hotelIDs;

	public void setVipGrade(int vipGrade) {
		this.vipGrade = vipGrade;
	}

	public String getBirthday(){
		return birthday;
	}
	
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}
	
	public int getVipGrade(){
		return vipGrade;
	}
	
	public void serVipGrade(int grade){
		this.vipGrade = grade;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdentityID() {
		return identityID;
	}
	public void setIdentityID(String identityID) {
		this.identityID = identityID;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getCredit_point() {
		return credit_point;
	}
	public void setCredit_point(double credit_point) {
		this.credit_point = credit_point;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	public String getHotelIDs(){
		return hotelIDs;
	}
	
	public void setHotelIDs(String hotelIDs){
		this.hotelIDs = hotelIDs;
	}
}
