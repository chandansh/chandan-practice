class ThreadDemoClass 
{
    public static void main(String args[]) 
    {
	new ThreadDemo();
   	System.out.println("The main thread started");
   	System.out.println("The main thread sleeping");
   	try
 	{
      		Thread.sleep(1000);
	}
	 catch(InterruptedException e)
   	{
		System.out.println("The main thread interrupted");
	}
  		System.out.println("Exiting main thread");
     }
}

class ThreadDemo extends Thread 
{
	ThreadDemo() 
	{
  		super("ChildThread"); // calls the superclass constructor
	  	System.out.println("ChildThread:" + this);
 		start();
	}
	public void run() 
	{
  		System.out.println("The child thread started");
                System.out.println("Running the child thread");
  		System.out.println("Exiting the child thread");
 	}
}

