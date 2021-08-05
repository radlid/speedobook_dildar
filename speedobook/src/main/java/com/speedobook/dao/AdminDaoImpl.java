package com.speedobook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.speedobook.bean.DoctorBean;
import com.speedobook.util.JdbcFactory;

public class AdminDaoImpl implements AdminDao{

	@Override
	public boolean saveDoctor(DoctorBean doctor) throws SQLException {
		
		String sql = "insert into doctors values (?,?,?,?,?,?)";
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, doctor.getCode());
			stmt.setString(2, doctor.getName());
			stmt.setString(3, doctor.getDepartment());
			stmt.setDouble(4, doctor.getCharge());
			stmt.setInt(5, doctor.getLimit());
			stmt.setString(6,doctor.getImage());
			stmt.executeUpdate();
			return true;
		} finally {
			conn.close();
		}
	}

	@Override
	public boolean updateLimit(int code, int limit) throws SQLException {
		
		String sql = "update doctors set limit="+limit+" where code="+code;
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			conn.createStatement().executeUpdate(sql);
			return true;
		} finally {
			conn.close();
		}
	}


	
	}
	
	


