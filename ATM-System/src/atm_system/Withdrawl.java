package atm_system;

import java.util.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Withdrawl extends JFrame implements ActionListener {
	JLabel l1, l2;
	JTextField tf1;
	JButton b1, b2, b3;
	String pin;
	
	public Withdrawl(String pin) {
		// TODO Auto-generated constructor stub
		this.pin = pin;
		
		l1 = new JLabel("MAXIMUM WITHDRAWL IS RS. 10,000");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("System", Font.BOLD, 16));
		l1.setBounds(100, 50, 400, 30);
		add(l1);
		
		l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("System", Font.BOLD, 16));
		l2.setBounds(120, 100, 300, 30);
		add(l2);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Ralway", Font.BOLD, 25));
		tf1.setBounds(100, 150, 300, 30);
		add(tf1);
		
		b1 = new JButton("WITHDRAWL");
		b1.setBounds(100, 200, 140, 30);
		add(b1);
		
		b2 = new JButton("BACK");		
		b2.setBounds(260, 200, 140, 30);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setLayout(null);
		setSize(500, 300);
		setLocation(0, 0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		try {
			String amount = tf1.getText();
			String date = (String) new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format (new Date());
			if (ae.getSource() == b1) {
				if (tf1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
				} else {
					Conn cn = new Conn();
					ResultSet rs = cn.st.executeQuery("select * from bank where pin = '"+pin+"'");
					int balance = 0;
					while (rs.next()) {
						if (rs.getString("status").equals("Deposit")) {
							balance += Integer.parseInt(rs.getString("amount"));
						} else {
							balance -= Integer.parseInt(rs.getString("amount"));
						}
					}
					if (balance < Integer.parseInt(amount)) {
						JOptionPane.showMessageDialog(null, "Insufficient Balance");
						return;
					}
					cn.st.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
					JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
					
					setVisible(false);
					new Transactions(pin).setVisible(true);
				}
			} else if (ae.getSource() == b2) {
				setVisible(false);
				new Transactions(pin).setVisible(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error: "+e);
		}
	}
	
	public static void main(String[] args) {
		new Withdrawl("").setVisible(true);
	}
}
