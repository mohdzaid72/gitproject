package formdemo;

import java.awt.EventQueue;
import javax.swing.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class loginform extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTable table;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginform frame = new loginform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 585);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LogIn Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(186, 22, 113, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(116, 76, 86, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(116, 128, 86, 22);
		contentPane.add(lblNewLabel_2);
		
		t1 = new JTextField();
		t1.setBounds(268, 80, 96, 19);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(268, 132, 96, 19);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zaid","root","root");
					Statement stmt = con.createStatement();
					String st="select * from employee where name='"+t1.getText()+"' and password ='"+t2.getText()+"'";
					 ResultSet rs=stmt.executeQuery(st);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null,"valid user... wellcome");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"invalid user... please try again");
					}
				}
				catch(Exception g)
				{
				System.out.println(g);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(116, 194, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//	try {
			//		Class.forName("com.mysql.jdbc.Driver");
				//	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zaid","root","root");
				//	Statement stmt = con.createStatement();
				//	String st="insert into employee values('"+t1.getText()+"','"+t2.getText()+"')";//
				//	int i=stmt.executeUpdate(st);
				//	if(i>0)
				//	{
				//		JOptionPane.showMessageDialog(null,"data inserted successfully");
				//	} 
				//	else
				//	{
				//		JOptionPane.showMessageDialog(null,"not inserted");
				//	}	
				//	 
					
				//}
				//catch(Exception g)
				//{
				//System.out.println(g);
				//}
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zaid","root","root");
					String st="insert into employee values(?,?)";//
					PreparedStatement pst=con.prepareStatement(st);
					pst.setString(1,t1.getText());
					pst.setString(2 ,t2.getText());
					int i= pst.executeUpdate();
					if(i>0)
					{
						JOptionPane.showMessageDialog(null,"data inserted successfully");
					} 
					else
					{
						JOptionPane.showMessageDialog(null,"not inserted");
					}					
				}
				catch(Exception g)
				{
				System.out.println(g);
				}
				
			}
		});
				
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(268, 195, 116, 22);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(151, 320, 213, 122);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("display data");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zaid","root","root");
					Statement stmt = con.createStatement();
					String qu="select * from employee";
					ResultSet rs=stmt.executeQuery(qu);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel tm=(DefaultTableModel)table.getModel();
					int col=rsmd.getColumnCount();
					String []nm=new String[col];
					for(int i=0;i<col;i++)
					{
						nm[i]=rsmd.getColumnName(i+1);
					}
					tm.setColumnIdentifiers(nm);
					while(rs.next())
					{
						String n=rs.getString(1);
						String p=rs.getString(2);
						String[]row= {n,p};
						tm.addRow(row);
					}
					
					
				}
				catch(Exception g)
				{
					System.out.println(g);
				}
			}
			
		});
		btnNewButton_2.setBounds(151, 462, 102, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zaid","root","root");
					Statement stmt = con.createStatement();
					String qu="delete from employee where name='"+t1.getText()+"'";
					int i=stmt.executeUpdate(qu);
					if(i>0)
					{
						JOptionPane.showMessageDialog(null,"data deleted successfully");
					} 
					else
					{
							JOptionPane.showMessageDialog(null,"not deleted");
					}	
				
				
				}
				catch(Exception v)
				{
					System.out.println(v);
				}
				
			}
		});
		btnNewButton_3.setBounds(197, 239, 86, 27);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("update");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zaid","root","root");
				Statement stmt =con.createStatement();
				String st="update employee set password='"+t2.getText()+"' where name='"+t1.getText()+"'";
				int i=stmt.executeUpdate(st);
				if(i>0)
				{
					JOptionPane.showMessageDialog(null,"data updated successfully");
				} 
				else
				{
						JOptionPane.showMessageDialog(null,"not updated");
				}
				}
				catch(Exception q)
				{
					System.out.println(q);
				}
			}
		});
		btnNewButton_4.setBounds(283, 465, 85, 21);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_3 = new JLabel("  for delete we required only name");
		lblNewLabel_3.setBounds(175, 225, 230, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_5 = new JButton("clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				
				
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_5.setBounds(10, 527, 85, 21);
		contentPane.add(btnNewButton_5);
		
		
		
		
		
		
		
	}
}
