package atm_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
	JLabel l1;
	JButton b1, b2, b3, b4, b5, b6, b7;
	String pin;
	
	public Transactions(String pin) {
		this.pin = pin;
		
		l1 = new JLabel("Please Select Your Transaction");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("System", Font.BOLD, 16));
		l1.setBounds(160, 50, 400, 35);
		add(l1);
		
		b1 = new JButton("DEPOSITE");
		b1.setBounds(100, 150, 150, 35);
		add(b1);
		
		b2 = new JButton("CASH WITHDRAWL");
		b2.setBounds(300, 150, 150, 35);
		add(b2);
		
		b3 = new JButton("FAST CASH");
		b3.setBounds(100, 250, 150, 35);
		add(b3);
		
		b4 = new JButton("MINI STSTEMENT");
		b4.setBounds(300, 250, 150, 35);
		add(b4);
		
		b5 = new JButton("PIN CHANGE");
		b5.setBounds(100, 350, 150, 35);
		add(b5);
		
		b6 = new JButton("BALANCE ENQUIRY");
		b6.setBounds(300, 350, 150, 35);
		add(b6);
		
		b7 = new JButton("EXIT");
		b7.setBounds(200, 450, 150, 35);
		add(b7);
		
		setLayout(null);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		
		setSize(550, 550);
		setLocation(0, 0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getSource() == b1) {
			setVisible(false);
			new Deposit(pin).setVisible(true);
		} else if(ae.getSource() == b2) {
			setVisible(false);
			new Withdrawl(pin).setVisible(true);
		} else if(ae.getSource() == b3) {
			setVisible(false);
			new FastCash(pin).setVisible(true);
		} else if(ae.getSource() == b4) {
			setVisible(false);
			new MiniStatement(pin).setVisible(true);
		} else if(ae.getSource() == b5) {
			setVisible(false);
			new PinChange(pin).setVisible(true);
		} else if(ae.getSource() == b6) {
			setVisible(false);
			new BalanceEnquiry(pin).setVisible(true);
		} else if(ae.getSource() == b7) {
			setVisible(false);
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Transactions("").setVisible(true);
	}
}