package view.dialogs;

import controller.Command;
import models.Store;
import view.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDialogAdd extends JDialog {

    private JTextArea jTname,jTAddress;
    private JButton jBAdd,jBCancel;
    private  JPanel jPContenetor;
    public JDialogAdd(ActionListener action) {
        this.setSize(350,300);
        this.setTitle("Añadir Almacen");
        this.setLayout(new BorderLayout());
        this.setIconImage(new ImageIcon(getClass().getResource(Constant.IMG_ICON_ADD_DIALOGS)).getImage());
        initComponents(action);
        this.setVisible(false);
    }

    private void initComponents(ActionListener action){
        jPContenetor = new JPanel();
        jPContenetor.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        GridLayout grid = new GridLayout(4,1);
        grid.setVgap(20);
        grid.setHgap(20);
        jPContenetor.setLayout(grid);
        jPContenetor.setBackground(Color.white);

        jTname = new JTextArea();
        jTname.setPreferredSize(new Dimension(200,30));
        jTname.setLineWrap(true);
        jTname.setBorder(BorderFactory.createTitledBorder("Nombre"));
        jPContenetor.add(jTname);

        jTAddress = new JTextArea();
        jTAddress.setPreferredSize(new Dimension(200,30));
        jTAddress.setBorder(BorderFactory.createTitledBorder("Direccion"));
        jPContenetor.add(jTAddress);
        this.add(jPContenetor, BorderLayout.CENTER);

        jBAdd = new JButton("Añadir Almacen");
        jBAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jBAdd.setBackground(Constant.C_DARK_GREEN);
        jBAdd.setForeground(Color.white);
        jBAdd.setPreferredSize(new Dimension(250,25));
        jBAdd.setFont(Constant.FONT_ARIAL_ROUNDER_15);
        jBAdd.setActionCommand(Command.CREATE_STORE.toString());
        jBAdd.addActionListener(action);
        jPContenetor.add(jBAdd);

        jBCancel = new JButton("Cancelar");
        jBCancel.setBackground(Constant.C_DARK_RED);
        jBCancel.setForeground(Color.white);
        jBCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jBCancel.setPreferredSize(new Dimension(250,25));
        jBCancel.setFont(Constant.FONT_ARIAL_ROUNDER_15);
        jBCancel.addActionListener(action);
        jBCancel.setActionCommand(Command.CANCEL_CREATE_STORE.toString());
        jPContenetor.add(jBCancel);
    }

    public void showDialog(boolean visibility){
        this.setVisible(visibility);
        this.jTname.setText("");
        this.jTAddress.setText("");
    }

    public Store getNewStore(){
        if (!(jTname.getText().isEmpty() || jTAddress.getText().isEmpty())){
            return new Store(jTname.getText(),jTAddress.getText());
        }
        return null;
    }




}
