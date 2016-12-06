package data.datahelper.factory;

import data.datahelper.ClientDataHelper;
import data.datahelper.xmlhelper.XMLHelper;

public class ClientFactory {

	public static ClientDataHelper getClientDataHelper() {
		
	    ClientDataHelper clientdata = null;
	    String name = XMLHelper.getClass("./xml/dataxml/clientdata.xml","class");//�������ļ�����ȡ����
	    
	    try {
	    	//�÷���ʵ��ʵ����
			clientdata = (ClientDataHelper)Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
		return clientdata;
	}

}
