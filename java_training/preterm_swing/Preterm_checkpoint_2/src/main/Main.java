package main;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.client.Client;
import com.client.ClientStore;
import com.swing.containers.main.MatrixDisplayArea;

public class Main {

	public static void main(String[] args) {
		
		try {
			/* Use an appropriate Look and Feel */
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		/* Turn off metal's use of bold fonts */
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				createAndShowGUI();
				
			}
		});

	}

	private static void createAndShowGUI() {
		//Prepare Data for the theatre 
		ClientStore store = new ClientStore("clients_list.csv");
		List<Client> list = store.getClientStore();
		
		//Create frame and prepare for deployment
		MatrixDisplayArea frame = new MatrixDisplayArea("Theatre Seater", list);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addComponentsToPane();
		frame.pack();
		frame.setVisible(true);

	}

}
