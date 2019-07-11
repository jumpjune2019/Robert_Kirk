package keyeventdemo;

class ReportThread implements Runnable {
	   public Thread t;
	   private String threadName;
	   boolean suspended = false;

	   public ReportThread( String name) {
	      threadName = name;
	      
	      System.out.println("Creating " +  threadName );
	      start();
	   }
	   
	   public void run() {
	      System.out.println("Running " +  threadName );
	      try {
	    	  while(!suspended) {
	    		  for(int i = 10; i > 0; i--) {
	    			  if(i == 1) {
	    				  //System.out.println();
	    				  KeyEventDemo.displayInfo("Excecuting thread: " + threadName + ".");
	  	  	            // Let the thread sleep for a while.
	  	  	            Thread.sleep(1000);
	  	  	            synchronized(this) {
	  	  	               while(suspended) {
	  	  	                  wait();
	  	  	               }
	    			  }
	  	           
	  	            }
	    	  }
	         
	         }
	      } catch (InterruptedException e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      System.out.println("Thread " +  threadName + " exiting.");
	   }

	   public void start () {
	      System.out.println("Starting " +  threadName );
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
	   
	   void suspend() {
	      suspended = true;
	   }
	   
	   synchronized void resume() {
	      suspended = false;
	      notify();
	   }

	public String getThreadName() {
		
		return this.threadName;
	}
}