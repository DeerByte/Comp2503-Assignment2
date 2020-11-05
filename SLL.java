/**
 * @author Justin, DeerByte (Ryan)
 * 
 * SLL class 
 * 
 * This class contains our Singly Linked List as well as it's many 
 * methods to maintain, modify, add, remove, etc.
 * 
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
	public int compare(T o1, T o2) 
	{
		if (o1 == null || o2 == null)
		{
			return 0;
		} 
		else if (comparator == null)
		{
			return o1.compareTo(o2);
		}
		
		return comparator.compare(o1,o2);
	}
	
	/**
	  * returns the head and checks if empty
	  * @return boolean: returns true if empty
	  */
	public boolean isEmpty() 
	{
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
		{
			head = nodeToAdd;
			tail = nodeToAdd;
		}
		else
        {
          nodeToAdd.setNext(head);
          head = nodeToAdd;
        }
    }

	/**
	  * checks to see if the index data matches the arg data
	  * @param data of type T
	  * @return boolean: true if it matches, false if no match
	  *  
	  */
	public boolean contains(T data) 
	{
		Node<T> current = head;    
        while (current != null) 
        { 
            if (current.getData().equals(data)) 
            {
				return true;
			}    
            current = current.getNext(); 
        } 
        return false;
	}

	/**
	 * Adds the object to the SLL at the start of the list.
	 * @param data of type T
	 */
	public void add(T data) 
	{
		addToEnd(data);
    }

	/**
	 * Adds the object to the SLL at the chosen index of the list
	 * @param index, data of type T
	 */
	public void add(int index, T data) 
	{
		      
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException(index);
		}
		else if (index == 0)
		{
			addToStart(data);
		}
		else if (size <= index) 
		{
			addToEnd (data);
		}
		
		
    	Node<T> nodeAdd = new Node<>(data);
    	Node<T> curr = head;                
		for (int count = 0; count < index -1; count++) 
		{              			
			curr = curr.getNext(); 
		}           
    	nodeAdd.setNext (curr.getNext());            				
		curr.setNext(nodeAdd);
		size++;
    	
    }

	/**
	 * Adds the object to the SLL at the end of the list.
	 * @param data of type T
	 */
	public void addToEnd(T data) 
	{
		size++;
		Node<T> nodeAdd = new Node<>(data);
		
		if(head == null)
		{
			head = nodeAdd;
			tail = nodeAdd;
		}
		else if (head == tail) 
		{
			head.setNext(nodeAdd);
			tail = nodeAdd;
		}
		else
		{
			tail.setNext(nodeAdd);
			tail = nodeAdd;
		}
	}

	/**
	 * Removes the object from the list
	 * @param obj of type T
	 * @return link  of type T
	 */
	public T remove(T obj) {
		size--;
		Node<T> currentLink = head;
		Node<T> previousLink = head;

		if (currentLink == null || obj == null) 
		{
			return null;
		} 
		else if (obj.equals(head.getData()))
		{
			return removeFromStart();
		}

		while (!currentLink.getData().equals(obj)) 
		{
			if (currentLink.getNext() == null) 
			{
				return null;
			} 
			else 
			{
				previousLink = currentLink;
				currentLink = currentLink.getNext();
			}
		}
		previousLink.setNext(currentLink.getNext());
		
		return currentLink.getData();
	}

	/**
	 * Removes the object from the list based off index
	 * @param int index
	 * @return T data
	 */
	public T remove(int index) 
	{ 
		Node<T> removed;
		
		if (index < 0 || index >= size) 
		{
			throw new IndexOutOfBoundsException();
		} 
		else if (index == 0) 
		{
			Node<T> newHead = head.getNext();
			removed = head;
			head = newHead;
		}
		else 
		{
			Node<T> pointer = head;
			int i = 0;

			while (i < index - 1) 
			{
				pointer = pointer.getNext();
				i++;
			}
			removed = pointer.getNext();
			pointer.setNext(removed.getNext());
		}

		size--;
		return removed.getData();
	}

	/**
	 * Removes the object from the end of the list
	 * @return T link 
	 */
	public T removeFromEnd() 
	{
		size--;
		if (head == null) 
		{
	        return null;
		}	 
		       
		T data = null;
			    	
		if (size() == 1) 
		{
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
		public T removeFromStart() 
		{
		size--;
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
	
	/*
	 * Size method to return size
	 * @return int size
	 */
	public int size() 
	{
		return size;
	}

	/**
	 * Returns the SLL head Node.
	 * @return head of T data
	 */
	protected Node<T> getHead() 
	{
		return head;
	}
	
	/**
	 * Removes the object from the list
	 * @param int index
	 * @return T index data
	 */
	public T get(int index) 
	{
		if (index >= size) 
		{
			throw new IndexOutOfBoundsException(index);
		}

		Node<T> pointer = head;
		for (int i = 0; i < index; i ++) 
		{
			pointer = pointer.getNext();
		}
		return pointer.getData();
	}
	
	/**
	 * Finds an object in the list
	 * @param e of data type T
	 * @return T data
	 */
	public T find(T e)
	{	
		Node<T> current = head;			
		if(isEmpty())
		{
			return null;	

		} else {
			while(!current.getData().equals(e))
			{
				if(current.getNext() == null)
				{
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
	 * @param e of type T
	 * 
	 */
	public void addInOrder(T e) 
	{
        
		if (head == null || compare(e, head.getData()) <= 0) 
		{
            addToStart(e);

		} 
		else if (tail == head || compare(e, tail.getData()) > 0) 
		{
			addToEnd(e);
        
		} 
		else 
		{
			Node<T> pointer = head;
			Node<T> newNode = new Node<>(e);
			while (pointer.hasNext() && compare(e, pointer.getNext().getData()) > 0) 
			{
				pointer = pointer.getNext();
			}
			newNode.setNext(pointer.getNext());
			pointer.setNext(newNode); 
			size++;          
        }
	}

	
	 /**
	  * Searches for index of object within list. If no such object exists or the list is empty, returns -1.
	  * @author DeerByte
	  * @param e - element within list
	  * @return int: index of object, or -1.
	  */
	 public int indexOf(T e) 
	 {
		 int index = -1;

		 if (head == null) 
		 {
			 return index;
		 }  
		 else if (tail.getData().equals(e)) 
		 {
			 return size - 1;
		 }
		 else 
		 {
			Node<T> current = head;
			index = 0;

			while (index < size) 
			{
				if (current.getData().equals(e)) 
				{
					return index;
				}
				current = current.getNext();
				index++;
			}
			return -1;
		 }
	 }

	 /**
	  *  Returns a ListIterator object that can iterate forward through the SLL.
	  *  @return list
	  */
	 public ListIterator<T> iterator() 
	 {
		return new ListIterator<>(this);
	 }
}