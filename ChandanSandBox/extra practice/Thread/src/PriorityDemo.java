class ChildThread1 implements Runnable {
	Thread t;

	ChildThread1(int p, String name) {
		t = new Thread(this, name);
		t.setPriority(p);
		System.out.println("Thread created: " + t);
	}

	public void run() {
		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println(t + "loop :" + i);
				Thread.sleep(100);
			}
		} catch (InterruptedException obj) {
			System.out.println("Thread :" + t + "interrupted");
		}
	}
}

class PriorityDemo {
	public static void main(String args[]) {
		ChildThread1 obj1 = new ChildThread1(Thread.NORM_PRIORITY - 2, "1");
		ChildThread1 obj2 = new ChildThread1(Thread.NORM_PRIORITY + 2, "2");
		ChildThread1 obj3 = new ChildThread1(Thread.NORM_PRIORITY + 3, "3");
		obj1.t.start();
		obj2.t.start();
		obj3.t.start();
		try {
			System.out
					.println("Main thread waiting for child thread to finish");
			obj1.t.join();
			obj2.t.join();
			obj3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread is interrupted");
		}
		System.out.println(obj1.t + "is alive ? : " + obj1.t.isAlive());
		System.out.println(obj2.t + "is alive ? : " + obj2.t.isAlive());
		System.out.println(obj3.t + "is alive ? : " + obj3.t.isAlive());
		System.out.println("Main Thread is exiting");
	}
}
