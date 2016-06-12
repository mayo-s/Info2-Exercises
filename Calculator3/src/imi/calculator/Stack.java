package imi.calculator;

/**
 * 
 * @author Jack Lai & Mario Schuetz
 *
 */
public class Stack<T extends Comparable<T>> implements IStack<T>{
//stack using a linkedlist by calling its methods within the stack's methods push/pop/top/empty.
	
	T data;
	LinkedList<T> stackList;

	public Stack() {
		stackList = new LinkedList<T>();
	}

	public void push(T data) {
		stackList.insertFirstNode(data);
	}

	public T pop() throws Exception {
		if (!stackList.isEmpty()) {

			return stackList.deleteFirstNode();

		} else {

			return null;
		}
	}

	public T top() {
		return stackList.getFirst();
	}

	public void empty() {
		empty();
	}

	public boolean isEmpty() {
		if (stackList.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return stackList.toString();
	}
}
