package view.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JBModel extends JButton {
    private int arcW;
    private int arcH;

    public JBModel(String text, Color backGround, ActionListener action,String command){
        super(text);
        this.setBackground(backGround);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setActionCommand(command);
        this.addActionListener(action);
    }

    public JBModel(String text,String imagePath,Font font,int width,int height, Color...colors) {
        super(text);
        this.setFont( font );
        ImageIcon imagen = new ImageIcon(getClass().getResource(imagePath));
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        this.setIcon(icon);
        this.setBorderPainted( false );
        this.setFocusable( false );
        this.setOpaque(false);
        this.setHorizontalTextPosition( SwingConstants.CENTER );
        this.setVerticalTextPosition( SwingConstants.BOTTOM );
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setBackground(colors[0]);
        this.setForeground(colors[1]);
    }

    public JBModel(String imagePath,int width,int height) {
        ImageIcon imagen = new ImageIcon(getClass().getResource(imagePath));
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        this.setIcon(icon);
        this.setBorderPainted( false );
        this.setFocusable( false );
        this.setOpaque(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public JBModel( int arcW, int arcH, String text, Color codeColorBackground, Color codeColorForeground, String command, ActionListener listener) {
        super( text );
        this.arcW = arcW;
        this.arcH = arcH;
        this.setBackground( codeColorBackground );
        this.setContentAreaFilled( false );
        this.setForeground(  codeColorForeground );
        this.setActionCommand( command );
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.addActionListener( listener );
    }

    public JBModel( int arcW, int arcH, String text, Color codeColorBackground, Color codeColorForeground, Font font, String command, ActionListener listener) {
        super( text );
        this.arcW = arcW;
        this.arcH = arcH;
        this.setBackground( codeColorBackground );
        this.setContentAreaFilled( false );
        this.setForeground(  codeColorForeground );
        this.setFont( font );
        this.setActionCommand( command );
        this.addActionListener( listener );
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arcW, arcH);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arcW, arcH);
    }
}
