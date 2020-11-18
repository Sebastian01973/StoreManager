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
        Item p5 = new Item(5,"Doh",30,1233);
        Item p6 = new Item(6,"Doh",30,1233);
        Item p7 = new Item(15,"Doh",30,1233);
        Item p8 = new Item(20,"Doh",30,1233);
        Item p9 = new Item(19,"Doh",30,1233);

        test.addItemShort(p1);
        test.addItemShort(p2);
        test.addItemShort(p3);
        test.addItemShort(p4);
        test.addItemShort(p5);
        test.addItemShort(p6);
        test.addItemShort(p7);
        test.addItemShort(p8);
        test.addItemShort(p9);
        System.out.println("-------------");
        System.out.println(test.show());
        System.out.println(test.removeInRange(1,20));
        System.out.println(test.show());
        System.out.println(test.removeInRange(1,1));
        System.out.println(test.show());
        System.out.println(test.removeInRange(8,20));
        System.out.println(test.show());
    }
}
