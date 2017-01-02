package service.Account.Login;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.concurrent.SynchronousQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import data.dao.AccountDao;
import data.dao.impl.AccountDaoImpl;
import service.Account.help.md5;
import service.picture.Picture;

public class LoginServiceImpl implements LoginService{

	private AccountDao accountDao;
	
	public LoginServiceImpl(){
		
		accountDao = AccountDaoImpl.getInstance();
	}
	@Override
	public boolean check(String id, String password) throws RemoteException{
		
		String pass = md5.getMD5(password);
		
		return accountDao.check(id,pass);//��¼ʱ�ȶԵ��Ǽ���֮����ַ���
	}
	
	@Override
	public String getType(String ID) throws RemoteException {
		
		if("".equals(ID)||ID==null){
			System.out.println(6666);
			return "";
		}
		
		if("666".equals(ID)){
			return "��վ������Ա";
		}else if(ID.matches("[0-9]*")){
			
			if(ID.length()==7){
				//IDȫ���ֲ���Ϊ7λ
				return "�ͻ�";
			}else if(ID.length() == 6){
				if(ID.charAt(0)=='1'){
					//6λ���ֵ�ID�����ҿ�ͷ����Ϊ1
					return "�Ƶ깤����Ա";
				}else if(ID.charAt(0)=='2'){
					///6λ���ֵ�ID,���ҿ�ͷ����Ϊ2
					return "��վӪ����Ա";
				}
			}
			
		}
		return "";
	}
	
	@Override
	public byte[] getClientPicture(String clientID) throws RemoteException {
		
		return Picture.getClientPicture(clientID);
	}
    
    
}
