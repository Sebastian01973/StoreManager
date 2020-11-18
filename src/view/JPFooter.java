package view;

import controller.Command;
import javafx.scene.control.TextFormatter;
import utilities.UtilitiesView;
import view.model.JBModel;
import view.model.JModelTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPFooter extends JPanel {
    private JLabel totalInventory, valueInventory,totalSale;
    private int valueLabel;
    private JComboBox<String> jCitemList;
    private JSpinner jsQuantity;
    private JBModel jBSell;
    private ArrayList<String> list;
    private JModelTextField textDelete;
    private JButton jbDelete;

    public JPFooter(ActionListener action) {
        GridLayout grid = new GridLayout(1,6);
        this.setBackground(Constant.C_DARK_BLUE);
        grid.setHgap(20);
        this.setLayout(grid);
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        initComponents(action);
        this.setPreferredSize(new Dimension(0,100));
        this.valueLabel = 0;
    }


    private void initComponents(ActionListener action){
        totalInventory = new JLabel(" valor total del inventario: ");
        totalInventory.setFont(Constant.FONT_ARIAL_ROUNDER_15);
        totalInventory.setForeground(Color.white);
        this.add(totalInventory);
        valueInventory = new JLabel(String.valueOf(valueLabel));
        valueInventory.setFont(Constant.FONT_ARIAL_ROUNDER_15);
        valueInventory.setForeground(Color.white);
        this.add(valueInventory);

        totalSale = new JLabel("Ultima venta: " + 0);
        totalSale.setFont(Constant.FONT_ARIAL_ROUNDER_15);
        totalSale.setForeground(Color.WHITE);
        this.add(totalSale);
        this.list = new ArrayList<>();

        jCitemList = new JComboBox<>();
        jCitemList.setPreferredSize(new Dimension(0,30));
        jCitemList.setBackground(Color.decode("#131345"));
        jCitemList.setForeground(Color.decode("#e4e4f0"));
        this.add(jCitemList);

        SpinnerNumberModel spModel = new SpinnerNumberModel(1,0,null,1);
        jsQuantity = new JSpinner(spModel);
        this.add(jsQuantity);

        jBSell = new JBModel(10,10,"Vender",Constant.C_DARK_RED,Color.white,Command.TO_SELL.toString(),action);
        this.add(jBSell);

        textDelete = new JModelTextField("Eliminar:","Ej: 2-6",Constant.FONT_ARIAL_ROUNDER_15,Constant.C_WHITE);
        textDelete.validateNum(textDelete);
        this.add(textDelete);

        jbDelete = new JBModel("Eliminar",Constant.IMG_ICON_DELETE,Constant.FONT_ARIAL_ROUNDER_15,15,15,Constant.C_WHITE,Constant.C_BLACK);
        jbDelete.setActionCommand(Command.DELETE_RANG_ITEM.toString());
        jbDelete.addActionListener(action);
        this.add(jbDelete);

        setVisibility(false);
    }

    public int[] getDeleteString(){
        String[] auxSplit = textDelete.getText().split("-");
        if (auxSplit.length > 1){
            if (auxSplit.length <= 2 && !auxSplit[0].isEmpty()){
                return new int[]{Integer.parseInt(auxSplit[0]),Integer.parseInt(auxSplit[1])};
            }
        }
        textDelete.setText("");
        return null;
    }

    public void setVisibleDelete(boolean visible){
        textDelete.setText("");
        textDelete.setVisible(visible);
        jbDelete.setVisible(visible);
    }

    public void fillList(ArrayList<String> list){
        setList(list);
        jCitemList.addItem("Cod.-Nombre-Unidades-Vr. Unidad");
        for (String s:list){
            jCitemList.addItem(s);
        }
    }

    public void setList(ArrayList<String> list) {
        this.jCitemList.removeAllItems();
        this.list = list;
        this.jsQuantity.setValue(0);
        this.totalSale.setText("0");
    }

    public String getItemObject(){
        if (jCitemList.getSelectedIndex() == 0 || jCitemList.getSelectedItem() == null){
            return "";
        }
        return jCitemList.getSelectedItem().toString();
    }

    public int getQuantity(){
        return (int) jsQuantity.getValue();
    }

    public void setVisibility(boolean visibility){
        this.jCitemList.setVisible(visibility);
        jsQuantity.setVisible(visibility);
        jBSell.setVisible(visibility);
        jbDelete.setVisible(visibility);
        textDelete.setVisible(visibility);
    }

    public void setValues(double totalInventory,int totalSale){
        this.valueInventory.setText(""+totalInventory);
        String[] data = UtilitiesView.split(getItemObject());
        if (totalSale > 0) {
            totalSale = (int) (Double.parseDouble(data[3])*totalSale);
            this.totalSale.setText("Ultima venta:"+totalSale);
        }
    }

}
