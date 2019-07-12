package trafficlight;

public enum Lights {
	
	Green(5000, "Light is Green - Go!", 0), 
	Yellow(2000, "Light is Yellow - Beware!", 5000), 
	Red(3000, "Light is Red - Stop!", 7000);
	
	private int time;
	private String message;
	private int delay;
	
	Lights(int sec, String s, int d) { 
		time = sec;
		message = s;
		delay = d;
	}
	int getTime() {
		return time; 
	}
	public String getMessage() {
		return message;
	}
	int getDelay() {
		return delay;
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
