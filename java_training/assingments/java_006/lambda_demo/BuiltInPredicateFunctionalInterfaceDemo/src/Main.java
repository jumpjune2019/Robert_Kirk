/* 
 * A function that takes in a value and returns true or false. 
 * In Java 8, java.util.function.Predicate was introduced that behaves 
 * the same way and can be used as an assignment target in lambda expressions
 * and functional interfaces. 
 * The functional method of Predicate is test(Object)
*/
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		// This lambda uses Predicate<Integer> to determine
		// if a number is even.
		Predicate<Integer> isEven = (n) -> (n %2) == 0;
		if(isEven.test(4)) {
			System.out.println("4 is even");
		}
		if(!isEven.test(5)) {
			System.out.println("5 is odd");
		}
	}
}
