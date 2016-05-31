import java.util.Scanner;

/**
 * 
 * @author Jack Lai & Mario Schuetz
 *
 */

public class Postfix {

	public int evaluate(String pfx) throws NumberFormatException, Exception {

		Stack<Integer> stack = new Stack<Integer>();

		int result = 0;

		char[] charArray = pfx.toCharArray(); // converts pfx to Char-Array

		// walk through the array
		for (char c : charArray) {
			// if character is a number, push it to the stack
			if (Character.isDigit(c)) {
				stack.push(c - 48);
				continue;
			}

			// if character equals an operator,
			// execute particular operation with both side as operands
			int rhs = stack.pop();
			int lhs = stack.pop();
			if (c == '+') {
				result = lhs + rhs;
			} else if (c == '-') {
				result = lhs - rhs;
			} else if (c == '*') {
				result = lhs * rhs;
			} else if (c == '/') {
				result = lhs / rhs;
			} else if (c == '^') {
				result = (int) Math.pow(lhs, rhs);
			}
			stack.push(result);
		}
		return result;
	}

	public String infixToPostfix(String ifx) throws Exception {

		Stack<Character> charStack = new Stack<Character>();
		String result = "";

		// converts ifx to Char-Array
		char[] charArray = ifx.toCharArray();

		// walk through the array
		for (char c : charArray) {
			// if character is a number, push it to the stack

			if (Character.isDigit(c)) {
				result = result + c;
			}
			if (c == '(') {
				charStack.push(c);
			}
			if (c == ')') {

				while (charStack.top() != '(') {
					result = result + charStack.top();
					charStack.pop();
				}
				charStack.pop();
			}
			if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
				while (!charStack.isEmpty() && (operatorRanking(c) <= operatorRanking(charStack.top()))) {
					// while(!charStack.isEmpty() &&
					// (((operatorRanking(charStack.top()) > c) ||
					// ((charStack.top().toString().matches("[\\-\\/\\^]") &&
					// operatorRanking(charStack.top()) == c))))){
					result = result + charStack.top();
					charStack.pop();
				}
				charStack.push(c);
			}
		}
		while (!charStack.isEmpty()) {
			result = result + charStack.top();
			charStack.pop();
		}
		return result;
	}

	private int operatorRanking(char value) {
		switch (value) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return 0;
		}
	}
	
	public void evaluateResult(){
		System.out.print("Insert your postfix expression: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.print("result: ");
		
			try {
				System.out.println(evaluate(input));
				sc.close();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				sc.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				sc.close();
			}
	}
}