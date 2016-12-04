package vo;

import java.io.Serializable;

import po.PersonnelPO;

/**
 * personnelID           工作人员id
 * type                  工作人员类别
 * name                  工作人员姓名
 * sex                   工作人员性别
 * phoneNumber           工作人员联系方式
 * hotelID               酒店编号
 * @author lewis_chen
 *
 */
public class PersonnelVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6365141306313600252L;
	private String personnelID;
	private String type;
	private String name;
	private String sex;
	private String phoneNumber;
	private String hotelID;
/**
 * 传递personnelPO，hotelInfo作为构造函数的参数
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
 * 传递PersonnelVO需要的参数	
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
