package gameofdice;

import gameofdice.functionalinterfaces.DiceHandler;

public class DiceRoller extends twoPlayerGame {
	final String[][] labels = {
			{ "Snake eyes", "Australian yo", "Little Joe From Kokomo", "No field five", "Easy six",
					"Six one you're done" },
			{ "Ace caught", "Ballerina", "The fever", "Jimmie Hicks", "Benny Blue", "Easy eight" },
			{ "Easy four", "OJ", "Brooklyn Forest", "Big Red", "Eighter from", "Nina from Pasadena" },
			{ "Little Phoebe", "Easy six", "Skinny McKinney", "Square Pair", "RailRoad", "Big one on the end" },
			{ "Sixie from Dixie", "Skinny Dugan", "Easy Eight", "Jesse James", "Puppy paws", "Yo" },
			{ "The Devil", "Easy Eight", "Lou Brown", "Tennessee", "Six five no jive", "Midnighta" } };


	DiceHandler<Short> throwDie = () -> (Short) (short) (Math.random() * 6 + 1);

	// ArrayHandler<String> getLables= ()-> this.getLabels();
	public String gameStart() {
		return("Welcome to the dice throw challenge!\r\n" + "Do you feel lucky? “Punk”… Do ya? "
				+ "Press the button on the right to start rolling your dice or close the window if you can't handle me bro!");
	}
	public String[][] getLabels() {
		return this.labels;
	}

	public String playDiceGame() {
		String result= "Go! Dice roll!\n";
		int[] playerScore = { throwDie.rolling(), throwDie.rolling() };

		int[] compScore = { throwDie.rolling(), throwDie.rolling() };

		result+="You have a " + playerScore[0] + " and " + playerScore[1] + "> "
				+ labels[playerScore[0] - 1][playerScore[1] - 1]+"\n";
		result+="I have a " + compScore[0] + " and " + compScore[1] + "> "
				+ labels[compScore[0] - 1][compScore[1] - 1]+"\n";
		result+= this.judgeVictor(playerScore, compScore)+"\n";

		
		
		return result;

	}

}
