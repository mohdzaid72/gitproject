import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class calcu implements ActionListener {
	JFrame f;
	JPanel p;
	JTextField tf1, tf2, tf3;
	JButton b1, b2, b3, b4;

	calcu() {
		f = new JFrame();
		p = new JPanel();
		tf1 = new JTextField(20);
		tf2 = new JTextField(20);
		tf3 = new JTextField(20);
		b1 = new JButton("+");
		b2 = new JButton("-");
		b3 = new JButton("*");
		b4 = new JButton("/");

		f.add(p);
		p.add(tf1);
		p.add(tf2);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(tf3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		f.pack();
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String s1 = tf1.getText();
		String s2 = tf2.getText();
		int a = Integer.parseInt(s1);
		int b = Integer.parseInt(s2);
		int c = 0;
		if (e.getSource() == b1) {
			c = a + b;
		}
		if (e.getSource() == b2) {
			c = a - b;
		}
		if (e.getSource() == b3) {
			c = a * b;
		}
		if (e.getSource() == b4) {
			c = a / b;
		}
		String result = String.valueOf(c);
		tf3.setText(result);
	}

	public static void main(String[] args) {
		calcu calcu = new calcu();

	}

}