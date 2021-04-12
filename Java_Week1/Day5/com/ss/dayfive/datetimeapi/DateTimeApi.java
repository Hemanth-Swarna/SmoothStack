/**
 * 
 */
package com.ss.dayfive.datetimeapi;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author heman
 *
 */
class DateTimeApi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Question1
		LocalDateTime datetime = LocalDateTime.now();
		System.out.println(datetime);

		// Question2
		LocalDate date = LocalDate.now();
		System.out.println(date.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));

		// Question3; ZoneId allows you to feed a region and get the time of that
		// particular area whereas ZoneOffset (a subclass of ZoneId) is focused on
		// showing the time differential between an intended region and UTC
		ZoneId zoneid = ZoneId.of("America/Los_Angeles");
		LocalTime time1 = LocalTime.now(zoneid);
		ZoneOffset zoneoffset = ZoneOffset.of("+02:00");
		System.out.println(time1);
		System.out.println(zoneoffset);

		// Question4; Using the "ofInstant" we can convert from ZonedDateTime to Instant
		// and we can go from Instant to ZoneDateTime with "atZone"
		ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.now(), zoneid);
		System.out.println(zdt);
		Instant instant = Instant.now();
		zdt = instant.atZone(zoneid);
		System.out.println(zdt);
		
		//Question5
		int year = 2008;
		monthLength(year);
		
		//Question6
		Month month = Month.APRIL;
		mondaysInMonth(month);
		
		//Question7
		LocalDate customdate = LocalDate.of(2021, 8, 13);
		System.out.println(isItFridayTheThirteenth(customdate));

	}
	
	static int[] monthLength(int year) {
		int[] months = new int[12];
		for(int i = 1; i <= months.length; i++) {
			months[i-1] = Month.of(i).length(LocalDate.ofYearDay(year, 1).isLeapYear());
			System.out.println(Month.of(i) + ": " + months[i-1]);
		}
		
		return months;
		
	}
	
	static LocalDate[] mondaysInMonth(Month month) {
		int year = LocalDate.now().getYear();
		LocalDate date = LocalDate.of(year, month, 1);
		LocalDate[] dates = new LocalDate[5];
		while(date.getDayOfMonth() < month.length(LocalDate.now().isLeapYear())) {
			int i=0;
			if(date.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
				dates[i] = date;
				System.out.println(date);
				i++;
			};
			date = date.plusDays(1);
		}
		
		
		return dates;
		
	}

	static boolean isItFridayTheThirteenth(LocalDate date) {
		if(date.getDayOfWeek().equals(DayOfWeek.FRIDAY) && date.getDayOfMonth() == 13) {
			return true;
		} else {
			return false;
		}
	}
}
