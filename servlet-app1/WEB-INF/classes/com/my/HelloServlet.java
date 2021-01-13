package com.my;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet("/hello")
public class HelloServlet implements Servlet {

    public void init(ServletConfig config) {
		System.out.println("HelloServlet#init");
	}

    public void service(ServletRequest req, ServletResponse res)
			throws ServletException, java.io.IOException {
				
		System.out.println("HelloServlet#service");	
		
		String name = req.getParameter("name");
		
		res.getWriter()
			.append("<html><body>")
			.append("<h2>Hi, ")
			.append(name)
			.append("!</h2>")
			.append("<a href='index.html'>Back</a>")
			.append("</body></html>");
		
		
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

