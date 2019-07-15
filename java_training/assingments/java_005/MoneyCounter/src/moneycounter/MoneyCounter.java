package moneycounter;

import java.util.Arrays;
import java.util.List;

public class MoneyCounter {
	
	private Money money;
	
	private double totalVal;


	private int[] cashHolder;

	private String[] stringOfVals;
	
	public MoneyCounter(Money money) {
		this.money = money;
		
		this.moneySorting();
		this.currencyVal();
		this.createStringArrayOfDollarAndDecimalValues();
		
	}
	private void createStringArrayOfDollarAndDecimalValues() {
		String dollars = Double.toString(this.totalVal);
		String[] values = dollars.split("\\.");
		values[1] = processDecimal(values[1]);
		this.stringOfVals = values;
	}
	private String processDecimal(String s) {
		return s.substring(0, 2);
	}
	
	public String returnRaw() {
		if(this.totalVal>0) {
			return this.stringOfVals[0] + "." + this.stringOfVals[1];
			
		}
		return "0";
	}
	
	public String returnPretty() {
		if(this.totalVal>0) {
			String val = "";
			
			String[] values = this.stringOfVals;
			String cents = "";
			String dollars = "";
			try {
				dollars = values[0];
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				cents= values[1].substring(0, 2);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			if(Integer.parseInt(dollars) > 0) {
				val += dollars;
				if(Integer.parseInt(dollars) ==1) {
					val+= " dollar";
				}else {
					val+= "dollars";
				}
			}
			if(Integer.parseInt(dollars)>0 && Integer.parseInt(cents) >0) {
				val += " and ";
			}
			if(Integer.parseInt(cents)>0) {
				val += cents;
				
				if(cents.equals("01")) {
					val+= " cent";
				}else {
					val+=" cents";
				}
			}
			return val;
		}
		return "No money has been set";
	}

	public String returnCurrency() {
		if(this.totalVal>0) {
			return "$" + this.returnRaw();
		}
		return "No money has been set";
	}
	
	
	public void setMoney(Money money) {
		this.money = money;
	}
	
	private void moneySorting() {
		int[] cashPile = new int[6];
		cashPile[0] = this.money.getPennyCount();
		cashPile[1] = this.money.getNickelCount();
		cashPile[2] = this.money.getDimeCount();
		cashPile[3] = this.money.getQuarterCount();
		cashPile[4] = this.money.getHalfDollarCount();
		cashPile[5] = this.money.getDollarCount();
		
		this.cashHolder = cashPile;
	}
	private void currencyVal() {
		
		List<USDollarCoins> listOfEnum = enumGetter();
		int i = 0;
		double value = 0;
		for(USDollarCoins denomination : listOfEnum ) {
			int count = this.cashHolder[i];
			double val = denomination.getValue();
			value += val*count;
			i++;
		}
		this.totalVal = value;
	}
	private List<USDollarCoins> enumGetter() {
		return Arrays.asList(USDollarCoins.values());
	}
}
