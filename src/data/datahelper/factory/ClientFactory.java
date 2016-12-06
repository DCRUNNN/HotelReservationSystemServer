package data.datahelper.factory;

import data.datahelper.ClientDataHelper;
import data.datahelper.xmlhelper.XMLHelper;

public class ClientFactory {

	public static ClientDataHelper getClientDataHelper() {
		
	    ClientDataHelper clientdata = null;
	    String name = XMLHelper.getClass("./xml/dataxml/clientdata.xml","class");//用配置文件来读取类名
	    
	    try {
	    	//用反射实现实例化
			clientdata = (ClientDataHelper)Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
		return clientdata;
	}

}
