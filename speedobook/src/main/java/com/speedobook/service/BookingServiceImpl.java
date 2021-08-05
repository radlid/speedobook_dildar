package com.speedobook.service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.speedobook.bean.DoctorBean;
import com.speedobook.bean.LoginBean;
import com.speedobook.bean.RegisterBean;
import com.speedobook.dao.BookDoctorDao;
import com.speedobook.dao.BookDoctorDaoImpl;
import com.speedobook.util.SpeedoEncoder;

public class BookingServiceImpl implements BookingService {
private BookDoctorDao dao;
	
	public BookingServiceImpl() {
		dao = new BookDoctorDaoImpl();
	}
	@Override
	public boolean addUser(RegisterBean user) {
		user.setPassword(SpeedoEncoder.encode(user.getPassword()));
		try {
			return dao.persist(user);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public RegisterBean authenticate(LoginBean login) {
		login.setPassword(SpeedoEncoder.encode(login.getPassword()));
		try {
			return dao.validate(login);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public DoctorBean getDoctor(int code) {
		try {
			return dao.fetchDoctor(code);
		} catch ( SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<DoctorBean> getDoctors() {
		try {
			System.out.println("before dao.fetch");
			return dao.fetchDoctors();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public void updateLimit(int code) {
	
		try {
			dao.updateLimit(code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	

}
