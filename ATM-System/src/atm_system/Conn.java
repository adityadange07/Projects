package atm_system;

import java.sql.*;

public class Conn {
	Connection cn = null;
	Statement st = null;
	public Conn() { 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","");
			st = cn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
