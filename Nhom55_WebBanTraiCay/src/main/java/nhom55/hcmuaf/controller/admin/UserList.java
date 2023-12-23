package nhom55.hcmuaf.controller.admin;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserList", value = "/userList")
public class UserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("loginedUser");

        Users users = UserService.getInstance().getUserById(user.getId());
        request.setAttribute("showUser", users);
        RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/WEB-INF/admin/user-list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}