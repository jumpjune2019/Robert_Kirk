package trafficlight;

import java.io.IOException;

public class Main {
	
	

	public static void main(String[] args) {
		//Creates controller
		LightController lightSystem = new LightController();
		
		//Creates light threads
		LightThread green = new LightThread(Lights.Green);
		LightThread yellow = new LightThread(Lights.Yellow);
		LightThread red = new LightThread(Lights.Red);
		
		System.out.println("Please enter to start the lights. Then press enter to stop them");
		try {
		    //Waits for user to press enter
		    boolean notStarted = lightSystem.getInput();
		    
		    while(!green.isSuspended()) {		    
		    	//Starts threads
		    	if(notStarted) {
		    		notStarted = false;
		    		green.start();
		    		yellow.start();
		    		red.start();
		    	}else {
		    		//Waits for user to terminate the threads by pressing enter
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
