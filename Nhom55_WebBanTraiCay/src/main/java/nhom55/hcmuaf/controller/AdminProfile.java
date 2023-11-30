package nhom55.hcmuaf.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminProfile", value = "/adminProfile")
public class AdminProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext ().getRequestDispatcher ("/WEB-INF/admin/admin-profile.jsp");
        dispatcher.forward (request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}