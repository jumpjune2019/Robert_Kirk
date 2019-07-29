package main;

public class ComputerFlipper {

	protected String startGameMessage() {
		return "Welcome to the game of Head or Tail where you will flip your life away!"
				+ "\nPress the 'Click to Flip' button to flip a coin!!!"
				+ "\nWhen you want to quit please close this window.";
	}

	private Flipper coinFlipper = () -> {
		int side = (int) (Math.random() * 2) + 1;
		if (side == 1) {
			return "Head";
		} else if (side == 2) {
			return "Tail";
		} else {
			return "Nothing? Didn't return 1 or 2";
		}
	};

	protected String game(){
		return this.coinFlipper.flipCoin();
	}

}
