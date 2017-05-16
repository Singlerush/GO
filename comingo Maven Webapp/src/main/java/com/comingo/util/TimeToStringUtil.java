package com.comingo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeToStringUtil {
	public static String timeToString(Date datetime){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(datetime);
	}
}
