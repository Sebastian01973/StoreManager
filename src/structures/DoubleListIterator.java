package structures;

import java.util.Iterator;

public class DoubleListIterator<T> implements Iterator<T> {
    private DoubleNode<T> actual;

    public DoubleListIterator(DoubleNode<T> actual) {
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
