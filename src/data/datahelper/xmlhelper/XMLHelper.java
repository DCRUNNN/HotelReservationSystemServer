package data.datahelper.xmlhelper;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLHelper {

	/**
	 * @param filePath xml�ļ���·��
	 * @param nodeName Ҫ�ҵĽڵ������
	 * @return �����ļ��µĸ��ڵ�����nodeName������
	 * */
	public static String getClass(String filePath,String nodeName){
		
		String name = null;
		try{
	        File f = new File(filePath);
	        DocumentBuilder db = null;
	        db = DocumentBuilderFactory.newInstance().newDocumentBuilder();//�õ�documentbuilder��ʵ��
	        
	        Document d = db.parse(f);
	        NodeList nodelist = d.getDocumentElement().getChildNodes();//�õ���Ԫ���������Ԫ���б�
	        for(int i=0;i<nodelist.getLength();i++){
	        	//�����ӽڵ�
	        	Node node = nodelist.item(i);
	        	if(nodeName.equals(node.getNodeName())){
	        		//�ҵ��ڵ���Ϊ"class"�Ľڵ�
	        		name = node.getTextContent();
	        	}
	        }
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		
		return name;
	}
}
