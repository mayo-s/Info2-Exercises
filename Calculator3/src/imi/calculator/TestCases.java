package imi.calculator;

/**
 * 
 * @author Jack Lai & Mario Schuetz
 *
 */

public class TestCases {
	//private static Postfix pfx;
	private static TestCases test;
	private static CalcEngine engine;

	public TestCases() {
	}

	public static void main(String[] args) throws NumberFormatException, Exception {
		
		test = new TestCases();

//		pfx = new Postfix();
		engine = new CalcEngine();
		test.cases();
	}

	private void cases() throws NumberFormatException, Exception {
		
		System.out.println("Given value 7DE, expected calculated value 2014, calculated: " + engine.getHexDisplayValue("7DE")); 
		System.out.println("Given value 1E3, expected calculated value 483, calculated: " + engine.getHexDisplayValue("1E3")); 
		System.out.println("Given value 2014, expected calculated value 7DE, calculated: " + engine.getDecDisplayValue("2014"));
		System.out.println("Given value 123, expected calculated value 7B, calculated: " + engine.getDecDisplayValue("123")); 
		System.out.println("Given value 1996, expected calculated value 7CC, calculated: " + engine.getDecDisplayValue("1996"));

		
		System.out.println("Given expression 12*3+, expected calculated value 7, calculated: " + engine.getDecSolution("12*3+"));
		System.out.println("Given expression 123*+, expected calculated value 7, calculated: " + engine.getDecSolution("123*+"));
		System.out.println("Given expression 12+34^-, expected calculated value -82, calculated: " + engine.getDecSolution("12+34^-"));
		System.out.println("Given expression 12^34*-, expected calculated value -161, calculated: " + engine.getDecSolution("12^34*-"));
		System.out.println("Given expression 5^2*3, expected calculated value 75, calculated: " + engine.getDecSolution("5^2*3"));

		
//		System.out.println("Given expression 12^34*-, expected calculated value 7DE, calculated: " + engine.getHexSolution("AB+C*"));
//		System.out.println("Given expression 12^34*-, expected calculated value 7DE, calculated: " + engine.getHexSolution("AB+1+"));
//		System.out.println("Given expression 12^34*-, expected calculated value 7DE, calculated: " + engine.getHexSolution("BC^EF"));
//		System.out.println("Given expression 12^34*-, expected calculated value 7DE, calculated: " + engine.getHexSolution("A5+^2"));
//		System.out.println("Given expression 12^34*-, expected calculated value 7DE, calculated: " + engine.getHexSolution("A/B+15"));


	}
}
