/**
 * 
 * @author Philip Daduna & Mario Schuetz
 * GD2JD-Formula Source = http://aa.usno.navy.mil/faq/docs/JD_Formula.php
 *
 */

public class JulianDate {

	int[] date;

	public JulianDate() {
		
	}

	/**
	* public static void main(String[] args) {
	*	JulianDate juDas = new JulianDate();
	* 	juDas.GD2JD();
	* }
	*/
	private int GD2JD(){
		int year = date[0]; 
		int month = date[1];
		int day = date[2]; 
		
		int JD = day-32075+1461*(year+4800+(month-14)/12)/4+367*(month-2-(month-14)/12*12)*2/12-3*((year+4900+(month-14)/12)/100)/4;
	
		return JD;
	}
}
