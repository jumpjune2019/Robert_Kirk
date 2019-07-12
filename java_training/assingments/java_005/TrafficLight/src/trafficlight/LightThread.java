package trafficlight;



public class LightThread implements Runnable{
		public Thread t;
		private String threadName;
		private boolean suspended = false;
		private String lastSignal = "red";
		
	   public LightThread(String s) {
		  this.threadName = s;
	      System.out.println(threadName + " light installed!");
//	      start();
	   }
	   
	   public void run() {
		 //TimeUnit.SECONDS.sleep(1);
			//System.out.println("Traffic Light Simulator is a Go!");					
			while(!suspended) {
				
				
				if(this.lastSignal.equals("red")) {
					System.out.println(Lights.Green.getMessage());
					Lights.setTimer(Lights.Green.getTime());
				}else if(this.lastSignal.equals("green")) {
					System.out.println(Lights.Yellow.getMessage());
					Lights.setTimer(Lights.Yellow.getTime());
				}else {
					System.out.println(Lights.Red.getMessage());
					Lights.setTimer(Lights.Red.getTime());
				}
				this.lightChange();					
			}
			
	   }

	   public void start () {
	      System.out.println("Please enter to start the lights. Then press enter to stop them");
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
	   
	   void suspend() {
	      suspended = true;
	      System.out.println("Traffic Light Simulator is Done!");
	   }
	   
	   synchronized void resume() {
		   //System.out.println(message);
		   suspended = false;
		   notify();
	   }

	public String getThreadName() {
		
		return this.threadName;
	}
	protected void lightChange() {
		if(this.lastSignal.equals("red")) {
			this.lastSignal= "green";
		}else if(this.lastSignal.equals("green")) {
			this.lastSignal = "yellow";
		}else {
			this.lastSignal = "red";
		}
	}
	public boolean isSuspended() {
		return this.suspended;
	}
	
	

}
