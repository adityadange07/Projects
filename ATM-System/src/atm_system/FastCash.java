package atm_system;

import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class FastCash extends JFrame implements ActionListener {
	
	JLabel l1, l2;
	JButton b1, b2, b3, b4, b5, b6, b7, b8;
	String pin;
	
	public FastCash(String pin) {
		// TODO Auto-generated constructor stub
		this.pin = pin;
		
		l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
		l1.setFont(new Font("System", Font.BOLD, 16));
		l1.setBounds(125, 50, 300, 30);
		add(l1);
		
		b1 = new JButton("Rs. 100");
		b1.setBounds(100, 100, 140, 30);
		add(b1);
		
		b2 = new JButton("Rs. 500");
		b2.setBounds(260, 100, 140, 30);
		add(b2);
		
		b3 = new JButton("Rs. 1000");
		b3.setBounds(100, 150, 140, 30);
		add(b3);
		
		b4 = new JButton("Rs. 2000");
		b4.setBounds(260, 150, 140, 30);
		add(b4);
		
		b5 = new JButton("Rs. 5000");
		b5.setBounds(100, 200, 140, 30);
		add(b5);
		
		b6 = new JButton("Rs. 10,000");
		b6.setBounds(260, 200, 140, 30);
		add(b6);
		
		b7 = new JButton("Back");
		b7.setBounds(180, 250, 140, 30);
		add(b7);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		
		setLayout(null);
		setSize(500, 350);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		try {	
			String amount = ((JButton)ae.getSource()).getText().substring(4);
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
			if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
				JOptionPane.showMessageDialog(null, "Insufficient Balance");
				return;
			}
			if (ae.getSource() == b7) {
				setVisible(false);
				new Transactions(pin).setVisible(true);
			} 
			else {
				String date = (String) new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format (new Date());
				cn.st.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
				JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
				setVisible(false);
				new Transactions(pin).setVisible(true);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FastCash("").setVisible(true);
	}
}
