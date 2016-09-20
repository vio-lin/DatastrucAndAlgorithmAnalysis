package com.violin.qlcode;

import java.awt.Image;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//这边是这样了
public class Md5加密 {
	
	public static void main(String[] args) {
		try {
			 //信息摘要器  
			MessageDigest digest = MessageDigest.getInstance("md5");
			String password = "123456";
			byte[] result =digest.digest(password.getBytes());
			StringBuffer buffer = new StringBuffer();
			for(byte b:result){
				//与运算
				int number = b&0xff;
				String str = Integer.toHexString(number);
//				System.out.println(str);
				if(str.length()==1){
					buffer.append("0");
				}
				buffer.append(str);
			}
			System.out.println(buffer);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
