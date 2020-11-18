package structures.doublyList;

import structures.simpleList.Node;

import java.util.Comparator;
import java.util.Iterator;

public class DoubleList <T> implements Iterable<T>{
    private DoubleNode <T> head;
    private Comparator <T> comparator;

    public DoubleList(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void insert(T data){
        if(head == null){
            head = new DoubleNode<T>(data);
        }else{
            DoubleNode<T> aux = head;
            DoubleNode<T> newNode = new DoubleNode<T>(data);
            while (aux.getNext() != null){
                aux = aux.getNext();
            }
            newNode.setPrevious(aux);
            aux.setNext(newNode);
        }
    }

    public void insertShort(T data){
        DoubleNode<T> newNode = new DoubleNode<T>(data);
        if(isEmpty()){
            head = newNode;
        }else{
            DoubleNode<T> aux = head;

            if (comparator.compare(aux.getData(),newNode.getData()) > 0) {
                newNode.setNext(aux);
                aux.setPrevious(newNode);
                head = newNode;
            }else{
                DoubleNode<T> current = head;
                DoubleNode<T> previous = head;
                while (comparator.compare(aux.getData(),newNode.getData()) <= 0 && current.getNext() != null){
                    previous = current;
                    current = current.getNext();
                }
                if (comparator.compare(aux.getData(),newNode.getData()) <= 0){
                    newNode = current.getNext();
                }else{
                    current = newNode.getNext();
                    newNode = previous.getNext();
                }
            }
        }
    }

    public String showForward(){
        String datas = "";
        DoubleNode<T> aux = head;
        if (aux == null){
            return "Empty";
        }
        while (aux != null){
            datas += aux.getData().toString() + "->";
            aux = aux.getNext();
        }
        return datas;
    }

    public String showBackward(){
        String datas = "";
        DoubleNode<T> aux = head;
        if (aux == null){
            return "Empty";
        }
        while(aux.getNext() != null){
            aux = aux.getNext();
        }
        while (aux != null){
            datas += aux.getData().toString() + "<-";
            aux = aux.getPrevious();
        }
        return datas;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public boolean exist(T data){
        DoubleNode<T> aux = head;
        while (aux != null){
            if(comparator.compare(aux.getData(),data) == 0){
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public void remove(T data){
        DoubleNode<T> previous = head;
        DoubleNode<T> actual = head;
        boolean found = false;
        while (actual != null && !found){
            found = comparator.compare(actual.getData(),data) == 0;
            if(!found){
                previous = actual;
                actual = actual.getNext();
            }
        }
        if (actual == head && actual != null){
            head = actual.getNext();
            if (head != null){
                head.setPrevious(null);
            }
        }else if (found){
            previous.setNext(actual.getNext());
            actual.setPrevious(null);
            actual = actual.getNext();
            if (actual != null){
                actual.setPrevious(previous);
            }
        }
    }

    /**
     * busca un dato dentro de la lista
     * @return null si no encuentra el dato
     */

    public int getSize(){
        DoubleNode<T> aux = head;
        int count = 0;
        while (aux != null) {
            count++;
            aux = aux.getNext();
        }
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoubleListIterator<>(head);
    }
}
