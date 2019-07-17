package stringarrayutilities;

public class Main {

	public static void main(String[] args) {
		
		
		
		System.out.println("This is the a test of the arrayHasExactMatch "
				+ "and indexOfOccurenceInArray methods");
		System.out.println("The array to test contains the following items");
		System.out.println(" {\"Bozo\", \"FooBar\", \"Delta\", \"Foozball\", \"Demo\", \"Money\", \"Zoo\"}");
		
		
		String myList[] = {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo"};
		
		ArrayAndStrings question = new ArrayAndStrings();
		
		//False
		question.arrayHasExactMatch(myList, "zo", false);
		//True
		question.arrayHasExactMatch (myList, "zoo", false);
		//False
		question.arrayHasExactMatch (myList, "zoo", true);
		//False
		question.arrayHasExactMatch (myList, "foobar", true);
		//True
		question.arrayHasExactMatch (myList, "foobar", false);
		//False
		question.arrayHasExactMatch (myList, "delta", true);
		//true
		question.arrayHasExactMatch (myList, "Delta", true);
		
		//-1
		question.indexOfOccuranceInArray (myList, "zo", false);
		//5
		question.indexOfOccuranceInArray (myList, "zoo", false);
		//-1
		question.indexOfOccuranceInArray (myList, "zoo", true);
		//-1
		question.indexOfOccuranceInArray (myList, "foobar", true);
		//1
		question.indexOfOccuranceInArray (myList, "foobar", false);
		//-1
		question.indexOfOccuranceInArray (myList, "delta", true);
		//2
		question.indexOfOccuranceInArray (myList, "Delta", true);

	}

}
