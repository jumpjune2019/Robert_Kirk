package labelpairofdice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiceRoller {
	
	private HashMap<String, Integer> results = new HashMap<String, Integer>();
	final String[][] labels = {
			{"Snake eyes", "Australian yo", "Little Joe From Kokomo", "No field five", "Easy six", "Six one you're done"},
			{"Ace caught","Ballerina","The fever","Jimmie Hicks","Benny Blue","Easy eight"},
			{"Easy four","OJ","Brooklyn Forest","Big Red","Eighter from","Nina from Pasadena"},
			{"Little Phoebe","Easy six","Skinny McKinney","Square Pair","RailRoad","Big one on the end"},
			{"Sixie from Dixie","Skinny Dugan","Easy Eight","Jesse James","Puppy paws","Yo"},
			{"The Devil","Easy Eight","Lou Brown","Tennessee","Six five no jive","Midnighta"}
	};
	
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
	public HashMap<String, Integer> getResults() {
		return results;
	}
	public void setResults(HashMap<String, Integer> results) {
		this.results = results;
	}
	public String[][] getLabels() {
		return labels;
	}
}
