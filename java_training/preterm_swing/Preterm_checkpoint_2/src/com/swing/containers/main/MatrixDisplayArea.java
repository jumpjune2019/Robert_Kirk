package com.swing.containers.main;

import java.awt.BorderLayout;
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

	DefaultListModel<String> dm = new DefaultListModel<String>();

	JList<String> listOfClientNamesToBeDisplayed;

	JList<Client> clientsJList;

	String[] clientNamesList;

	List<Client> store;

	HashMap<String, Client> storeMap;

	JPanel displayArea;

	JPanel titleArea;

	JLabel title;

	JPanel broadcastingArea;

	JButton broadcaster;

	Client stagedClient;
	
	int stagedIndex;
	
	JScrollPane scrollPaneOfClients;
	

	Room room;

	final String newline = System.getProperty("line.separator");

	public MatrixDisplayArea(String title, List<Client> clients) {
		// Create a new JFrame container.
		super(title);
		this.store = clients;

		this.createJList();
	}

	private void createJList() {

		Client[] list = this.getClientArray(this.store);
		this.clientsJList = new JList<Client>(list);
		String[] names = this.getClientNames(this.store);
		this.clientNamesList = names;
		// this.clientNames = new JList<String>(names);

		this.storeMap = this.generateMap(list, names);

		// this.clientNames.addListSelectionListener(listSelectionListener);
		this.listOfClientNamesToBeDisplayed = new JList<String>();

		this.listOfClientNamesToBeDisplayed.setModel(dm);

		dm.addAll(Arrays.asList(names));

		this.listOfClientNamesToBeDisplayed.addListSelectionListener(this.listSelectionListener);

	}

	ListSelectionListener listSelectionListener = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			String s = listOfClientNamesToBeDisplayed.getSelectedValue();
			stageClient(s);
			stagedIndex = e.getLastIndex();
			
		}
	};

	private void stageClient(String s) {
		this.stagedClient = this.storeMap.get(s);
	}

	private HashMap<String, Client> generateMap(Client[] client, String[] name) {
		HashMap<String, Client> clientMap = new HashMap<String, Client>();
		for (int i = 0; i < client.length; i++) {
			clientMap.put(name[i], client[i]);
		}
		
		return clientMap;
	}

	private String[] getClientNames(List<Client> clients) {
		String[] store = new String[clients.size()];
		for (int i = 0; i < clients.size(); i++) {
			Client c = clients.get(i);
			store[i] = c.getClientFirstName() + " " + c.getClientLastName();
		}
		return store;
	}

	private Client[] getClientArray(List<Client> clients) {
		Client[] store = new Client[clients.size()];
		for (int i = 0; i < clients.size(); i++) {
			store[i] = clients.get(i);
		}
		return store;
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
				// return client to JList
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
		} else {
			System.out.println("tap");
		}
	}

	private void assignClientSeat(Client c, JLabel readout) {
		System.out.println(c.getClientFirstName());
		
		//room.getSeatedClients().put(c.getClientFirstName() + " " + c.getClientLastName(), readout.getText());
		String customer = c.createInitial();
		readout.setText(customer);

	}

	private void resetRoom() {
		this.dm.removeAllElements();
		this.dm.addAll(Arrays.asList(this.clientNamesList));
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

	private void assignAll() {
		int j = dm.getSize();
		System.out.println("DM SIZE: "+j);
		for (int i = 0; i < j; i++) {
			boolean notSeated = true;
			String name = dm.get(i);
			System.out.println(name+ " " +i);
			do {

				JLabel label = this.generateSeatValue();
				try {
					
					if (label.getText().equals("Vacant")) {
						
						this.assignClientSeat(storeMap.get(name),label);
						notSeated = false;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			} while (notSeated);

		}
		dm.clear();
	}

	private JLabel generateSeatValue() {
		boolean notGoodSeat = true;
		
		while(notGoodSeat) {
			int[][] mat = this.room.getMatrix();
			int seat = (int)(Math.random()*(this.displayArea.getAccessibleContext().getAccessibleChildrenCount())+mat[0].length);
			if(seat%11!=0) {
				try {
					JPanel circuit = (JPanel) displayArea.getComponent(seat);
					JPanel labelContainer = (JPanel) circuit.getComponent(0);
					JLabel label = (JLabel) labelContainer.getComponent(0);
					if(label.getText().equals("Vacant")) {
						return label;
					}
				}catch (Exception e) {
					continue;
				}
				
			}
		}
		return null;
	}

	public void addComponentsToPane() {

		//Creates room by default it is a 10 by 10 room that is an 11 by 11 matrix to include rows and seat numbers
		room = new Room();
		
		//Creates main display area
		displayArea = new JPanel();
		//Creates an 11X11 grid by default based on the room
		displayArea.setLayout(new GridLayout(room.getCols(), room.getRows()));
		
		//fills the grid based on the integer values of the matrix;
		this.addContent(room.getMatrix());
		
		displayArea.setPreferredSize(new Dimension(600, 600));
		
		
		//Creates title
		String titleText = "Preterm Second Pass: Theatre Seat Assigning";
		this.title = new JLabel(titleText);
		titleArea = new JPanel();
		titleArea.add(title, BorderLayout.CENTER);
		titleArea.setPreferredSize(new Dimension(room.getCols() * 50, 40));


		JScrollPane scrollPane = new JScrollPane(displayArea);
		
		//Creates ResetButton
		broadcaster = cellButton("Reset All");
		
		//Creates area where buttons will be placed
		broadcastingArea = new JPanel();
		//adds reset button
		broadcastingArea.add(broadcaster, BorderLayout.CENTER);
		//Creates new button for Assigning all seats to all clients that have not been assigned a seat.
		broadcaster = cellButton("Assign All in List");
		broadcastingArea.add(broadcaster);
		broadcastingArea.setPreferredSize(new Dimension(room.getCols() * 50, 40));
		
		this.scrollPaneOfClients = new JScrollPane(this.listOfClientNamesToBeDisplayed);
		//Adds all components to the JFrame
		getContentPane().add(this.scrollPaneOfClients, BorderLayout.LINE_START);
		getContentPane().add(titleArea, BorderLayout.NORTH);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(broadcastingArea, BorderLayout.SOUTH);
	}

	private JPanel constructCell(int[][] matrix, int rowNum, int col) {

		String labelText = isVacant(matrix, rowNum, col);
		String buttonText = (char) (65 + rowNum) + "-" + (col + 1);

		JPanel labelContainer = new JPanel();

		JPanel buttonContainer = new JPanel();

		JLabel label = new JLabel(labelText);
		// label.addPropertyChangeListener(propertyName, listener);
		labelContainer.add(label, BorderLayout.CENTER);

		JButton button = this.cellButton(buttonText);
		buttonContainer.add(button, BorderLayout.CENTER);

		JPanel theatreGrid = new JPanel();
		theatreGrid.setPreferredSize(new Dimension(50, 50));

		theatreGrid.add(labelContainer);
		theatreGrid.add(buttonContainer, BorderLayout.CENTER);
		theatreGrid.setLayout(new BoxLayout(theatreGrid, 1));
		return theatreGrid;
	}

	private String isVacant(int[][] roomMatrix, int i, int j) {
		// TODO Auto-generated method stub
		if (roomMatrix[i + 1][j + 1] == 0) {
			return "Vacant";
		} else {
			return "taken";
		}
	}


	private void addContent(int[][] roomMatrix) {
		for (int i = 0; i < roomMatrix.length; i++) {
			for (int j = 0; j < roomMatrix[i].length; j++) {
				if (i == 0 || j == 0) {
					JPanel label = constructLabel(i, j, roomMatrix);
					displayArea.add(label);
				} else {
					JPanel cell = constructCell(roomMatrix, i - 1, j - 1);
					String labelText = ((char) (65 + i - 1)) + "-" + (j - 1);
					displayArea.add(labelText, cell);
				}
			}
		}
	}

	private JPanel constructLabel(int i, int j, int[][] arr) {
		if (i == 0 && j == 0) {
			JPanel voidCorner = new JPanel();
			voidCorner.setPreferredSize(new Dimension(50, 50));
			return voidCorner;
		} else if (i == 0) {
			JPanel seatNumber = new JPanel();
			seatNumber.setPreferredSize(new Dimension(50, 50));
			JLabel label = new JLabel();
			String text = String.valueOf(j);
			System.out.println(text);
			label.setText(text);
			seatNumber.add(label, BorderLayout.CENTER);
			return seatNumber;
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

	public JButton cellButton(String label) {
		JButton jbtn = new JButton(label);
		// Add action listeners.
		jbtn.addActionListener(this);
		// Add the buttons to the content pane.
		return jbtn;
	}

}
