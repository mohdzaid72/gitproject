//io in java

/*
import java.io.*;
class ademo
{
public static void main(String args[]) throws IOException
{
FileOutputStream fo=new FileOutputStream("C:\\c/demo.txt");
BufferedOutputStream bo=new BufferedOutputStream(fo);
String a="hello user";
byte[] b=a.getBytes();
//fo.write(b);
bo.write(b);
System.out.println("Data writen Successfully");
bo.close();
fo.close();
}
*/

}



/*import java.io.*;
class ademo
{
public static void main(String args[]) throws IOException
{
try
{

FileInputStream fo=new FileInputStream("C:\\c/demo.txt");

int i=fo.read();
while(i!=-1)
{
  System.out.print((char)i);
 i=fo.read();


}
fo.close();

}
catch(Exception e)
{
System.out.println(e);
}


}
*/


// this program doing by using file reader and file writer

/*import java.io.*;
class ademo
{ 
public static void main(String args[])
{
try
{   
FileWriter fw= new FileWriter("C:\\c/demo.txt");
   
 String s="file writer";
 fw.write(s);
 fw.close();
}
catch(Exception e)
{

System.out.println(e);
}

}
}
*/



/*
import java.io.*;
class ademo
{ 
public static void main(String args[])
{
try
{   
FileReader fw= new FileReader("C:\\c/demo.txt");
  int i=fw.read();
  
while(i!=-1)
{
  System.out.print((char)i);
 i=fw.read();


}
 

}
catch(Exception e)
{

System.out.println(e);
}

}
}

*/
