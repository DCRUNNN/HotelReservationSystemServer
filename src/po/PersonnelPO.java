package po;
/**
 * personnelID         ������Ա���
 * name                ������Ա����
 * sex                 ������Ա�Ա�
 * phoneNumber         ������Ա��ϵ��ʽ
 * hotelID             �Ƶ���
 * type                ������Ա����
 * @author lewis_chen
 */
public class PersonnelPO {
	
	private String personnelID;
	private String name;
	private String sex;
	private String phoneNumber;
	private String hotelID;
	private String type;
	
	public String getPersonnelID() {
		return personnelID;
	}
	public void setPersonnelID(String personnelID) {
		this.personnelID = personnelID;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
}
