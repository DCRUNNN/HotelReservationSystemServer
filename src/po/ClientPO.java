package po;
/**
 * id               �ͻ����
 * name             �ͻ�����
 * sex              �ͻ��Ա�
 * identityID       �ͻ����֤����
 * phoneNumber      �ͻ��ֻ�����
 * credit_point     �ͻ�ʣ�����õ�
 * clientType       �ͻ����ͣ���ͨ�ͻ�����ͨ��Ա����ҵ��Ա��
 * birthday         �ͻ�����ͨvip�Ļ����пͻ�����(��ʽ��"yyyy-MM-dd")
 * vipGrade         vip�ȼ�(1,2,3,4,5)
 * companyName      ��˾����
 * companyAddress   ��˾��ַ(ʡ��+"/"+��+"/"+��ϸ��ַ)
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
	private String companyName;
	private String companyAddress;

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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
}
