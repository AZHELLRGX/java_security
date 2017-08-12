package edu.ctgu.md;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;

/**
 * @author AZHELL E-mail:r776379772@Gmail.com
 * @version ����ʱ�䣺2017��8��12�� ����10:36:24
 * @ClassDescription ��˵��:������ϢժҪ�㷨������md��ϢժҪ�㷨
 */
public class MDTest {
	private static String s = "I love java";

	public static void main(String[] args) {
		testMd5();
		testMd2();
		testBcMd4();
	}

	// test jdk md5
	public static void testMd5() {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] md5bytes = digest.digest(s.getBytes());
			// Convert to 16 digits
			System.out.println(Hex.encodeHexString(md5bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	// test jdk md2
	public static void testMd2() {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD2");
			byte[] md2bytes = digest.digest(s.getBytes());
			// Convert to 16 digits
			System.out.println(Hex.encodeHexString(md2bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	// test md4 (jdk not supportted md4,readsers can test it)
	public static void testBcMd4() {
		Digest digest = new MD4Digest();
		digest.update(s.getBytes(), 0, s.getBytes().length);
		byte[] md4Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md4Bytes, 0);
		System.out.println(Hex.encodeHexString(md4Bytes));
	}
	
	// if u interested in bouncycastle md2 and md5,u can code them by yourself,they just like md4.
}
