
public class Main {

	public static void main(String[] args) {
		// myVal
		MyValue myVal;
		// this implies that the result of this assignment
		// will be assigned to the 'single' abstract
		// method getValue in the MyValue interface;

		myVal = () -> 98.6;
		// could have done 2 steps into one single statement
		// MyValue myVal = () -> 98.6;
		
		// accessing the value via the getValue() method
		System.out.println(String.format("myVal = %f", myVal.getValue()));
		
		// myPval being declared and the lambda expression
		// is defined
		MyParamValue myPval = (n) -> 1.0 / n;
		
		// accessing the value via the getValue() method
		System.out.println(String.format("myVal = %f", myPval.getValue(4.0)));

		// A lambda expression must be compatible with the method
		// defined by the functional interface. Therefore, these won't work:
		// myVal = () -> "three"; // Error! String not compatible with double!
		// myPval = () -> Math.random(); // Error! Parameter required!
		
	}

}
