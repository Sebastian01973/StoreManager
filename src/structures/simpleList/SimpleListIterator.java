package structures.simpleList;

import java.util.Iterator;

public class SimpleListIterator<T> implements Iterator<T> {
    private Node<T> actual;

    public SimpleListIterator(Node<T> actual) {
        this.actual = actual;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        T data = actual.getData();
        actual = actual.getNext();
        return data;
    }
}
