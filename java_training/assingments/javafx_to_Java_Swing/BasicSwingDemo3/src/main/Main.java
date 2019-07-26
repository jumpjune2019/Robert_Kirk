package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {
	JLabel broadcaster;
	Main(String s){
		super(s);
	}
	
	public void addComponentsToPane() {
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, 0));
		
		JPanel buttonPanelAlpha = new JPanel();
		
		JPanel buttonPanelBeta = new JPanel();
		
		JButton buttonAlpha = new JButton("Alpha");
		buttonAlpha.addActionListener(this);
		buttonAlpha.setSize(new Dimension(50,50));
		
		broadcaster = new JLabel("Broadcast zone");
		broadcaster.setText(" ");
		
		
		JButton buttonBeta = new JButton("Beta");
		buttonBeta.addActionListener(this);
		buttonBeta.setSize(new Dimension(50,50));
		
		buttonPanelAlpha.add(buttonAlpha);
		
		buttonPanelAlpha.add(buttonBeta);
		
		panel.add(buttonPanelAlpha);
		panel.add(buttonPanelBeta);
		panel.add(broadcaster);
		getContentPane().add(panel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Alpha")) {
			broadcaster.setText("Alpha");
		}else {
			broadcaster.setText("Beta");
		}
		
	}
	public static void main(String[] args) {
		Main frame = new Main("Demo 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.addComponentsToPane();
		frame.setPreferredSize(new Dimension(300,300));
		frame.pack();
		frame.setVisible(true);
	}

}
