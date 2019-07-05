package simpledie;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean notFinished= true;
		Scanner sc = new Scanner(System.in);
		DiceRoller diceRoller = new DiceRoller();
		while(notFinished) {
			
			System.out.println("Press any key to throw a die and press Enter (or Q and Enter to quit)");
			
			String userInput = sc.next();
			
			if(userInput.toLowerCase().equals("q")) {
			
				notFinished = false;
				sc.close();
					
			}else {
				
				short result = diceRoller.rollDie();
				
				System.out.println("You have rolled a "+ result);
				
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
