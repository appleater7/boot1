package com.practice.boot1.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAEncoder {
	private static final String ENCODE_TYPE = "SHA-256";
	private static final String CHAR_SET = "UTF-8";
	private static final String SALT = "OSF";

	public static String sha256(String msg) {
		try {
			MessageDigest md = MessageDigest.getInstance("ENCODE_TYPE");
			md.update(msg.getBytes());
			return md.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
