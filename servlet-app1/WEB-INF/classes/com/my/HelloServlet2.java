package com.my;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet("/hello2")
public class HelloServlet2 implements Servlet {

    public void init(ServletConfig config) {
		System.out.println("HelloServlet#init");
	}

	// JSP Model 2
    public void service(ServletRequest req, ServletResponse res)
			throws ServletException, java.io.IOException {
				
		System.out.println("HelloServlet#service");	
		
		// (1) obtain an input info!
		String name = req.getParameter("name");
		
		// (2) generate a result
		String greeting = "Hi, " + name;
		
		// (3) save a result as an attribute in a appropriate container
		req.setAttribute("res", greeting);

		// (4) forwared to view layer (MVC)
		req.getRequestDispatcher("result.jsp").forward(req, res);
	}
			
	public void destroy() {
		System.out.println("HelloServlet#destroy");
	}


	/////////////////////
	
    public String getServletInfo() {
		return "";
	}
	
	public ServletConfig getServletConfig() {
		return null;
	}
	
	
}

