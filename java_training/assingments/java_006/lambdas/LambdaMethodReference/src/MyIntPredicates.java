public class MyIntPredicates {
	// A static method that returns true if a number is prime.
	static boolean isPrime(int n) {
		if(n < 2) return false; 
		
		for(int i=2; i <= n/i; i++) {
			if((n % i) == 0) {
				return false;
			}
		}
		return true;
	}
	// A static method that returns true if a number is even.
	static boolean isEven(int n) {
		return (n % 2) == 0;
	}
	// A static method that returns true if a number is positive.
	static boolean isPositive(int n) {
		return n > 0;
	}
}