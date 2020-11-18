package view;

import view.dialogs.JDAddItem;
import view.dialogs.JDialogAdd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JFMainWindow extends JFrame {
    private JPMainPanel jpMainPanel;
    private JDialogAdd jDialogAdd;
    private JDAddItem jdAddItem;

    public JFMainWindow(ActionListener action, MouseListener mouseListener){
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.setTitle("Manage Stores");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(getClass().getResource(Constant.IMG_ICON_APP)).getImage());
        initComponents(action ,mouseListener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener action,MouseListener mouseListener){
        jpMainPanel = new JPMainPanel(action,mouseListener);
        jpMainPanel.setBackground(Color.white);
        this.add(jpMainPanel,BorderLayout.CENTER);

        jDialogAdd = new JDialogAdd(action);
        jDialogAdd.setLocationRelativeTo(this);

        jdAddItem = new JDAddItem(action,this);
    }

    public void addRowTable(Object[] vector){
        jpMainPanel.addRowTable(vector);
    }

    public void addRowsTable(ArrayList<Object[]> matrix, String[] headers){
        jpMainPanel.addRowsToTable(matrix,headers);
    }

    public void showDialog(boolean visibility){
        jDialogAdd.showDialog(visibility);
    }

    public Object createStore(){
        return jDialogAdd.getNewStore();
    }

    public String getSelectedRow(Point point) {
        return jpMainPanel.getSelectedRow(point);
    }

    public void showButtons(boolean visibility){
        jpMainPanel.showButtons(visibility);
    }

    public void showDialogAddItem(boolean visibility, boolean isChange){
        jdAddItem.showDialog(visibility, isChange);
    }

    public String getAddressStore(){
        return jdAddItem.getAddressStore();
    }

    public void setAddressStore(String address){
        jdAddItem.setAddressStore(address);
    }

    public Object getItem(){
        return jdAddItem.createItem();
    }

    public int getSearchedCode(){
        String value = jpMainPanel.getSearchedCode();
        if(!value.equals("")){
            return Integer.parseInt(jpMainPanel.getSearchedCode());
        }
        return -1;
    }

    public void cleanRows(){
        jpMainPanel.cleanRows();
    }

    public void fillListItem(ArrayList<String> list){
        jpMainPanel.fillListItem(list);
    }

    public String getItemObject(){
        return jpMainPanel.getItemObject();
    }

    public void setVisibleSell(boolean visibility){
        jpMainPanel.setVisibleSell(visibility);
    }

    public int getQuantity(){
        return jpMainPanel.getQuantity();
    }

    public void setValues(double totalInventory,int value){
        jpMainPanel.setValues(totalInventory,value);
    }

    public void setNumberitems(int value){
        jpMainPanel.setNumberitems(value);
    }

    public int[] getDeleteString(){
        return jpMainPanel.getDeleteString();
    }

    public void setVisibleDelete(boolean visible){
        jpMainPanel.setVisibleDelete(visible);
    }
}
