package nhom55.hcmuaf.controller.user;

import nhom55.hcmuaf.beans.Users;
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
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/user/update-user-password.jsp");
        dispatcher.forward(request, response);    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParameter = request.getParameter("id");
        String oldPassword = request.getParameter("old-password");
        String newPassword = request.getParameter("new-password");
        String retypePassword = request.getParameter("retype-password");

        if (!newPassword.equals(retypePassword)) {
            request.setAttribute("result", "Mật khẩu mới và mật khẩu nhập lại không khớp");
            RequestDispatcher dispatcher = this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/user/update-user-password.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (idParameter != null && !idParameter.isEmpty()) {
            int id = Integer.parseInt(idParameter);

            // Kiểm tra mật khẩu cũ
            if (!UserService.getInstance().checkUser(id, MyUtils.encodePass(oldPassword))) {
                request.setAttribute("result", "Mật khẩu cũ không đúng");
                RequestDispatcher dispatcher = this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/user/update-user-password.jsp");
                dispatcher.forward(request, response);
                return;
            }

            String result = UserService.getInstance().changePass(id, newPassword);

            if (result.equals("SUCCESS")) {
                Users updatedUser = UserService.getInstance().showInfoUser(id);
                request.setAttribute("hashedNewPassword", updatedUser.getHash());

                request.setAttribute("result", "Đổi mật khẩu thành công");
                RequestDispatcher dispatcher = this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/login/login.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("result", "Có lỗi xảy ra khi đổi mật khẩu");
                RequestDispatcher dispatcher = this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/user/update-user-password.jsp");
                dispatcher.forward(request, response);
            }
        }

    }
}
