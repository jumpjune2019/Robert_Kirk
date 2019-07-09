package phone;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello please tell me how many phone numbers you would like to add.");
		Scanner sc = new Scanner(System.in);
		PhoneRegister register = new PhoneRegister(sc.nextInt());
		register.compileRecords();
		sc.close();
	}

}
