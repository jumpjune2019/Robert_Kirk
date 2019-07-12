package trafficlight;

//Class for creating threads to control the lights
public class LightThread implements Runnable {
	
	public Thread t;
	private String threadName;
	private boolean suspended = false;
	private String message;
	private long delay;

	//Constructor that gets info for each light
	public LightThread(Lights light) {
		this.threadName = light.name();
		this.message = light.getMessage();
		this.delay = light.getDelay();
		System.out.println(threadName + " light installed!");
	}

	//causes the readout for the lights
	@SuppressWarnings("static-access")
	public void run() {
		try {
			//staggers the deployment of the lights 
			this.t.sleep(this.delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//runs until suspended
		while (!suspended) {
			//broadcasts message
			System.out.println(this.message);
			
			try {
				//causes thread to sleep until it needs to broadcast again
				this.t.sleep(10_000);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
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

	public boolean isSuspended() {
		return this.suspended;
	}
}
