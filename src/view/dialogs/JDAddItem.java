package view.dialogs;

import com.sun.org.apache.bcel.internal.Const;
import controller.Command;
import models.Item;
import utilities.UtilitiesView;
import view.Constant;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDAddItem extends JDialog {
    private JPanel container;
    private JTextArea jTName;
    private JButton jBCreate,jBCancel;
    private JFormattedTextField jtFUnitValue ,jtfQuantity,jtFCode;
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

        jTName = new JTextArea();
        jTName.setBorder(BorderFactory.createTitledBorder("Nombre"));
        container.add(jTName);
        jtFUnitValue = new JFormattedTextField();
        jtfQuantity = new JFormattedTextField();
        jtFCode = new JFormattedTextField();

        jtFUnitValue.setBorder(BorderFactory.createTitledBorder("Valor por unidad"));
        container.add(jtFUnitValue);
        jtfQuantity.setBorder(BorderFactory.createTitledBorder("Cantidad"));
        container.add(jtfQuantity);

        jtFCode.setBorder(BorderFactory.createTitledBorder("Codigo del producto"));
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

    public void showDialog(boolean visible){
        jTName.setText("");
        jtFCode.setText("");
        jtfQuantity.setText("");
        jtFUnitValue.setText("");
        this.setVisible(visible);
    }

    public Item createItem(){
        return new Item(Integer.parseInt(jtFCode.getText()),jTName.getText(),
                Integer.parseInt(jtfQuantity.getText()),
                UtilitiesView.toformatPrice(Integer.parseInt(jtFUnitValue.getText())));
    }

    public String getAddressStore() {
        return addressStore;
    }

    public void setAddressStore(String addressStore) {
        this.addressStore = addressStore;
    }

}
