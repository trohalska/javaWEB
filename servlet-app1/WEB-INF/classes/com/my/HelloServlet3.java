package com.my;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet("/hello3")
public class HelloServlet3 implements Servlet {

    public void init(ServletConfig config) {}

    public void service(ServletRequest req, ServletResponse res)
			throws ServletException, java.io.IOException {
				
		System.out.println("HelloServlet3#service");	
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
	}
			
	public void destroy() {}


	/////////////////////
	
    public String getServletInfo() {
		return "";
	}
	
	public ServletConfig getServletConfig() {
		return null;
	}
	
	
}

