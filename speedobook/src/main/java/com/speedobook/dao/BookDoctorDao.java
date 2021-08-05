package com.speedobook.dao;

import java.sql.SQLException;
import java.util.List;

import com.speedobook.bean.DoctorBean;
import com.speedobook.bean.LoginBean;
import com.speedobook.bean.RegisterBean;

public interface BookDoctorDao {
	RegisterBean validate(LoginBean login) throws SQLException;
	boolean persist(RegisterBean user) throws SQLException;
	DoctorBean fetchDoctor(int code) throws SQLException;
	List<DoctorBean> fetchDoctors() throws SQLException;
	void updateLimit(int code) throws SQLException;

}
