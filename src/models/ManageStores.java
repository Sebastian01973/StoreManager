package models;
import structures.SimpleList;

import java.util.ArrayList;
import java.util.Iterator;

public class ManageStores {
    private SimpleList<Store> storeList;

    public ManageStores() {
        this.storeList = new SimpleList<>(new StoreComparator());
    }

    public void addStore(Store store){
        storeList.insert(store);
    }

    public Store createStore(String name, String address){
        return new Store(name,address);
    }

    public double getTotalInventory(){
        double total = 0;
        Iterator<Store> iterator = storeList.iterator();
        while(iterator.hasNext()){
            total += iterator.next().getTotal();
        }
        return total;
    }

    public Store searchStore(String address){
        Iterator<Store> iterator = storeList.iterator();
        while (iterator.hasNext()){
            Store storeAux = iterator.next();
            if(storeAux.getAddress().equals(address)){
                return storeAux;
            }
        }
        return null;
    }

    public void addItemToStore(String address,int code,String name,int quantity,double unitValue){
        Store aux = searchStore(address);
        if (aux != null){
            aux.addItem(aux.createItem(code, name, quantity, unitValue));
        }
    }

    public ArrayList<Object[]> getMatrixList(){
        ArrayList<Object[]> matrix = new ArrayList<>();
        Iterator<Store> iterator = storeList.iterator();
        while (iterator.hasNext()){
            matrix.add(iterator.next().toObjectVector());
        }
        return matrix;
    }
}
