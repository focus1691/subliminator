package com.psychotechnology.Controller;

public class Validation {

	public static boolean isMoreThanThreeChars(String message) {
		if (message.length() < 3)
			return false;
		return true;
	}
}
