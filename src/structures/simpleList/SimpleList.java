package structures.simpleList;

import java.util.Comparator;
import java.util.Iterator;

public class SimpleList<T> implements Iterable<T>{
    private Node<T> head;
    private Comparator<T> comparator;

    public SimpleList(Comparator<T> comparator){
        this.comparator = comparator;
    }

    /**
     * Se agrega un nuevo elemento
     * @param data
     */
    public void insert(T data){
        if (head == null){
            head = new Node<T>(data);
        }else {
            Node<T> auxNode = head;
            while (auxNode.getNext() != null){
                auxNode = auxNode.getNext();
            }
            auxNode.setNext(new Node<T>(data));
        }
    }

    /**
     * verifica si existe un elemento
     * @param data
     * @return true or false
     */
    public boolean exist(T data){
        Node<T> auxNode = head;
        while (auxNode != null) {
            if (comparator.compare(auxNode.getData(),data) == 0){
                return true;
            }
            auxNode = auxNode.getNext();
        }
        return false;
    }

    /**
     * Muestra los elementos de la lista
     * @return un String con los elementos
     */
    public String show(){
        String data = "";
        String empty = "Empty";
        String separator = "->";
        Node<T> auxNode = head;
        while (auxNode != null){
            data += separator + auxNode.getData().toString();
            auxNode = auxNode.getNext();
        }
        return data == ""? empty:data;
    }

    /**
     * verifica si la lista está vacía o no
     * @return true or false
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * elimina un nodo de la lista
     * @param data campo caracteristico del nodo a eliminar
     */
    public void remove(T data) {
        Node<T> previous = head;
        Node<T> actual = head;
        boolean isFound = false;
            while (actual != null && !isFound) {
            isFound = comparator.compare(actual.getData(),data) == 0;
            if (!isFound) {
                previous = actual;
                actual = actual.getNext();
            }
        }
        if (actual == head && actual != null) {
            head = actual.getNext();
        } else if (isFound){
            previous.setNext(actual.getNext());
        }
    }

    public int getSize(){
        Node<T> aux = head;
        int count = 0;
        while (aux != null) {
            count++;
            aux = aux.getNext();
        }
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleListIterator(head);
    }
}
