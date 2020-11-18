package view;

import controller.Command;
import view.model.JModelMenuItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JModelMenu extends JMenuBar {

    private JModelMenuItem itemAddStore, itemSale, addItem, backItem;

    public JModelMenu(ActionListener action) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBorder(new EmptyBorder(15,10,5,15));
        this.setBackground(Color.WHITE);
        initComponents(action);
    }

    private void initComponents(ActionListener action){
        itemAddStore = new JModelMenuItem("Añadir",Constant.IMG_ICON_ADD,Constant.FONT_ARIAL_ROUNDER_15,
                25,25,Color.white,Color.BLACK);
        itemAddStore.setActionCommand(Command.ADD_STORE.toString());
        itemAddStore.addActionListener(action);
        this.add(itemAddStore);

        itemSale = new JModelMenuItem("Nueva venta",Constant.IMG_ICON_SALE,Constant.FONT_ARIAL_ROUNDER_15,25,25,
                Color.WHITE,Color.BLACK);
        itemSale.setActionCommand(Command.NEW_SALE.toString());
        itemSale.addActionListener(action);
        this.add(itemSale);

        addItem = new JModelMenuItem("Añadir articulo", Constant.FONT_ARIAL_ROUNDER_15,Color.WHITE);
        addItem.addActionListener(action);
        addItem.setActionCommand(Command.ADD_ITEM.toString());
        this.add(addItem);

        backItem = new JModelMenuItem("Regresar",Constant.IMG_ICON_BACK,Constant.FONT_ARIAL_ROUNDER_15,25,25
                ,Color.WHITE,Color.BLACK);
        backItem.addActionListener(action);
        backItem.setActionCommand(Command.BACK.toString());
        this.add(backItem);
    }

    public void setVisibleButton(boolean visibility){
        addItem.setVisible(visibility);
        backItem.setVisible(visibility);
        itemSale.setVisible(visibility);
        itemAddStore.setVisible(!visibility);
    }
}
