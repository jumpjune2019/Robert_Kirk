package compare;

public class StreamComparitor {
	
	private String firstString;
	
	private String secondString;

	public StreamComparitor(String firstString, String secondString) {
		super();
		this.firstString = firstString;
		this.secondString = secondString;
	}
	
	public void compareFiles() {
		int firstLen = this.firstString.length();
		int secondLen = this.secondString.length();
		
		String trim1 = this.firstString.trim();
		String trim2 = this.secondString.trim();
		System.out.println("Results: ");
		declareContentComparision(compareContent(trim1, trim2));
		declareSizeComparision(compareSize(firstLen, secondLen), firstLen, secondLen);
		
	}
	private void declareSizeComparision(boolean compareSize, int firstLength, int secondLength) {
		if(compareSize) {
			System.out.println("Both files have a character length of: " +firstLength);
		}else {
			System.out.println("The first file has a character length of: " + firstLength);
			System.out.println("The second file has a character length of: " + secondLength);
		}
		
	}

	private void declareContentComparision(boolean compareContent) {
		if(compareContent) {
			System.out.println("Both of the files contain the same content");
		}else {
			System.out.println("The content of the files is different");
		}
		
	}

	private boolean compareContent(String s1, String s2) {
		
		return s1.equals(s2);
		
	}
	
	private boolean compareSize(int x, int y) {
		return x==y;
	}

}
