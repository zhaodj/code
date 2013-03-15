package org.zhaodj.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileHasher {

	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
			'b', 'c', 'd', 'e', 'f' };

	public static String hash(String algorithm, String filepath) throws NoSuchAlgorithmException,
			IOException {
		MessageDigest md = MessageDigest.getInstance(algorithm);
		InputStream is = new FileInputStream(filepath);
		try {
			int numRead = 0;
			byte[] buffer = new byte[1024];
			while ((numRead = is.read(buffer)) > 0) {
				md.update(buffer, 0, numRead);
			}
		} finally {
			is.close();
		}
		return new String(encodeHex(md.digest()));
	}

	public static char[] encodeHex(byte[] data) {

		int l = data.length;

		char[] out = new char[l << 1];

		// two characters form the hex value.
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}

		return out;
	}

	public static void test(String algorithm, String filepath, int times)
			throws NoSuchAlgorithmException, IOException {
		long begin = System.nanoTime();
		for (int i = 0; i < times; i++) {
			hash(algorithm, filepath);
		}
		System.out.println(algorithm + ":" + (System.nanoTime() - begin));
	}

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		String file = "/home/zhaodj/图片/照片/IMG_3643.JPG";
		System.out.println("file:" + file);
		test("MD5", file, 1000);
		test("SHA1", file, 1000);
		file = "/home/zhaodj/图片/照片/ada.jpg";
		System.out.println("file:" + file);
		test("MD5", file, 1000);
		test("SHA1", file, 1000);
	}

}
