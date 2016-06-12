package imi.calculator;

/**
 * Working Calculator cloned from https://github.com/EliGould/Exercise07
 * @author Jack Lai & Mario Schuetz
 *
 */

public interface IStack<T> {
	
	public void push(T data);
	
	public T pop() throws Exception;
	
	public T top();
	
	public String toString();
	
	public boolean isEmpty();
	
}
