package trafficlight;

import java.io.IOException;

public class Main {
	
	

	public static void main(String[] args) {
		
		LightController lightSystem = new LightController();
		LightThread thread = new LightThread("Lights");
		
		try {
		    //String str = "Light Trigger";
		    boolean notStarted = lightSystem.getInput();
		    
		    while(!thread.isSuspended()) {		    
		    	
		    	if(notStarted) {
		    		notStarted = false;
		    		thread.start();
		    	}else {
		    		
		    		boolean b = lightSystem.getInput();
		    		if(b) {
		    			thread.suspend();
		    			
		    		}		    		
		    	}		    	
		    }  
		} 
		catch( IOException e ) {
		    System.err.println( "Error: " + e );
		}
		
		

	}

}
