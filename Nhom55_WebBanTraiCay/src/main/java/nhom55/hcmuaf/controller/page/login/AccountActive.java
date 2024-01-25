package nhom55.hcmuaf.controller.page.login;

import nhom55.hcmuaf.services.AdminService;
import nhom55.hcmuaf.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccountActive", value = "/account-active")
public class AccountActive extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter ("key1");
        String hash = request.getParameter ("key2");

       if ( AdminService.getInstance().updateUserStatus (email,hash) != null) {
           RequestDispatcher dispatcher = this.getServletContext ().getRequestDispatcher ("/WEB-INF/login/login.jsp");
           dispatcher.forward (request,response);
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}