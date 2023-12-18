package nhom55.hcmuaf.controller.user;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.dao.UsersDaoImpl;
import nhom55.hcmuaf.services.UserService;
import nhom55.hcmuaf.util.MyUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updatePasswordUser", value = "/updatePasswordUser")
public class UpdatePasswordUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Users users = UserService.getInstance().showInfoUser(id);
        request.setAttribute("showUser", users);
        RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/WEB-INF/user/update-user-password.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParameter = request.getParameter("id");

        if (idParameter != null && !idParameter.isEmpty()) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                String password = request.getParameter("password");
                String newPassword = request.getParameter("newPassword");

                Users user = UserService.getInstance().checkUser(id, password);
//                Users users = UserService.getInstance().showInfoUser(id);

                if (user == null) {
                    // không tồn tại
                    String ms = "Old password is incorrect";
                    request.setAttribute("ms", ms);
                    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/user/update-user-password.jsp");
                    dispatcher.forward(request, response);
                } else {
                    // đúng old pass
                    String updateUser = UserService.getInstance().updatePass(id, newPassword);
                    MyUtils.encodePass(newPassword);

                    request.setAttribute("showUser", updateUser);
                    RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/user/update-user-password.jsp");
                    dispatcher.forward(request, response);

                }
            } catch (Exception  e) {
                e.printStackTrace();;
            }
        }
    }
}
