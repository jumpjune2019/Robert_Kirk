package pairofdice;

public class DiceRoller {
	public short rollDie() {
		return (short)(Math.random()*6 +1);
	}
}
