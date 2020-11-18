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

    public void insertInOrder(T data){
        if (head == null){
            head = new DoubleNode<>(data);
        }else if (comparator.compare(head.getData(), data) > 0){
            DoubleNode<T> auxNew = head;
            head = new DoubleNode<>(data);
            head.setNext(auxNew);
            auxNew.setPrevious(head);
        }else{
            DoubleNode<T> auxNode = head;
            DoubleNode<T> newNode = new DoubleNode<>(data);
            DoubleNode<T> auxiliarNode = null;
            boolean isFound = false;
            while (auxNode != null && !isFound){
                if (comparator.compare(auxNode.getData(),data) > 0){
                    DoubleNode<T> auxPrevious = auxNode.getPrevious();
                    newNode.setPrevious(auxPrevious);
                    newNode.setNext(auxNode);
                    auxNode.setPrevious(newNode);
                    if (auxPrevious != null){
                        auxPrevious.setNext(newNode);
                    }
                    isFound = true;
                }
                auxiliarNode = auxNode;
                auxNode = auxNode.getNext();
            }
            if (auxiliarNode != null && !isFound){
                newNode.setPrevious(auxiliarNode);
                auxiliarNode.setNext(newNode);
            }
        }
    }
}
