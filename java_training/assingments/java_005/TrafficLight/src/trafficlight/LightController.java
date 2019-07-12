package trafficlight;

import java.io.IOException;
import java.util.Scanner;

public class LightController {
	
	private boolean lightsActive = false;
	
	public boolean getInput() throws IOException {
		
		//System.out.println("getting scanner input");
		Scanner br = new Scanner(System.in);
		br.nextLine();
		//System.out.println(input);
		if(this.lightsActive) {
			br.close();
		}
		return true;
	}

	public boolean isLightsActive() {
		return lightsActive;
	}

	public void setLightsActive(boolean lightsActive) {
		this.lightsActive = lightsActive;
	}
	
	
	

}
