import java.util.Comparator;
import java.lang.IndexOutOfBoundsException;

public class SLL<T extends Comparable<T>> implements Iterable<T>{

	private Node<T> head, tail;
	private int size;
	private Node<T> tail;
	
	
	//I haven't created this class since someone else was doing that.
	private Comparator<T> comparator;
	


	//A little confused do I put our avengers variables in our list?
	public SLL() {
		head = null;
		tail = null;
		size = 0;
		comparator = null;
		tail = null;
	}

	
	public SLL(Comparator<T> externalComp) {
		head = null;
		tail = null;
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
	
	/*
	 * Insert Method
	 * 
	 * 
	 * INCOMPLETE
	 * 
	 * 
	 */
	public void addToStart(T data) {
		Node<T> newLink = new Node<>(data);
		newLink.next = head;
		head = newLink;
	}

	/*
	*TODO: finish contains(T) method.
	*/

	public boolean contains(T data) {
		return false;

		//Search for data object.
		// If found, return true
		// else false
	}

	/**
	 * TODO: finish add(T) method.
	 * Adds the object to the SLL at the tail.
	 * @param data
	 * @return
	 */
	public boolean add(T data) {
		//Create new node using data
		//Set tail.next reference to new Node.
		// set Tail reference to new Node.
	}

	/*
	 * Remove Link Method
	 * TODO: finish remove method.
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
	public T remove(T obj) {

		Node<T> currentLink = head;
		Node<T> previousLink = head;

		if (currentLink == null) {
			return null;
		}

		while (!currentLink.getData().equals(obj)) {
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

			previousLink.setNext(currentLink.getNext());
		}
		return currentLink.getData();
	}
	
	//returns size
	public int size() {
		return size;
	}
	
	public T get(int index) {
		if (index > size - 1) {
			throw new IndexOutOfBoundsException(index);
		}

		Node<T> pointer = head;
		for (int i = 0; i < index; i ++) {
			pointer = pointer.getNext();
		}
		return pointer.getData();
	}
	/*
	 * Find Method
	 * 
	 * TODO: finish find(T) method.
	 * INCOMPLETE
	 * 
	 * 
	 */
	
	public T find(T e){	
		Node<T> current = head;			
		if(isEmpty()){
			System.out.println("Empty LinkedList");	

		} else {
			while(!current.getData().equals(e)){
				if(current.next == null){
					return null;

				} else {
					current = current.getNext();		
				}		
			}				
		}	
		return current.getData();	
	}
	
	/*
	 * Add in Order Method
	 * 
	 * TODO: finish addInOrder(T) method.
	 * INCOMPLETE
	 * 
	 * 
	 */
	
	 /**
	  * Searches for index of object within list. If no such object exists or the list is empty, returns -1.

	  * @author DeerByte
	  * @param e - element within list
	  * @return int: index of object, or -1.
	  */
	 public int indexOf(T e) {
		 int index = -1;

		 if (head == null) {
			 return index;

		 } else {
			Node<T> current = head;
			index = 0;

			while (!current.getData().equals(e)) {
				if (!current.hasNext()) {
					return -1;
				}
				index++;
			}
			return index;
		 }
	 }
}
