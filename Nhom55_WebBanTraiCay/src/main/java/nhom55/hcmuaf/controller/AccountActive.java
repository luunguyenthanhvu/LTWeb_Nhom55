package nhom55.hcmuaf.controller;

import nhom55.hcmuaf.services.AdminService;
import nhom55.hcmuaf.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccountActive", value = "/AccountActive")
public class AccountActive extends HttpServlet {
    AdminService adminService = new AdminService ();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter ("key1");
        String hash = request.getParameter ("key2");

       if ( adminService.updateUserStatus (email,hash) != null) {
           RequestDispatcher dispatcher = this.getServletContext ().getRequestDispatcher ("/WEB-INF/login/login.jsp");
           dispatcher.forward (request,response);
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}