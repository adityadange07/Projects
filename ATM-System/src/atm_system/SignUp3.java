package atm_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SignUp3 extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
	JRadioButton rb1, rb2, rb3, rb4;
	JButton b1, b2;
	JCheckBox ch1, ch2, ch3, ch4, ch5, ch6, ch7;
	String form_no;
	
	SignUp3(String form_no) {
		this.form_no = form_no;
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
		
		l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Ralway", Font.BOLD, 22));
		l1.setBounds(200, 10, 400, 40);
		add(l1);
		
		l2 = new JLabel("Account Type:");
		l2.setFont(new Font("Ralway", Font.BOLD, 18));
		l2.setBounds(100, 50, 150, 30);
		add(l2);
		
		rb1 = new JRadioButton("Saving Account");
		rb1.setFont(new Font("Ralway", Font.BOLD, 16));
		rb1.setBounds(100, 100, 200, 30);
		add(rb1);
		
		rb2 = new JRadioButton("Fixed Deposit Account");
		rb2.setFont(new Font("Ralway", Font.BOLD, 16));
		rb2.setBounds(300, 100, 200, 30);
		add(rb2);
		
		rb3 = new JRadioButton("Current Account");
		rb3.setFont(new Font("Ralway", Font.BOLD, 16));
		rb3.setBounds(100, 150, 200, 30);
		add(rb3);
		
		rb4 = new JRadioButton("Recurring Deposite Account");
		rb4.setFont(new Font("Ralway", Font.BOLD, 16));
		rb4.setBounds(300, 150, 200, 30);
		add(rb4);
		
		l3 = new JLabel("Card Number:");
		l3.setFont(new Font("Ralway", Font.BOLD, 18));
		l3.setBounds(100, 200, 200, 30);
		add(l3);
		
		l4 = new JLabel("XXXX-XXXX-XXXX-XXXX-1234");
		l4.setFont(new Font("Ralway", Font.BOLD, 18));
		l4.setBounds(300, 200, 300, 30);
		add(l4);
		
		l5 = new JLabel("(Your 16-digit Card Number)");
		l5.setFont(new Font("Ralway", Font.BOLD, 12));
		l5.setBounds(100, 225, 200, 30);
		add(l5);
		
		l6 = new JLabel("It would appear on ATM Card");
		l6.setFont(new Font("Ralway", Font.BOLD, 12));
		l6.setBounds(300, 225, 300, 30);
		add(l6);
		
		l7 = new JLabel("PIN");
		l7.setFont(new Font("Ralway", Font.BOLD, 18));
		l7.setBounds(100, 275, 200, 30);
		add(l7);
		
		l8 = new JLabel("XXXX");
		l8.setFont(new Font("Ralway", Font.BOLD, 18));
		l8.setBounds(300, 275, 300, 30);
		add(l8);
		
		l9 = new JLabel("(4-digit Password)");
		l9.setFont(new Font("Ralway", Font.BOLD, 12));
		l9.setBounds(100, 300, 200, 30);
		add(l9);
		
		l10 = new JLabel("Service Required");
		l10.setFont(new Font("Ralway", Font.BOLD, 18));
		l10.setBounds(100, 350, 200, 30);
		add(l10);
		
		ch1 = new JCheckBox("ATM CARD");
		ch1.setFont(new Font("Ralway", Font.BOLD, 16));
		ch1.setBounds(100, 400, 200, 30);
		add(ch1);

		ch2 = new JCheckBox("Internet Banking");
		ch2.setFont(new Font("Ralway", Font.BOLD, 16));
		ch2.setBounds(300, 400, 200, 30);
		add(ch2);

		ch3 = new JCheckBox("Mobile Banking");
		ch3.setFont(new Font("Ralway", Font.BOLD, 16));
		ch3.setBounds(100, 450, 200, 30);
		add(ch3);

		ch4 = new JCheckBox("EMAIL Alerts");
		ch4.setFont(new Font("Ralway", Font.BOLD, 16));
		ch4.setBounds(300, 450, 200, 30);
		add(ch4);

		ch5 = new JCheckBox("CHEQUE Book");
		ch5.setFont(new Font("Ralway", Font.BOLD, 16));
		ch5.setBounds(100, 500, 200, 30);
		add(ch5);

		ch6 = new JCheckBox("E-Statement");
		ch6.setFont(new Font("Ralway", Font.BOLD, 16));
		ch6.setBounds(300, 500, 200, 30);
		add(ch6);

		ch7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.");
		ch7.setFont(new Font("Ralway", Font.BOLD, 12));
		ch7.setBounds(100, 550, 600, 30);
		add(ch7);
		
		l11 = new JLabel("Form No.:");
		l11.setFont(new Font("Ralway", Font.BOLD, 12));
		l11.setBounds(550, 10, 70, 30);
		add(l11);
		
		l12 = new JLabel(form_no);
		l12.setFont(new Font("Ralway", Font.BOLD, 12));
		l12.setBounds(620, 10, 70, 30);
		add(l12);
		
		b1 = new JButton("Submit");
		b1.setFont(new Font("Ralway", Font.BOLD, 18));
		b1.setBounds(200, 600, 140, 30);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setFont(new Font("Ralway", Font.BOLD, 18));
		b2.setBounds(360, 600, 140, 30);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setLayout(null);
		setSize(700, 700);
		setLocation(0, 0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String ac_type = null;
		if (rb1.isSelected()) {
			ac_type = "Saving Account";
		} else if (rb2.isSelected()) {
			ac_type = "Fixed Deposit Account";
		} else if (rb2.isSelected()) {
			ac_type = "Current Account";
		} else if (rb2.isSelected()) {
			ac_type = "Recurring Deposit Account";
		}
		
		Random ran = new Random();
		long first7 = (ran.nextLong() % 90000000L) + 100000000000L;
		String card_no = "" + Math.abs(first7);

		long first3 = (ran.nextLong() % 9000L) + 1000L;
		String pin = "" + Math.abs(first3);
		
		String facility = "";
		if (ch1.isSelected()) {
			facility = facility + "ATM Card";
		} else if (ch2.isSelected()) {
			facility = facility + "Internet Banking";
		} else if (ch3.isSelected()) {
			facility = facility + "Mobile Banking";
		} else if (ch4.isSelected()) {
			facility = facility + "EMAIL Alerts";
		} else if (ch5.isSelected()) {
			facility = facility + "Cheque Book";
		} else if (ch6.isSelected()) {
			facility = facility + "E-Statemnet";
		}
		
		try {
			if (ae.getSource() == b1) {
				if (ac_type.equals("")) {
					JOptionPane.showMessageDialog(null, "Fill all the required fields");
				} else {
					Conn cn = new Conn();
					String querry1 = "insert into signup3 values('"+form_no+"','"+ac_type+"','"+card_no+"','"+pin+"','"+facility+"')";
					String querry2 = "insert into login values('"+form_no+"','"+card_no+"','"+pin+"')";
					cn.st.executeUpdate(querry1);
					cn.st.executeUpdate(querry2);
					JOptionPane.showMessageDialog(null, "Card Number: " + card_no + "\n Pin: " + pin);
					
					new Deposit(pin).setVisible(true);
					setVisible(false);
				}
			} else if (ae.getSource() == b2) {
				System.exit(0);
			}
			
		} catch (Exception e3) {
			// TODO: handle exception
			System.out.println(e3);;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUp3("").setVisible(true);
	}
}
