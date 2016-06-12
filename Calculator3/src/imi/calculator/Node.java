package imi.calculator;
/**
 * 
 * @author Jack Lai & Mario Schuetz
 *
 */

public class Node<T extends Comparable<T>>{
	
	public T data;
	public Node<T> nextNode;
	
	public Node(){
		data = null; //has to be null, since it's an Object of type T
		nextNode = null;
	}
	
	public Node(T value){
		data = value;
		nextNode = null;
	}
	
	public T getData(){
		return data;
	}
	
	public Node<T> getNextNode(){
		return nextNode;
	}
	
	
	public String toString(){
		return (new String(""+data));
	}
}

