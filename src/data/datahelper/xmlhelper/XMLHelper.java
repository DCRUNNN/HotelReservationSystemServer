package data.datahelper.xmlhelper;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLHelper {

	/**
	 * @param filePath xml文件的路径
	 * @param nodeName 要找的节点的名称
	 * @return 返回文件下的根节点下面nodeName的内容
	 * */
	public static String getClass(String filePath,String nodeName){
		
		String name = null;
		try{
	        File f = new File(filePath);
	        DocumentBuilder db = null;
	        db = DocumentBuilderFactory.newInstance().newDocumentBuilder();//得到documentbuilder的实例
	        
	        Document d = db.parse(f);
	        NodeList nodelist = d.getDocumentElement().getChildNodes();//得到根元素下面的子元素列表
	        for(int i=0;i<nodelist.getLength();i++){
	        	//遍历子节点
	        	Node node = nodelist.item(i);
	        	if(nodeName.equals(node.getNodeName())){
	        		//找到节点名为"class"的节点
	        		name = node.getTextContent();
	        	}
	        }
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		
		return name;
	}
}
