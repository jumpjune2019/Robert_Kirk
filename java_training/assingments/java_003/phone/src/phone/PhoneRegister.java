package phone;

import java.util.Scanner;

public class PhoneRegister extends Formater{
	
	private String[][] records;
	
	private String printableRecords;
	
	private int recordsBeingAdded;
	
	private int recordsThatHaveBeenAdded=0;

	public PhoneRegister(int n) {
		super();
		this.records = new String[n][3];
		this.recordsBeingAdded = n;
	}

	public String[][] getRecords() {
		return records;
	}

	public void setRecords(String[][] records) {
		this.records = records;
	}

	public String getPrintableRecords() {
		return printableRecords;
	}

	public void setPrintableRecords(String printableRecords) {
		this.printableRecords = printableRecords;
	}
	public void setRecord(int index, String name, String phoneNum, String city) {
		this.records[index][0] = name;
		this.records[index][1] = phoneNum;
		this.records[index][2] = city;
	}
	public void compileRecords() {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<this.recordsBeingAdded; i++) {
			System.out.println("Whose number do you want to save?");
			String name = sc.nextLine();
			catchEmpty(name);
			System.out.println("What is the phone number?");
			String phoneNum = sc.nextLine();
			catchEmpty(phoneNum);
			System.out.println("Which city does it belong to?");
			String city = sc.nextLine();
			catchEmpty(city);
			this.setRecord(i, name, phoneNum, city);
			this.writeFile(this.records[i]);
		}
		sc.close();
	}

	private void catchEmpty(String str) {
		if(str.equals("")) {
			try {
				throw new EmptyStringException();
			}catch(EmptyStringException e) {
				System.out.println("Empty string detected try again!");
				this.recordsBeingAdded -= this.recordsThatHaveBeenAdded;
				compileRecords();
			}
			
		}
		
	}

}
