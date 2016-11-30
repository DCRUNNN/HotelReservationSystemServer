package vo;

import po.PersonnelPO;
import java.util.Vector;

/**
 * personnelID           ������Աid
 * type                  ������Ա���
 * name                  ������Ա����
 * sex                   ������Ա�Ա�
 * phoneNumber           ������Ա��ϵ��ʽ
 * hotelID               �Ƶ���
 * @author lewis_chen
 *
 */
public class PersonnelVO {

	private String personnelID;
	private String type;
	private String name;
	private String sex;
	private String phoneNumber;
	private String hotelID;
/**
 * ����personnelPO��hotelInfo��Ϊ���캯���Ĳ���
 */
	public PersonnelVO(PersonnelPO po){
		
		this.personnelID=po.getPersonnelID();
		this.name=po.getName();
		this.sex=po.getSex();
		this.phoneNumber=po.getPhoneNumber();
		this.hotelID=po.getHotelID();
		this.type=po.getType();
		
	}
/**
 * ����PersonnelVO��Ҫ�Ĳ���	
 */
	public PersonnelVO (String personnelID,String type,String name,String sex,String phoneNumber,String hotelID){
		this.personnelID = personnelID;
		this.type = type;
		this.name = name;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.hotelID = hotelID;
	}

	public String getpersonnelID(){
		return personnelID;
	}
	public String getType(){
		return type;
	}
	public String getname(){
		return name;
	}
	public String getsex(){
		return sex;
	}
	public String getphoneNumber(){
		return phoneNumber;
	}
	public String gethotelID(){
		return hotelID;
	}
	public void setPersonnelID(String personnelID) {
		this.personnelID = personnelID;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	
}
