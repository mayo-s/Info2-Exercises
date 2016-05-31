/**
 * 
 * @author Jack Lai & Mario Schuetz
 *
 */

public class TestCases {
	private static Postfix pfx;
	private static TestCases test;

	public TestCases() {
	}

	public static void main(String[] args) throws NumberFormatException, Exception {
		
		//test = new TestCases();
		//test.cases();

		pfx = new Postfix();
		pfx.evaluateResult();
	}

	private void cases() throws NumberFormatException, Exception {
		
		System.out.println(pfx.evaluate("12*3+"));
		System.out.println(pfx.evaluate("123*+"));
		System.out.println(pfx.evaluate("12+34^-"));
		System.out.println(pfx.evaluate("12^34*-"));
		System.out.println(pfx.evaluate("123*+45^-6+"));
		System.out.println(pfx.evaluate("12+3*456-^+"));
		System.out.println(pfx.evaluate("12+3*456-^+"));
		System.out.println(pfx.evaluate("91-2-32*-1-"));

		System.out.println(pfx.infixToPostfix("1*2+3"));
		System.out.println(pfx.infixToPostfix("1+2*3"));		
		System.out.println(pfx.infixToPostfix("1+2-3^4"));
		System.out.println(pfx.infixToPostfix("1^2-3*4"));
		System.out.println(pfx.infixToPostfix("1+2*3-4^5+6"));
		System.out.println(pfx.infixToPostfix("(1+2)*3+(4^(5-6))"));
		System.out.println(pfx.infixToPostfix("1+2+3/4+5+6*(7+8)"));
		System.out.println(pfx.infixToPostfix("9-1-2-3*2-1"));
	}
}
