package demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * http://www.oracle.com/technetwork/articles/java/jf14-date-time-2125367.html
 *
 */
public class DateTime4 {

	public static void main(String[] args) {

		LocalDate oldDate = LocalDate.of(2000, Month.NOVEMBER, 20);
		System.out.println(oldDate);

		/*
		 * A Period represents a value such as “3 months and 1 day,” which is a
		 * distance on the timeline. This is in contrast to the other classes
		 * we’ve looked at so far, which have been points on the timeline.
		 */
		// 3 years, 2 months, 1 day
		Period period = Period.of(3, 2, 1);

		// You can modify the values of dates using periods
		LocalDate newDate = oldDate.plus(period);
		System.out.println(newDate);
		
		// Given a random date, how to find the date of the previous Thursday?
		LocalDate currentDate = LocalDate.of(2014, Month.JUNE, 27);
		System.out.printf("The previous Thursday is: %s%n",
				currentDate.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));
		
		

		ZonedDateTime currentDateTime = ZonedDateTime.now();
		System.out.println("ZonedDateTime: "+currentDateTime);

		LocalTime currentDateTime1 = LocalTime.now();
		System.out.println("LocalTime: " +currentDateTime1	);
		
		/*
		 * Question:  Which class would you use to store your birthday in
		 * years, months, days, seconds, and nanoseconds?
		 * 
		 * Answer:  Most likely you would use the LocalDateTime class. To take
		 * a particular time zone into account, you would use the ZonedDateTime
		 * class. Both classes track date and time to nanosecond precision and
		 * both classes, when used in conjunction with Period, give a result
		 * using a combination of human-based units, such as years, months, and
		 * days.
		 */
		LocalDateTime currentDateTime2 = LocalDateTime.now();
		System.out.println("LocalDateTime: " +currentDateTime2	);
		
		ZonedDateTime newDateTime = currentDateTime.minus(period);
		System.out.println(newDateTime);
		


	}

}
