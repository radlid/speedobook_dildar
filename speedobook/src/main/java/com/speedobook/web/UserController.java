 package com.speedobook.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.speedobook.bean.LoginBean;
import com.speedobook.bean.RegisterBean;
import com.speedobook.service.BookingService;
import com.speedobook.service.BookingServiceImpl;

@WebServlet(name = "User", urlPatterns = { "/User.fm" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingService service;

	@Override
	public void init() throws ServletException {
		service = new BookingServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// Request is coming for logout
		if (request.getParameter("logout") != null) {
			session.invalidate(); // Deleting user session
			response.sendRedirect("home.jsp"); // Sending to home page
		} else {

			// To identify the request is coming for login or registration
			String referer = request.getHeader("referer");
			if (referer.contains("home")) {
				// Request is coming from home.jsp for login
				LoginBean login = new LoginBean();
				login.setEmail(request.getParameter("email"));
				login.setPassword(request.getParameter("password"));

				RegisterBean user = service.authenticate(login);
				if (user != null) {
					// Login successful
					session.setAttribute("USER", user);
					
					if(user.getEmail().equalsIgnoreCase("admin@speedobook.com"))
						response.sendRedirect("Admin");
					else
						response.sendRedirect("Appointment");
				} else {
					// Login failed
					response.sendRedirect("home.jsp?invalid=yes");
				}

			} else {
				// Request is coming from register.jsp
				RegisterBean user = new RegisterBean();
				user.setEmail(request.getParameter("email"));
				user.setPassword(request.getParameter("password"));
				user.setName(request.getParameter("name"));
				user.setAge(Integer.parseInt(request.getParameter("age")));
				user.setGender(request.getParameter("gender"));
				user.setCity(request.getParameter("city"));
				user.setMobile(request.getParameter("mobile"));

				if (service.addUser(user)) {
					// Registration successful
					response.sendRedirect("home.jsp");
				} else {
					// Registration failed
					response.sendRedirect("register.jsp");
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}