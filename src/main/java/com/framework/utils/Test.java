package com.framework.utils;

import java.util.Base64;

public class Test {

	public static void main(String[] args) {
		String encodedstring = Base64.getEncoder().encodeToString("Shivani".getBytes());
		System.out.println(encodedstring);
		String decodestring = new String(Base64.getDecoder().decode("U2hpdmFuaQ==".getBytes()));
		System.out.println(decodestring);

	}

}
