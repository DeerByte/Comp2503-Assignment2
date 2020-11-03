import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ListIterator-like object, used to traverse a SinglyLinkedList (SLL) object.
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
    Node<T> currNode;

    public ListIterator(SLL<T> list) {
        currNode = list.getHead();
    }

    public boolean hasNext() {
        return currNode.hasNext();
    }

    public T next() {
        if (currNode == null) {
            throw new NoSuchElementException();
        }

        T data = currNode.getData();
        currNode = currNode.getNext();
        return data;
    }
}
