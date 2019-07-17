public class Main {
	public static void main(String[] args) {
		boolean result;
		MyIntNum myNum = new MyIntNum(12);
		MyIntNum myNum2 = new MyIntNum(16);
		// This makes inp refer to the instance method isFactor().
		MyIntNumPredicate inp = MyIntNum::isFactor;
		// The following calls isFactor() on myNum.
		result = inp.test(myNum, 3);
		if(result) {
			System.out.println("3 is a factor of " + myNum.getNum());
		}
		// The following calls isFactor() on myNum2.
		result = inp.test(myNum2, 3);
		if(!result) {
			System.out.println("3 is a not a factor of " + myNum2.getNum());
		}
	}
}