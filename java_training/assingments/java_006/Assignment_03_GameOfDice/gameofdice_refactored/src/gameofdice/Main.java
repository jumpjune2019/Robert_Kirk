package gameofdice;

import gameofdice.functionalinterfaces.DiceRollerHelper;

public class Main {

	public static void main(String[] args) {
		
		//DiceRoller diceRoller = new DiceRoller();
		//Lambda equivalent of using the constructor for diceRoller
		DiceRollerHelper<DiceRoller> assistant = ()-> new DiceRoller();
		//Call for game to start with functional interface
		assistant.rollDice().playDiceGame();
		

		
	}

}
