package nhom55.hcmuaf.controller.admin;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.services.UserService;
import nhom55.hcmuaf.util.MyUtils;
import nhom55.hcmuaf.util.UserValidator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdatePasswordAdmin", value = "/updatePasswordAdmin")
public class UpdatePasswordAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("loginedUser");

        Users users = UserService.getInstance().getUserById(user.getId());
        request.setAttribute("user", users);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/admin/update-admin-password.jsp");
        dispatcher.forward(request, response);    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("loginedUser");

        String oldPassword = request.getParameter("old-password");
        String newPassword = request.getParameter("new-password");
        String retypePassword = request.getParameter("retype-password");

        if (!newPassword.equals(retypePassword)) {
            request.setAttribute("result", "Mật khẩu mới và mật khẩu nhập lại không khớp");
            RequestDispatcher dispatcher = this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/admin/update-admin-password.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (checkValidate(request,response,oldPassword,newPassword,retypePassword)) {
            // Kiểm tra mật khẩu cũ
            if (!UserService.getInstance().checkUser(user.getId(), MyUtils.encodePass(oldPassword))) {
                request.setAttribute("result", "Mật khẩu cũ không đúng");
                RequestDispatcher dispatcher = this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/admin/update-admin-password.jsp");
                dispatcher.forward(request, response);
                return;
            }

            // Đổi mật khẩu
            String result = UserService.getInstance().changePass(user.getId(), newPassword);

            if (result.equals("SUCCESS")) {
                Users updatedUser = UserService.getInstance().getUserById(user.getId());
                // Mật khẩu mới bị mã hóa
                request.setAttribute("hashedNewPassword", updatedUser.getHash());
                request.setAttribute("result", "Đổi mật khẩu thành công");
                RequestDispatcher dispatcher = this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/login/login.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("result", "Có lỗi xảy ra khi đổi mật khẩu");
                RequestDispatcher dispatcher = this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/admin/update-admin-password.jsp");
                dispatcher.forward(request, response);
            }

        }

    }

    /**
     * check validate for form input
     *
     * @param oldPassword
     * @param newPassword
     * @param retypePassword
     * @return
     */

    private static boolean checkValidate(HttpServletRequest request, HttpServletResponse response,
                                         String oldPassword, String newPassword, String retypePassword) {

        String checkPassword = UserValidator.validatePassword(oldPassword,newPassword,retypePassword);

        String checkOldPassword = UserValidator.validatePass(newPassword);
        String checkNewPassword = UserValidator.validatePass(newPassword);
        String checkRetypePassword = UserValidator.validatePass(retypePassword);

        // count for validate
        int count = 0;

        if (!checkPassword.isEmpty()) {
            count++;
            request.setAttribute("error_password", checkPassword);
        }

        if (!checkOldPassword.isEmpty()) {
            count++;
            request.setAttribute("error_oldPassword", checkOldPassword);
        } else {
            request.setAttribute("oldPassword", oldPassword);
        }

        if (!checkNewPassword.isEmpty()) {
            count++;
            request.setAttribute("error_newPassword", checkNewPassword);
        } else {
            request.setAttribute("newPassword", newPassword);
        }

        if (!checkRetypePassword.isEmpty()) {
            count++;
            request.setAttribute("error_retypePassword", checkRetypePassword);
        } else {
            request.setAttribute("retypePassword", retypePassword);
        }
        if (count > 0) {
            return false;
        }
        return true;
    }



}
