class threaddemo extends Thread
{
public void run()          //running state
{
   for(int i=0;i<6;i++)
	{    

	try{
	Thread.sleep(3000);       //waiting state
	    System.out.println("the thread is running"+i);
	}
	catch(Exception e)
	{System.out.println(e);
	}	
}
}

public static void main(String args[])
{


threaddemo td=new threaddemo();    //new state
System.out.println("Neme of thread is"+td.getName()); //throwing thread name
 td.start();        //Runnable state

}

}