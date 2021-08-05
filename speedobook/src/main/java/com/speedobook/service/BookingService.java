package com.speedobook.service;

import java.util.List;


import com.speedobook.bean.DoctorBean;
import com.speedobook.bean.LoginBean;
import com.speedobook.bean.RegisterBean;

public interface BookingService {
	boolean addUser(RegisterBean user);
	RegisterBean authenticate(LoginBean login);
	DoctorBean getDoctor(int code);
	List<DoctorBean> getDoctors();
	void updateLimit(int code);

}
