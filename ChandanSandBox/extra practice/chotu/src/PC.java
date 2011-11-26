class Buffer {
	int a;
	boolean produced = false;

	public synchronized void produce(int x) {
		if (produced) {
			System.out
					.println("Producer enter the moniter out of turn,suspending...");
			try {
				wait();
			} catch (Exception e) {
			}
		}
		a = x;
		System.out.println(a + "is produced.");
		produced = true;
		notify();
	}

	public synchronized void consume() {
		if (!produced) {
			System.out
					.println("consumer enter the moniter out of turn,suspending...");
			try {
				wait();
			} catch (Exception e) {
			}
		}

		System.out.println(a + "is consumed.");
		produced = false;
		notify();
	}
}

class producer extends Thread {
	Buffer b;

	public producer(Buffer b) {
		this.b = b;
	}

	public void run() {
		System.out.println("Producer started, producing values.....");
		for (int i = 1; i <= 10; i++)
			b.produce(i);
	}
}

class consumer extends Thread {
	Buffer b;

	public consumer(Buffer b) {
		this.b = b;
	}

	public void run() {
		System.out.println("consumer started, consuming values.....");
		for (int i = 1; i <= 10; i++)
			b.consume();
	}
}

public class PC {
	public static void main(String arr[]) {
		System.out
				.println("Main thread started,starting producer and consumer..");
		Buffer b = new Buffer();
		producer p = new producer(b);
		consumer c = new consumer(b);

		p.start();
		c.start();
	}
}