package view;

import controller.Command;
import view.model.JBModel;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static javax.swing.JOptionPane.showMessageDialog;

public class JPHeader extends JPanel {
    private JModelMenu jModelMenu;
    private JFormattedTextField jFormattedTextField;
    private JButton jButton ,jbUpdate,jbDelete;
    private JLabel jLNumberItems;

    public JPHeader(ActionListener action) {
        initComponents(action);
    }

    private void initComponents(ActionListener action){
        jModelMenu = new JModelMenu(action);
        this.add(jModelMenu);

        jFormattedTextField = new JFormattedTextField();
        jFormattedTextField.setPreferredSize(new Dimension(100,25));
        this.add(jFormattedTextField);

        jButton = new JButton("Buscar articulo");
        jButton.setPreferredSize(new Dimension(150,25));
        jButton.setBackground(Constant.C_BLUE_MID);
        jButton.setForeground(Color.white);
        jButton.setFont(Constant.FONT_ARIAL_ROUNDER_15);
        jButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton.setActionCommand(Command.SEARCH.toString());
        jButton.addActionListener(action);
        this.add(jButton);

        jLNumberItems = new JLabel("Número de productos: ");
        jLNumberItems.setFont(Constant.FONT_ARIAL_ROUNDER_15);
        this.add(jLNumberItems);

        jbUpdate = new JButton(new ImageIcon(getClass().getResource(Constant.IMG_ICON_REFRESH)));
        jbUpdate.setBackground(Color.white);
        jbUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jbUpdate.addActionListener(action);
        jbUpdate.setActionCommand(Command.UPDATE.toString());
        jbUpdate.setBorder(BorderFactory.createEmptyBorder());
        jbUpdate.setPreferredSize(new Dimension(60,60));
        this.add(jbUpdate);

        jbDelete = new JBModel("Eliminar",Constant.IMG_ICON_DELETE,Constant.FONT_ARIAL_ROUNDER_15,15,15,Constant.C_WHITE,Constant.C_BLACK);
        jbDelete.setActionCommand(Command.SHOW_DELETE.toString());
        jbDelete.addActionListener(action);
        this.add(jbDelete);

        setVisibility(false);

    }

    public void setVisibility(boolean visibility){
        jFormattedTextField.setText("");
        jButton.setVisible(visibility);
        jFormattedTextField.setVisible(visibility);
        jModelMenu.setVisibleButton(visibility);
        jbUpdate.setVisible(visibility);
        jLNumberItems.setVisible(visibility);
        jbDelete.setVisible(visibility);
    }

    public String getSearchedCode(){
        return jFormattedTextField.getText();
    }

    public void setNumberitems(int value){
        this.jLNumberItems.setText("Número de productos: " + value);
    }
}
