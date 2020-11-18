package controller;

import models.Item;
import models.ManageStores;
import models.Store;
import utilities.UtilitiesView;
import view.Constant;
import view.JFMainWindow;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class Controller implements ActionListener , MouseListener {

    private ManageStores manageStores;
    private JFMainWindow jfMainWindow;

    public Controller() {
        this.manageStores = new ManageStores();
        this.jfMainWindow = new JFMainWindow(this,this);
        manageStores.addStore(manageStores.createStore("A","cra1"));
        manageStores.addStore(manageStores.createStore("B","cra2"));
        manageStores.addStore(manageStores.createStore("C","cra3"));
        manageStores.addItemToStore("cra1",1,"papel",10,1000);
        manageStores.addItemToStore("cra1",2,"leche",20,3000);
        manageStores.addItemToStore("cra2",1,"papel",10,1000);
        manageStores.addItemToStore("cra3",1,"papel",10,1000);
        addListToTable(manageStores.getMatrixList(),Constant.MAIN_HEADERS);
    }

    public void addElementToTable(Object[] vector){
        jfMainWindow.addRowTable(vector);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())){
            case ADD_STORE:
                showDialog(true);
                break;
            case CREATE_STORE:
                addStore();
                showDialog(false);
                break;
            case CANCEL_CREATE_STORE:
                showDialog(false);
                break;
            case BACK:
                addListToTable(manageStores.getMatrixList(),Constant.MAIN_HEADERS);
                jfMainWindow.showButtons(false);
                jfMainWindow.setVisibleSell(false);
                break;
            case CREATE_ITEM:
                addItemToStore();
                break;
            case CANCEL_CREATE_ITEM:
                jfMainWindow.showDialogAddItem(false);
                break;
            case ADD_ITEM:
                jfMainWindow.showDialogAddItem(true);
                break;
            case SEARCH:
                searchItem();
                break;
            case UPDATE:
                refreshTable();
                break;
            case NEW_SALE:
                sellItems();
                break;
            case TO_SELL:
                sellItem();
                break;
            default:
                break;
        }
    }

    private void addStore(){
        Store store = (Store) jfMainWindow.createStore();
        manageStores.addStore(store);
        addElementToTable(store.toObjectVector());
    }

    private void addItemToStore(){
        Store store = manageStores.searchStore(jfMainWindow.getAddressStore());
        Item item = (Item) jfMainWindow.getItem();
        if(store != null && item != null){
            store.addItem(item);
            addElementToTable(item.toObjectVector());
            jfMainWindow.setNumberitems(store.getNumberItems());
        }else{
            showMessageDialog(null, "Hay datos Vacios por favor llenarlos todos");
            jfMainWindow.showDialogAddItem(true);
        }
        jfMainWindow.showDialogAddItem(false);
    }

    private void searchItem(){
        Item item = searchStore(jfMainWindow.getAddressStore())
                .searchItem(jfMainWindow.getSearchedCode());
        if(item != null){
            jfMainWindow.cleanRows();
            addElementToTable(item.toObjectVector());
        }else {
            showMessageDialog(null,"Articulo no encontrado");
        }
    }

    private void sellItems(){
        jfMainWindow.setVisibleSell(true);
        Store store = searchStore(jfMainWindow.getAddressStore());
        jfMainWindow.fillListItem(store.getItemslist());
    }

    private void sellItem(){
        Store store = searchStore(jfMainWindow.getAddressStore());
        String itemObject = jfMainWindow.getItemObject();
        if (itemObject == ""){
            showMessageDialog(null,"Seleccione un articulo");
            return;
        }
        String[] data = UtilitiesView.split(itemObject);
        int quantity = jfMainWindow.getQuantity();
        boolean isSold = store.sellItem(Integer.parseInt(data[0]),quantity);
       if (isSold){
           refreshTable();
           jfMainWindow.setValues(store.getTotal(),quantity);
       }else{
           showMessageDialog(null,"producto no vendido excede cantidad de inventario");
       }
       jfMainWindow.setVisibleSell(false);
    }

    private Store searchStore(String address){
        return manageStores.searchStore(address);
    }

    private void showDialog(boolean visibility){
        jfMainWindow.showDialog(visibility);
    }

    private void addListToTable(ArrayList<Object[]> matrix,String[] headers){
        jfMainWindow.addRowsTable(matrix, headers);
        jfMainWindow.setValues(manageStores.getTotalInventory(),0);
    }

    public void refreshTable(){
        Store store = searchStore(jfMainWindow.getAddressStore());
        if(store != null){
            addListToTable(store.getItemlist(),Constant.STORE_HEADERS);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point value = e.getPoint();
        Store store = manageStores.searchStore(jfMainWindow.getSelectedRow(value));
        if (store != null){
            addListToTable(store.getItemlist(),Constant.STORE_HEADERS);
            jfMainWindow.setAddressStore(store.getAddress());
            jfMainWindow.setValues(store.getTotal(),0);
            jfMainWindow.setNumberitems(store.getNumberItems());
        }
        jfMainWindow.showButtons(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
