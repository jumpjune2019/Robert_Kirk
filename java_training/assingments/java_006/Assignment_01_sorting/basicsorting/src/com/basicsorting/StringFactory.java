package com.basicsorting;

public class StringFactory<T> {
	
	public String arrString(T[] arr) {
		String s = "";
		for(T t: arr) {
			s+=t+" ";
		}
		return s;
	}

	public T[] reverseArr(T[] arr) {
		T[] array = arr;
		for(int i = 0; i<array.length; i++) {
			T temp = array[i];
			array[i] = array[array.length-(i+1)];
			array[array.length-1-i] = temp;
		}
		
		return array;
	}
}
