package com.speedobook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.speedobook.util.JdbcFactory;
import com.speedobook.bean.DoctorBean;
import com.speedobook.bean.LoginBean;
import com.speedobook.bean.RegisterBean;

public class BookDoctorDaoImpl implements BookDoctorDao {

	@Override
	public RegisterBean validate(LoginBean login) throws SQLException {
		String sql = "select * from patient where email=? and password=?";
		Connection conn = null;
		RegisterBean user = null;
		try {
			conn = JdbcFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, login.getEmail());
			stmt.setString(2, login.getPassword());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new RegisterBean();
				user.setEmail(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setGender(rs.getString(5));
				user.setCity(rs.getString(6));
				user.setMobile(rs.getString(7));
			}
			return user;
		} finally {
			conn.close();
		}
	}

	@Override
	public boolean persist(RegisterBean user) throws SQLException {
		String sql = "insert into patient values (?,?,?,?,?,?,?)";
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setInt(4, user.getAge());
			stmt.setString(5, user.getGender());
			stmt.setString(6, user.getCity());
			stmt.setString(7, user.getMobile());
			stmt.executeUpdate();
			return true;
		} finally {
			conn.close();
		} 
	}

	@Override
	public DoctorBean fetchDoctor(int code) throws SQLException {
		String sql="select * from doctors where code="+code;
		Connection conn=null;
		DoctorBean doctor=null;
		try {
			conn=JdbcFactory.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				doctor = new DoctorBean();
				doctor.setCode(rs.getInt(1));
				doctor.setName(rs.getString(2));
				doctor.setDepartment(rs.getString(3));
				doctor.setCharge(rs.getDouble(4));
				doctor.setLimit(rs.getInt(5));
				doctor.setImage(rs.getString(5));
			}
			return doctor;
		} 
		finally {
			conn.close();
			
		}
	
	}
	@Override
	public List<DoctorBean> fetchDoctors() throws SQLException {
		String sql = "select * from doctors";
		Connection conn = null;
		List<DoctorBean> doctorlist = new ArrayList<DoctorBean>();
		
		try {
			conn = JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				DoctorBean doctor = new DoctorBean();
				doctor.setCode(rs.getInt(1));
				System.out.println("hello");
				doctor.setName(rs.getString(2));
				doctor.setDepartment(rs.getString(3));
				doctor.setCharge(rs.getDouble(4));
				doctor.setLimit(rs.getInt(5));
				doctor.setImage(rs.getString(6));
				doctorlist.add(doctor);
			}
			return doctorlist;
		} finally {
			conn.close();
		}
	}

	@Override
	public void updateLimit(int code) throws SQLException {
		String sql = "update doctors set limit=limit-1 where code="+ code;
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			conn.createStatement().executeUpdate(sql);
		} finally {
			conn.close();
		}
		
	}
	
	

}
