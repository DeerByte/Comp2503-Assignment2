/**
 * @author Justin 
 * SLL class
 */

import java.util.Comparator;

public class SLL<T extends Comparable<T>> implements Iterable<T>{

	private Node<T> head, tail, start;
	private int size;	
	private Comparator<T> comparator;
	
	public SLL() {
		head = null;
		tail = null;
		size = 0;
		comparator = null;
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
	
	public void addToStart(T data) 
    { 
        Node<T> nodeToAdd = new Node<>(data); 
        if(isEmpty())
            start = nodeToAdd;
        else
        {
          nodeToAdd.setNext(start);
          start = nodeToAdd;
        }
    }

	/*
	*TODO: finish contains(T) method.
	*/

	public boolean contains(T data) {
		Node<T> current = head;    
        while (current != null) 
        { 
            if (current.getData() == data) 
                return true;    
            current = current.getNext(); 
        } 
        return false;
	}

	/**
	 * TODO: finish add(T) method.
	 * Adds the object to the SLL at the end of the list.
	 * @param data
	 * @return
	 */
	public void add(T data) {
		Node<T> nodeAdd = new Node<T>(data);
		if(start != null){
            Node<T> curr = start;
            while(curr.getNext() != null){
               curr = curr.getNext();
            }
            curr.setNext(nodeAdd);
        }
        else
            start = nodeAdd;
    }

	public void add(int index, T data) {
		int length = size();        
    	if (length == 0 || index <= 0)
    		addToStart(data);
    	else if (length <= index)
    		addToEnd (data);
    	else {
    		Node<T> nodeAdd = new Node<>(data);
    		Node<T> curr = start;                
    		for (int count = 0; count < index - 1; count++)                			
    			curr = curr.getNext();            
    		nodeAdd.setNext (curr.getNext());            				
    		curr.setNext(nodeAdd);
    	}
    }

	public void addToEnd(T data) {
		Node<T> nodeAdd = new Node<T>(data);
		if(start != null){
            Node<T> curr = start;
            while(curr.getNext() != null){
               curr = curr.getNext();
            }
            curr.setNext(nodeAdd);
        }
        else
            start = nodeAdd;
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
	* The Avenger fields should remain within the Avenger class. The Node should remain isolated from the Avenger methods, 
	*			as the field belongs to the Avenger class, and the Node should function with other data types. 
	*
	* If you're removing a node, you can use an index or an object reference address. Method overloading allows for both.
	*/
	public T remove(T obj) {

		Node<T> currentLink = head;
		Node<T> previousLink = head;

		if (currentLink == null) {
			return null;
		}

		while (!currentLink.getData().equals(obj)) {
			if (currentLink.getNext() == null) {
				return null;
			} else {
				previousLink = currentLink;
				currentLink = currentLink.getNext(); // Methods require brackets (), while fields do not. The Node fields should be private and unnaccessible from here.
			}
		}
		if (currentLink == head) {
			head = head.getNext();
		} else {

			System.out.println("match found");
			System.out.println("currentLink: " + currentLink);
			System.out.println("firstLink: " + head);

			previousLink.setNext(currentLink.getNext());
		}
		return currentLink.getData();
	}

	public T removeFromEnd() {
		 if (start == null) {
	        	return null;
	        }	        
	    	T data = null;	    	
	    	if (size() == 1) {
	    		data = start.getData();
	        	start = null;
	        	return data;
	        }

	        Node<T> curr = start;
	        Node<T> prev = start;
	       
	        while (curr.getNext() != null) 
	        {
	        	prev = curr;
	        	curr = curr.getNext();
	        }
	        data = curr.getData();
	        prev.setNext(null);
	        return data;
	    }

		public T removeFromStart() {
		 T data = null;
	        if(start != null)
	        {
	            if(start.getNext() == null)
	            {
	                data = start.getData();
	                start = null;
	            }
	            else
	            {
	                Node<T> curr = start;
	                data = start.getData();
	                start = start.getNext();
	                curr.setNext(null);
	            }
	        }
	        return data;
	    
	
	//returns size
	public int size() {
		return size;
	}

	protected Node<T> getHead() {
		return head;
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
				if(current.getNext() == null){
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

	 public ListIterator<T> iterator() {
		return new ListIterator<>(this);
	 }
}
