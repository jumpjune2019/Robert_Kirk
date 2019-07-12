package trafficlight;

public class LightThread implements Runnable {
	public Thread t;
	private String threadName;
	private boolean suspended = false;
	private String message;
	private long delay;

	public LightThread(Lights light) {
		this.threadName = light.name();
		this.message = light.getMessage();
		this.delay = light.getDelay();
		System.out.println(threadName + " light installed!");
//		      start();
	}

	@SuppressWarnings("static-access")
	public void run() {
		try {
			this.t.sleep(this.delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while (!suspended) {
			
			System.out.println(this.message);
			
			try {
			
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
