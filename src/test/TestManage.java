package test;

import models.ManageStores;
import models.Store;

import java.util.ArrayList;

public class TestManage {
    public static void main(String[] args) {
        ManageStores manageStores = new ManageStores();

//        manageStores.addStore("A","cra1");
//        manageStores.addStore("B","cra2");
//        manageStores.addStore("C","cra3");
//        manageStores.addStore("D","cra4");
//        manageStores.addStore("E","cra5");

        System.out.println(manageStores.getTotalInventory());

        manageStores.addItemToStore("cra1",1,"papa",10,1000);
        manageStores.addItemToStore("cra1",2,"papel",10,2000);
        manageStores.addItemToStore("cra1",3,"pan",10,1000);
        manageStores.addItemToStore("cra1",4,"pc",10,50000);
        manageStores.addItemToStore("cra1",5,"clorox",10,2000);
        System.out.println(manageStores.getTotalInventory());
        System.out.println(manageStores.getTotalInventory());
        ArrayList<Object[]> matrix = manageStores.getMatrixList();
        for (Object[] objects: matrix) {
            System.out.println(objects[0]);
        }

    }
}
