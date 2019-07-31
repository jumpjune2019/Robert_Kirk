package com.swing.containers.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.client.Client;
import com.room.Room;

@SuppressWarnings("serial")
public class MatrixDisplayArea extends JFrame implements ActionListener {

	// Model for allowing dynamic JList
	DefaultListModel<String> dm = new DefaultListModel<String>();

	// List that will be displayed to people
	JList<String> listOfClientNamesToBeDisplayed;

	// Contains all names for creating and restoring the list of names in dm
	String[] clientNamesList;

	// Holds all clients to help create hash map
	List<Client> store;

	// Hash map that allows for client info to be located by name
	HashMap<String, Client> storeMap;

	// Holds theatre grid
	JPanel displayArea;

	// Holds title
	JPanel titleArea;
	JLabel title;

	// Holds buttons to assign all and reset seats
	JPanel broadcastingArea;

	// Holds client that has been selected
	Client stagedClient;
	// Holds index of the clients name
	int stagedIndex;

	// Displays JList
	JScrollPane scrollPaneOfClients;

	// Holds the room object that creates the matrix and provides functionality for
	// handling space in the room.
	Room room;

	public MatrixDisplayArea(String title, List<Client> clients) {
		// Create a new JFrame container.
		super(title);
		this.store = clients;
		this.createJList();

	}

	private void createJList() {
		// Create client array for hash map usage.
		Client[] list = this.getClientArray(this.store);
		// Create string array of names for other lists
		String[] names = this.getClientNames(this.store);
		this.clientNamesList = names;

		this.storeMap = this.generateMap(list, names);

		// Instantiate JList
		this.listOfClientNamesToBeDisplayed = new JList<String>();
		// Set model of the JList to the DM
		this.listOfClientNamesToBeDisplayed.setModel(dm);
		// Convert String Array to DefaultModel for JList ot display
		dm.addAll(Arrays.asList(names));
		// Create event listener to detect if an item has been selected
		// it will then be staged for potential usage
		this.listOfClientNamesToBeDisplayed.addListSelectionListener(this.listSelectionListener);
	}

	// Listener that will on list selection stage the selected client
	ListSelectionListener listSelectionListener = new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			String s = listOfClientNamesToBeDisplayed.getSelectedValue();
			stageClient(s);
			stagedIndex = e.getLastIndex();
		}
	};

	// gets client info from hash map which is more efficient than looping through
	// an array multiple times.
	private void stageClient(String s) {
		this.stagedClient = this.storeMap.get(s);
	}

	// Creates an array of names
	private String[] getClientNames(List<Client> clients) {
		String[] store = new String[clients.size()];
		for (int i = 0; i < clients.size(); i++) {
			Client c = clients.get(i);
			store[i] = c.getClientFirstName() + " " + c.getClientLastName();
		}
		return store;
	}

	// Creates an array of Clients
	private Client[] getClientArray(List<Client> clients) {
		Client[] store = new Client[clients.size()];
		for (int i = 0; i < clients.size(); i++) {
			store[i] = clients.get(i);
		}
		return store;
	}

	// Generate hash map created from the arrays above
	private HashMap<String, Client> generateMap(Client[] client, String[] name) {
		HashMap<String, Client> clientMap = new HashMap<String, Client>();
		for (int i = 0; i < client.length; i++) {
			clientMap.put(name[i], client[i]);
		}

		return clientMap;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO set new action for app button clicks
		String s = e.getActionCommand();

		if (s.equals("Reset All")) {

			// handles the reseting of the room
			this.resetRoom();

			// Regex detecting for button press from the matrix will catch
			// any single alphabetical character followed by a '-' and a multiple digits
		} else if (s.equals("Assign All in List")) {
			this.assignAll();
		} else if (s.matches("[a-z,A-Z]-\\d+")) {
			this.processSeatingButtonClick(e);
		} else if (s.equals("Print All Reservations")) {
			this.printAllSeatsReserved();
		} else {
			System.out.println("tap");
		}
	}

	private void processSeatingButtonClick(ActionEvent e) {
		// Gets the source of the button
		JButton pressed = (JButton) e.getSource();

		// gets the parent panel then its parent panel then gain access to the panel
		// containing the panel that needs to be changed
		JPanel circuit = (JPanel) pressed.getParent().getParent().getComponent(0);

		// Gain access to the label that needs to be changed
		JLabel readout = (JLabel) circuit.getComponent(0);
		try {
			String[] idAndInit = readout.getText().split(" ");
			String[] id = idAndInit[1].split("/");
			int idNumb = Integer.valueOf(id[0]);
			String nameKey = clientNamesList[idNumb - 1];

			this.dm.addElement(nameKey);

			readout.setText("Vacant");
		} catch (Exception e2) {
			if (readout.getText().equals("Vacant")) {
				try {
					this.assignClientSeat(this.stagedClient, readout);
					int i = this.listOfClientNamesToBeDisplayed.getSelectedIndex();
					dm.remove(i);
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			} else {
				readout.setText("Vacant");
			}
		}
	}

	// Assigns a seat to a client
	private void assignClientSeat(Client c, JLabel readout) {

		// creatInitial creates the label we need to display
		String customer = c.createInitial();
		readout.setText(customer);

	}

	// Displays room as vacant and refills displayed names
	private void resetRoom() {
		// clear list
		this.dm.removeAllElements();
		// fill list back up
		this.dm.addAll(Arrays.asList(this.clientNamesList));
		// set all seats to vacant
		int[][] matrix = this.room.getMatrix();
		int rows = this.room.getRows();
		int index = matrix[0].length - 1;
		for (int i = 1; i < rows; i++) {
			index += 1;
			int[] row = matrix[i];
			int len = row.length;
			for (int j = 1; j < len; j++) {
				index += 1;
				JPanel circuit = (JPanel) displayArea.getComponent(index);
				JPanel labelContainer = (JPanel) circuit.getComponent(0);
				JLabel label = (JLabel) labelContainer.getComponent(0);
				label.setText("Vacant");
			}

		}
		room.resetSeatedClients();

	}

	// As an extra assignment I was told to create a button that
	// auto assigns all clients randomly to a seat. This method does that
	private void assignAll() {
		// TODO SCOPE CREEP create means to randomly pick clients
		// gets size of current model for JList
		int j = dm.getSize();

		// Loops through current model
		for (int i = 0; i < j; i++) {

			// grabs name from list so we can access the hash map and get necessary info for
			// label creation
			String name = dm.get(i);

			// grabs random seat that is vacant from GUI
			JLabel label = this.generateSeatValue();

			// If the seat is labeled vacant it can be taken and seated
			// Will through null if the theatre is full of seats.
			try {
				this.assignClientSeat(storeMap.get(name), label);
			} catch (NullPointerException e) {
				break;
			}
		}
		// clear list to remove all names from the list
		dm.clear();
	}

	private JLabel generateSeatValue() {
		// TODO need to create a means to detect if the theatre is completely full. and
		// stop assignment

		// Controls loop to wait for a vacant seat to be found
		boolean notGoodSeat = true;

		while (notGoodSeat) {

			int[][] mat = this.room.getMatrix();
			// Finds random seat
			int seat = (int) (Math.random() * (this.displayArea.getAccessibleContext().getAccessibleChildrenCount())
					+ mat[0].length);
			if (seat % this.room.getCols() != 0) {
				// Gets seat
				try {
					JPanel circuit = (JPanel) displayArea.getComponent(seat);
					JPanel labelContainer = (JPanel) circuit.getComponent(0);
					JLabel label = (JLabel) labelContainer.getComponent(0);
					if (label.getText().equals("Vacant")) {
						return label;
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
		return null;
	}

	public void addComponentsToPane() {

		// Creates room by default it is a 10 by 10 room that is an 11 by 11 matrix to
		// include rows and seat numbers
		room = new Room();

		// Creates main display area
		displayArea = new JPanel();
		// Creates an 11X11 grid by default based on the room
		displayArea.setLayout(new GridLayout(room.getCols(), room.getRows()));

		// fills the grid based on the integer values of the matrix;
		this.addContent(room.getMatrix());

		displayArea.setPreferredSize(new Dimension(600, 600));

		// Creates title
		String titleText = "Preterm Second Pass: Theatre Seat Assigning";
		this.title = new JLabel(titleText);
		titleArea = new JPanel();
		titleArea.add(title, BorderLayout.CENTER);
		titleArea.setPreferredSize(new Dimension(room.getCols() * 50, 40));

		// create scroll pane to hold JList of unseated clients
		JScrollPane scrollPane = new JScrollPane(displayArea);
		this.scrollPaneOfClients = new JScrollPane(this.listOfClientNamesToBeDisplayed);

		// Creates area where buttons will be placed
		broadcastingArea = new JPanel();
		broadcastingArea.setPreferredSize(new Dimension(room.getCols() * 50, 40));

		// Creates ResetButton
		JButton resetButton = cellButton("Reset All");
		// adds reset button to broadcastingArea panel
		broadcastingArea.add(resetButton, BorderLayout.CENTER);

		// Creates new button for printing all reservations in the room
		JButton printBtn = cellButton("Print All Reservations");
		// add printBtn to broadcastingArea panel
		broadcastingArea.add(printBtn);
		
		// Creates new button for Assigning all seats to all clients that have not been
		// assigned a seat.
		JButton assignAllBtn = cellButton("Assign All in List");
		// add assignAllBtn to broadcastingArea panel
		broadcastingArea.add(assignAllBtn);



		// Print All Reservations

		// Adds all components to the JFrame
		getContentPane().add(this.scrollPaneOfClients, BorderLayout.LINE_START);
		getContentPane().add(titleArea, BorderLayout.NORTH);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(broadcastingArea, BorderLayout.SOUTH);
	}

	// constructs cell
	private JPanel constructCell(int[][] matrix, int rowNum, int col) {
		// gets if the seat is taken or not
		String labelText = isVacant(matrix, rowNum, col);
		// sets button text
		String buttonText = (char) (65 + rowNum) + "-" + (col + 1);

		// creates container for label
		JPanel labelContainer = new JPanel();
		JLabel label = new JLabel(labelText);
		// label.addPropertyChangeListener(propertyName, listener);
		labelContainer.add(label, BorderLayout.CENTER);

		// creates container for button
		JPanel buttonContainer = new JPanel();

		// creates button
		JButton button = this.cellButton(buttonText);
		buttonContainer.add(button, BorderLayout.CENTER);

		// Sets Cells main panel to a grid type with preferred dimension to 50, 50
		JPanel cellBox = new JPanel();
		cellBox.setPreferredSize(new Dimension(50, 50));
		cellBox.add(labelContainer);
		cellBox.add(buttonContainer, BorderLayout.CENTER);
		// sets layout to box layout that goes vertically #1
		cellBox.setLayout(new BoxLayout(cellBox, 1));

		return cellBox;
	}

	private String isVacant(int[][] roomMatrix, int i, int j) {
		// makes sell label vacant or seats a client
		if (roomMatrix[i + 1][j + 1] == 0) {
			return "Vacant";
		} else {
			int x = roomMatrix[i][j];
			String s = dm.get(x - 1);
			Client c = storeMap.get(s);
			// Removes client from list
			dm.remove(x - 1);
			return "id: " + x + "/" + c.createInitial();

		}
	}

	private void addContent(int[][] roomMatrix) {
		for (int i = 0; i < roomMatrix.length; i++) {
			for (int j = 0; j < roomMatrix[i].length; j++) {
				// sets up columns and rows
				if (i == 0 || j == 0) {
					JPanel label = constructLabel(i, j, roomMatrix);
					displayArea.add(label);
					// sets up buttons
				} else {
					JPanel cell = constructCell(roomMatrix, i - 1, j - 1);
					String labelText = ((char) (65 + i - 1)) + "-" + (j - 1);
					displayArea.add(labelText, cell);
				}
			}
		}
	}

	// Creates labels for seating chart
	private JPanel constructLabel(int i, int j, int[][] arr) {
		// voids top left corner
		if (i == 0 && j == 0) {
			JPanel voidCorner = new JPanel();
			voidCorner.setPreferredSize(new Dimension(50, 50));
			return voidCorner;
			// Sets seat numbering seats 1, 2, 3, 4, 5 ... -> n seats long
		} else if (i == 0) {
			JPanel seatNumber = new JPanel();
			seatNumber.setPreferredSize(new Dimension(50, 50));
			JLabel label = new JLabel();
			String text = String.valueOf(j);
			System.out.println(text);
			label.setText(text);
			seatNumber.add(label, BorderLayout.CENTER);
			return seatNumber;
			// Sets row names A, B, C, D ... -> Unicode 65+ lettering
		} else {
			JPanel rowLetter = new JPanel();
			rowLetter.setPreferredSize(new Dimension(50, 50));
			JLabel label = new JLabel();

			char textChar = Character.valueOf((char) (65 + i - 1));

			String text = Character.toString(textChar);

			label.setText(text);
			rowLetter.add(label, BorderLayout.CENTER);
			return rowLetter;
		}
	}

	// creates JButtons for the seating process
	public JButton cellButton(String label) {
		JButton jbtn = new JButton(label);
		// Add action listeners.
		jbtn.addActionListener(this);
		// Add the buttons to the content pane.
		return jbtn;
	}

	private void printAllSeatsReserved() {
		// set all seats to vacant
		System.out.println("Printing reservations. Standby\n");
		int[][] matrix = this.room.getMatrix();
		int rows = this.room.getRows();
		int index = matrix[0].length - 1;
		//name column width 30
		// id column length = 4
		System.out.println("Name" + getSpaces(30,4) + "ID" + getSpaces(4,2) + "Seat\n");
		for (int i = 1; i < rows; i++) {

			index += 1;
			int[] row = matrix[i];
			int len = row.length;
			for (int j = 1; j < len; j++) {
				index += 1;
	
				JPanel circuit = (JPanel) displayArea.getComponent(index);
				JPanel labelContainer = (JPanel) circuit.getComponent(0);
				JLabel label = (JLabel) labelContainer.getComponent(0);
				JPanel buttonContainer = (JPanel) circuit.getComponent(1);
				JButton button = (JButton) buttonContainer.getComponent(0);

				String seat = label.getText();
				if (seat.matches("(id:) \\d+/\\w+")) {
					seat = seat.replaceAll("\\D", "").trim();					
					Integer idNum;
					String clientName;
					try {
						idNum = Integer.parseInt(seat);
						clientName = this.clientNamesList[idNum - 1];
						System.out.println(clientName + getSpaces(30,clientName.length()) + idNum + getSpaces(4,seat.length()) + button.getText());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}

		}

	}

	private String getSpaces(int i, int j) {
		String s = "";
		for(int spaces = 0; spaces<(i-j); spaces++) {
			s+= " ";
		}
		return s;
	}

}
