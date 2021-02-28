package com.api.rest.gas.station.rene.utils;

public class EncodeUtils {
	
	public static String removeUTF8(String s) {
		s = s.replace("ï»¿", "");
		s = s.replace("Ã¡", "á");
	    s = s.replace("Ã©", "é");
	    s = s.replace("Ã­", "í");
	    s = s.replace("Ã³", "ó");
	    s = s.replace("Ãº", "ú");
		s = s.replace("\uFEFF", "");
	    s = s.replace("\ufeff", "");
	    return s;
	}
	
}