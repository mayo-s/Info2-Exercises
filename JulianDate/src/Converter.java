
/**
 * @author Philip Daduna & Mario Schuetz 
 * JD-Formula Source = http://aa.usno.navy.mil/faq/docs/JD_Formula.php
 */

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Converter extends JulianDate {

	private static int[] date;
	private static int[] today;
	private static Converter converter;

	public Converter() {
		date = new int[3];
		today = new int[3];
	}

	public static void main(String[] args) {
		converter = new Converter();
		MetricDate metricDate = new MetricDate();
		converter.input();
		int birthday = converter.GD2JD(date); // convert to julian day
		converter.today();
		int currentDay = converter.GD2JD(today);
		int[] metricBD = metricDate.JD2MD(currentDay - birthday);
		converter.output(birthday, currentDay, metricBD);

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
		input.close();

		return date;
	}

	private void output(int birthday, int currentDay, int[] metricBD) {

		if (date[1] < 10)
			System.out.println("Your Gregorian-Birthday is: " + date[2] + "-0" + date[1] + "-" + date[0]);
		else
			System.out.println("Today is the: " + date[0] + "-" + date[1] + "-" + date[2]);

		System.out.println("Your Julian-Birthday is: " + birthday);
		System.out.println("You are " + (currentDay - birthday) + " days old.");
		System.out.println("Your Metric-Age is: " + metricBD[0] + " years " + metricBD[1] + " month " + metricBD[2]
				+ " weeks " + metricBD[3] + " days");
		String weekday = converter.weekday(birthday);
		System.out.println("You were born on a " + weekday);
		System.out.println(converter.specialMsg(weekday, birthday));

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

	private String weekday(int julianDay) {

		int year = date[0];
		int month = date[1];
		int day = date[2];
		String dateString;
		int dateInt;
		String weekday = "";
		if (month < 10) {
			dateString = Integer.toString(year) + "0" + Integer.toString(month) + Integer.toString(day);
			dateInt = Integer.parseInt(dateString);
		} else {
			dateString = Integer.toString(year) + Integer.toString(month) + Integer.toString(day);
			dateInt = Integer.parseInt(dateString);
		}
		// System.out.println(dateInt);
		// System.out.println(dateString);
		// System.out.println(julianDay);
		// System.out.println(julianDay%7);

		// 10 mystic days added after 04oct1582
		if (dateInt < 15821004) {
			if ((julianDay % 7) == 0) {
				weekday = "Sunday";
			} else if ((julianDay % 7) == 1) {
				weekday = "Monday";
			} else if ((julianDay % 7) == 2) {
				weekday = "Tuesday";
			} else if ((julianDay % 7) == 3) {
				weekday = "Wednesday";
			} else if ((julianDay % 7) == 4) {
				weekday = "Thursday";
			} else if ((julianDay % 7) == 5) {
				weekday = "Friday";
			} else {
				weekday = "Saturday";
			}
		} else {
			if ((julianDay % 7) == 0) {
				weekday = "Monday";
			} else if ((julianDay % 7) == 1) {
				weekday = "Tuesday";
			} else if ((julianDay % 7) == 2) {
				weekday = "Wednesday";
			} else if ((julianDay % 7) == 3) {
				weekday = "Thursday";
			} else if ((julianDay % 7) == 4) {
				weekday = "Friday";
			} else if ((julianDay % 7) == 5) {
				weekday = "Saturday";
			} else {
				weekday = "Sunday";
			}
		}

		return weekday;
	}

	private String specialMsg(String weekday, int jd) {
		String msg = "";

		if (weekday.equals("Sunday")) {
			msg += "You are one of those famous sunday-childs. BE PROUD! ";
		}
		if (jd % 100 == 0) {
			msg += "Your birthday is divisable by 100";
		}

		return msg;
	}

}
