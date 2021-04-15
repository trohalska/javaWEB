package ua.training.controller;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet extends HttpServlet {

    public void init(){

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/page1.html")
               .forward(request,response);

    }
}