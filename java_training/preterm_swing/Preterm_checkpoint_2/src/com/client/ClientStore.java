package com.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientStore {
	private List<Client> dataStore = new ArrayList<Client>();
	private int dataCount;
	private String filename;

	public ClientStore(String f) {
		// for now this is hardcoded, until
		// we learn how to work with a combination of objects and arraylist
		// dataStore = new Client[25];
		dataCount = 0;
		setFilename(f);
		boolean success = loadClientFromFile(f);
		if (!success) {
			// we have a problem
			System.out.println("The file was not loaded and the datastore is empty");
		}
	}

	// for now, this is internal to the method;
	// will be used by loadClientFromFile() method
	void addClient(Client client) {

		//System.out.println(Arrays.toString(dataStore.toArray()));
		dataStore.add(client);
		dataCount++;
	}

	boolean loadClientFromFile(String f) {
		// the file will be configured as a Comma Separated Value (CSV) file.
		String fileLine;
		String[] record;

		boolean first = true;
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			while ((fileLine = br.readLine()) != null) {
				// skip the first line of the CSV
				// it contains the field names
				if (first == true) {
					first = false;
					continue;
				}
				record = fileLine.split(",");
				Client client = new Client(record[1], record[2], Integer.parseInt(record[0]));
				addClient(client);
//  				System.out.println(fileLine);
			}

		} catch (IOException exc) {
			System.out.println("IO Error: " + exc);
		}

		return true;
	}

	void addClientToDB(String lastName, String firstName, int id) {
		// append to file system
		String textToAppend = id + "," + lastName + "," + firstName;

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(this.getFilename(), true));
			writer.newLine(); // Add new line
			writer.write(textToAppend);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void addClientToStore(Client newClient) {
		// append to this.datasStore
		this.addClient(newClient);

	}

	Client createNewClientInfo(String firstName, String lastName) {
		int newId = this.dataStore.size() + 1;
		Client newClient = new Client(lastName, firstName, newId);
		this.addClientToDB(lastName, firstName, newId);
		this.addClientToStore(newClient);

		return newClient;
	}

	// could return an empty store..
	public List<Client> getClientStore() {
		return dataStore;
	}

	int getClientDataCount() {
		return dataCount;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
