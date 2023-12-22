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

        if (checkValidate(request,response,oldPassword,newPassword,retypePassword)) {
            // Kiểm tra mật khẩu cũ
            if (!UserService.getInstance().checkUser(user.getId(), MyUtils.encodePass(oldPassword))) {
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

        String checkOldPassword = UserValidator.validateOldPass(oldPassword);
        String checkNewPassword = UserValidator.validateNewPass(newPassword);
        String checkOldAndNewPass = UserValidator.validateOldAndNewPass(oldPassword, newPassword);
        String checkNewAndRetypePass = UserValidator.validateNewAndRetypePass(newPassword, retypePassword);

        // count for validate
        int count = 0;

        if (!checkOldPassword.isEmpty()) {
            count++;
            request.setAttribute("error_oldPassword", checkOldPassword);
        }

        if (!checkNewPassword.isEmpty()) {
            count++;
            request.setAttribute("error_newPassword", checkNewPassword);
        }

        if (!checkOldAndNewPass.isEmpty()) {
            count++;
            request.setAttribute("error_checkOldAndNewPass", checkOldAndNewPass);
        }

        if (!checkNewAndRetypePass.isEmpty()) {
            count++;
            request.setAttribute("error_checkNewAndRetypePass", checkNewAndRetypePass);
        }

        if (count > 0) {
            return false;
        }
        return true;
    }



}
