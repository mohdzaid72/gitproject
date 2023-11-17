class A
{
	public void settable(int n)
	{
		for(int i=0;i<11;i++)
		{ 
		 System.out.println(i*n);
		}
	}

}
class B extends Thread
{ A a;
B(A a)
{
 this.a=a;
}
	public void run(){
		a.settable(2);
	}

}
class C extends Thread
{A a;
C(A a)
{
this.a=a; 
}
	public void run(){
		a.settable(3);	
	}

}
class D
{
public static void main(String args[])
{A a=new A();
B b=new B(a);
C c=new C(a);
b.start();
c.start();
}
}
 