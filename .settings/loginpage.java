import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class loginform extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;

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
		setBounds(100, 100, 523, 476);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
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
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zaid","root","root");
					String st="insert into employee values(?,?)";//
					PreparedStatement pst=con.prepareStatement(st);
					pst.setString(1,t1.getText());
					pst.setString(1,t1.getText());
					int i= stmt.executeUpdate(pst);
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
	}
}









*********************************************************
data base on interface
********************************************************
ResultSetMataData






