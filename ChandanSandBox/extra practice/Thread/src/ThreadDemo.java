class NewThread implements Runnable 
{
  	Thread t;

  	NewThread() 
	{
   	 t = new Thread(this, "child");
    	 System.out.println(Thread.currentThread()+":::::: " +t);
   	 t.start(); // Start the thread	
         System.out.println("Child Thread started"+t);            
	 }


  	public void run() 
	{
    		try
		{
                        System.out.println(Thread.currentThread());
      			for(int i = 5; i > 0;i--) 
			{
        		   System.out.println("Child Thread: " + i);                                       Thread.sleep(1000);
      			}
    		} 
		catch (InterruptedException e) 
		{
      		   System.out.println("Child interrupted.");
    		}
                   System.out.println("Exiting child thread.");
  	}
}

class ThreadDemo 
{
  	public static void main(String args[]) 
	{
   		 new NewThread(); // create a new thread

   		 try 
		{
      			for(int i = 15; i > 10;i--) 
			{
       				                                                      System.out.println(Thread.currentThread()+": " +i);
        		  Thread.sleep(1000);
      			}
    		}
		catch (InterruptedException e)
		{
     		    System.out.println("Main thread interrupted.");
    		}
    		System.out.println("Main thread exiting.");
  	}
}
