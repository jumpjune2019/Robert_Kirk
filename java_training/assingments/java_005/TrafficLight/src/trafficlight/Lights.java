package trafficlight;

public enum Lights {
	
	Green(5, "Light is Green - Go!"), 
	Yellow(2, "Light is Yellow - Beware!"), 
	Red(3, "Light is Read - Stop!");
	
	private int time;
	private String message;
	
	Lights(int sec, String s) { 
		time = sec;
		message = s;
	}
	int getTime() {
		return time; 
	}
	public String getMessage() {
		return message;
	}
//	public static void setTimer(int seconds) {
//		try {
//			TimeUnit.SECONDS.sleep(Lights.Green.getTime());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	

}
