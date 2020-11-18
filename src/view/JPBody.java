package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JPBody extends JPanel {
    private JpTable jpTable;

    public JPBody(ActionListener action, MouseListener mouseListener) {
        this.setLayout(new BorderLayout(0,0));
        this.setBackground(Color.GREEN);
        initComponents(action ,mouseListener);
    }

    private void initComponents(ActionListener action,MouseListener mouseListener){
        jpTable = new JpTable(action,mouseListener);
        this.add(jpTable,BorderLayout.CENTER);
    }

    public void addRowTable(Object[] vector){
        jpTable.addRowTable(vector);
    }

    public void addRowsToTable(ArrayList<Object[]> matrix,String[] headers){
        jpTable.addRowsToTable(matrix,headers);
    }

    public String getSelectedRow(Point point){
        return jpTable.getSelectedRow(point);
    }

    public void cleanRows(){
        jpTable.cleanRowsTable();
    }
}
