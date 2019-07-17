package stringarrayutilities;

import functionalinterfaces.IndexFinder;
import functionalinterfaces.Inspector;

public class ArrayAndStrings {

	Inspector<String> inspection = (String[] arr, String s) -> {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(s)) {
				return true;
			}
		}
		return false;

	};

	public void arrayHasExactMatch(String[] arr, String str, boolean caseSensitive) {
		boolean state = false;
		String[] lowerCasedArray = new String[arr.length];
		if (caseSensitive) {
			// Replaced
			state = inspection.inspecting(arr, str);
		} else {
			for (int i = 0; i < arr.length; i++) {
				String s = arr[i];
				lowerCasedArray[i] = s.toLowerCase();
			}
			str.toLowerCase();
			state = inspection.inspecting(lowerCasedArray, str);
		}
		System.out.println(state);
	}

	IndexFinder<String> finder = (String[] arr, String s) -> {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(s)) {
				return i;
			}
		}
		return -1;
	};

	public void indexOfOccuranceInArray(String[] myList, String string, boolean b) {

		int position;
		String[] lowerCasedArray = new String[myList.length];
		if (b) {
			//
			position = finder.findingIndex(myList, string);
		} else {
			for (int i = 0; i < myList.length; i++) {
				String s = myList[i].toLowerCase();

				lowerCasedArray[i] = s;

			}
			string.toLowerCase();
			//
			position = finder.findingIndex(lowerCasedArray, string);
		}

		System.out.println(position);

	}

}
