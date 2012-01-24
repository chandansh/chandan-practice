class Thread11
{
    void call()
    {
	System.out.println("first statement");
	try
	{
   	  Thread.sleep(1000);
	}
	catch(Exception e)
	{
	  System.out.println("Error " + e);
        }
	System.out.println("second statement");
    }
}
class Thread12 extends Thread
{
	Thread11 t;
	public Thread12(Thread11 t)
	{
		this.t = t;
   	}
   	public void run()
	{
		
		        t.call();
        	
   	}
}
public class SynchronizedBlock 
{
	public static void main(String args[])
	{
	   Thread11 obj1 = new Thread11();
	   Thread12 obja = new Thread12(obj1);
	   Thread12 objb = new Thread12(obj1);
	   obja.start();
	   objb.start();
   	}
}
