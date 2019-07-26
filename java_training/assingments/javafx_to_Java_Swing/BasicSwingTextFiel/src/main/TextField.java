package main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextField extends JFrame implements ActionListener, KeyListener {

	JLabel title;
	JLabel broadcaster;
	JButton button;
	JTextField field;

	TextField(String string) {
		super(string);
	}

	public void addComponentsToPane() {
		this.title = new JLabel("Text Field Demo");
		this.title.setText("Text Field Demo");
		this.broadcaster = new JLabel("Text display area");

		this.button = new JButton("Display");
		this.button.addActionListener(this);
		JPanel controlBox = new JPanel();
		controlBox.setLayout(new BoxLayout(controlBox, 1));
		controlBox.add(broadcaster);
		controlBox.add(button);
		field = new JTextField();
		field.addActionListener(this);
		getContentPane().add(title, BorderLayout.NORTH);
		getContentPane().add(this.field, BorderLayout.CENTER);
		getContentPane().add(controlBox, BorderLayout.SOUTH);

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// e.getKeyChar();
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 13) {

			this.broadcaster.setText(this.field.getText());
			this.field.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.broadcaster.setText(this.field.getText());
		// this.field.setText("");

	}

}
