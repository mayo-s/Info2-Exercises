
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

	private int[] date;
	private int[] today;
	// private int year;
	// private int month;
	// private int day;

	public JD2GDConverter() {
		date = new int[3];
		today = new int[3];
	}

	public static void main(String[] args) {
		JD2GDConverter JD2GDC = new JD2GDConverter();
		JD2GDC.input();
		System.out.println("Your Julian-Birthday is: " + JD2GDC.GD2JD());
		JD2GDC.today();
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

		return date;
	}

	private int GD2JD() {
		int year = date[0];
		int month = date[1];
		int day = date[2];
		int JD = day - 32075 + 1461 * (year + 4800 + (month - 14) / 12) / 4
				+ 367 * (month - 2 - (month - 14) / 12 * 12) * 2 / 12
				- 3 * ((year + 4900 + (month - 14) / 12) / 100) / 4;
		return JD;
	}

	private int[] today() {

		LocalDate now = LocalDate.now();
		DateTimeFormatter df;
		df = DateTimeFormatter.BASIC_ISO_DATE;
		
		today[0] = Integer.parseInt(now.format(df).toString().substring(0, 4));
		today[1] = Integer.parseInt(now.format(df).toString().substring(4, 6));
		today[2] = Integer.parseInt(now.format(df).toString().substring(6));
		if(today[1] < 10)
			System.out.println("Today is the: " + today[0] + "0" + today[1] + today[2]);
		else
			System.out.println("Today is the: " + today[0] + today[1] + today[2]);
			
		return today;
	}
}
