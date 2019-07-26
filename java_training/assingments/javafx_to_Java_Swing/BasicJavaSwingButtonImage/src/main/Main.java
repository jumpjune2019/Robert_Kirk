package main;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main implements ActionListener {
	private JFrame mainFrame;
	private JLabel title;
	private JLabel broadcaster;
	private JButton resetButton;
	private JPanel controlPanel;

	public Main() throws IOException {
		prepareGUI();
	}

	private void prepareGUI() throws IOException {
		mainFrame = new JFrame("Swing Button Image");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));
		title = new JLabel("Push a button", JLabel.CENTER);
		broadcaster = new JLabel("", JLabel.CENTER);
		broadcaster.setSize(350, 100);
		resetButton = new JButton("Reset");
		resetButton.setText("Reset");
		resetButton.addActionListener(this);

		// old school way to close a window
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				// this is the way to force a java application to gracefully exit
				// when not going to end via the main method entry point
				System.exit(0);
			}
		});
		title.setText("Push a button");
		broadcaster.setText("");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JButton fungi = buttonGeneration("src/fungi.png", "Fungi");
		
		fungi.addActionListener(this);
		
		JButton dairy = buttonGeneration("src/dairy.png", "Dairy");
		
		dairy.addActionListener(this);

		panel.add(fungi);
		panel.add(dairy);

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		panel.add(broadcaster);
		panel.add(resetButton);
		mainFrame.add(title);
		mainFrame.add(panel);
		// mainFrame.add(controlPanel);
		// mainFrame.add(broadcaster);
		// mainFrame.add(resetButton);
		mainFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String str;
		String s = ae.getActionCommand();
		switch (s) {
		case "Reset":
			str = "";
			break;
		case "Fungi":
			str = "Fungi";
			break;
		case "Dairy":
			str = "Dairy";
			break;
		default:
			str = "no values to place";
			break;

		}

		broadcaster.setText(str);
	}
	public static JButton buttonGeneration(String filename, String name) {
		JButton button = new JButton();
		try {
			
			File picture = new File(filename);
			BufferedImage buttonImage = ImageIO.read(picture);
			Image scaled = buttonImage.getScaledInstance(28, 28, java.awt.Image.SCALE_SMOOTH);
			Icon icon = new ImageIcon(scaled);
			
			button.setText(name);
			
			button.setIcon(icon);
			
			Font font = new Font(Font.SERIF, Font.PLAIN,  32);
			
			button.setFont(font);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return button;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					Main gridLayoutDemo = new Main();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// gridLayoutDemo.showGridLayoutDemo();
			}
		});
	}
}