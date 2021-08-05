package com.speedobook.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.speedobook.bean.DoctorBean;
import com.speedobook.service.BookingService;
import com.speedobook.service.BookingServiceImpl;


/**
 * Servlet implementation class AppointmentController
 */
@WebServlet(name = "Appointment", urlPatterns = { "/Appointment" })
public class AppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
private BookingService service;
	
	@Override
	public void init() throws ServletException {
		service = new BookingServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String code = request.getParameter("code");
		
		if(code != null) {
			// Request is received for adding product to cart
			HttpSession session = request.getSession();

			response.sendRedirect("payment.jsp");
		service.updateLimit(Integer.parseInt(code));

			
			
		} else {
			// Request is for populating doctors catalogue
			List<DoctorBean> doctors = service.getDoctors();
			System.out.println("doctors Fetched: " + doctors.size());
			
			// Adding doctor list to request scope
			request.setAttribute("DOCTORS", doctors);
	
			// Forward to doctors page along with doctor list in request scope
			getServletContext().getRequestDispatcher("/doctors.jsp").forward(request, response);
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
