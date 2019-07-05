package app;

import static arrayutils.ArrUtil.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("This is the a test of the arrayHasExactMatch "
				+ "and indexOfOccurenceInArray methods");
		System.out.println("The array to test contains the following items");
		System.out.println(" {\"Bozo\", \"FooBar\", \"Delta\", \"Foozball\", \"Demo\", \"Money\", \"Zoo\"}");
		
		
		String myList[] = {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo"};
		
		
		//False
		arrayHasExactMatch(myList, "zo", false);
		//True
		arrayHasExactMatch (myList, "zoo", false);
		//False
		arrayHasExactMatch (myList, "zoo", true);
		//False
		arrayHasExactMatch (myList, "foobar", true);
		//True
		arrayHasExactMatch (myList, "foobar", false);
		//False
		arrayHasExactMatch (myList, "delta", true);
		//true
		arrayHasExactMatch (myList, "Delta", true);
		
		//-1
		indexOfOccuranceInArray (myList, "zo", false);
		//5
		indexOfOccuranceInArray (myList, "zoo", false);
		//-1
		indexOfOccuranceInArray (myList, "zoo", true);
		//-1
		indexOfOccuranceInArray (myList, "foobar", true);
		//1
		indexOfOccuranceInArray (myList, "foobar", false);
		//-1
		indexOfOccuranceInArray (myList, "delta", true);
		//2
		indexOfOccuranceInArray (myList, "Delta", true);

	}

}
