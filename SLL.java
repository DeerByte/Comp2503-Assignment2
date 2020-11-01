import java.util.Comparator;

public class SLL<T extends Comparable<T>> {

	private Node<T> head;
	private int size;
	private Node<T> next;
	
	
	//I haven't created this class since someone else was doing that.
	private Comparator<T> comparator;
	
	//To add avengers to list, don't know if we need this though


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
	private int compare(T o1, T o2) {
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
		public Node<T> next;
		public String Name;

		/**
		 * Constructor for objects of class Node
		 */
		public Node(T avenger) {
			data = avenger;
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
	public void insertFirstLink(T Avenger) {
		Node<T> newLink = new Node<T>(Avenger);
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
