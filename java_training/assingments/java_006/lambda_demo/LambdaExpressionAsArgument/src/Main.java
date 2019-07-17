public class Main {
	static String changeStr(StringFunc sf, String s) {
		return sf.func(s);
	}
	public static void main(String args[]) {
		String inStr = "Lambda Expressions Expand Java";
		String outStr;
		System.out.println("Here is input string: " + inStr);
		// Define a lambda expression that reverses the contents
		// of a string and assign it to a StringFunc reference variable.
		StringFunc reverse = (str) -> {
			String result = "";
			for(int i = str.length()-1; i >= 0; i--) {
				result += str.charAt(i);
			}
			return result;
		};
		// Pass reverse to the first argument to changeStr().
		// Pass the input string as the second argument.
		outStr = changeStr(reverse, inStr);
		System.out.println("The string reversed: " + outStr);

		// This lambda expression replaces spaces with hyphens.
		// It is embedded directly in the call to changeStr().
		outStr = changeStr((str) -> str.replace(' ', '-'), inStr);
		System.out.println("The string with spaces replaced: " + outStr);

		// This block lambda inverts the case of the characters in the
		// string. It is also embedded directly in the call to changeStr().
		outStr = changeStr((str) -> {
			String result = "";
			char ch;
			
			for(int i = 0; i < str.length(); i++ ) {
				ch = str.charAt(i);
				// ternary operator being used with += operator
				result += (Character.isUpperCase(ch)) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
				// the code below is identical to the ternary operator
//				if(Character.isUpperCase(ch)) {
//					result += Character.toLowerCase(ch);
//				} else {
//					result += Character.toUpperCase(ch);	
//				}
			}
			return result;
		}, inStr);
		System.out.println("The string in reversed case: " + outStr);
	}
}
