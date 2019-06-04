package com.superm.easy.cloud.commons.util;


public class HMACSHA1 {
	
	public static byte[] getHmacSHA1( String data,String key){
		byte[] ipadArray = new byte[64];
		byte[] opadArray = new byte[64];
		byte[] keyArray = new byte[64];
		int ex = key.length();
		SHA1 sha1= new SHA1();
		if (key.length() > 64) {
			byte[] temp = sha1.getDigestOfBytes(key.getBytes());
			ex = temp.length;
			for (int i = 0; i < ex; i++) {
				keyArray[i] = temp[i];
			}
		}else{
			byte[] temp = key.getBytes();
			for (int i = 0; i < temp.length; i++) {
				keyArray[i] = temp[i];
			}
		}
		for (int i = ex; i < 64; i++) {
			keyArray[i] = 0;
		}
		for (int j = 0; j < 64; j++) {
			ipadArray[j] = (byte) (keyArray[j] ^ 0x36);
			opadArray[j] = (byte) (keyArray[j] ^ 0x5C);
		}
		byte[] tempResult = sha1.getDigestOfBytes(join(ipadArray,data.getBytes()));
		
		return sha1.getDigestOfBytes(join(opadArray,tempResult));
	}
	
	private static byte[] join(byte[] b1,byte[] b2){
		int length = b1.length + b2.length;
		byte[] newer = new byte[length];
		for (int i = 0; i < b1.length; i++) {
			newer[i] = b1[i];
		}
		for (int i = 0; i < b2.length; i++) {
			newer[i+b1.length] = b2[i];
		}
		return newer;
	}
	
	// 将字节数组转换为十六进制字符
	public static String byteArrayToHexString(byte[] bytearray) {
		String strDigest = "";

		for (int i = 0; i < bytearray.length; i++) {
			strDigest += byteToHexString(bytearray[i]);
		}

		return strDigest;
	}
	// 将字节转换为十六进制字符
	private static String byteToHexString(byte ib) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
				'b', 'c', 'd', 'e', 'f' };
		char[] ob = new char[2];
		ob[0] = Digit[(ib >>> 4) & 0X0F];
		ob[1] = Digit[ib & 0X0F];

		String s = new String(ob);

		return s;
	}
}
