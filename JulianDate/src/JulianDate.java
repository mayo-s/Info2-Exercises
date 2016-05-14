/**
 * 
 * @author Philip Daduna & Mario Schuetz
 * GD2JD-Formula Source = http://aa.usno.navy.mil/faq/docs/JD_Formula.php
 * http://www.timeanddate.com/calendar/julian-gregorian-switch.html
 *
 */

public class JulianDate {

	public JulianDate() {

	}

	/*
	 * // Another Formula to convert GD 2 JD
	 * protected int GD2JD(int[] date) { int year = date[0]; int month =
	 * date[1]; int day = date[2]; int JD = day - 32075 + 1461 * (year + 4800 +
	 * (month - 14) / 12) / 4 + 367 * (month - 2 - (month - 14) / 12 * 12) * 2 /
	 * 12 - 3 * ((year + 4900 + (month - 14) / 12) / 100) / 4; return JD; }
	 */

	
	protected int GD2JD(int[] date) {

		int[] monthD = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int year = date[0];
		int month = date[1];
		int day = date[2];
		int totaldays = 0;
		// sum of all days till current month - 1
		for (int i = 0; i < (month - 1); i++) {
			totaldays = totaldays + monthD[i];
		}

		if (month == 2 && year % 4 == 0)
			totaldays += 1;
		if (month == 2 && year % 100 == 0)
			totaldays -= 1;
		if (month == 2 && year % 400 == 0)
			totaldays += 1;

		String dateString = Integer.toString(year) + Integer.toString(month) + Integer.toString(day);
		int dateInt = Integer.parseInt(dateString);
		// 10 mystic days added after 04oct1582
		if (dateInt > 15821004) {
			totaldays += 10;
		}

		int JD = 1721059 + day + totaldays + year * 365 + (year / 4) - (year / 100) + (year / 400);
		return JD;
	}
}
