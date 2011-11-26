class newThreadClass implements Runnable
 {
	Thread t;
	newThreadClass() 
	{
		t = new Thread(this,"ChildThread" );
		System.out.println("Thread created: " + t);
		t.start();
	}
	public void run()
  	{
		try
		{
			for(int i=1;i<2;i++)
			{ 
				System.out.println(t + "loop :" + i);
				Thread.sleep(500);
                                System.out.println(t  + "is alive ? : " + t.isAlive());
			}
		}
		catch( InterruptedException obj)
 		{
			System.out.println("Thread :" + t + "interrupted");
                        
		}
                
		
  	}
}
class isAliveDemo 
{
	 public static void main(String args[])
  	 {
   		newThreadClass obj = new newThreadClass();
	   	System.out.println(obj.t  + "is alive ? : " + obj.t.isAlive());
   	try
 	{
     		for(int i=1;i<2;i++)
     		{
			System.out.println("Main Thread loop:" + i);
      			Thread.sleep(500);
			
      		}
  	 }
	catch(InterruptedException e)
     	{
		System.out.println("Main thread is interrupted");
	}
	  	//System.out.println(obj.t  + "is alive ? : " + obj.t.isAlive());
  		System.out.println("Main Thread is exiting");
  	}
}
