package dicepairStats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiceRoller {
	
	private HashMap<String, Integer> results = new HashMap<String, Integer>();
	
	public short rollDie() {
		return (short)(Math.random()*6 +1);
	}
	public short testTracker() {
		
		return this.rollDie();
		
	}
	
	public void diceRollerTester(int times) {
		List<short[]> results = new ArrayList<short[]>();
		for(int i = 0; i<times;i++) {
			
			short[] sets = new short[2];
			
			sets[0]= testTracker();
			sets[1]= testTracker();
			
			if(sets[0] < sets[1]) {
				short temp = sets[1];
				sets[1] = sets[0];
				sets[0] = temp;
			}
			results.add(sets);
		}
		for(short[] result: results) {
			
			try {
				int val = this.results.get(result[0] + " and " + result[1]);
				val++;
				this.results.put(result[0] + " and " + result[1], ++val);
			}catch(Exception e){
				this.results.put(result[0] + " and " + result[1], 1);
			}
			
		}
		System.out.println(times + " Random 2 dice toss stats:");
		
		Object[] keys = this.results.keySet().toArray();
		
		for(Object key:keys) {
			System.out.println("Dice "+ key+ ": " + this.results.get(key) + " times");
			
		}
		
		
		
	}
}
