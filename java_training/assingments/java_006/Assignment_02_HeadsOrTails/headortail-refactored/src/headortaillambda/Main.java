package headortaillambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException, CowardException {
		boolean notFinished = false;
		boolean ready = false;
		System.out.println("Welcome to the game of Head or Tail " + "where you will flip your life away!");
		Flipper coinFlipper = () -> {
			int side = (int) (Math.random() * 2) + 1;
			if (side == 1) {
				return "Head";
			} else if (side == 2) {
				return "Tail";
			} else {
				return "Nothing? Didn't return 1 or 2";
			}
		};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Press the F key and flip your luck!"
				+ "... or press q to you be a coward.");
		String detect = br.readLine();

		if (!detect.toLowerCase().equals("q")) {
			notFinished = true;
			ready = true;
		}else {
			throw new CowardException();
		}
		
		do {
			
			if (ready) {
				String result = coinFlipper.flipCoin();

				System.out.println("The cointflkipt is " + result);
			}
			System.out.println("Press the any key to try again, press Q or q to Quit");
			String s = Character.toString((char)br.read());
			if (s.toLowerCase().equals("q")) {
				notFinished = false;
			} else {
				ready = true;
			}
			
		}while(notFinished);
	
		System.out.println("Thanks for playing");
	}
}
