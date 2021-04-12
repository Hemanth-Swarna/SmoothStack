package com.ss.dayfive.datetimeapi;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import org.junit.Test;

/**
 * @author heman
 *
 */
public class DateTimeApiTest {
	
	@Test
	public void testMonthLength() {
		Month month = Month.FEBRUARY;
		int year = 2008;
		assertTrue(DateTimeApi.monthLength(year)[1] == (month.length(LocalDate.ofYearDay(year, 1).isLeapYear())));
	}
	
//	@Test
//	public void testMondaysInMonth() {
//		LocalDate[] mondays = DateTimeApi.mondaysInMonth((Month.APRIL));
//        assertArrayEquals(mondays, new LocalDate[] {
//                LocalDate.of(2021, 4, 26),
//                LocalDate.of(2021, 4, 19),
//                LocalDate.of(2021, 4, 12),
//                LocalDate.of(2021, 4, 5),
//                null});
//	}
	
	@Test
	public void testIsItFridayTheThriteenth() {
		assertTrue(DateTimeApi.isItFridayTheThirteenth(LocalDate.of(2021, 8, 13)));
		assertFalse(DateTimeApi.isItFridayTheThirteenth(LocalDate.of(2021, 6, 13)));
	}
}
