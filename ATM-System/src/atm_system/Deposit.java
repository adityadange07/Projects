package atm_system;

import java.util.*;
import java.util.Date;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener {
	 
	JLabel l1;
	JTextField tf1, tf2;
	JButton b1, b2, b3;
	String pin;
	
	public Deposit(String pin) {
		this.pin = pin;

		l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
		l1.setFont(new Font("Ralway", Font.BOLD, 22));
		l1.setBounds(70, 100, 450, 35);
		add(l1);
		
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Ralway", Font.BOLD, 22));
		tf1.setBounds(100, 200, 380, 35);
		add(tf1);
		
		b1 = new JButton("Deposit");
		b1.setFont(new Font("Ralway", Font.BOLD, 22));
		b1.setBounds(150, 300, 140, 30);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setFont(new Font("Ralway", Font.BOLD, 22));
		b2.setBounds(310, 300, 140, 30);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setLayout(null);
		setSize(600, 450);
		setLocation(0,0);
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
					JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
				} else {
					Conn cn = new Conn();
					cn.st.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
					JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
					setVisible(false);
					new Transactions(pin).setVisible(true);
				}
			} else if (ae.getSource() == b2) {
				setVisible(false);
				new Transactions(pin).setVisible(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Deposit("").setVisible(true);
	}
}
