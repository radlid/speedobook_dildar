package com.speedobook.dao;

import java.sql.SQLException;

import com.speedobook.bean.DoctorBean;



public interface AdminDao {
	boolean saveDoctor(DoctorBean doctor) throws SQLException;
	boolean updateLimit(int code, int limit) throws SQLException;
	
}
