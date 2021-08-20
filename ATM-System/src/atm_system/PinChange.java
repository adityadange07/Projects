package atm_system;

import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {
	JLabel l1, l2, l3;
	JButton b1, b2;
	JPasswordField pf1, pf2;
	String pin;
	
	public PinChange(String pin) {
		// TODO Auto-generated constructor stub
		l1 = new JLabel("CHANGE YOUR PIN");
		l1.setFont(new Font("System", Font.BOLD, 16));
		l1.setBounds(170, 50, 300, 30);
		add(l1);
		
		l2 = new JLabel("New PIN:");
		l2.setFont(new Font("System", Font.BOLD, 16));
		l2.setBounds(100, 100, 200, 30);
		add(l2);
		
		pf1 = new JPasswordField();
		pf1.setFont(new Font("System", Font.BOLD, 16));
		pf1.setBounds(250, 100, 150, 30);
		add(pf1);
		
		l3 = new JLabel("Re-Enter New PIN:");
		l3.setFont(new Font("System", Font.BOLD, 16));
		l3.setBounds(100, 150, 200, 30);
		add(l3);
		
		pf2 = new JPasswordField();
		pf2.setFont(new Font("System", Font.BOLD, 16));
		pf2.setBounds(250, 150, 150, 30);
		add(pf2);
		
		b1 = new JButton("CHANGE");
		b1.setBounds(100, 200, 140, 30);
		add(b1);
		
		b2 = new JButton("BACK");
		b2.setBounds(260, 200, 140, 30);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setLayout(null);
		setSize(500, 300);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		try {
			String new_pin = new String(pf1.getPassword());
			String re_pin = new String(pf2.getPassword());
			
			if (!new_pin.equals(re_pin)) {
				JOptionPane.showMessageDialog(null, "Entered PIN does not match");
				return;
			}
			
			if (ae.getSource() == b1) {
				if (new_pin == "") {
					JOptionPane.showMessageDialog(null, "Enter New PIN");
				}
				if (re_pin == "") {
					JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
				}
				Conn cn = new Conn();
				String querry1 = "update bank set pin = '"+new_pin+"' where pin = '"+pin+"' ";
                String querry2 = "update login set pin = '"+new_pin+"' where pin = '"+pin+"' ";
                String querry3 = "update signup3 set pin = '"+new_pin+"' where pin = '"+pin+"' ";
                
                cn.st.executeUpdate(querry1);
                cn.st.executeUpdate(querry2);
                cn.st.executeUpdate(querry3);
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully.");
                setVisible(false);
                new Transactions(new_pin).setVisible(true);
                
			} else if (ae.getSource() == b2) {
				new Transactions(pin).setVisible(true);
				setVisible(false);
			}
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PinChange("").setVisible(true);
	}
}
