import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author DeerByte;
 * 
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
        if (!currNode.hasNext()) {
            throw new NoSuchElementException();
        }

        T data = currNode.getData();
        currNode = currNode.getNext();
        return data;
    }
}
