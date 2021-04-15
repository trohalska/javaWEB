package ua.training;

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

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String path = request.getRequestURI();
        response.getWriter().print("Hello from servlet " + path +" ");
        path = path.replaceAll(".*/app" , "");
        response.getWriter().print("Hello from servlet " + path);
    }
}