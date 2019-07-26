package main;

import jardemopackage.Dice;

public class Main {
	public static void main(String[] args) {
		Dice d = new Dice();
		System.out.println("First Throw: " + d.getDie());
		System.out.println("Second Throw: " + d.getDie());
	}
}