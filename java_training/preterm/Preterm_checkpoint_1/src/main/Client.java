package main;

import java.util.ArrayList;
import java.util.List;

// a client object

public class Client {
	private String lastname;
	private String firstname;
	private int id;
	private List<String[]> reservations; 
	
	Client(String l, String f, int i, List<String[]> res) {
		lastname = l;
		firstname = f;
		id = i;
		reservations = res;
	}
	
	Client(String l, String f, int i) {
		lastname = l;
		firstname = f;
		id = i;
		reservations = new ArrayList<String[]>();
	}
	
	int getClientId() {
		return id;
	}
	
	String getClientLastName() {
		return lastname;
	}
	
	String getClientFirstName() {
		return firstname;
	}
	
	String getClientInitials() {
		char[] initialsArr = {' ', ' '};
		initialsArr[0] = firstname.charAt(0);
		initialsArr[1] = lastname.charAt(0); 
		return new String(initialsArr);
	}

	String getFullClientString() {
		String full = ("id: " + id + " lastname: " + lastname + " firstname: " + firstname);
		return full;
	}

	public List<String[]> getReservations() {
		return reservations;
	}

	public void setReservations(List<String[]> reservations) {
		this.reservations = reservations;
	}

	public void printReservations() {
		
		for(int i=0; i<this.reservations.size(); i++) {
			String[] res = this.reservations.get(i);
			System.out.println(res[0]);
			System.out.println(res[0]+" "+res[1]);
		}
		
	}
}
