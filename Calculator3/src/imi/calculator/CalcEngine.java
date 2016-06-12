package imi.calculator;

/**
 * Working Calculator cloned from https://github.com/EliGould/Exercise07
 * 
 * @author Jack Lai & Mario Schuetz
 *
 */

public class CalcEngine {

	Postfix pfx;

	// Engine Stuff

	// Takes a math expression in Dec display style and returns the solution as
	// a new display value
	public String getDecSolution(String displayValue) throws Exception {
		pfx = new Postfix();
		String result = Integer.toString(pfx.evaluate(pfx.infixToPostfix(displayValue)));
		return result;
	}

//	// Takes a math expression in Hex display style and returns the solution as
//	// a new display value
//	public String getHexSolution(String displayValue) throws Exception {
//		pfx = new Postfix();
//		String result = getDecSolution(getDecDisplayValue(displayValue));
//		
//		result = pfx.infixToPostfix(result);
//		result = Integer.toString(pfx.evaluate(result));
//		result = getHexDisplayValue(result);
//
//		return result;
//	}

	// Transcribes the current Display Value from Dec to Hex
	public String getHexDisplayValue(String displayValue) {
		char[] hexDisplay = displayValue.toCharArray();
		int value = 0;

		int i = hexDisplay.length - 1;
		String result = "";
		//System.out.println("value (array length - 1) of i: " + i);
		for (char tempChar : hexDisplay) {
			//System.out.println("TempChar value: " + tempChar);
			if (tempChar == 'A' || tempChar == 'B' || tempChar == 'C' || tempChar == 'D'
					|| tempChar == 'E' || tempChar == 'F') {
				value = (int) (tempChar - 55);

				// test print to check change from A - F to 10 - 15
				//System.out.println("current hexvalue (A-F): " + hexDisplay[i] + " = "+ value);
				
				result += Integer.toString(value);
				//System.out.println("result: " + result);
			}
			else if(tempChar == '+' || tempChar == '-' || tempChar == '*' || tempChar == '/'
					|| tempChar == '^'){
				result += tempChar;
				
			}
			else{
				result += (int)(tempChar - 48) * Math.pow(16, i);
				//System.out.println("result: " + result);
			}
			i--;
		}
		// test print to check int value
		//System.out.println("Hex result value after for loop: " + result);
		
		return result;
	}

	// Transcribes the current Display Value from Hex to Dec
	public String getDecDisplayValue(String displayValue) {
		
		int dec = Integer.parseInt(displayValue);

		String result = Integer.toHexString(dec).toUpperCase();
		//System.out.println(result);
		return result;
	}

	// ------------------------------------ //

	// Formal Stuff...
	public String getTitle() {

		return "Calculator Deluxe";
	}

	public String getAuthor() {

		return "Jack Lai & Mario Schuetz";
	}

	public String getVersion() {
		return "v 1.337";
	}
}
