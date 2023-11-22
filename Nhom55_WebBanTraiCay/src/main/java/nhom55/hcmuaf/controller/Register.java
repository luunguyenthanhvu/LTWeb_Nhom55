package nhom55.hcmuaf.controller;

import nhom55.hcmuaf.beans.RegisterBean;
import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.services.RegisterService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "register", value = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext ().getRequestDispatcher ("/WEB-INF/login/register.jsp");
        dispatcher.forward (request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username =  request.getParameter ("username");
        String phoneNum = request.getParameter ("phoneNum");
        String address = request.getParameter ("address");
        String email = request.getParameter ("email");
        String password = request.getParameter ("password");

        String newPassword = DigestUtils.md5Hex (password);
        String makeHash;
        Random random = new Random ();
        random.nextInt (9999990);
        makeHash = DigestUtils.md5Hex ("" + random);

        RegisterBean register = new RegisterBean ();
        register.setUsername (username);
        register.setPhoneNumber (phoneNum);
        register.setAddress (address);
        register.setEmail (email);
        register.setPassword (newPassword);
        register.setHash (makeHash);

        RegisterService registerService = new RegisterService ();
        String str = registerService.RegisterUser (register);

        if (str.equals ("SUCCESS")) {
            RequestDispatcher dispatcher = this.getServletContext ().getRequestDispatcher ("/WEB-INF/login/verify.jsp");
            dispatcher.forward (request,response);
        } else if(str.equals ("had user")) {
            request.setAttribute ("errorRegister", "Tài khoản đã tồn tại");
            RequestDispatcher dispatcher = this.getServletContext ().getRequestDispatcher ("/WEB-INF/login/register.jsp");
            dispatcher.forward (request,response);
        }
    }
}