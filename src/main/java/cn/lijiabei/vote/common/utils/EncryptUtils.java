package cn.lijiabei.vote.common.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 加密编码工具类
 * 
 * @author LiYishi
 */
public class EncryptUtils {

	private static Logger logger = LoggerFactory.getLogger(EncryptUtils.class);

	/**
	 * 用MD5算法进行加密
	 * 
	 * @param str 需要加密的字符串
	 * @return MD5加密后的结果
	 */
	public static String encodeMD5(String str) {
		return encode(str, "MD5");
	}

	/**
	 * 用SHA算法进行加密
	 * 
	 * @param str 需要加密的字符串
	 * @return SHA加密后的结果
	 */
	public static String encodeSHA(String str) {
		return encode(str, "SHA");
	}

	/**
	 * 用base64算法进行加密
	 * 
	 * @param str 需要加密的字符串
	 * @return base64加密后的结果
	 */
	public static String encodeBase64(String str) {
		return new String(Base64.encodeBase64(str.getBytes()));
	}

	/**
	 * 用base64算法进行解密
	 * 
	 * @param str 需要解密的字符串
	 * @return base64解密后的结果
	 * @throws IOException
	 */
	public static String decodeBase64(String str) {
		return new String(Base64.decodeBase64(str.getBytes()));
	}

	public static String encode(String str, String method) {
		MessageDigest md = null;
		String dstr = null;
		try {
			md = MessageDigest.getInstance(method);
			md.update(str.getBytes());
			dstr = byteArrayToHex(md.digest());
		} catch (NoSuchAlgorithmException e) {
			logger.error("call EncryptUtils.encode error", e);
		}

		return dstr;
	}

	public static String byteArrayToHex(byte[] byteArray) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		char[] resultCharArray = new char[byteArray.length * 2];
		int index = 0;

		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b & 0xf];
		}
		return new String(resultCharArray);
	}

}
