package data.datahelper.factory;

import data.datahelper.CreditDataHelper;
import data.datahelper.xmlhelper.XMLHelper;

public class CreditFactory {

	public static CreditDataHelper getCreditDataHelper() {
		
	    CreditDataHelper creditdata = null;
	    String name = XMLHelper.getClass("./xml/dataxml/creditdata.xml","class");//�������ļ�����ȡ����
	    
	    try {
	    	//�÷���ʵ��ʵ����
			creditdata = (CreditDataHelper)Class.forName(name).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
		return creditdata;
	}

}
