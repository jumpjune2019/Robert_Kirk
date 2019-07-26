package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reservations {
	
	protected List<String[]> listOfReservations=new ArrayList<String[]>();
	
	public List<String[]> getListOfReservations() {
		return listOfReservations;
	}
	public void setListOfReservations(List<String[]> listOfReservations) {
		this.listOfReservations = listOfReservations;
	}
	
	public String reservationsToString() {
		String arrString = "Client initials Seat\n";
		int nameColLen = 30;
		int idColLen = 8;
		for(int i = 0; i<this.listOfReservations.size(); i++) {
			String[] clientAndSeat = this.listOfReservations.get(i);
			String clientName = clientAndSeat[0];
			clientName = addSpaces(clientName, nameColLen);
			String clientId = clientAndSeat[1];
			clientId = addSpaces(clientId, idColLen);
			String seat = clientAndSeat[2];
			
			arrString += clientName + clientId + seat + "\n";
		}
		return arrString;
	}
	private String addSpaces(String colName, int len) {
		int spaces = len-colName.length();
		if(spaces > 1) {
			for(int i = 0; i<spaces; i++) {
				colName+=" ";
			}
		}else {
			colName = colName.substring(0, len-1);
		}
		return colName;
	}	
	protected void addToReservations(String name, String id, String seat) {
		String[] res = new String[3];//{name, id, seat};
		res[0] = name;
		res[1] = id;
		res[2] = seat;
		System.out.println(Arrays.toString(res));
		this.listOfReservations.add(res);
	}

}
