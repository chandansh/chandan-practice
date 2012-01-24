class NewThread1A implements Runnable
{
	Thread t;
	NewThread1A() 
	{
		t = new Thread(this, "ChildThread");
		System.out.println("Child Thread:" + t);
		t.start();
	}
	public void run()
	{ // Implementing the run() method of the Runnable interface
      	 	System.out.println("Child Thread Started");
		System.out.println("Exiting the child thread");
	}
}

class ThreadClass 
{
	public static void main(String args[]) 
	{
		NewThread1A nn =  new NewThread1A();
	   System.out.println("Main thread Started");
	   try
	   {
            System.out.println("Sleeping the main thread");                
        	       Thread.sleep(5000);
     	   }
    	   catch(InterruptedException e)
     	   {
		System.out.println("The main thread interrupted");}
		System.out.println("Exiting the main thread");
  	   }
}
