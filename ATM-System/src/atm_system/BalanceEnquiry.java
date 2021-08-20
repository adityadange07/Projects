package atm_system;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
	JLabel l1;
	JButton b1;
	String pin;

	public BalanceEnquiry(String pin) {
		// TODO Auto-generated constructor stub
		this.pin = pin;
		l1 = new JLabel();
		l1.setFont(new Font("System", Font.BOLD, 16));
		l1.setBounds(100, 500, 500, 35);
		add(l1);
		
		b1 = new JButton("Back");
		b1.setBounds(390, 600, 150, 35);
		add(b1);
		
		int balance = 0;
		try {
			Conn cn = new Conn();
			ResultSet rs = cn.st.executeQuery("select * from bank where pin = '"+pin+"'");
			while (rs.next()) {
				if (rs.getString("status").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		l1.setText("Your Current Amount Balance is Rs. "+balance);
		
		b1.addActionListener(this);
		
		setLayout(null);
		setSize(700, 700);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		new Transactions(pin).setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BalanceEnquiry("").setVisible(true);
	}
}
