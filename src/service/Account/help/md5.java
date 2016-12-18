
package service.Account.help;

import java.security.*;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.logging.Level;
import java.util.logging.Logger;
public class md5{
	
    public static String getMD5(String str) {
        String s=str;
	if(s==null){
		return "";
	}else{
		String value = null;
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			}catch (NoSuchAlgorithmException ex) {
				Logger.getLogger(md5.class.getName()).log(Level.SEVERE, null, ex);
				}
		      Encoder baseEncoder = Base64.getEncoder();
		try {
			value = new String(baseEncoder.encode(md5.digest(s.getBytes("utf-8"))));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return value;
		}
	}   
    
}