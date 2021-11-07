package com.stone.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

	public String encrypt(String str) {
		String result = "";

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256"); // 암호화 방식
			md.update(str.getBytes());

			byte byteData[] = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i=0; i<byteData.length; i++) {
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}

			result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return result;
	}
}

// https://blog.naver.com/chozza2019/222072533770