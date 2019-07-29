package main;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.client.Client;
import com.client.ClientStore;
import com.room.Room;
import com.swing.containers.main.MatrixDisplayArea;

public class Main {

//	public static void startApp() {
//		System.out.println("startApp()");
//		System.out.println("\n");
//		
//		appSession.start();
//
//	}

	private static void placeRandomResersvationsForAll(Room room) {
		ClientStore store = new ClientStore("clients_list.csv");
		List<Client> clientsList = store.getClientStore();
		room.fillTheatre(clientsList);
		System.out.println(room.toString());
		room.trueArrayString();
		room.getListOfReservations();

	}

	private static Room generateRoom() {
		System.out.println("Generating Room");
		Room room = new Room(10,10);
		room.makeRoom();
		
		System.out.println(room.toString());
		room.trueArrayString();
		
		return room;

	}

//	public static void getInput() {
//
//		// quick test of the client data structure
//		System.out.println("getInput()\n");
//		System.out.println("- We are going to create a Client class that will hold data and return itself or some info about it");
//		Client testClient = new Client("Gauthier", "Claude", 2);
//		System.out.println("Lastname: " + testClient.getClientLastName() + " " + "Firstname: " + testClient.getClientFirstName() + " " + "ID: " + testClient.getClientId());
//		System.out.println("\n\n");
//		// quick test to see if we can load data from a CSV file
//		// and at least get an accurate count of the rows loaded in
//		System.out.println("- Testing the ClientStore class\n");
//		ClientStore myStore = new ClientStore("clients_list.csv");
//		Client[] store = myStore.getClientStore();
//		System.out.println("\n");
//		System.out.println("- DataCount: " + myStore.getClientDataCount());
//		System.out.println("\nThis is a list of all the data in the store\n");
//		// iterate via the array of store.
//		for(Client c : store) {
//			if(c != null) {
//				System.out.println(c.getFullClientString());
//			}
//		}
//		
//	}	

	public static void main(String[] args) {
		Room room = generateRoom();
		placeRandomResersvationsForAll(room);
		/* Use an appropriate Look and Feel */
		try {
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
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

//Schedule a job for event dispatch thread:
//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
				
			}
		});

	}
	@SuppressWarnings("static-access")
	private static void createAndShowGUI() {
		ClientStore store = new ClientStore("clients_list.csv");
		List<Client> list = store.getClientStore();
		MatrixDisplayArea frame = new MatrixDisplayArea("Theatre Seater", list);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.addComponentsToPane();

		frame.pack();
		frame.setVisible(true);
		
		//Initial Greeting
		//frame.displayInfo(frame.diceRoller.gameStart());
	}

}
