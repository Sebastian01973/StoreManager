package view.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class JModelTextField extends JTextField{

	public JModelTextField(String text, String water, Font font, Color bg) {
		setBorder(BorderFactory.createTitledBorder(text));
		this.setFont(font);
		this.setBackground(bg);
		
		TextPrompt placeHolder = new TextPrompt(water, this);
		setColumns(22);
	}
	
	public void validateNum(JTextField jTextField) {
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Solo se puede ingresar Numeros.");
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}
		});
	}
	
	public void validateText(JTextField jTextField) {
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Solo se puede Ingresar Texto");
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}
		});
	}
}
