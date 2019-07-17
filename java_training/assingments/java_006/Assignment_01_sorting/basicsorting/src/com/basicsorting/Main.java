package com.basicsorting;

import java.util.Arrays;
import java.util.Collections;

public class Main {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		StringFactory factory = new StringFactory();
		
		Integer[] numArr = { 10, 3, 4, 15, 7, 9, 1, 21 };
		String[] strArr = {"claude", "Phil", "lois", "clark", "Arthur", "Mera", "bruce"};
		
		SensitiveSort caseSort = (strArrAsc, ascend)->{
			
			String[] canSort = (String[]) strArrAsc;
			String[] returnArray = new String[strArrAsc.length];
			
			for(int i = 0; i<canSort.length; i++) {
				String s = canSort[i];
				returnArray[i] = s.toLowerCase();
			}
			if(ascend) {
				Arrays.sort(returnArray);
			}else {
				Arrays.sort(returnArray, Collections.reverseOrder());
			}
			
			for(int i =0; i<returnArray.length; i++ ) {
				for(int j = 0; j<returnArray.length; j++) {
					if(returnArray[i].equals(canSort[j].toLowerCase())) {
						
						returnArray[i] = canSort[j];
					}
				}
			}
			
			return returnArray;
		};
		
		ArrayHelping sortedDecsend = (arrDecs, sensitive)->{
			
			if(!sensitive) {
				return caseSort.insensitiveSort(arrDecs, false);
			}else {
				Arrays.sort(arrDecs, Collections.reverseOrder());
			}
			
			return arrDecs;
			
		};
		
		ArrayHelping sortAscend = (arrAsc, sensitive)->{
			if(!sensitive) {
				return caseSort.insensitiveSort(arrAsc, true);
			}else {
				Arrays.sort(arrAsc);
			}
			
			return arrAsc;
		};
		
		
		
		
		
		
		//Printing Integer[]
		System.out.println(factory.arrString(numArr));
		//Ascend
		numArr = (Integer[]) sortAscend.arryHelper(numArr, true);
		System.out.println(factory.arrString(numArr));
		//descend
		numArr = (Integer[]) sortedDecsend.arryHelper(numArr, true);
		System.out.println(factory.arrString(numArr));
		
		//Printing String[]
		System.out.println(factory.arrString(strArr));
		
		
		
		//Ascend Case Sensitive
		System.out.println(Arrays.toString((String[])sortAscend.arryHelper(strArr, true)));
		//Descend Case Sensitive
		System.out.println(Arrays.toString((String[])sortedDecsend.arryHelper(strArr, true)));
		
		//Ascend Case Insensitive
		System.out.println(Arrays.toString((String[])sortAscend.arryHelper(strArr, false)));
		//Descend Case Insensitive
		System.out.println(Arrays.toString((String[])sortedDecsend.arryHelper(strArr, false)));
		

	}

}
