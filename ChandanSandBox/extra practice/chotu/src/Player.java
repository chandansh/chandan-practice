public class Player extends Thread {
	Striker s;
	int p_no;

	public Player(Striker s, int p_no) {
		this.s = s;
		this.p_no = p_no;
	}

	@Override
	public void run() {

		//System.out.println("\nPlayer no "+p_no+" is started to play game\n");
		for (int i = 1; i <= 10; i++)
			//s.struck(p_no);
			System.out.println("player no :"+p_no+" is playing.");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	

}