package com.room;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.client.Client;

public class Room extends Reservations {

	private int rows;
	private int cols;
	private int[][] matrix;
	private String style;
	private boolean boxyStyle;
	protected HashMap<String, String> seatedClient;

	public Room(int rows, int col) {
		this.rows = rows + 1;
		this.cols = col + 1;
		this.style = "none";
		this.boxyStyle = true;
		seatedClient = new HashMap<String, String>();
		this.matrix = new int[this.rows][this.cols];
		
	}

	public Room() {
		this.rows = 11;
		this.cols = 11;
		this.style = "none";
		this.boxyStyle = true;
		seatedClient = new HashMap<String, String>();
		this.matrix = new int[this.rows][this.cols];
	}

	public Room(int rows, int cols, int[][] matrix, String style, boolean boxyStyle,
			HashMap<String, String> seatedClient) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.matrix = matrix;
		this.style = style;
		this.boxyStyle = boxyStyle;
		this.seatedClient = seatedClient;
	}

	public void makeRoom() {
		// this.style.equals("none")
		//System.out.println();
		if (this.boxyStyle) {
			// this.matrix = new int[this.rows][this.cols];
			//Arrays.toString(this.matrix);
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (i == 0) {
						if (j == 0) {
							this.matrix[i][j] = -1;
						} else {
							this.matrix[i][j] = j;
						}
					} else if (i != 0 && j == 0) {
						this.matrix[i][j] = 65 + i - 1;
					} else {
						this.matrix[i][j] = 0;
					}
				}
			}
		} else {
			this.transformMatrix(this.rows, this.cols, this.style);
		}

	}

	private void transformMatrix(int rows2, int col2, String style2) {
		// TODO Create Method to transform Arrays into
		System.out.println("Why is this printing");

	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Override
	public String toString() {
		String matrixAsString = "";
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				int val = this.matrix[i][j];
				if(i==0 && j ==0) {
					matrixAsString+= "  ";
				}else if(i==0 && j !=0) {
					matrixAsString += val + " ";
				}else if (j == 0) {
					int n =  this.matrix[i][j];
					System.out.println(n);
					matrixAsString += ((char)n) +" ";
				} else {
					if (val == 0) {
						matrixAsString += "O ";
					} else if (val > 0) {
						matrixAsString += "X ";
					} else {
						matrixAsString += "- ";
					}
				}
				matrixAsString+= " ";
			}
			matrixAsString += "\n";
		}

		return matrixAsString;
	}
	public void trueArrayString() {
		for(int i = 0; i<this.rows; i++) {
			System.out.println(Arrays.toString(this.matrix[i]));
		}
	}

	public void fillTheatre(List<Client> clientsList) {
		for(int i = 0; i<clientsList.size(); i++) {
			boolean notSeated = true;
			Client client = clientsList.get(i);
			System.out.println(client.getClientFirstName());
			System.out.println(client.getClientLastName());
			System.out.println(client.getClientId());
			int id = client.getClientId();
			do {
				int row = (int) (Math.random()*this.rows-2) +2;
				int seat = (int) (Math.random()*this.cols-2) +2;
				System.out.println(row);
				System.out.println(seat);
				
				if(this.matrix[row][seat] == 0) {
					this.matrix[row][seat]= id;
					String name = client.getClientFirstName()+" "+client.getClientLastName();
					String clientId = client.getClientId() +"";
					if(client.getClientId()<10) {
						clientId = "0"+""+clientId;
					}
					String rowLetter = Character.toString((char)this.matrix[row][0]);
					String clientSeat = rowLetter +" - " + seat;
					
					addToReservations(name, clientId, clientSeat);
					notSeated = false;
				}
			}while(notSeated);
			
		}
		this.trueArrayString();
		System.out.println(this.toString());
		this.getReservationsList();
	}

	private void getReservationsList() {
		System.out.println(this.reservationsToString());
		
	}
	public HashMap<String,String> getSeatedClients(){
		return this.seatedClient;
	}

	public void resetSeatedClients() {
		this.seatedClient = new HashMap<String, String>();
		
	}
	
}
