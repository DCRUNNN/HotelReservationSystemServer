package service.picture;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Picture {


	/**
	 * @param clientID 客户编号
	 * @return 返回客户的图片的byte数组，不存在的话返回null
	 * */
	public static byte[] getClientPicture(String clientID){

		String filePath1 = "./picture/clientpicture/"+clientID;
		String filePath2= "./picture/clientpicture/"+clientID+"/"+clientID;
		
		File f1 = new File(filePath1);
		File f2 = new File(filePath2);
		
		if(!f1.exists()){
			return null;
		}else{
			if(!f2.exists()){
				return null;
			}
		}
		return fileToByte(filePath2);
	
	}
	
	/**
	 * 将一个文件先转换为FileInputStream,再转换为byte[] 
	 * @param filePath 文件路径
	 * @return 文件路径对应文件的 byte数组
	 * */
    private static byte[] fileToByte(String filePath){
    	
    	byte[] b = null;
    	try{
    		File file = new File(filePath);
    		b = new byte[(int)file.length()];
    		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(file));
    		bi.read(b);
    		bi.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return b;
    }
    
    /**
     * @param picture 图片数组
     * @param clientID 客户编号
     * @return 成功返回true
     * 
     * */
    public static boolean uploadPicture(byte[] picture,String clientID){
    	
    	String filePath1 = "./picture/clientpicture/"+clientID;
		String filePath2 = "./picture/clientpicture/"+clientID+"/"+clientID;
		File f1 = new File(filePath1);
		File f2 = new File(filePath2);
		if(!f1.exists()){
			//文件目录不存在的话
			f1.mkdirs();
			try {
				f2.createNewFile();
			    FileOutputStream fos = new FileOutputStream(f2);
			    fos.write(picture);
			    fos.close();//把图片写到文件里
			    return true;
			} catch (IOException e) {

				e.printStackTrace();
			}
		}else{
			if(f2.exists()){
				//存在文件，先删除再新建
				f2.delete();
			}
			
			try {
				f2.createNewFile();
				FileOutputStream fos = new FileOutputStream(f2);
				fos.write(picture);
				fos.close();//把图片写到文件里
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		return false;
	}

    public static boolean uploadHotelPicture(byte[] b,String hotelID){
    	
    	String filePath1 = "./picture/hotelpicture/"+hotelID;
    	String filePath2 = "./picture/hotelpicture/"+hotelID+"/"+hotelID;
    	File f1 = new File(filePath1);
    	File f2 = new File(filePath2);
    	if(!f1.exists()){
    		//文件目录不存在
    		f1.mkdirs();
    		try {
				f2.createNewFile();
				FileOutputStream fos = new FileOutputStream(f2);
				fos.write(b);
				fos.close();
				return true;
			} catch (IOException e) {
			
				e.printStackTrace();
			}
    		
    	}else{
    		//文件目录存在
    		if(f2.exists()){
    			f2.delete();//已经存在图片的话，先删除
    		}
    		
    		try {
				f2.createNewFile();
				FileOutputStream fos = new FileOutputStream(f2);
				fos.write(b);
				fos.close();//把图片写到文件里
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	return false;
    }
    
    public static byte[] getHotelPicture(String hotelID){
    	
    	String filePath1 = "./picture/hotelpicture/"+hotelID;
    	String filePath2 = "./picture/hotelpicture/"+hotelID+"/"+hotelID;
    	File f1 = new File(filePath1);
    	File f2 = new File(filePath2);
    	if(!f1.exists()){
    		//目录不存在
    		return null;
    	}else{
    		if(!f2.exists()){
    			//没有照片
    			return null;
    		}
    	}
    	
    	return fileToByte(filePath2);
    }

    /**
     * @param b 图片数组
     * @param hotelID 酒店编号
     * @return 返回是否修改成功
     * */
	public static boolean changeHotelPicture(byte[] b, String hotelID) {
		
		String filePath = "./picture/hotelpicture/"+hotelID+"/"+hotelID;
		File f = new File(filePath);
		if(f.exists()){
			f.delete();
			try {
				f.createNewFile();
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(b);
				fos.close();
				return true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * @param b 图片的byte数组
	 * @param clientID 客户编号
	 * @return 返回是否修改成功
	 * */
	public static boolean changeClientPicture(byte[] b,String clientID){
		
		String filePath = "./picture/clientpicture/"+clientID+"/"+clientID;
		File f = new File(filePath);
		if(f.exists()){
			f.delete();
			try {
				f.createNewFile();
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(b);
				fos.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return false;
	}
}
