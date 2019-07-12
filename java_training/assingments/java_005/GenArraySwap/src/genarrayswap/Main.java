package genarrayswap;

public class Main {

	public static void main(String[] args) {
		
		//Creates array to be tested
		Integer[] intArray = new Integer[10];
		
		//Creates the generic class
		GenArray<Integer> genArr = new GenArray<Integer>(intArray);
		
		
		//Randomly seeds the Integer array inside genArr
		for(int i = 0; i<genArr.getT().length;i++) {
			Integer val = (int)(Math.random()*100)+1;
			genArr.placeValue(val, i);
		}
		
		//prints out the genArr array for comparison with the end result
		System.out.println(genArr.toString());
		
		
		//Randomly select indexes to be swapped
		int a = (int) ((Math.random()*intArray.length));
		int b = (int) (Math.random()*intArray.length);
		
		//Swap indexes
		genArr.exchangeVals(a, b);
		
		//Display Results
		System.out.println(genArr.toString());
		
		
	}

}
