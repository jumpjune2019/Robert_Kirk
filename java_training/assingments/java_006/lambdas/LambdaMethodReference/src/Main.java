public class Main {

	// This method has a functional interface as the type of its
	// first parameter. Thus, it can be passed a reference to any
	// instance of that interface, including one created by a
	// method reference.
	static boolean numTest(IntPredicate p, int v) {
		return p.test(v);
	}
	
	public static void main(String[] args) {
		boolean result;
		// Here, a method reference to isPrime is passed to numTest().
		result = numTest(MyIntPredicates::isPrime, 17);
		if(result) {
			System.out.println("17 is prime.");
		}
		// Next, a method reference to isEven is used.
		result = numTest(MyIntPredicates::isEven, 12);
		if(result) {
			System.out.println("12 is even.");
		}
		// Now, a method reference to isPositive is passed.
		result = numTest(MyIntPredicates::isPositive, 11);
		if(result) {
			System.out.println("11 is positive.");
		}
	}
}
