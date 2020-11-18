package models;

import models.comparators.ItemComparator;
import structures.doublyList.DoubleList;

import java.util.ArrayList;
import java.util.Iterator;

public class Store {
    private String name;
    private String address;
    private DoubleList<Item> itemList;

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
        this.itemList = new DoubleList<>(new ItemComparator());
    }

    public void addItem(Item item){
        itemList.insert(item);
    }

    public Item createItem(int code,String name,int quantity,double unitValue){
        return new Item(code,name,quantity,unitValue);
    }

    public Item searchItem(int code){
        Iterator<Item> iterator = itemList.iterator();
        while (iterator.hasNext()){
            Item item = iterator.next();
            if(item.getCode() == code){
                return item;
            }
        }
        return null;
    }

    public int getNumberItems(){
        return itemList.getSize();
    }

    public double getTotal(){
        double total = 0;
        Item item;
        Iterator<Item> iterator = itemList.iterator();
        while (iterator.hasNext()){
            item = iterator.next();
            total += item.getUnitValue()*item.getQuantity();
        }
        return total;
    }

    public boolean sellItem(int code, int quantity){
        Item aux = searchItem(code);
        int quantityTotal = aux.getQuantity()-quantity;
        if(quantityTotal > -1){
           setItemQuantity(aux,quantityTotal);
           return true;
        }
        return false;
    }

    public double getPriceSell(int value,int quantity){
        return value*quantity;
    }

    public void setItemQuantity(Item item,int quantity){
        if(item != null){
            item.setQuantity(quantity);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DoubleList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(DoubleList<Item> itemList) {
        this.itemList = itemList;
    }

    public Object[] toObjectVector(){
        return new Object[]{
                address,name,this.getNumberItems(),this.getTotal()
        };
    }

    public ArrayList<Object[]> getItemlist(){
        ArrayList<Object[]> matrix = new ArrayList<>();
        Iterator<Item> iterator = itemList.iterator();
        while (iterator.hasNext()){
            matrix.add(iterator.next().toObjectVector());
        }
        return matrix;
    }

    public ArrayList<String> getItemslist(){
        ArrayList<String> list = new ArrayList<>();
        Iterator<Item> iterator = itemList.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next().toString());
        }
        return list;
    }
}
