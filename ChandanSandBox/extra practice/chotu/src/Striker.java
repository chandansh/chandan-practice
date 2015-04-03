public class Striker {
	int a;
	boolean strick = false;

	public synchronized void struck(int x) {

		System.out.println("Player " + x + " entered the game and play.");
		// if (strick) {
		// System.out.println("Player " + x
		// + " enter the game out of turn,please wait your turn");
		// try {
		// wait();
		// } catch (Exception e) {
		// }
		// strick=false;
		// } else {
		// a = x;
		// System.out.println("player " + a + " is starting to play");
		// System.out.println("player " + a + " now your turn.");
		// strick = true;
		// notify();
		// }

	}
}