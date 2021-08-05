package com.speedobook.util;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class SpeedoEncoder {
	private SpeedoEncoder() {
	}

	public static String encode(String value) {
		Encoder encoder = Base64.getEncoder();
		byte[] bytes = encoder.encode(value.getBytes());
		return new String (bytes);
	}
	
	public static String decoder(String value) {
		Decoder decoder = Base64.getDecoder();
		byte[] debytes = decoder.decode(value.getBytes());
		return new String(debytes);
	}
}
