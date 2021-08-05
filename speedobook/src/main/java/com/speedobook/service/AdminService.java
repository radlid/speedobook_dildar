package com.speedobook.service;

import com.speedobook.bean.DoctorBean;

public interface AdminService {
	boolean addDoctor(DoctorBean doctor);
	boolean updateLimit(int code, int limit);
	
}
