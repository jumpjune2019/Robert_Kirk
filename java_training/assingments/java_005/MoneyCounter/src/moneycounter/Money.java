package moneycounter;

public class Money {
	
	private int pennyCount;
	private int nickelCount;
	private int dimeCount;
	private int quarterCount;
	private int halfDollarCount;
	private int dollarCount;
	
	public Money() {
		this.pennyCount = 0;
		this.nickelCount = 0;
		this.dimeCount = 0;
		this.quarterCount = 0;
		this.halfDollarCount = 0;
		this.dollarCount = 0;
	}

	public Money(int pennyCount, int nickelCount, int dimeCount, int quarterCount, int halfDollarCount,
			int dollarCount) {
		super();
		this.pennyCount = pennyCount;
		this.nickelCount = nickelCount;
		this.dimeCount = dimeCount;
		this.quarterCount = quarterCount;
		this.halfDollarCount = halfDollarCount;
		this.dollarCount = dollarCount;
	}


	//Getters and Setters
	public int getPennyCount() {
		return pennyCount;
	}

	public void setPennyCount(int pennyCount) {
		this.pennyCount = pennyCount;
	}

	public int getNickelCount() {
		return nickelCount;
	}

	public void setNickelCount(int nickelCount) {
		this.nickelCount = nickelCount;
	}

	public int getDimeCount() {
		return dimeCount;
	}

	public void setDimeCount(int dimeCount) {
		this.dimeCount = dimeCount;
	}

	public int getQuarterCount() {
		return quarterCount;
	}

	public void setQuarterCount(int quarterCount) {
		this.quarterCount = quarterCount;
	}

	public int getHalfDollarCount() {
		return halfDollarCount;
	}

	public void setHalfDollarCount(int halfDollarCount) {
		this.halfDollarCount = halfDollarCount;
	}

	public int getDollarCount() {
		return dollarCount;
	}

	public void setDollarCount(int dollarCount) {
		this.dollarCount = dollarCount;
	}
	
	
}
