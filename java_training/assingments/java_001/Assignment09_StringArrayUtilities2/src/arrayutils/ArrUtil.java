package arrayutils;

public class ArrUtil {
	
	public static void arrayHasExactMatch(String[] arr, String str, boolean caseSensitive) {
		boolean state = false;
		String[] lowerCasedArray = new String[arr.length];
		if(caseSensitive) {
			state = findInArray(arr, str);
		}else {
			
			for(int i = 0; i<arr.length; i++) {
				String s = arr[i].toLowerCase();
				
				lowerCasedArray[i]= s;
				
			}
			str.toLowerCase();
			state = findInArray(lowerCasedArray, str);
		}
		
		
		System.out.println(state);
		return;
	}
	
	private static boolean findInArray(String[] arr, String s) {
		for(int i = 0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//			System.out.println(s);
			if(arr[i].equals(s)) {
				return true;
			}
		}
		return false;
		
	}


	public static void indexOfOccuranceInArray(String[] myList, String string, boolean b) {
		
		int position;
		String[] lowerCasedArray = new String[myList.length];
		if(b) {
			position = findIndexValue(myList, string);
		}else {
			for(int i = 0; i<myList.length; i++) {
				String s = myList[i].toLowerCase();
				
				lowerCasedArray[i]= s;
				
			}
			string.toLowerCase();
			position = findIndexValue(lowerCasedArray, string);
		}
	
		System.out.println(position);
		
	}
	private static int findIndexValue(String[] myList, String string) {
		
		for (int i = 0; i < myList.length; i++) {
//			System.out.println(myList[i]);
//			System.out.println(string);
			if(myList[i].equals(string)) {
				return i;
			}
		}
		
		return -1;
	}

}
