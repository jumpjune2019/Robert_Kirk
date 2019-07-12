package trafficlight;

import java.io.IOException;

public class Main {
	
	

	public static void main(String[] args) {
		
		LightController lightSystem = new LightController();
		LightThread green = new LightThread(Lights.Green);
		LightThread yellow = new LightThread(Lights.Yellow);
		LightThread red = new LightThread(Lights.Red);
		System.out.println("Please enter to start the lights. Then press enter to stop them");
		try {
		    
		    boolean notStarted = lightSystem.getInput();
		    
		    while(!green.isSuspended()) {		    
		    	
		    	if(notStarted) {
		    		notStarted = false;
		    		green.start();
		    		yellow.start();
		    		red.start();
		    	}else {
		    		
		    		boolean b = lightSystem.getInput();
		    		if(b) {
		    			green.suspend();
		    			yellow.suspend();
		    			red.suspend();
		    			System.out.println("Traffic Light Simulator is Done!");
		    			
		    		}		    		
		    	}		    	
		    }  
		} 
		catch( IOException e ) {
		    System.err.println( "Error: " + e );
		}
		
		
		

	}

}
