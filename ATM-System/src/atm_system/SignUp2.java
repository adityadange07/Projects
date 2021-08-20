package atm_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SignUp2 extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
	JButton b;
	JTextField tf1, tf2;
	JRadioButton rb1, rb2, rb3, rb4;
	JComboBox cb1, cb2, cb3, cb4, cb5;
	String form_no;
	
	public SignUp2(String form_no) {
				
		this.form_no = form_no;
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		l1 = new JLabel("Page 2: Account Details");
		l1.setFont(new Font("Ralway", Font.BOLD, 22));
		l1.setBounds(200, 30, 300, 40);
		add(l1);
		
		l2 = new JLabel("Religion:");
		l2.setFont(new Font("Ralway", Font.BOLD, 18));
		l2.setBounds(100, 100, 100, 30);
		add(l2);
		
		String religion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
		cb1 = new JComboBox(religion);
		cb1.setBackground(Color.WHITE);
		cb1.setFont(new Font("Ralway", Font.BOLD, 14));
		cb1.setBounds(300, 100, 220, 30);
		add(cb1);
		
		l3 = new JLabel("Category");
		l3.setFont(new Font("Ralway", Font.BOLD, 18));
		l3.setBounds(100, 150, 100, 30);
		add(l3);
		
		String category[] = {"Genral", "OBC", "SC", "ST", "Other"};
		cb2 = new JComboBox(category);
		cb2.setBackground(Color.WHITE);
		cb2.setFont(new Font("Ralway", Font.BOLD, 14));
		cb2.setBounds(300, 150, 220, 30);
		add(cb2);
		
		l4 = new JLabel("Income:");
		l4.setFont(new Font("Ralway", Font.BOLD, 18));
		l4.setBounds(100, 200, 100, 30);
		add(l4);
		
		String income[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
		cb3 = new JComboBox(income);
		cb3.setBackground(Color.WHITE);
		cb3.setFont(new Font("Ralway", Font.BOLD, 14));
		cb3.setBounds(300, 200, 220, 30);
		add(cb3);
		
		l5 = new JLabel("Educational");
		l5.setFont(new Font("Ralway", Font.BOLD, 18));
		l5.setBounds(100, 240, 150, 30);
		add(l5);
		
		l6 = new JLabel("Qualification:");
		l6.setFont(new Font("Ralway", Font.BOLD, 18));
		l6.setBounds(100, 260, 150, 30);
		add(l6);
		
		String education[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other"};
		cb4 = new JComboBox(education);
		cb4.setBackground(Color.WHITE);
		cb4.setFont(new Font("Ralway", Font.BOLD, 14));
		cb4.setBounds(300, 250, 220, 30);
		add(cb4);
		
		l7 = new JLabel("Occupation:");
		l7.setFont(new Font("Ralway", Font.BOLD, 18));
		l7.setBounds(100, 300, 150, 30);
		add(l7);
		
		String occupation[] = {"Salaried", "Self_Employed", "Business", "Student", "Retired", "Other"};
		cb5 = new JComboBox(occupation);
		cb5.setBackground(Color.WHITE);
		cb5.setFont(new Font("Ralway", Font.BOLD, 14));
		cb5.setBounds(300, 300, 220, 30);
		add(cb5);
		
		l8 = new JLabel("PAN Number:");
		l8.setFont(new Font("Ralway", Font.BOLD, 18));
		l8.setBounds(100, 350, 150, 30);
		add(l8);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Ralway", Font.BOLD, 14));
		tf1.setBounds(300, 350, 220, 30);
		add(tf1);
		
		l9 = new JLabel("Aadhar Number:");
		l9.setFont(new Font("Ralway", Font.BOLD, 18));
		l9.setBounds(100, 400, 150, 30);
		add(l9);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Ralway", Font.BOLD, 14));
		tf2.setBounds(300, 400, 220, 30);
		add(tf2);
		
		l10 = new JLabel("Senior Citizen:");
		l10.setFont(new Font("Ralway", Font.BOLD, 18));
		l10.setBounds(100, 450, 150, 30);
		add(l10);
		
		rb1 = new JRadioButton("Yes");
		rb1.setFont(new Font("Ralway", Font.BOLD, 14));
		rb1.setBackground(Color.WHITE);
		rb1.setBounds(300, 450, 100, 30);
		add(rb1);
		
		rb2 = new JRadioButton("No");
		rb2.setFont(new Font("Ralway", Font.BOLD, 14));
		rb2.setBackground(Color.WHITE);
		rb2.setBounds(420, 450, 100, 30);
		add(rb2);
		
		l11 = new JLabel("Existing Account:");
		l11.setFont(new Font("Ralway", Font.BOLD, 18));
		l11.setBounds(100, 500, 200, 30);
		add(l11);
		
		rb3 = new JRadioButton("Yes");
		rb3.setFont(new Font("Ralway", Font.BOLD, 14));
		rb3.setBackground(Color.WHITE);
		rb3.setBounds(300, 500, 100, 30);
		add(rb3);
		
		rb4 = new JRadioButton("No");
		rb4.setFont(new Font("Ralway", Font.BOLD, 14));
		rb4.setBackground(Color.WHITE);
		rb4.setBounds(420, 500, 100, 30);
		add(rb4);
		
		l12 = new JLabel("Form No.:");
		l12.setFont(new Font("Ralway", Font.BOLD, 13));
		l12.setBounds(500, 10, 70, 30);
		add(l12);
		
		l13 = new JLabel(form_no);
		l13.setFont(new Font("Ralway", Font.BOLD, 13));
		l13.setBounds(570, 10, 70, 30);
		add(l13);
		
		b = new JButton("NEXT");
		b.setFont(new Font("Ralway", Font.BOLD, 14));
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		b.setBounds(300, 550, 220, 30);
		add(b);
		
		b.addActionListener(this);
		
		setLayout(null);
		setSize(650, 650);
		setLocation(0, 0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String religion = (String) cb1.getSelectedItem(); 
		String category = (String) cb2.getSelectedItem(); 
		String income = (String) cb3.getSelectedItem(); 
		String education = (String) cb4.getSelectedItem(); 
		String occupation = (String) cb5.getSelectedItem(); 
		
		String pan = tf1.getText();
		String aadhar = tf2.getText();
		
		String sr_citizen = "";
		if (rb1.isSelected()) {
			sr_citizen = "Yes";
		} else if (rb2.isSelected()) {
			sr_citizen = "No";
		}
		
		String exit_accnt = "";
		if (rb3.isSelected()) {
			exit_accnt = "Yes";		
		} else if (rb4.isSelected()) {
			exit_accnt = "No";
		}
		
		try {
			if(tf2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Fill all the required fields");
			} else {
				Conn cn = new Conn();
				String querry = "insert into signup2 values('"+form_no+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+sr_citizen+"','"+exit_accnt+"')";
				cn.st.executeUpdate(querry);
				
				new SignUp3(form_no).setVisible(true);
			}
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2);
		}
	}
	public static void main(String[] args) {
		new SignUp2("").setVisible(true);
	}
}
