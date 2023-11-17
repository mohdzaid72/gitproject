

class threaddemo2 implements Runnable
{
public void run()          //running state
{
   for(int i=0;i<6;i++)
	{    

	try{
	//Thread.sleep(3000);       //waiting state
	    System.out.println("the thread is running"+i);
	}
	catch(Exception e)
	{System.out.println(e);
	}	
}
}
	public void a()
	{ 
		 for(int i=100;i<110;i++)
		{
			System.out.println(i);
		}

	}

public static void main(String args[])
{


	threaddemo2 td0=new threaddemo2();    //new state
	threaddemo2 td1=new threaddemo2();
	threaddemo2 td3=new threaddemo2();

	Thread t0=new Thread(td0);
	Thread t1=new Thread(td1);
	Thread t2=new Thread(td3);
	//System.out.println("Neme of thread is"+td.getName()); //throwing thread name
	 t0.start();        //Runnable state
	 try{
		//t0.join();

	}
	catch(Exception e)
	{
		System.out.println(e);
	}

	 t1.start();
	t2.a();
}

}
