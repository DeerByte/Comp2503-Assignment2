/**
 * @author Justin 
 * SLL class
 */

import java.util.Comparator;

public class SLL<T extends Comparable<T>> implements Iterable<T>{

	private Node<T> head;
	private Node<T> tail;
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
	
	/**
	  * Compares 2 objects with our compareTo or Comparator method
	  * @param o1,o2 - objects (avengers)
	  * @return int: comparator 1,-1, or 0
	  */
	public int compare(T o1, T o2) {
		if (o1 == null | o2 == null)
			return 0;
		if (comparator == null)
			return o1.compareTo(o2);
		else
			return comparator.compare(o1,o2);
	}
	
	/**
	  * returns the head and checks if empty
	  * @return boolean: returns true if empty
	  */
	public boolean isEmpty() {
		return (head == null);
	}
	
	/**
	  * adds an avenger to the start of the list
	  * @param T - avenger object
	  *  
	  */
	public void addToStart(T data) 
    { 
		size++;
        Node<T> nodeToAdd = new Node<>(data); 
        if(isEmpty())
        	head = nodeToAdd;
        else
        {
          nodeToAdd.setNext(head);
          head = nodeToAdd;
        }
    }

	/**
	  * checks to see if the index data matches the arg data
	  * @param T - avenger object
	  * @return boolean: true if it matches, false if no match
	  *  
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
	 * Adds the object to the SLL at the start of the list.
	 * @param data
	 */
	public void add(T data) {
		addToEnd(data);
    }

	/**
	 * Adds the object to the SLL at the chosen index of the list
	 * @param index, data
	 */
	public void add(int index, T data) {
		int length = size();        
    	if (length == 0 || index == 0)
    		addToStart(data);
    	else if (length <= index)
    		addToEnd (data);
    	else {
    		Node<T> nodeAdd = new Node<>(data);
    		Node<T> curr = head;                
    		for (int count = 0; count < index -1; count++)                			
    			curr = curr.getNext();            
    		nodeAdd.setNext (curr.getNext());            				
			curr.setNext(nodeAdd);
			size++;
    	}
    }

	/**
	 * Adds the object to the SLL at the end of the list.
	 * @param data
	 */
	public void addToEnd(T data) {
		size++;
		Node<T> nodeAdd = new Node<>(data);
		if(head != null){
            Node<T> curr = head;
            while(curr.getNext() != null){
               curr = curr.getNext();
            }
            curr.setNext(nodeAdd);
        }
        else
        	head = nodeAdd;
    }

	/**
	 * Removes the object from the list
	 * @param T obj
	 * @return T link
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
				currentLink = currentLink.getNext();
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

	public T remove(int index) { 
		Node<T> removed;

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			Node<T> newHead = head.getNext();
			removed = head;
			head = newHead;

			return removed.getData();

		} else {
			Node<T> pointer = head;
			int i = 0;

			while (i < index - 1) {
				pointer = pointer.getNext();
			}
			removed = pointer.getNext();
			pointer.setNext(removed.getNext());

			return removed.getData();
		}
		

		
	}

	/**
	 * Removes the object from the end of the list
	 * @return T link 
	 */
	public T removeFromEnd() {
		 if (head == null) {
	        	return null;
	        }	        
	    	T data = null;	    	
	    	if (size() == 1) {
	    		data = head.getData();
	    		head = null;
	        	return data;
	        }

	        Node<T> curr = head;
	        Node<T> prev = head;
	       
	        while (curr.getNext() != null) 
	        {
	        	prev = curr;
	        	curr = curr.getNext();
	        }
	        data = curr.getData();
	        prev.setNext(null);
	        return data;
	    }

	/**
	 * Removes the object from the start of the list
	 * @return T link 
	 */
		public T removeFromStart() {
		 T data = null;
	        if(head != null)
	        {
	            if(head.getNext() == null)
	            {
	                data = head.getData();
	                head = null;
	            }
	            else
	            {
	                Node<T> curr = head;
	                data = head.getData();
	                head = head.getNext();
	                curr.setNext(null);
	            }
	        }
	        return data;
		}
	
	//returns size
	public int size() {
		return size;
	}

	//returns head
	protected Node<T> getHead() {
		return head;
	}
	
	/**
	 * Removes the object from the list
	 * @param int index
	 * @return T index data
	 */
	public T get(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException(index);
		}

		Node<T> pointer = head;
		for (int i = 0; i < index; i ++) {
			pointer = pointer.getNext();
		}
		return pointer.getData();
	}
	
	/**
	 * Finds an object in the list
	 * @param T object
	 * @return T data
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
	 * 
	 */
	public void addInOrder(T e) {
        
        if (head == null || compare(e, head.getData()) <= 0) {
            addToStart(e);

        } else if (tail == head || compare(e, tail.getData()) > 0) { // Fix, will not sort using compare
			addToEnd(e);
        
        } else {
			Node<T> pointer = head;
			Node<T> newNode = new Node<>(e);
			while (pointer.hasNext() && compare(e, pointer.getNext().getData()) > 0) {
				pointer = pointer.getNext();
			}
			newNode.setNext(pointer.getNext());
			pointer.setNext(newNode);            
        }
	}

	
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
