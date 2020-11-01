import java.util.Comparator;

public class SLL<T extends Comparable<T>> {

	private Node<T> head;
	private int size;
	
	
	//I haven't created this class since someone else was doing that.
	private Comparator<T> comparator;
	


	//A little confused do I put our avengers variables in our list?
	public SLL() {
		head = null;
		size = 0;
		comparator = null;
	}

	
	public SLL(Comparator<T> externalComp) {
		head = null;
		size = 0;
		comparator = externalComp;
	}
	
	//checking 2 objects
	public int compare(T o1, T o2) {
		if (comparator == null)
			return o1.compareTo(o2);
		else
			return comparator.compare(o1,o2);
	}
	
	public boolean isEmpty() {
		return (head == null);
	}

	//Creating Node Class
	public static class Node<T extends Comparable<T>> {

		private T data;
		private Node<T> next;

		/**
		 * Constructor for objects of class Node
		 */
		public Node(T data) {
			this.data = data;
			next = null;
		}

		public T getData() {
			return data;
		}

		public void setData(T o) {
			data = o;
			}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> n) {
			next = n;
		}

		public String toString() {
			return "Node: " + getData().toString();
		}

	}
	//end of node class 
	
	/*
	 * Insert Method
	 * 
	 * 
	 * INCOMPLETE
	 * 
	 * 
	 */
	public void insertFirstLink(T data) {
		Node<T> newLink = new Node<>(data);
		newLink.next = head;
		head = newLink;
	}

	/*
	 * Remove Link Method
	 * 
	 * 
	 * INCOMPLETE
	 * 
	 * 
	 */
	/*
	* The name of the Avenger within the Node should remain isolated from the Node class, 
	*			as the field belongs to the Avenger class. 
	*
	* If you're removing a node, you can use an index or an object reference address.
	*/
	public Node<T> removeLink(String Name) {

		Node<T> currentLink = head;
		Node<T> previousLink = head;

		while (currentLink.Name != Name) {
			if (currentLink.next == null) {
				return null;
			} else {
				previousLink = currentLink;
				currentLink = currentLink.next;
			}
		}
		if (currentLink == head) {
			head = head.next;
		} else {

			System.out.println("match found");
			System.out.println("currentLink: " + currentLink);
			System.out.println("firstLink: " + head);

			previousLink.next = currentLink.next;
		}
		return currentLink;
	}
	
	//returns size
	public int size() {
		return size;
	}
	
	
	/*
	 * Find Method
	 * 
	 * 
	 * INCOMPLETE
	 * 
	 * 
	 */
	
	public Node<T> find(String name){	
		Node<T> theLink = head;			
		if(!isEmpty()){
			while(theLink.Name != name){
				if(theLink.next == null){
					return null;	
				} else {
					theLink = theLink.next;			
				}		
			}		
		} else {			
			System.out.println("Empty LinkedList");		
		}	
		return theLink;	
	}
	
	/*
	 * Add in Order Method
	 * 
	 * 
	 * INCOMPLETE
	 * 
	 * 
	 */
	
}
