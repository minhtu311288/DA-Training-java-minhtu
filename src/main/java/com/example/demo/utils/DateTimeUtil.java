package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class DateTimeUtil {
	private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";
	public static String datetimeformat(Date dateInString) throws ParseException {

		SimpleDateFormat simpledatetime = new SimpleDateFormat(DATE_FORMAT);
		
		DateTime dt = new DateTime(dateInString);
		
		DateTimeZone dtZone = DateTimeZone.forID("Asia/Bangkok");
		
		DateTime datetime = dt.withZone(dtZone);
		
		Date dateLocal = datetime.toLocalDateTime().toDate();
		
		String timeformat = simpledatetime.format(dateLocal);

         return timeformat;
    }

}
