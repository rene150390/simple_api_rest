package com.api.rest.gas.station.rene.utils;

public class EncodeUtils {
	
	public static String removeUTF8(String s) {
		s = s.replace("﻿", "");
		s = s.replace("á", "�");
	    s = s.replace("é", "�");
	    s = s.replace("í", "�");
	    s = s.replace("ó", "�");
	    s = s.replace("ú", "�");
		s = s.replace("\uFEFF", "");
	    s = s.replace("\ufeff", "");
	    return s;
	}
	
}