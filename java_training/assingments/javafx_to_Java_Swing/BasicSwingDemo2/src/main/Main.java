package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {
	JLabel broadcaster;
	Main(String s){
		super(s);
	}
	
	public void addComponentsToPane() {
		
		JButton button = new JButton("Hello World!!");
		button.addActionListener(this);
		button.setSize(new Dimension(50,50));
		
		broadcaster = new JLabel("Broadcast zone");
		broadcaster.setText(" ");
		
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(this);
		reset.setSize(new Dimension(50,50));
		
		getContentPane().add(button, BorderLayout.NORTH);
		getContentPane().add(broadcaster, BorderLayout.CENTER);
		getContentPane().add(reset, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Reset")) {
			broadcaster.setText(" ");
		}else {
			broadcaster.setText("Hello World");
		}
		
	}
	public static void main(String[] args) {
		Main frame = new Main("Demo 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.addComponentsToPane();
		frame.setPreferredSize(new Dimension(100,100));
		frame.pack();
		frame.setVisible(true);
	}

}
