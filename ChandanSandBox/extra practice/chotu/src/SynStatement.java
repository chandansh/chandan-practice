class Share1 extends Thread {
	static String msg[] = { "This", "is", "a", "synchronized", "variable" };

	Share1(String threadname) {
		super(threadname);
	}

	public void run() {
		display(getName());
	}

	public void display(String threadN) {
		synchronized (this) {
			for (int i = 0; i <= 200; i++)
				System.out.println(threadN + i);
			try {
				//this.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}

public class SynStatement {
	public static void main(String[] args) {
		Share1 t1 = new Share1("Thread One: ");
		t1.start();
		Share1 t2 = new Share1("Thread Two: ");
		t2.start();
	}
}