package com.shabaton.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shabaton.Shabaton;

public class ShabatonUnitTests {

	@Test
	public void testEngday_week() {
		int dayOfWeek;
		dayOfWeek = Shabaton.engday_week(2017, 7, 14); // July 14, 2017 is a Friday; should return 6
		assertTrue(dayOfWeek == 6);
		
		dayOfWeek = Shabaton.engday_week(2017, 7, 1); // July 1, 2017 - Saturday
		assertTrue(dayOfWeek == 0);
		
		dayOfWeek = Shabaton.engday_week(2017, 7, 2); // July 2, 2017 - Sunday
		assertTrue(dayOfWeek == 1);
		
		dayOfWeek = Shabaton.engday_week(2017, 7, 3); // July 3, 2017 - Monday
		assertTrue(dayOfWeek == 2);

		dayOfWeek = Shabaton.engday_week(2017, 7, 4); // July 4, 2017 - Tuesday
		assertTrue(dayOfWeek == 3);

		dayOfWeek = Shabaton.engday_week(2017, 7, 5); // July 5, 2017 - Wednesday
		assertTrue(dayOfWeek == 4);
		
		dayOfWeek = Shabaton.engday_week(2017, 7, 6); // July 6, 2017 - Thursday
		assertTrue(dayOfWeek == 5);

		dayOfWeek = Shabaton.engday_week(2017, 7, 7); // July 7, 2017 - Thursday
		assertTrue(dayOfWeek == 6);

	}
	
	@Test
	public void testEngday_week1() {		
		int dayOfWeek1 = Shabaton.engday_week(2017, 7, 15); // July 15, 2017 is a Saturday; should return 0
		System.out.println("Day of the week is: " + dayOfWeek1);
		assertTrue(dayOfWeek1 == 0);
	}
	

	@Test
	public void testEngday_year() {
		int dayOfYear;
		dayOfYear = Shabaton.engday_year(2017, 1, 1);
		assertTrue(dayOfYear == 1);
		//System.out.println("Day of year is: " + dayOfYear);
		//fail("Not yet implemented");
		
		dayOfYear = Shabaton.engday_year(2000, 3, 1);
		assertTrue(dayOfYear == 61);
		//System.out.println("Day of year is: " + dayOfYear);

		dayOfYear = Shabaton.engday_year(20017, 12, 31);
		assertTrue(dayOfYear == 365);
	}
	
	@Test
	public void testEngday_year2() {
		int dayOfYear2 = Shabaton.engday_year(2000, 3, 1);
		System.out.println("Day of year is: " + dayOfYear2);
		assertTrue(dayOfYear2 == 61);
	}
	
	@Test
	public void testMult_or() {
		int leapYear = Shabaton.mult_or(0);
		assertTrue(leapYear == 1);
		leapYear = Shabaton.mult_or(1);
		assertTrue(leapYear == 0);
		leapYear = Shabaton.mult_or(2);
		assertTrue(leapYear == 0);
		leapYear = Shabaton.mult_or(3);
		assertTrue(leapYear == 1);
		leapYear = Shabaton.mult_or(4);
		assertTrue(leapYear == 0);
		leapYear = Shabaton.mult_or(5);
		assertTrue(leapYear == 0);
		leapYear = Shabaton.mult_or(6);
		assertTrue(leapYear == 1);
		leapYear = Shabaton.mult_or(7);
		assertTrue(leapYear == 0);
		leapYear = Shabaton.mult_or(8);
		assertTrue(leapYear == 1);
		leapYear = Shabaton.mult_or(9);
		assertTrue(leapYear == 0);
		leapYear = Shabaton.mult_or(10);
		assertTrue(leapYear == 0);
		leapYear = Shabaton.mult_or(11);
		assertTrue(leapYear == 1);
		leapYear = Shabaton.mult_or(12);
		assertTrue(leapYear == 0);
		leapYear = Shabaton.mult_or(13);
		assertTrue(leapYear == 0);
		leapYear = Shabaton.mult_or(14);
		assertTrue(leapYear == 1);
		leapYear = Shabaton.mult_or(15);
		assertTrue(leapYear == 0);
		leapYear = Shabaton.mult_or(16);
		assertTrue(leapYear == 0);
		leapYear = Shabaton.mult_or(17);
		assertTrue(leapYear == 1);
		leapYear = Shabaton.mult_or(18);
		assertTrue(leapYear == 0);		
	}
	
	@Test
	public void testClassify_year() {
	   int classifyYear; 
	   classifyYear = Shabaton.classify_year(5777);
	   assertTrue (classifyYear == 2);
	   
	   classifyYear = Shabaton.classify_year(5778);
	   assertTrue (classifyYear == 5);
	   
	   classifyYear = Shabaton.classify_year(5779);
	   assertTrue (classifyYear == 8);

	   classifyYear = Shabaton.classify_year(5780);
	   assertTrue (classifyYear == 1);

	   classifyYear = Shabaton.classify_year(5781);
	   assertTrue (classifyYear == 7);

	   classifyYear = Shabaton.classify_year(5782);
	   assertTrue (classifyYear == 10);

	   classifyYear = Shabaton.classify_year(5783);
	   assertTrue (classifyYear == 1);

	   classifyYear = Shabaton.classify_year(5784);
	   assertTrue (classifyYear == 14);

	   classifyYear = Shabaton.classify_year(5785);
	   assertTrue (classifyYear == 4);

	   classifyYear = Shabaton.classify_year(5786);
	   assertTrue (classifyYear == 3);

	   classifyYear = Shabaton.classify_year(5787);
	   assertTrue (classifyYear == 13);

	   classifyYear = Shabaton.classify_year(5788);
	   assertTrue (classifyYear == 6);

	   classifyYear = Shabaton.classify_year(5789);
	   assertTrue (classifyYear == 5);

	   classifyYear = Shabaton.classify_year(5790);
	   assertTrue (classifyYear == 9);

	   classifyYear = Shabaton.classify_year(5791);
	   assertTrue (classifyYear == 6);

	   classifyYear = Shabaton.classify_year(5792);
	   assertTrue (classifyYear == 5);

	   classifyYear = Shabaton.classify_year(5793);
	   assertTrue (classifyYear == 1);

	   classifyYear = Shabaton.classify_year(5794);
	   assertTrue (classifyYear == 6);

	   classifyYear = Shabaton.classify_year(5795);
	   assertTrue (classifyYear == 11);
	}
	
	@Test
	public void testIsLeapYear() {
		int isLeapYear;
		isLeapYear = Shabaton.isLeapYear(2000);
		assertTrue(isLeapYear == 1);
		
		isLeapYear = Shabaton.isLeapYear(2001);
		assertTrue(isLeapYear == 0);
		
		isLeapYear = Shabaton.isLeapYear(2002);
		assertTrue(isLeapYear == 0);
		
		isLeapYear = Shabaton.isLeapYear(2003);
		assertTrue(isLeapYear == 0);
		
		isLeapYear = Shabaton.isLeapYear(2004);
		assertTrue(isLeapYear == 1);




		//fail("Not yet implemented");
	}
	
	@Test
	public void testConvertheb_eng() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testHebday_year() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testConvert_num_engdate() {
		fail("Not yet implemented");
	}
}
