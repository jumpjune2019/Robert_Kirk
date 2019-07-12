package genarrayswap;

public class Main {

	public static void main(String[] args) {
		
		Integer[] intArray = new Integer[10];
		GenArray<Integer> genArr = new GenArray<Integer>(intArray);
		
		for(int i = 0; i<genArr.getT().length;i++) {
			Integer val = (int)(Math.random()*100)+1;
			genArr.placeValue(val, i);
		}
		
		System.out.println(genArr.toString());

		int a = (int) ((Math.random()*intArray.length));
		int b = (int) (Math.random()*intArray.length);
		
		genArr.exchangeVals(a, b);
		
		System.out.println(genArr.toString());
		
		
	}

}
