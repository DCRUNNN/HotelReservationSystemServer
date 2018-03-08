package service.picture;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Picture {


	/**
	 * @param clientID �ͻ����
	 * @return ���ؿͻ���ͼƬ��byte���飬�����ڵĻ�����null
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
	 * ��һ���ļ���ת��ΪFileInputStream,��ת��Ϊbyte[] 
	 * @param filePath �ļ�·��
	 * @return �ļ�·����Ӧ�ļ��� byte����
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
     * @param picture ͼƬ����
     * @param clientID �ͻ����
     * @return �ɹ�����true
     * 
     * */
    public static boolean uploadPicture(byte[] picture,String clientID){
    	
    	String filePath1 = "./picture/clientpicture/"+clientID;
		String filePath2 = "./picture/clientpicture/"+clientID+"/"+clientID;
		File f1 = new File(filePath1);
		File f2 = new File(filePath2);
		if(!f1.exists()){
			//�ļ�Ŀ¼�����ڵĻ�
			f1.mkdirs();
			try {
				f2.createNewFile();
			    FileOutputStream fos = new FileOutputStream(f2);
			    fos.write(picture);
			    fos.close();//��ͼƬд���ļ���
			    return true;
			} catch (IOException e) {

				e.printStackTrace();
			}
		}else{
			if(f2.exists()){
				//�����ļ�����ɾ�����½�
				f2.delete();
			}
			
			try {
				f2.createNewFile();
				FileOutputStream fos = new FileOutputStream(f2);
				fos.write(picture);
				fos.close();//��ͼƬд���ļ���
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
    		//�ļ�Ŀ¼������
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
    		//�ļ�Ŀ¼����
    		if(f2.exists()){
    			f2.delete();//�Ѿ�����ͼƬ�Ļ�����ɾ��
    		}
    		
    		try {
				f2.createNewFile();
				FileOutputStream fos = new FileOutputStream(f2);
				fos.write(b);
				fos.close();//��ͼƬд���ļ���
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
    		//Ŀ¼������
    		return null;
    	}else{
    		if(!f2.exists()){
    			//û����Ƭ
    			return null;
    		}
    	}
    	
    	return fileToByte(filePath2);
    }

    /**
     * @param b ͼƬ����
     * @param hotelID �Ƶ���
     * @return �����Ƿ��޸ĳɹ�
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
	 * @param b ͼƬ��byte����
	 * @param clientID �ͻ����
	 * @return �����Ƿ��޸ĳɹ�
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
