package com.generic_Utilities;

import java.util.Date;

public class Java_Utility {

	public static String getCurrentDate() {
		Date date = new Date();
		return date.toString().replace(' ', '_').replace(':', '_');
	}
}
