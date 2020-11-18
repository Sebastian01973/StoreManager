package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JPMainPanel extends JPanel {
    private JPHeader jpHeader;
    private JPBody jpBody;
    private JPFooter jpFooter;

    public JPMainPanel(ActionListener action, MouseListener mouseListener) {
        this.setLayout(new BorderLayout());
        initComponents(action,mouseListener);
    }

    private void initComponents(ActionListener action,MouseListener mouseListener){
        jpHeader = new JPHeader(action);
        jpHeader.setBackground(Color.white);
        this.add(jpHeader,BorderLayout.NORTH);

        jpBody = new JPBody(action,mouseListener);
        jpBody.setBackground(Color.white);
        this.add(jpBody,BorderLayout.CENTER);

        jpFooter = new JPFooter(action);
        this.add(jpFooter,BorderLayout.SOUTH);
    }

    public void addRowTable(Object[] vector){
        jpBody.addRowTable(vector);
    }

    public void addRowsToTable(ArrayList<Object[]> matrix,String[] headers){
        jpBody.addRowsToTable(matrix,headers);
    }

    public String getSelectedRow(Point point){
        return jpBody.getSelectedRow(point);
    }

    public void showButtons(boolean visibility){
        jpHeader.setVisibility(visibility);
    }

    public String getSearchedCode(){
        return jpHeader.getSearchedCode();
    }

    public void cleanRows(){
        jpBody.cleanRows();
    }

    public void fillListItem(ArrayList<String> list){
        jpFooter.fillList(list);
    }

    public String getItemObject(){
        return jpFooter.getItemObject();
    }

    public void setVisibleSell(boolean visibility){
        jpFooter.setVisibility(visibility);
    }

    public int getQuantity(){
        return jpFooter.getQuantity();
    }

    public void setValues(double totalInventory,int value){
        jpFooter.setValues(totalInventory,value);
    }

    public void setNumberitems(int value){
        jpHeader.setNumberitems(value);
    }
}
