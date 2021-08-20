package atm_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	JLabel l1, l2, l3;
	JTextField tf1;
	JPasswordField pf2;
	JButton b1, b2, b3;
	
	public Login() {
		setTitle("AUTOMETED TELLER MACHINE");
		
		l1 = new JLabel("WELCOME TO ATM");
		l1.setFont(new Font("Osward", Font.BOLD, 38));
		l1.setBounds(140, 40, 450, 40);
		add(l1);
		
		l2 = new JLabel("Card No.:");
		l2.setFont(new Font("Raleway", Font.BOLD, 28));
		l2.setBounds(100, 100, 375, 30);
		add(l2);
		
		tf1 = new JTextField(15);
		tf1.setBounds(300, 100, 230, 30);
		tf1.setFont(new Font("Arial", Font.BOLD, 14));
		add(tf1);
		
		l3 = new JLabel("PIN:");
		l3.setFont(new Font("Raleway", Font.BOLD, 28));
		l3.setBounds(100, 150, 375, 30);
		add(l3);
		
		pf2 = new JPasswordField();
		pf2.setFont(new Font("Arial", Font.BOLD, 14));
		pf2.setBounds(300, 150, 230, 30);
		add(pf2);
		
		b1 = new JButton("SIGN IN");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Arial", Font.BOLD, 14));
		b1.setBounds(300, 200, 100, 30);
		add(b1);
		
		b2 = new JButton("CLEAR");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Arial", Font.BOLD, 14));
		b2.setBounds(430, 200, 100, 30);
		add(b2);
		
		b3 = new JButton("SIGN UP");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Arial", Font.BOLD, 14));
		b3.setBounds(300, 250, 230, 30);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setLayout(null);
		setSize(650, 350);
		setLocation(0, 0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		try {
			if (ae.getSource() == b1) {
				Conn cn = new Conn();
				String card_no = tf1.getText();
				String pin = new String(pf2.getPassword());
				String qurry = "Select * from login where card_no = '"+card_no+"' and pin = '"+pin+"'";
				
				ResultSet rs = cn.st.executeQuery(qurry);
				if (rs.next()) {
					setVisible(false);
					new Transactions(pin).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
				}
			} else if(ae.getSource() == b2) {
				tf1.setText("");
				pf2.setText("");
			} else if(ae.getSource() == b3) {
				setVisible(false);
				new SignUp().setVisible(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new Login().setVisible(true);
	}
}
