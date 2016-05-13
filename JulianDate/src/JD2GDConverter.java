
/**
 * 
 * @author Philip Daduna & Mario Schuetz 
 * JD-Formula Source = http://aa.usno.navy.mil/faq/docs/JD_Formula.php
 *
 */

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class JD2GDConverter extends JulianDate {

	private static int[] date;
	private static int[] today;

	public JD2GDConverter() {
		date = new int[3];
		today = new int[3];
	}

	public static void main(String[] args) {
		JD2GDConverter JD2GDC = new JD2GDConverter();
		JD2GDC.input();
		int birthday = JD2GDC.GD2JD(date);
		System.out.println("Your Julian-Birthday is: " + birthday);
		JD2GDC.today();
		int currentDay = JD2GDC.GD2JD(today);
		System.out.println("You are " + (currentDay - birthday) + " days old.");
		System.out.println("You were born on a " + JD2GDC.weekday(birthday));

	}

	private int[] input() {
		Scanner input = new Scanner(System.in);
		System.out.println("When were you born? Type in your date of birth:");
		System.out.println("Year (YYYY): ");
		date[0] = Integer.parseInt(input.next());
		System.out.println("Month (MM): ");
		date[1] = Integer.parseInt(input.next());
		System.out.println("Day (DD): ");
		date[2] = Integer.parseInt(input.next());

		if (date[1] < 10)
			System.out.println("Your Gregorian-Birthday is: " + date[2] + "-0" + date[1] + "-" + date[0]);
		else
			System.out.println("Today is the: " + date[0] + "-" + date[1] + "-" + date[2]);

		return date;
	}

	private int[] today() {

		LocalDate now = LocalDate.now();
		DateTimeFormatter df;
		df = DateTimeFormatter.BASIC_ISO_DATE;

		today[0] = Integer.parseInt(now.format(df).toString().substring(0, 4));
		today[1] = Integer.parseInt(now.format(df).toString().substring(4, 6));
		today[2] = Integer.parseInt(now.format(df).toString().substring(6));
		if (today[1] < 10)
			System.out.println("Today is the: " + today[2] + "-" + "0" + today[1] + "-" + today[0]);
		else
			System.out.println("Today is the: " + today[2] + "-" + today[1] + "-" + today[0]);

		return today;
	}
	
	private String weekday(int julianDay){
		
		String weekday;
		if((int)((julianDay)%7) == 0)
			weekday = "Sunday";
		else if((int)((julianDay)%7)%6 == 0)
			weekday = "Saturday";
		else if((int)((julianDay)%7)%5 == 0)
			weekday = "Friday";
		else if((int)((julianDay)%7)%4 == 0)
			weekday = "Thursday";
		else if((int)((julianDay)%7)%3 == 0)
			weekday = "Wednesday";
		else if((int)((julianDay)%7)%2 == 0)
			weekday = "Tuesday";
		else
			weekday = "Monday";			
		
		return weekday;
	}
}
