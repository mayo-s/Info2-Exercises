package imi.calculator;
/**
 * 
 * @author Jack Lai & Mario Schuetz
 *
 */

public class LinkedList<T extends Comparable<T>>{

	private Node<T> first; // first Node in the list (FIFO principle)

	public LinkedList() {
		first = null; //new empty list
	}

	public void insertFirstNode(T value) { //"push" a new Node to the beginning of the list
		Node<T> aNode = new Node<T>(value); // a new Node is created
		aNode.nextNode = first; // aNode's "nextNode" is assigned the reference to the previous Link
		first = aNode; // the list's first/current Node is assigned to the newest Node added
	}

	public T deleteFirstNode() throws Exception {
		
		Node<T> nodeReference = first; 
		T tmp = first.data;

		if (!isEmpty()) {	//"pull" the first Node if stack is not empty
			first = first.nextNode; //first Node in the List is assigned the value of the previous Node
		} else {
			throw new Exception("UnderflowException");
		}
		return tmp;
	}
	
	public T getFirst() { //equivalent to method top()
		return first.getData();
	}

	public Node<T> find(T value) throws Exception {
		
		Node<T> searchedNode = first; //starting at the first Node in the List
		
		if (!isEmpty()) {
			while(searchedNode != null){ //continue searching until ref is found
				if(searchedNode.data.compareTo(value) == 0){ //if end of the List is reached, return null
					return searchedNode;
				} else{ //if matching node found
					searchedNode = searchedNode.nextNode; //searchedNode becomes nextNode
				}
			}
		} else{
			throw new Exception("UnderflowException");
		}
		return searchedNode;
	}

	public void empty(){
		first = null;
	}

	public boolean isEmpty() {
		return(first == null);
	}
	
	public String toString(){
		Node<T> top = first;
		String info = "the content of the stack is:";
		while(top != null){
			info += top.getData() + "";
			top = top.nextNode;
		}
		return info;
	}

}
