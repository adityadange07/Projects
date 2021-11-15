package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDao {

	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addUser(User user) {
		boolean f = false;
		try {
			String sql = "insert into user(name, email, password, qualification, role) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getQualification());
			ps.setString(5, "user");

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}
	
	public User login(String email, String password) {
		User user = null;
		try {
			String sql = "select * from user where email=? and password+?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setQualification(rs.getString(5));
				user.setRole(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean updateUser(User user) {
		
		boolean f = false;
		
		try {
			String sql = "update user set name=?, email=?, password=?, qualification=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getQualification());
			ps.setInt(5, user.getId());
			
			int i = ps.executeUpdate();
			
			if (i == 1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
