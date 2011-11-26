class Share extends Thread {
	SynMethod s;

	
	Share(SynMethod sm,String threadname) {
		super(threadname);
		this.s=sm;
	}

	public void run() {
		for(int i=0;i<5;i++)
		{
			
			s.display(getName(),i);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		try {
//			sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	
}

class SynMethod
{
	boolean status=false;
	public synchronized void display(String threadN, int i) {
//		for (int i = 0; i <= 500; i++)
//			System.out.println(threadN + i);
//		try {
//			
//		} catch (Exception e) {
//		}
		if(!status)
		{
			status=true;
			try {
				//wait();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notify();
		}
		
		if(status)
		{
		System.out.println(i+" time "+threadN+" is playing");
		try {
			wait(100);
			status=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		
		//notify();
	}
	
	
}

public class SynThread1 {
	public static void main(String[] args) {
		SynMethod s=new SynMethod();
		Share t1 = new Share(s,"Thread One: ");
		t1.start();
		Share t2 = new Share(s,"Thread Two: ");
		t2.start();
		Share t3 = new Share(s,"Thread Three: ");
		t3.start();
		Share t4 = new Share(s,"Thread Four: ");
		t4.start();
	}
}