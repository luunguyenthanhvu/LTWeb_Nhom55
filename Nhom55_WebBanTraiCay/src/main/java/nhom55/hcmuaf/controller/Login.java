package nhom55.hcmuaf.controller;

import nhom55.hcmuaf.beans.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext ().getRequestDispatcher ("/WEB-INF/login/login.jsp");
        dispatcher.forward (request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");



        List<Users> listUsers = new ArrayList<>();
        Users user1 = new Users("minhtuan123@gmail.com" , "12345", 1);
        Users user2 = new Users("minhtu123@gmail.com" , "12345", 1);
        Users user3 = new Users();

        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);
        for (Users  u : listUsers) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                request.setAttribute("user", email);
                RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
                dispatcher.forward(request, response);
            }
        }
        request.setAttribute("user", email);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/login/login.jsp");
        dispatcher.forward(request, response);
    }
}