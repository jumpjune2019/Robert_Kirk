package tallycall;

public class Coin {
	
	private short coinStaste=0;
	private static boolean coinHasBeenFlipped = false;
	
	private int headTally = 0;
	private int tailsTally = 0;
	
	public void flipCoin() {
		this.coinStaste = (short) (Math.random()*2 + 1);
		coinHasBeenFlipped = true;
	}
	
	public void revealCoin() {
		if(coinHasBeenFlipped) {
			
			//If heads
			if(this.coinStaste == 1) {
				
				System.out.println("Heads");
				
				
			//If Tails
			}else if(this.coinStaste == 2) {
				
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
	
	public short testTracker() {
		this.flipCoin();
		return this.coinStaste;
	}
	
	public void coinFlipTester(int times) {
		short[] results = new short[1000];
		for(int i = 0; i<times;i++) {
			
			results[i]= testTracker();
		}
		for(short result: results) {
			if(result == 1) {
				this.headTally++;
				
			}else {
				this.tailsTally++;
			}
		}
		System.out.println(times + " Coin Flips");
		System.out.println("Count of Head: " + this.headTally);
		System.out.println("Count of Tail: " + this.tailsTally);
		
	}

}
