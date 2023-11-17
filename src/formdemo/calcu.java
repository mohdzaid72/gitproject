import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class calcu implements ActionListener
{JFrame f;
 JPanel p;
JTextField tf1,tf2,tf3;
 JButton b;


calcu()
{f=new JFrame();
p=new JPanel();
tf1=new JTextField(20);
 tf2=new JTextField(20);
tf3=new JTextField(20);
b=new JButton("+");
f.add(p);
p.add(tf1);
p.add(tf2);
p.add(b);
p.add(tf3);


b.addActionListener(new ActionListener()
 {public void actionPerformed(ActionEvent e)
  {String s1=tf1.getText();
    String s2=tf2.getText();
     int a=Integer.parseInt(s1);
     int b=Integer.parseInt(s2);
      int c=a+b;
String result=String.valueOf(c);
tf3.setText(result);
   }

});
f.pack();
f.setVisible(true);





}
public void actionPerformed(ActionEvent e)
{
	System.out.println("zaid");
}

public static void main(String []args)
{
calcu cal=new calcu();

}



}