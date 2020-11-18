package test;

import models.Store;

public class TestStore {
    public static void main(String[] args) {
        Store store = new Store("A","cra223b");
//        store.addItem(1,"papel",10,2000);
//        store.addItem(2,"pan",20,1000);
//        store.addItem(3,"cinta",10,2000);
//        store.addItem(4,"B",20,1000);
//        store.addItem(5,"C",10,2000);

        System.out.println(store.searchItem(1).getName());
        System.out.println(store.getTotal());
        System.out.println(store.getNumberItems());
        System.out.println(store.getAddress() + store.getName());
        System.out.println(store.sellItem(1,9));
        System.out.println(store.searchItem(1));
        System.out.println(store.sellItem(1,1));
        System.out.println(store.sellItem(1,1));
        System.out.println(store.searchItem(1).getQuantity());
        System.out.println(store.searchItem(2).getQuantity());
        System.out.println(store.getNumberItems());

    }
}
