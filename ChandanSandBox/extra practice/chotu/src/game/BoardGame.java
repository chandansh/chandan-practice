package game;

class Player extends Thread {
	Striker s;

	Player(Striker sm, String playername) {
		super(playername);
		this.s = sm;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {

			s.strike(getName(), i);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class Striker {
	boolean status = false;

	public synchronized void strike(String playerName, int i) {
		if (!status) {
			status = true;
			notify();
		}

		if (status) {
			System.out.println(i + " time " + playerName + " is playing");
			try {
				wait(100);
				status = false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}

public class BoardGame {
	public static void main(String[] args) {
		Striker s = new Striker();
		Player t1 = new Player(s, "Player One: ");
		t1.start();
		Player t2 = new Player(s, "Player Two: ");
		t2.start();
		Player t3 = new Player(s, "Player Three: ");
		t3.start();
		Player t4 = new Player(s, "Player Four: ");
		t4.start();
	}
}