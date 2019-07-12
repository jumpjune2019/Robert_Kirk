package trafficlight;

import java.io.IOException;
import java.util.Scanner;

public class LightController {
	
	private boolean lightsActive = false;
	
	protected String lastSignal="red";
	
//	public void runLights() {
//		//TimeUnit.SECONDS.sleep(1);
//		System.out.println("Traffic Light Simulator is a Go!");
//		this.setLightsActive(true);
//				
//		while(this.lightsActive) {
//			
//			
//			if(this.lastSignal.equals("red")) {
//				System.out.println(Lights.Green.getMessage());
//				Lights.setTimer(Lights.Green.getTime());
//			}else if(this.lastSignal.equals("green")) {
//				System.out.println(Lights.Yellow.getMessage());
//				Lights.setTimer(Lights.Yellow.getTime());
//			}else {
//				System.out.println(Lights.Red.getMessage());
//				Lights.setTimer(Lights.Red.getTime());
//			}
//			this.lightChange();					
//		}
//		System.out.println("Traffic Light Simulator is Done!");
//		
//	}
	
	public void inspectLights(String str) {
		if(str == " ") {
			
			if(this.lightsActive) {
				this.setLightsActive(false);
				
			}else {
				//this.runLights();
			}
		}
			
	}
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
	
	public void dealWithInput(String s) {
		
		this.inspectLights(s);
		
	}

	public boolean isLightsActive() {
		return lightsActive;
	}

	public void setLightsActive(boolean lightsActive) {
		this.lightsActive = lightsActive;
	}
	
	
	

}
