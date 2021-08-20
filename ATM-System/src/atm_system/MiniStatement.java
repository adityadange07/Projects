package atm_system;

import java.util.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class MiniStatement extends JFrame implements ActionListener{
	JLabel l1, l2, l3, l4;
	JButton b1, b2;
	public MiniStatement(String pin) {
		// TODO Auto-generated constructor stub
		l1 = new JLabel("XYZ Bank");
		l1.setBounds(150, 20, 100, 20);
		add(l1);
		
		l2 = new JLabel();
		l2.setBounds(20, 80, 300, 20);
		add(l2);
		
		l3 = new JLabel();
		l3.setBounds(20, 140, 400, 200);
		add(l3);
		
		l4 = new JLabel();
		l4.setBounds(20, 400, 300, 20);
		add(l4);
		
		try {
			Conn cn = new Conn();
			ResultSet rs = cn.st.executeQuery("select * from login where pin = '"+pin+"'");
			while (rs.next()) {
				l2.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			int balance = 0;
			Conn cn = new Conn();
			ResultSet rs = cn.st.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
			while (rs.next()) {
				l3.setText(l3.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("status") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
				if (rs.getString("status").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
			l4.setText("Your total Balance is Rs. "+balance);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		b1 = new JButton("Exit");
		b1.setBounds(20, 500, 100, 25);
		add(b1);
		
		b1.addActionListener(this);
		
		setLayout(null);
		setSize(400, 600);
		setLocation(0, 0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiniStatement("").setVisible(true);
	}
}
