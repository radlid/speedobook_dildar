package com.speedobook.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.speedobook.bean.DoctorBean;
import com.speedobook.service.AdminService;
import com.speedobook.service.AdminServiceImpl;
import com.speedobook.service.BookingService;
import com.speedobook.service.BookingServiceImpl;



/**
 * Servlet implementation class AdminController
 */
@WebServlet(name = "Admin", urlPatterns = { "/Admin" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService;
	private BookingService bookService;
	@Override
	public void init() {
		adminService = new AdminServiceImpl();
		bookService = new BookingServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String referer = request.getHeader("referer");
		if(referer.contains("doctor")) {
			DoctorBean doctor = new DoctorBean();
			doctor.setCode(Integer.parseInt(request.getParameter("code")));
			doctor.setName(request.getParameter("name"));
			doctor.setDepartment(request.getParameter("department"));
			doctor.setCharge(Double.parseDouble(request.getParameter("charge")));
			doctor.setLimit(Integer.parseInt(request.getParameter("limit")));
			doctor.setImage(request.getParameter("image"));
			
			if(!adminService.addDoctor(doctor)) 
				response.sendRedirect("adddoctor.jsp?failed=yes");
			
		}
			if(request.getParameter("limit") != null) {
			int code = Integer.parseInt(request.getParameter("code"));
			int stock = Integer.parseInt(request.getParameter("limit"));
			adminService.updateLimit(code, stock);
			}
			
		
		
		List<DoctorBean> doctors = bookService.getDoctors();
		request.setAttribute("DOCTORS",doctors);
		getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
