package moneycounter;

public enum USDollarCoins {
	
	PENNY("penny", "cent", 0.01), 
	NICKEL("nickle", "cent", 0.05),
	DIME("dime", "cent", 0.1),
	QUARTER("quarter", "cent", 0.25),
	HALFDOLLAR("half dollar", "cent", 0.5),
	DOLLAR("dollar", "dollar", 1);

	
	private String denom;
	private String  type;
	private double value;
	
	
	USDollarCoins(String s, String type, double d){
		this.denom = s;
		this.type = type;
		this.value = d;
		
	}

	public String getDenom() {
		return denom;
	}

	public String getType() {
		return type;
	}

	public double getValue() {
		return value;
	}
}