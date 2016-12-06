package data.datahelper.factory;

import data.datahelper.AccountDataHelper;
import data.datahelper.xmlhelper.XMLHelper;

public class AccountFactory {

	public static AccountDataHelper getAccountDataHelper() {
		
	    AccountDataHelper accountdata = null;
	    String name = XMLHelper.getClass("./xml/dataxml/accountdata.xml","class");//�������ļ�����ȡ����
	    
	    try {
	    	//�÷���ʵ��ʵ����
			accountdata = (AccountDataHelper)Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
		return accountdata;
	}

	
}
