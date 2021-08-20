package atm_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class SignUp extends JFrame implements ActionListener{

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	JRadioButton rb1, rb2, rb3, rb4, rb5, rb6;
	JButton b;
	JDateChooser date;
	
	Random ran = new Random();
	long first4 = (ran.nextLong() % 9000L) + 1000L;
	String form_no = "" + Math.abs(first4);
	
	public SignUp() {
		
		setTitle("NEW ACCOUNT APPLICATION FORM");
		
		l1 = new JLabel("APPLICATION FORM NO. "+form_no);
		l1.setFont(new Font("Raleway", Font.BOLD, 38));
		l1.setBounds(100, 20, 600, 40);
		add(l1);
		
		l2 = new JLabel("Page 1: Personal Details");
		l2.setFont(new Font("Raleway", Font.BOLD, 22));
		l2.setBounds(250, 80, 600, 30);
		add(l2);
		
		l3 = new JLabel("Name:");
		l3.setFont(new Font("Raleway", Font.BOLD, 20));
		l3.setBounds(100, 150, 150, 30);
		add(l3);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Raleway", Font.BOLD, 14));
		tf1.setBounds(300, 150, 300, 30);
		add(tf1);
		
		l4 = new JLabel("Father's Name:");
		l4.setFont(new Font("Raleway", Font.BOLD, 20));
		l4.setBounds(100, 200, 150, 30);
		add(l4);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Raleway", Font.BOLD, 14));
		tf2.setBounds(300, 200, 300, 30);
		add(tf2);
		
		l5 = new JLabel("Date of Birth:");
		l5.setFont(new Font("Raleway", Font.BOLD, 20));
		l5.setBounds(100, 250, 150, 30);
		add(l5);
		
		date = new JDateChooser();
		date.setForeground(new Color(105, 105, 105));
		date.setBounds(300, 250, 300, 30);
		add(date);
		
		l6 = new JLabel("Gender:");
		l6.setFont(new Font("Raleway", Font.BOLD, 20));
		l6.setBounds(100, 300, 150, 30);
		add(l6);
		
		rb1 = new JRadioButton("Male");
		rb1.setFont(new Font("Raleway", Font.BOLD, 14));
		rb1.setBackground(Color.WHITE);
		rb1.setBounds(300, 300, 100, 30);
		add(rb1);
		
		rb2 = new JRadioButton("Female");
		rb2.setFont(new Font("Raleway", Font.BOLD, 14));
		rb2.setBackground(Color.WHITE);
		rb2.setBounds(400, 300, 100, 30);
		add(rb2);
		
		rb3 = new JRadioButton("Other");
		rb3.setFont(new Font("Raleway", Font.BOLD, 14));
		rb3.setBackground(Color.WHITE);
		rb3.setBounds(500, 300, 100, 30);
		add(rb3);
		
		l7 = new JLabel("Email Address:");
		l7.setFont(new Font("Raleway", Font.BOLD, 20));
		l7.setBounds(100, 350, 150, 30);
		add(l7);
		
		tf3 = new JTextField();
		tf3.setFont(new Font("Raleway", Font.BOLD, 14));
		tf3.setBounds(300, 350, 300, 30);
		add(tf3);
		
		l8 = new JLabel("Marital Status:");
		l8.setFont(new Font("Raleway", Font.BOLD, 20));
		l8.setBounds(100, 400, 150, 30);
		add(l8);
		
		rb4 = new JRadioButton("Married");
		rb4.setFont(new Font("Ralway", Font.BOLD, 14));
		rb4.setBackground(Color.WHITE);
		rb4.setBounds(300, 400, 100, 30);
		add(rb4);
		
		rb5 = new JRadioButton("Unmarried");
		rb5.setFont(new Font("Ralway", Font.BOLD, 14));
		rb5.setBackground(Color.WHITE);
		rb5.setBounds(400, 400, 100, 30);
		add(rb5);
		
		rb6 = new JRadioButton("Other");
		rb6.setFont(new Font("Ralway", Font.BOLD, 14));
		rb6.setBackground(Color.WHITE);
		rb6.setBounds(500, 400, 100, 30);
		add(rb6);
		
		l9 = new JLabel("Address:");
		l9.setFont(new Font("Raleway", Font.BOLD, 20));
		l9.setBounds(100, 450, 150, 30);
		add(l9);
		
		tf4 = new JTextField();
		tf4.setFont(new Font("Raleway", Font.BOLD, 14));
		tf4.setBounds(300, 450, 300, 30);
		add(tf4);
		
		l10 = new JLabel("City:");
		l10.setFont(new Font("Raleway", Font.BOLD, 20));
		l10.setBounds(100, 500, 150, 30);
		add(l10);
		
		tf5 = new JTextField();
		tf5.setFont(new Font("Raleway", Font.BOLD, 14));		
		tf5.setBounds(300, 500, 300, 30);
		add(tf5);
				
		l11 = new JLabel("Pin Code:");
		l11.setFont(new Font("Raleway", Font.BOLD, 20));
		l11.setBounds(100, 550, 150, 30);
		add(l11);
		
		tf6 = new JTextField();
		tf6.setFont(new Font("Raleway", Font.BOLD, 14));
		tf6.setBounds(300, 550, 300, 30);
		add(tf6);
		
		l12 = new JLabel("State:");
		l12.setFont(new Font("Raleway", Font.BOLD, 20));
		l12.setBounds(100, 600, 150, 30);
		add(l12);
		
		tf7 = new JTextField();
		tf7.setFont(new Font("Raleway", Font.BOLD, 14));
		tf7.setBounds(300, 600, 300, 30);
		add(tf7);
		
		b = new JButton("NEXT");
		b.setFont(new Font("Raleway", Font.BOLD, 14));
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		b.setBounds(300, 650, 300, 40);
		add(b);
		
		ButtonGroup gender = new ButtonGroup();
		gender.add(rb1);
		gender.add(rb2);
		gender.add(rb3);
		
		ButtonGroup status = new ButtonGroup();
		status.add(rb4);
		status.add(rb5);
		status.add(rb6);
		
		b.addActionListener(this);
		
		setLayout(null);
		setSize(750, 750);
		setLocation(0, 0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String full_name = tf1.getText();
		String father_name = tf2.getText();
		String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
		String gender = null;
		
		if (rb1.isSelected()) {
			gender = "Male";
		} else if (rb2.isSelected()) {
			gender = "Female";
		} else if (rb3.isSelected()) {
			gender = "Other";
		}
		
		String email = tf3.getText();
		String status = null;
		if (rb4.isSelected()) {
			status = "Married";
		} else if (rb5.isSelected()) {
			status = "Unmarried";
		} else if (rb6.isSelected()) {
			status = "Other";
		}
		
		String address = tf4.getText();
		String city = tf5.getText();
		String pincode = tf6.getText();
		String state = tf7.getText();
		
		try {
			if (tf6.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Fill all the required fields");
			} else {
				Conn cn = new Conn();
				String querry = "insert into signup values('"+form_no+"','"+full_name+"','"+father_name+"','"+dob+"','"+gender+"','"+email+"','"+status+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
				cn.st.executeUpdate(querry);
				
				new SignUp2(form_no).setVisible(true);
				setVisible(false);
			}
		} catch (Exception e1) {
			// TODO: handle exception
			System.out.println(e1);;
		}
	}
	
	public static void main(String[] args) {
		new SignUp().setVisible(true);
	}
}
