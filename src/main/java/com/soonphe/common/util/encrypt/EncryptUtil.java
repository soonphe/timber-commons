package com.soonphe.common.util.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类,支持MD5、SHA
 *
 * @author soonphe
 * @since 1.0
 */
public class EncryptUtil {

	private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	/**
	 * MD5加密
	 * @param inputText
	 * @return
	 */
	public static String getMd5(String inputText) {
		return encrypt(inputText, "md5");
	}

	/**
	 * sha加密 
	 * @param inputText
	 * @return
	 */
	public static String getSha(String inputText) {
		return encrypt(inputText, "sha-1");
	}

	/** 
	 * md5或者sha-1加密 
	 *  
	 * @param inputText 要加密的内容
	 * @param algorithmName 加密算法名称：md5或者sha-1，不区分大小写
	 * @return 
	 */
	private static String encrypt(String inputText, String algorithmName) {
		if (inputText == null || "".equals(inputText.trim())) {
			throw new IllegalArgumentException("请输入要加密的内容");
		}
		if (algorithmName == null || "".equals(algorithmName.trim())) {
			algorithmName = "md5";
		}
		try {
			MessageDigest m = MessageDigest.getInstance(algorithmName);
			m.update(inputText.getBytes("UTF8"));
			byte s[] = m.digest();
			return hex(s);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回十六进制字符串1
	 * @param arr
	 * @return
	 */
	private static String hex(byte[] arr) {
		StringBuilder sb = new StringBuilder();
		for (byte anArr : arr) {
			sb.append(Integer.toHexString((anArr & 0xFF) | 0x100), 1, 3);
		}
		return sb.toString();
	}

	/**
	 * 返回十六进制字符串2
	 * @param bytes
	 * @return
	 */
	private static String getFormattedText(byte[] bytes) {
		int len = bytes.length;
		StringBuilder buf = new StringBuilder(len * 2);
		for (int j = 0; j < len; j++) {
			buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
		}
		return buf.toString();
	}

}