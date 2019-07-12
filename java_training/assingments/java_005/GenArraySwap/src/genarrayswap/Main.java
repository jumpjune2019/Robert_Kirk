package genarrayswap;

public class Main {

	public static void main(String[] args) {
		TestArrayGenerator<Integer> generator = new TestArrayGenerator();
		Integer[] intArray = new Integer[10];
		GenArray genArr = new GenArray(intArray);
		
		for(int i = 0; i<genArr.getT().length;i++) {
			Integer val = (int)(Math.random()*100)+1;
			genArr.placeValue(val, i);
		}
		System.out.println(
				genArr.toString()
		);
		
//		boolean notSame = true;
//		while(notSame) {
//			
//			
//			if(!generator.comapreArrays(intArray, genArr.getT())) {
//				notSame = false;
//			}
//			
//		}
		int a = (int) ((Math.random()*intArray.length));
		int b = (int) (Math.random()*intArray.length);
		genArr.exchangeVals(a, b);
		
		System.out.println(
				genArr.toString()
		);
		
		
	}

}
