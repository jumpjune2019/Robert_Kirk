package trafficlight;

import java.io.IOException;
import java.util.Scanner;

//Controls when the loop in main starts and ends
public class LightController {
	//Get user input
	Scanner br = new Scanner(System.in);
	
	//allows for control of when the scanner will be closed
	private boolean lightsActive = false;
	
	//activates to get users enter input
	public boolean getInput() throws IOException {
		
		//Stops the main thread
		br.nextLine();
		//System.out.println(input);
		if(this.lightsActive) {
			br.close();
		}
		return true;
	}
	
	//Getters and setters
	public boolean isLightsActive() {
		return lightsActive;
	}

	public void setLightsActive(boolean lightsActive) {
		this.lightsActive = lightsActive;
	}
	
	
	

}
