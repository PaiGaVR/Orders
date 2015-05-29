package com.example.util;

public class CheckUtil {
	public static boolean isNull(String s){
		if (null == s){
			return true;
		} else if ("" == s.trim()) {
			return true;
		}
		
		return false;
	}
}
