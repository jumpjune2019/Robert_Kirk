package moneycounter;

public class Main {

	public static void main(String[] args) {

		Money bags = new Money(2,2,2,2,2,2);
		
		System.out.println(bags.getPennyCount());
		System.out.println(bags.getNickelCount());
		System.out.println(bags.getDimeCount());
		System.out.println(bags.getQuarterCount());
		System.out.println(bags.getHalfDollarCount());
		System.out.println(bags.getDollarCount());
		
		
		MoneyCounter counter = new MoneyCounter(bags);
		
		
		String raw = counter.returnRaw();
		String pretty = counter.returnPretty();
		String currency = counter.returnCurrency();
		
		System.out.println(raw);
		System.out.println(pretty);
		System.out.println(currency);

	}

}
