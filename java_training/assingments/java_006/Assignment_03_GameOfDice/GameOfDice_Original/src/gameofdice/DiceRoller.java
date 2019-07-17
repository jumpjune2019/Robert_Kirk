package gameofdice;

import java.util.Scanner;

public class DiceRoller extends twoPlayerGame{
	final String[][] labels = {
			{"Snake eyes", "Australian yo", "Little Joe From Kokomo", "No field five", "Easy six", "Six one you're done"},
			{"Ace caught","Ballerina","The fever","Jimmie Hicks","Benny Blue","Easy eight"},
			{"Easy four","OJ","Brooklyn Forest","Big Red","Eighter from","Nina from Pasadena"},
			{"Little Phoebe","Easy six","Skinny McKinney","Square Pair","RailRoad","Big one on the end"},
			{"Sixie from Dixie","Skinny Dugan","Easy Eight","Jesse James","Puppy paws","Yo"},
			{"The Devil","Easy Eight","Lou Brown","Tennessee","Six five no jive","Midnighta"}
	};
	Scanner sc = new Scanner(System.in);
	
	private boolean firstTime = true;
	
	public short rollDie() {
		return (short)(Math.random()*6 +1);
	}
	public String[][] getLabels(){
		return this.labels;
	}
	
	
	private void questionFinished(String desireToContinue) {
		
		if(desireToContinue.toLowerCase().equals("y")) {
			
			this.playDiceGame();
			
		}else if(desireToContinue.toLowerCase().equals("q")) {
			System.out.println("Thanks for being a good sport! Laters!");
			System.out.println("Final score: \n"
					+ "  Player: " + this.getPlayer1Score() + "\n" +
					"  Computer: " + this.getPlayer2Score());
		
			sc.close();
		}else {
			System.out.println("DO YOU WANT TO CONTINUE OR NOT? PRESS Y AND ENTER TO CONTI"
					+ "NUE OR PRESS Q AND ENTER TO GET OUT OF HERE");
			this.questionFinished(sc.next());
		}
		
		
	}
	public void playDiceGame() {
		
			if(firstTime) {
				System.out.println("Welcome to the dice throw challenge!\r\n" + 
						"Do you feel lucky? “Punk”… Do ya?\r\n" + 
						"Press any key and ENTER to throw your dice or press (Q or q) to chicken your butt off…");
				String userInput = sc.next();
				firstTime = false;
				if(userInput.toLowerCase().equals("q")) {
					System.out.println("See ya later alligator");
					sc.close();
					return;
				}
			}
			
			System.out.println("Go! Dice roll!");
					
			short playerFirst = this.rollDie();
			short playerSecond = this.rollDie();
			int[] playerScore = {playerFirst, playerSecond};
							
					
			short compFirst = this.rollDie();
			short compSecond = this.rollDie();
			int[] compSocre = {compFirst, compSecond};
					
					
			System.out.println("You have a " + playerFirst + " and " + playerSecond 
					+ "> " + labels[playerFirst-1][playerSecond-1] );
			System.out.println("I have a " + compFirst + " and " + compSecond 
						+ "> " + labels[compFirst-1][compSecond-1] );
			this.judgeVictor(playerScore, compSocre);
				
			System.out.println("Play Again? (Y or y) and Enter, any other key and Enter to Quit");
					
			String desireToContinue= sc.next();
			this.questionFinished(desireToContinue);
			return;
											
			
	}
	
}
