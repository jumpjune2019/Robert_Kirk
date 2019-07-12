package trafficlight;

//Enum contains info on how each light should behave
public enum Lights {
	
	//Defining of the lights
	Green("Light is Green - Go!", 0), 
	Yellow("Light is Yellow - Beware!", 5000), 
	Red("Light is Red - Stop!", 7000);
	
	private String message;
	private int delay;
	
	Lights(String s, int d) { 
		message = s;
		delay = d;
	}

	public String getMessage() {
		return message;
	}
	
	int getDelay() {
		return delay;
	}
}
