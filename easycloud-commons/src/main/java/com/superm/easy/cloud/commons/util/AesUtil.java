package com.superm.easy.cloud.commons.util;

import com.superm.easy.cloud.commons.exception.UnexpectedException;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.Security;
import java.util.Base64;
import java.util.Random;

/** 
 * @author hu.sheng
 * @since 20190425
 */
public class AesUtil {
	private static final String TRANS_CBC_PKCS5 = "AES/CBC/PKCS5Padding";
	private static final String TRANS_CBC_NO = "AES/CBC/NoPadding";
	private static final byte[] DEFAULT_IV = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	public static String decryptHexWithCBCNoPadding(String src, String key, String ivStr) {
		byte[] encrypted1 = hex2byte(src);
		return decryptWithCBCNoPadding(encrypted1, key, ivStr);
	}
	
	public static String decryptWithCBCNoPadding(byte[] src, String key, String ivStr) {
		try {  
			byte[] raw = key.getBytes();  
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");  
			Cipher cipher = Cipher.getInstance(TRANS_CBC_NO);  
			byte[] ivb = DEFAULT_IV;
			if(!StringUtils.isEmpty(ivStr)) {
				ivb = ivStr.getBytes();
			}
			IvParameterSpec iv = new IvParameterSpec(ivb); 
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] original = cipher.doFinal(src);  
			String originalString = new String(original,Charset.forName("utf-8"));  
			return originalString;
		} catch (Exception ex) {  
			ex.printStackTrace();
			return null;  
		}  
	}	
	
	public static String decrypt(String src, String key){
		try {
			// 判断Key是否正确
			if (key == null) {
				System.out.print("Key为空null");
				return null;
			}
			// 判断Key是否为16位或32位
			if (key.length() != 16 && key.length() != 32) {
				System.out.print("Key长度不是16位或32位");
				return null;
			}
			byte[] raw = key.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] encrypted1 = hex2byte(src);
			try {
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original);
				return originalString;
			} catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
		} catch (Exception ex) {
			
			System.out.println(ex.toString());
			return null;
		}
	}

	public static String encryptWithCBCNoPaddingToBase64(String src, String key, String ivstr) {
		byte[] rs = encryptWithCBCNoPadding(src, key, ivstr);
		return Base64.getEncoder().encodeToString(rs);
	}

	public static byte[] encryptWithCBCNoPadding(String src, String key, String ivstr) {
		return encryptWithoutCipherProvider(src.getBytes(), key.getBytes(), str2Bytes(ivstr, DEFAULT_IV), 
						TRANS_CBC_NO);
	}
	
	public static String encryptCBC2Hex(String src, String key, String ivstr) {
		byte[] encrypted = encryptWithoutCipherProvider(src.getBytes(), key.getBytes(), 
						str2Bytes(ivstr, DEFAULT_IV), TRANS_CBC_PKCS5);
		return byte2hex(encrypted);
	}
	
	private static byte[] str2Bytes(String str, byte[] defaultValue) {
		if(str == null) {
			return defaultValue;
		}
		return str.getBytes();
	}
	
	private static byte[] encryptWithoutCipherProvider(byte[] src, byte[] key, byte[] iv, String transformation) {
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			IvParameterSpec ivP = new IvParameterSpec(iv);
			Cipher cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivP);
			return cipher.doFinal(src);
		}catch(Exception e) {
			throw new UnexpectedException("encrypt with " + transformation +" error!", e);
		}
	}
	
	public static String encrypt(String src, String key) {
		String ret = "";
		try {
			if (StringUtils.isEmpty(src)) {
				throw new UnexpectedException("");
			}
			// 判断Key是否为16位或32位
			if (key.length() != 16 && key.length() != 32) {
				System.out.print("Key长度不是16位或32位");
				return null;
			}
			byte[] raw = key.getBytes("ASCII");
			
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Security.addProvider(new BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
	
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(src.getBytes());
			ret = AesUtil.byte2hex(encrypted);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UnexpectedException("");
		}
		return ret;
	}
	
	public static byte[] hex2byte(String strhex) {
		if (strhex == null) {
			return null;
		}
		int l = strhex.length();
		if (l % 2 == 1) {
			return null;
		}
		byte[] b = new byte[l / 2];
		for (int i = 0; i != l / 2; i++) {
			b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
					16);
		}
		return b;
	}

	
    public static String byte2hex(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        String tmp = "";
        for (int n = 0; n < b.length; n++) {
            // 整数转成十六进制表示
            tmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
        }
        return sb.toString().toUpperCase();
    }
    
    /** 
     * 生成随即密码 
     * @param pwdlen 生成的密码的总长度 
     * @return  密码的字符串 
     */  
    public static String genRandomNum(int pwdlen){  
	    //35是因为数组是从0开始的，26个字母+10个数字  
	    final int  maxNum = 36;  
	    int i;  //生成的随机数  
	    int count = 0;
	    char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',  
	    		'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',  
	    		'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };  
	       
	    StringBuffer pwd = new StringBuffer("");  
	    Random r = new Random();  
	    while(count < pwdlen){  
	    	//生成随机数，取绝对值，防止生成负数,生成的数最大为36-1 
	    	i = Math.abs(r.nextInt(maxNum));
	    	if (i >= 0 && i < str.length) {  
	    		pwd.append(str[i]);  
	    		count ++;  
	    	}  
	    }  
	       
	    return pwd.toString();  
    }  
}
