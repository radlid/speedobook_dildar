package com.speedobook.service;

import java.sql.SQLException;
import com.speedobook.bean.DoctorBean;
import com.speedobook.dao.AdminDao;
import com.speedobook.dao.AdminDaoImpl;

public class AdminServiceImpl implements AdminService {

	
	private AdminDao dao;
	
	public AdminServiceImpl() {
		dao = new AdminDaoImpl();
	}

	@Override
	public boolean addDoctor(DoctorBean doctor) {
		try {
			return dao.saveDoctor(doctor);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateLimit(int code, int limit) {
		
		try {
			return dao.updateLimit(code, limit);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	}
	
	
	
	


