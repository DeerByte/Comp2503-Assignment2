public class SLL<T extends Comparable<T>> {

	public SLL<T> firstLink;
	private SLL<T> next;
	
	//To add avengers to list, don't know if we need this though
	private String Name;
	private String Alias;
	private int Freq;


	//A little confused do I put our avengers variables in our list?
	public SLL(String N, String A, int F) {
		Name = N;
		Alias = A;
		Freq = F;
	}

	public boolean isEmpty() {
		return (firstLink == null);
	}

	//Creating Node Class
	public static class Node<T extends Comparable<T>> {

		private T data;
		public Node<T> next;

		/**
		 * Constructor for objects of class Node
		 */
		public Node(T d) {
			data = d;
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
	public void insertFirstLink(String Name, String Alias, int Frequency) {
		SLL<T> newLink = new SLL<T>(Name, Alias, Frequency);
		newLink.next = firstLink;
		firstLink = newLink;
	}

	/*
	 * Remove Link Method
	 * 
	 * 
	 * INCOMPLETE
	 * 
	 * 
	 */
	public SLL<T> removeLink(String Name) {

		SLL<T> currentLink = firstLink;
		SLL<T> previousLink = firstLink;

		while (currentLink.Name != Name) {
			if (currentLink.next == null) {
				return null;
			} else {
				previousLink = currentLink;
				currentLink = currentLink.next;
			}
		}
		if (currentLink == firstLink) {
			firstLink = firstLink.next;
		} else {

			System.out.println("match found");
			System.out.println("currentLink: " + currentLink);
			System.out.println("firstLink: " + firstLink);

			previousLink.next = currentLink.next;
		}
		return currentLink;
	}
	
	/*
	 * Find Method
	 * 
	 * 
	 * INCOMPLETE
	 * 
	 * 
	 */
	public SLL<T> find(String name){	
		SLL<T> theLink = firstLink;	
		
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
