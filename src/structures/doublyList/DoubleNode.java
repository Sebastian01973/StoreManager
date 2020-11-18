package structures.doublyList;

public class DoubleNode<T>{
    private DoubleNode previous, next;
    private T data;

    public DoubleNode(T data) {
        this.data = data;
    }

    public DoubleNode getPrevious() {
        return previous;
    }

    public DoubleNode getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}
