import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ListIterator-like object, used to traverse a custom SinglyLinkedList (SLL) object.
 * Data type (T) must implement the Comparable interface.
 * 
 * @author DeerByte;
 * 
 * References:
 * https://www.javatpoint.com/for-each-loop
 * https://www.geeksforgeeks.org/java-implementing-iterator-and-iterable-interface/
 * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Iterator.html
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Iterable.html
 */
public class ListIterator<T extends Comparable<T>> implements Iterator<T>{
    Node<T> currentNode;

    public ListIterator(SLL<T> list) {
        currentNode = list.getHead();
    }

    public boolean hasNext() {
        if (currentNode == null) {
            return false;
        }
        return currentNode != null;
    }

    public T next() {
        if (currentNode == null) {
            throw new NoSuchElementException();
        }

        T data = currentNode.getData();
        currentNode = currentNode.getNext();
        return data;
    }
}
