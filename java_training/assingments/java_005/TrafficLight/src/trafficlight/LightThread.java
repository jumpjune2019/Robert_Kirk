package trafficlight;

import java.util.concurrent.TimeUnit;

public class LightThread implements Runnable{
		public Thread t;
		private String threadName;
		private boolean suspended = false;
		private String lastSignal = "red";
		private long time;
		private String message;
		private long delay;
	   
	   public LightThread(Lights light) {
		   this.threadName = light.name();
		   this.time = light.getTime();
		   this.message = light.getMessage();
		   this.delay = light.getDelay();
		   System.out.println(threadName + " light installed!");
//		      start();
	   }

	public void run() {
		 	try {
				this.t.sleep(this.delay);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			while(!suspended) {
				
				System.out.println(this.message);
				try {
					this.t.sleep(10_000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
//				try {
//					if(this.lastSignal.equals("red")) {
//						System.out.println(Lights.Green.getMessage());
//						TimeUnit.SECONDS.sleep(Lights.Green.getTime());
//						
//					}else if(this.lastSignal.equals("green")) {
//						System.out.println(Lights.Yellow.getMessage());
//						TimeUnit.SECONDS.sleep(Lights.Yellow.getTime());
//					}else {
//						System.out.println(Lights.Red.getMessage());
//						TimeUnit.SECONDS.sleep(Lights.Red.getTime());
//					}
//					this.lightChange();
//				}catch (Exception e) {
//					e.printStackTrace();
//				}
									
			}
			
	   }

	   public void start () {
	      
	      if (t == null) {
	         t = new Thread (this, threadName);
	         //System.out.println(t.getName());
	         t.start ();
	        
	      }
	   }
	   
	   void suspend() {
	      suspended = true;
	      
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
