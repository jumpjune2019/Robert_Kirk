package pairofdice;

import java.util.Scanner;

import pairofdice.DiceRoller;

public class Main {

	public static void main(String[] args) {
		boolean notFinished= true;
		Scanner sc = new Scanner(System.in);
		DiceRoller diceRoller = new DiceRoller();
		while(notFinished) {
			
			System.out.println("Press any key to throw a pair of dice and press Enter (or Q and Enter to quit)");
			
			String userInput = sc.next();
			
			if(userInput.toLowerCase().equals("q")) {
			
				notFinished = false;
				sc.close();
					
			}else {
				
				short first = diceRoller.rollDie();
				short second = diceRoller.rollDie();
				
				System.out.println("You have rolled the following:");
				System.out.println("First Die: " + first);
				System.out.println("Second Die: " + second);
				
				System.out.println("Play Again? (Y or y) and Enter, any other key and Enter to Quit");
				
				String desireToContinue= sc.next();
				
				if(desireToContinue.toLowerCase().equals("y")) {
				
					continue;
				
				}else {
				
					notFinished = false;
					sc.close();
				}
			}
		}


	}

}
