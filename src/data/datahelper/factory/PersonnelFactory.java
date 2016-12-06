package data.datahelper.factory;

import data.datahelper.PersonnelDataHelper;
import data.datahelper.xmlhelper.XMLHelper;

public class PersonnelFactory {

	public static PersonnelDataHelper getPersonnelDataHelper() {
		
	    PersonnelDataHelper personneldata = null;
	    String name = XMLHelper.getClass("./xml/dataxml/personneldata.xml","class");//用配置文件来读取类名
	    
	    try {
	    	//用反射实现实例化
			personneldata = (PersonnelDataHelper)Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
		return personneldata;
	}

}
