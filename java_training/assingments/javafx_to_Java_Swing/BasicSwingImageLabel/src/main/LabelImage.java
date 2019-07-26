package main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LabelImage extends JFrame {

	JLabel broadcaster;
	
	LabelImage(String string){
		super(string);
	}

	public void addComponentsToPane() {
		File mushrooms = new File("src/fungi.png");
		BufferedImage fungiImageIcon;
		try {
			fungiImageIcon = ImageIO.read(mushrooms);
			Image scaled = fungiImageIcon.getScaledInstance(28, 28, java.awt.Image.SCALE_SMOOTH);
			Icon fungiIcon = new ImageIcon(scaled);
			broadcaster = new JLabel(fungiIcon);
			Font font = new Font(Font.SERIF, Font.PLAIN,  32);
			broadcaster.setText("Fungi");
			broadcaster.setFont(font);
			broadcaster.setIcon(fungiIcon);
		
			getContentPane().add(this.broadcaster, BorderLayout.CENTER);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}
	

}
