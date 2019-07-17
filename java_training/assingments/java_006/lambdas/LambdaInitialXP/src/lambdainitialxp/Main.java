package lambdainitialxp;

public class Main {
	interface RangeHelper{
		boolean func(int n);
	}

	public static void main(String[] args) {
		
		RangeHelper rangeDescriber = n -> n>=10 && n<=20;
		
		int n = (int)(Math.random()*25)+1;
		if(rangeDescriber.func(n)) {
			System.out.println(rangeDescriber.func(n) + " " + n);
		}else {
			System.out.println(false + " " + n);
		}	
		
		SingleNumberMathOperations factorial = (x) ->{
			int y = 1;
			for(int i = 2; i<x+1; i++) {
				y*=i;
			}
			return y;
		};
		
		System.out.println(factorial.test(4));
		
		Helpful battleBrother = Astartes::new;
		
		//MyClass mc = myClassCons.func("Testing");
		
		Astartes lysander = battleBrother.func("Lysander", "Imperial Fists");
		
		lysander.getBattleBrother();
		
		
	}
}
