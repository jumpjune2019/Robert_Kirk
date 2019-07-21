package headortaillambda;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GameWindow extends  JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 716587635800657849L;
	
	static JTextArea displayArea;
	
	static final String newline = System.getProperty("line.separator");
	
	protected ComputerFlipper flipper = new ComputerFlipper();
	GameWindow(String title) {
		super(title);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("Click to Flip")) {
			displayInfo(flipper.game());
		}else if(s.equals("Reset")){
			displayArea.setText("...waiting\n");
		}
	}
	void addComponentsToPane() {

		JButton button = new JButton("Click to Flip");
		button.addActionListener(this);
		
		JButton clearButton = new JButton("Reset");
		clearButton.addActionListener(this);

		displayArea = new JTextArea();
		displayArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(displayArea);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)screenSize.getHeight()/2;
		int width = (int) screenSize.getWidth()/2;
		scrollPane.setPreferredSize(new Dimension(width, height));

		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(button, BorderLayout.EAST);
		getContentPane().add(clearButton,BorderLayout.PAGE_END);
	}

	public static void displayInfo(String message) {

		displayArea.append(message + "\n");

		displayArea.setCaretPosition(displayArea.getDocument().getLength());
	}

}
