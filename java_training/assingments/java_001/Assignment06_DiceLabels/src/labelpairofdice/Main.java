package labelpairofdice;

public class Main {

	public static void main(String[] args) {
		
		DiceRoller diceRoller = new DiceRoller();
		
		String[][] labels = diceRoller.getLabels();
		
		//Longest label is 22 characters across 24 characters will be allocated to each column for their length
		//the column first column will is dice #. It will be allocated 8 character spaces
		
		System.out.println("Dice Combination Label Matrix\n");
		for(int i = 0; i<6; i++) {
			String printTarget = "Dice " + (i+1);
			if(i==0) {
				for(int j = 0; j<8; j++) {
					System.out.print(" ");
				}
				System.out.print(printTarget);
				
			}else {
				System.out.print(printTarget);
			}
			
			for(int j = 0; j<24-printTarget.length(); j++) {
				System.out.print(" ");
			}
		}
		
		
		for(int i = 0; i<6; i++) {
			String printTarget = "Dice " + (i+1);
			System.out.print("\n\n" + printTarget);
			for(int j = 0; j< 8-printTarget.length(); j++) {
				System.out.print(" ");
			}
			
			for(int j = 0; j<6; j++) {
				printTarget = labels[i][j];
				System.out.print(printTarget);
				for(int k = 0; k< 24-printTarget.length(); k++) {
					System.out.print(" ");
				}
				
			}
			
			
		}
	}

}
