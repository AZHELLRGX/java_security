package edu.ctgu.base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author AZHELL E-mail:r776379772@Gmail.com
 * @version 创建时间：2017年8月11日 上午10:36:51
 * @ClassDescription 类说明:测试base64的常规使用方式
 */
public class Base64Test {
	private static String s = "I Love Java";

	public static void main(String[] args) {
		// jdkBase64();
		// testBase64Util();
		//commonsCodeBase64();
		bouncyCastleBase64();
	}

	public static void jdkBase64() {
		// need to be imported \jre\lib\rt.jar manually if the java version is
		// 1.8.x
		try {
			BASE64Encoder encoder = new BASE64Encoder();
			String encode = encoder.encode(s.getBytes());
			System.out.println("encode:" + encode);

			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decode = decoder.decodeBuffer(encode);
			System.out.println("decode:" + new String(decode));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void commonsCodeBase64() {
		// org.apache.commons.codec.binary.Base64
		byte[] encodebytes = org.apache.commons.codec.binary.Base64.encodeBase64(s.getBytes());
		System.out.println("encode:" + new String(encodebytes));
		byte[] decode = org.apache.commons.codec.binary.Base64.decodeBase64(encodebytes);
		System.out.println("decode:" + new String(decode));
	}

	public static void bouncyCastleBase64() {
		// org.bouncycastle.util.encoders.Base64
		byte[] encodebytes = org.bouncycastle.util.encoders.Base64.encode(s.getBytes());
		System.out.println("encode:" + new String(encodebytes));
		byte[] decodebytes = org.bouncycastle.util.encoders.Base64.decode(encodebytes);
		System.out.println("decode:" + new String(decodebytes));
	}

	public static void testBase64Util() {
		// Test the base64 tool class
		try {
			String encode = Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
			System.out.println("encode:" + encode);
			byte[] decode = Base64.getDecoder().decode(encode);
			System.out.println("decode:" + new String(decode));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
