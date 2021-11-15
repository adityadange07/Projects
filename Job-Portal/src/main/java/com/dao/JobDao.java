package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Jobs;

public class JobDao {

	private Connection conn;

	public JobDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addJobs(Jobs jobs) {

		boolean f = false;
		try {
			String sql = "insert into jobs(title,description, category, status, location) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, jobs.getTitle());
			ps.setString(2, jobs.getDescription());
			ps.setString(3, jobs.getCategory());
			ps.setString(4, jobs.getStatus());
			ps.setString(5, jobs.getLocation());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Jobs> getAllJobs() {
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs jobs = null;

		try {
			String sql = "select * from jobs order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				jobs = new Jobs();
				jobs.setId(rs.getInt(1));
				jobs.setTitle(rs.getString(2));
				jobs.setDescription(rs.getString(3));
				jobs.setCategory(rs.getString(4));
				jobs.setStatus(rs.getString(5));
				jobs.setLocation(rs.getString(6));
				jobs.setPubdate(rs.getTimestamp(7) + "");
				list.add(jobs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Jobs> getAllJobsForUser() {
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs jobs = null;

		try {
			String sql = "select * from jobs where status=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				jobs = new Jobs();
				jobs.setId(rs.getInt(1));
				jobs.setTitle(rs.getString(2));
				jobs.setDescription(rs.getString(3));
				jobs.setCategory(rs.getString(4));
				jobs.setStatus(rs.getString(5));
				jobs.setLocation(rs.getString(6));
				jobs.setPubdate(rs.getTimestamp(7) + "");
				list.add(jobs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Jobs getJobById(int id) {

		Jobs jobs = null;

		try {
			String sql = "select * from jobs where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				jobs = new Jobs();
				jobs.setId(rs.getInt(1));
				jobs.setTitle(rs.getString(2));
				jobs.setDescription(rs.getString(3));
				jobs.setCategory(rs.getString(4));
				jobs.setStatus(rs.getString(5));
				jobs.setLocation(rs.getString(6));
				jobs.setPubdate(rs.getTimestamp(7) + "");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jobs;
	}

	public boolean updateJobs(Jobs jobs) {

		boolean f = false;
		try {
			String sql = "update jobs set title=?, description=?, category=?, status=?, location=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, jobs.getTitle());
			ps.setString(2, jobs.getDescription());
			ps.setString(3, jobs.getCategory());
			ps.setString(4, jobs.getStatus());
			ps.setString(5, jobs.getLocation());
			ps.setInt(6, jobs.getId());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Jobs> getJobsByLocationOrCategory(String category, String location) {
		
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs jobs = null;
		try {
			String sql = "select * from jobs where category=? or location=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category);
			ps.setString(2, location);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				jobs = new Jobs();
				jobs.setId(rs.getInt(1));
				jobs.setTitle(rs.getString(2));
				jobs.setDescription(rs.getString(3));
				jobs.setCategory(rs.getString(4));
				jobs.setStatus(rs.getString(5));
				jobs.setLocation(rs.getString(6));
				jobs.setPubdate(rs.getString(7));
				list.add(jobs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
public List<Jobs> getJobsByLocationAndCategory(String category, String location) {
		
		List<Jobs> list = new ArrayList<Jobs>();
		Jobs jobs = null;
		try {
			String sql = "select * from jobs where category=? and location=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category);
			ps.setString(2, location);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				jobs = new Jobs();
				jobs.setId(rs.getInt(1));
				jobs.setTitle(rs.getString(2));
				jobs.setDescription(rs.getString(3));
				jobs.setCategory(rs.getString(4));
				jobs.setStatus(rs.getString(5));
				jobs.setLocation(rs.getString(6));
				jobs.setPubdate(rs.getString(7));
				list.add(jobs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteJobs(int id) {

		boolean f = false;
		try {
			String sql = "delete from jobs where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

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
