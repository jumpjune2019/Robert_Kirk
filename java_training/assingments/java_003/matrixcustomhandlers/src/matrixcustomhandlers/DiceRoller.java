package matrixcustomhandlers;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class DiceRoller {
	
	private HashMap<String, Integer> results = new HashMap<String, Integer>();
	final static String[][] labels = {
			{"Snake eyes", "Australian yo", "Little Joe From Kokomo", "No field five", "Easy six", "Six one you're done"},
			{"Ace caught","Ballerina","The fever","Jimmie Hicks","Benny Blue","Easy eight"},
			{"Easy four","OJ","Brooklyn Forest","Big Red","Eighter from","Nina from Pasadena"},
			{"Little Phoebe","Easy six","Skinny McKinney","Square Pair","RailRoad","Big one on the end"},
			{"Sixie from Dixie","Skinny Dugan","Easy Eight","Jesse James","Puppy paws","Yo"},
			{"The Devil","Easy Eight","Lou Brown","Tennessee","Six five no jive","Midnighta"}
	};
	final private String matrix = createMatrix();
	private Scanner sc;
	
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
	public static String createMatrix() {
		String matrix = "";
		
		
		matrix+="Dice Combination Label Matrix\r\n\r\n";
		
		for(int i = 0; i<6; i++) {
			String printTarget = "Dice " + (i+1);
			if(i==0) {
				String spaces = "";
				for(int j = 0; j<8; j++) {
					//System.out.print(" ");
					spaces+= " ";
				}
				matrix += spaces;
				matrix +=printTarget;
				
			}else {
				matrix +=printTarget;
				
			}	
			for(int j = 0; j<24-printTarget.length(); j++) {
				matrix+= " ";
			}
		}
		for(int i = 0; i<6; i++) {
			String printTarget = "Dice " + (i+1);
			matrix+="\r\n\r\n" + printTarget;
			for(int j = 0; j< 8-printTarget.length(); j++) {
				matrix+=" ";
			}
			
			for(int j = 0; j<6; j++) {
				printTarget = labels[i][j];
				matrix+=printTarget;
				for(int k = 0; k< 24-printTarget.length(); k++) {
					matrix+=" ";
				}	
			}	
		}
		return matrix;
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
	public String getMatrix() {
		return matrix;
	}
	private void openScanner() {
		try {
			this.sc = new Scanner(System.in);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printMatrix() {
		this.openScanner();
		System.out.println("Press one and enter\r\n" + 
				"	1) print on screen only\r\n" + 
				"	2) print on file\r\n" + 
				"	3) print on both");
		
		
		boolean notAccepted = true;
		
//		String command = null;
//		while(notAccepted) {
//			command = sc.nextLine();
//			command.toLowerCase();
//			if(command.equals("console")||command.equals("file")||command.equals("both")) {
//				notAccepted = false;
//			}else {
//				System.out.println("Only one of three commands will work! CONSOLE, FILE or BOTH. This is not rocket science!");
//			}
//		}
		int command = 0;
		
		while(notAccepted) {
		  String c = null;
		  try{             
		    // Reads the next byte of data from the input stream
		    c =  sc.next();
		    //command = Integer.parseInt(c);
		    if(checkArray(c)) {
		    	throw new InputIsTheNameOfALableException();
		    }
		    try {
		    	command = Integer.parseInt(c.trim());
		    }catch(NumberFormatException e) {
		    	throw new NotAproperInputExcetpion();
		    }
		    
		    if(command > 3 || command < 1){
		      throw new NotAproperInputExcetpion();
		    }else {
		    	notAccepted =false;
		    }
		  }catch(NotAproperInputExcetpion e) {
			  System.out.println("You didn't type a proper response");
		  }catch(InputIsTheNameOfALableException e) {
			  System.out.println("Why do you need to print out the matrix... You already seem to know them");
		  }
		}
		  
		
		switch(command) {
			case 1:
				System.out.println(this.matrix);
				sc.close();
				break;
			case 2:
				this.printMatrixToFile();
				sc.close();
				break;
			case 3:
				System.out.println(this.matrix);
				this.printMatrixToFile();
				sc.close();
				break;
			default:
				System.out.println("How could you fail at printing!");
				break;
		}	
	}
	private boolean checkArray(String str) {
		
		for(int i = 0; i<6; i++) {
			for(int j = 0; j<6; j++) {
				if(str.equals(labels[i][j])) {
					return true;
				}
			}
		}
		return false;
	}
	private void printMatrixToFile() {
		
		try{
			FileWriter fw=new FileWriter("D:\\Coding\\JUMP_pro_2019\\Robert_Kirk\\java_training\\assingments\\java_003\\matrixchoice\\print_local.txt");    
	        fw.write(matrix);    
	        fw.close();    
	        }catch(Exception e){
	        	  System.out.println(e);
	        }    
	          System.out.println("IT IS DONE");    
	     }    
		
		
	
}
