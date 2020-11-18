package test;

import models.Item;
import models.Store;

public class TestAddOrder {
    public static void main(String[] args) {
        Store test = new Store("Bum","Ok");
        Item p1 = new Item(8,"Ok",30,1233);
        Item p2 = new Item(3,"Yeah",30,1233);
        Item p3 = new Item(1,"Doh",30,1233);
        Item p4 = new Item(2,"Doh",30,1233);

        test.addItemShort(p1);
        test.addItemShort(p2);
        test.addItemShort(p3);
        test.addItemShort(p4);
        System.out.println("-------------");
        System.out.println(test.show());
    }
}
