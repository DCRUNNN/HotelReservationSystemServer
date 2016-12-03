package vo;

import po.ClientPO;

/**
 * id               �ͻ����
 * name             �ͻ�����
 * sex              �ͻ��Ա�
 * identityID       �ͻ����֤����
 * phoneNumber      �ͻ��ֻ�����
 * credit_point     �ͻ�ʣ�����õ�
 * clientType       �ͻ�����(��ͨ�ͻ�����ͨvip����ҵvip)
 * birthday         �ͻ���Ӧ������ͨvip�Ļ���������
 * vipGrade         vip�ȼ���0��1��2��3��4��5��
 * companyAddress   ��˾��ַ(ʡ+"/"+��+"/"+��ϸ��ַ)
 * hotelIDs         ��ͻ�������ҵ�к��������оƵ���(hotelid1+"/"+hotelid2)
 * hotelInfos       ��Ӧ���к��������оƵ�ļ�����Ϣ(hotelInfo1+"/"+hotelInfo2)
 * 
 * hotelInfo = hotelProvince+hotelCity+hotelCBD+hotelAddress+hotelName
 * */

public class ClientVO {

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
	private String hotelInfos;
	
	public ClientVO(ClientPO po,String hotelInfos){
		
		this.id = po.getId();
		this.name = po.getName();
		this.sex = po.getSex();
		this.identityID = po.getIdentityID();
		this.phoneNumber = po.getPhoneNumber();
		this.credit_point = po.getCredit_point();
		this.clientType = po.getClientType();
		this.birthday = po.getBirthday();
		this.vipGrade = po.getVipGrade();
		this.companyAddress = po.getCompanyAddress();
		this.hotelIDs = po.getHotelIDs();
		this.hotelInfos = hotelInfos;
	}
	
	public ClientVO(String id,String name,String sex,String identityID,String phoneNumber,double credit_point,String clientType,String birthday,int vipGrade,String companyAddress,String hotelIDs){
		
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.identityID = identityID;
		this.phoneNumber = phoneNumber;
		this.credit_point = credit_point;
		this.clientType = clientType;
		this.birthday = birthday;
		this.vipGrade = vipGrade;
		this.companyAddress = companyAddress;
		this.hotelIDs = hotelIDs;
		
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public String getIdentityID() {
		return identityID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public double getCredit_point() {
		return credit_point;
	}

	public String getClientType() {
		return clientType;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}
	
	public String getBirthday(){
		return birthday;
	}
	
	public int getVipGrade(){
		return vipGrade;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setIdentityID(String identityID) {
		this.identityID = identityID;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setCredit_point(double credit_point) {
		this.credit_point = credit_point;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setVipGrade(int vipGrade) {
		this.vipGrade = vipGrade;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	public void serHotelIDS(String hotelIDs){
		this.hotelIDs = hotelIDs;
	}
	
	public String getHotelIDS(){
		return hotelIDs;
	}
	
	public String getHotelInfos(){
		return hotelInfos;
	}
	
}
