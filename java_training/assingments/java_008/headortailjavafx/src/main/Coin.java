package main;


public class Coin {
	
	private static short coinState;
	private static boolean coinHasBeenFlipped = false;
	
	public void flipCoin() {
		coinState = (short) (Math.random()*2 + 1);
		coinHasBeenFlipped = true;
	}
	
	public void revealCoin() {
		if(coinHasBeenFlipped) {
			if(coinState == 1) {
				System.out.println("Heads");
			}else if(coinState == 2) {
				System.out.println("Tails");
			}else {
				System.out.println("... it landed on its side");
			}
		}else{
			System.out.println("You haven't flipped it yet! I'll flip it for you.");
			this.flipCoin();
			this.revealCoin();
		}
		coinHasBeenFlipped = false;
		
	}

}
