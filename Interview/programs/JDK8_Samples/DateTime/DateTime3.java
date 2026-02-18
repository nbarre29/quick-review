package demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * http://docs.oracle.com/javase/tutorial/datetime/iso/date.html
 * 
 * Date Classes:
 * The Date-Time API provides four classes that deal exclusively
 * with date information, without respect to time or time zone. The use of these
 * classes are suggested by the class names: LocalDate, YearMonth, MonthDay, and
 * Year.
 *
 */
public class DateTime3 {

	public static void main(String[] args) {
		
		/*
		 * A LocalDate represents a year-month-day in the ISO calendar and is
		 * useful for representing a date without a time. You might use a
		 * LocalDate to track a significant event, such as a birth date or
		 * wedding date. The following examples use the 'of' and 'with' methods
		 * to create instances of LocalDate:
		 */
		LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20);
		LocalDate nextWed = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
		System.out.println(date);
		System.out.println(nextWed);
		
		/*
		 * In addition to the usual methods, the LocalDate class offers getter
		 * methods for obtaining information about a given date. The
		 * getDayOfWeek method returns the day of the week that a particular
		 * date falls on. For example, the following line of code returns
		 * "MONDAY":
		 */
		DayOfWeek dotw = LocalDate.of(2012, Month.JULY, 9).getDayOfWeek();
		System.out.println(dotw);
		
		/*
		 * The following example uses a TemporalAdjuster to retrieve the first
		 * Wednesday after a specific date.
		 */
		LocalDate date1 = LocalDate.of(2000, Month.NOVEMBER, 20);
		TemporalAdjuster adj = TemporalAdjusters.next(DayOfWeek.WEDNESDAY);
		LocalDate nextWed1 = date1.with(adj);
		System.out.printf("For the date of %s, the next Wednesday is %s.%n",
		                  date1, nextWed1);
		
		System.out.println("*********************************************************");
		
		/*
		 * The YearMonth class represents the month of a specific year. The
		 * following example uses the YearMonth.lengthOfMonth() method to
		 * determine the number of days for several year and month combinations.
		 */
		YearMonth date2 = YearMonth.now();
		System.out.printf("%s: %d%n", date2, date2.lengthOfMonth());

		YearMonth date3 = YearMonth.of(2010, Month.FEBRUARY);
		System.out.printf("%s: %d%n", date3, date3.lengthOfMonth());

		YearMonth date4 = YearMonth.of(2012, Month.FEBRUARY);
		System.out.printf("%s: %d%n", date4, date4.lengthOfMonth());
		System.out.println("*********************************************************");
		
		
		/*
		 * The MonthDay class represents the day of a particular month, such as
		 * New Year's Day on January 1.
		 * 
		 * The following example uses the MonthDay.isValidYear method to
		 * determine if February 29 is valid for the year 2010. The call returns
		 * false, confirming that 2010 is not a leap year.
		 */
		MonthDay date5 = MonthDay.of(Month.FEBRUARY, 29);
		boolean validLeapYear = date5.isValidYear(2010);
		System.out.println(validLeapYear);
		System.out.println("*********************************************************");
		
		/*
		 * The Year class represents a year. The following example uses the
		 * Year.isLeap method to determine if the given year is a leap year. The
		 * call returns true, confirming that 2012 is a leap year.
		 */
		boolean validLeapYear1 = Year.of(2012).isLeap();
		System.out.println(validLeapYear1);

	}

}
