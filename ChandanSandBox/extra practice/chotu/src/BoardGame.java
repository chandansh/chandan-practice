public class BoardGame {
	public static void main(String arr[]) {
		System.out.println("Board Game is Start to play Multiplayer\n");
		Striker s = new Striker();
		Player p1 = new Player(s, 1);
		Player p2 = new Player(s, 2);
		Player p3 = new Player(s, 3);
		Player p4 = new Player(s, 4);
		// player p2=new player(s);

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		// p2.start();

	}
}