package view.dialogs;

import com.sun.org.apache.bcel.internal.Const;
import controller.Command;
import models.Item;
import utilities.UtilitiesView;
import view.Constant;
import view.model.JModelTextField;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDAddItem extends JDialog {
    private JPanel container;
    private JModelTextField jTName;
    private JButton jBCreate,jBCancel;
    private JModelTextField jtFUnitValue ,jtfQuantity,jtFCode;
    private String addressStore;

    public JDAddItem(ActionListener actionListener,Component component) {
        this.setSize(350,450);
        this.setIconImage(new ImageIcon(getClass().getResource(Constant.IMG_ICON_ADD_DIALOGS)).getImage());
        this.setLayout(new BorderLayout());
        initComponents(actionListener);
        this.setLocationRelativeTo(component);
        this.setVisible(false);
        this.addressStore = "";
    }

    private void initComponents(ActionListener action){
        GridLayout grid = new GridLayout(7,1);
        grid.setVgap(20);
        container = new JPanel();
        container.setLayout(grid);
        container.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        container.setBackground(Color.white);

        jTName = new JModelTextField("Nombre del producto","Ingrese Nombre producto",Constant.FONT_ARIAL_ROUNDER_15,Constant.C_WHITE);
        jTName.validateText(jTName);
        container.add(jTName);

        jtFUnitValue = new JModelTextField("Valor por unidad","Ingrese Unidades",Constant.FONT_ARIAL_ROUNDER_15,Constant.C_WHITE);
        jtFUnitValue.validateNum(jtFUnitValue);
        container.add(jtFUnitValue);

        jtfQuantity = new JModelTextField("Cantidad:","Ingrese Cantidad",Constant.FONT_ARIAL_ROUNDER_15,Constant.C_WHITE);
        jtfQuantity.validateNum(jtfQuantity);
        container.add(jtfQuantity);

        jtFCode = new JModelTextField("Codigo:","Ingrese Codigo",Constant.FONT_ARIAL_ROUNDER_15,Constant.C_WHITE);
        jtFCode.validateNum(jtFCode);
        container.add(jtFCode);

        jBCreate = new JButton("Crear Articulo");
        jBCreate.setBackground(Constant.C_DARK_GREEN);
        jBCreate.setForeground(Color.white);
        jBCreate.setPreferredSize(new Dimension(250,30));
        jBCreate.setActionCommand(Command.CREATE_ITEM.toString());
        jBCreate.addActionListener(action);
        container.add(jBCreate);

        jBCancel = new JButton("Cancelar");
        jBCancel.setPreferredSize(new Dimension(250,30));
        jBCancel.setBackground(Constant.C_DARK_RED);
        jBCancel.setForeground(Color.white);
        jBCancel.setActionCommand(Command.CANCEL_CREATE_ITEM.toString());
        jBCancel.addActionListener(action);
        container.add(jBCancel);

        this.add(container,BorderLayout.CENTER);

    }

    public void showDialog(boolean visible, boolean isChange){
        if (isChange){
            jTName.setText("");
            jtfQuantity.setText("");
            jtFUnitValue.setText("");
            jtFCode.setText("");
            jtFCode.setForeground(Color.black);
        }else{
            jtFCode.setForeground(Constant.C_DARK_RED);
        }
        this.setVisible(visible);
    }

    public boolean isValidate(String name,String value,String unit,String code){
        return (name.isEmpty() || value.isEmpty() || unit.isEmpty() || unit.isEmpty()) ? true:false;
    }

    public Item createItem(){
        if (!isValidate(jTName.getText(),jtFCode.getText(),jtFUnitValue.getText(),jtfQuantity.getText())){
            return new Item(Integer.parseInt(jtFCode.getText()),jTName.getText(),
                    Integer.parseInt(jtfQuantity.getText()),
                    UtilitiesView.toformatPrice(Integer.parseInt(jtFUnitValue.getText())));
        }else{
            return null;
        }
    }

    public String getAddressStore() {
        return addressStore;
    }

    public void setAddressStore(String addressStore) {
        this.addressStore = addressStore;
    }

}
