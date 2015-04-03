class ThreadA {
	synchronized void call() {
		System.out.println("first statement");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		System.out.println("second statement");
	}
}

class ThreadB extends Thread {
	ThreadA t;

	public ThreadB(ThreadA t) {
		this.t = t;
	}

	public void run() {
		t.call();
	}
}

public class NotSynchronized {
	public static void main(String args[]) {
		ThreadA obj1 = new ThreadA();
		ThreadB Obja = new ThreadB(obj1);
		ThreadB Objb = new ThreadB(obj1);
		Obja.start();
		Objb.start();
	}
}
