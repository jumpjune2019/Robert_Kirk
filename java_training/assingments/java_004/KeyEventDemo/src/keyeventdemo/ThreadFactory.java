package keyeventdemo;

public class ThreadFactory {
	
	static final private String[] threadNames = {"One", "Two", "Three", "Four", "Five"};
	
	
	public ReportThread generateThreads(int n) {
		
			return new ReportThread(threadNames[n]);
		
	}

}
