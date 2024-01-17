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
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/admin/update-admin-password.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users admin = MyUtils.getLoginedUser(session);

        String oldPassword = request.getParameter("old-password");
        String newPassword = request.getParameter("new-password");
        String retypePassword = request.getParameter("retype-password");

        if (checkValidate(request, response, oldPassword, newPassword, retypePassword)) {
            // Kiểm tra mật khẩu cũ
            if (UserService.getInstance().checkPassUser(admin.getId(), MyUtils.encodePass(oldPassword))) {
                String result = UserService.getInstance().changePass(admin.getId(), newPassword);
                if (result.equals("SUCCESS")) {
                    request.setAttribute("result", "Đổi mật khẩu thành công");
                    // xoa session hien tai
                    MyUtils.removeLoginedUser(session);
                    MyUtils.removeCart(session);
                    RequestDispatcher dispatcher = this.getServletContext()
                            .getRequestDispatcher("/WEB-INF/login/login.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("result", "Có lỗi xảy ra khi đổi mật khẩu");
                    RequestDispatcher dispatcher = this.getServletContext()
                            .getRequestDispatcher("/WEB-INF/admin/update-admin-password.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                request.setAttribute("result", "Mật khẩu cũ không trùng khớp");
                RequestDispatcher dispatcher = this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/admin/update-admin-password.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/admin/update-admin-password.jsp");
            dispatcher.forward(request, response);
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
            String checkRetypePassword = UserValidator.validateNewPass(newPassword);
            String checkOldAndNewPass = UserValidator.validateOldAndNewPass(oldPassword, newPassword);
            String checkNewAndRetypePass = UserValidator.validateNewAndRetypePass(newPassword,
                    retypePassword);

            // count for validate
            int count = 0;

            if (!checkOldPassword.isEmpty()) {
                count++;
                request.setAttribute("error_oldPassword", checkOldPassword);
            } else {
                request.setAttribute("oldPass", oldPassword);
            }

            if (!checkNewPassword.isEmpty()) {
                count++;
                request.setAttribute("error_newPassword", checkNewPassword);
            } else {
                request.setAttribute("newPass", newPassword);
            }

            if (!checkNewPassword.isEmpty()) {
                count++;
                request.setAttribute("error_newPassword", checkNewPassword);
            } else {
                request.setAttribute("newPass", newPassword);
            }

            if (!checkNewPassword.isEmpty()) {
                count++;
                request.setAttribute("error_retypePassword", checkNewPassword);
            } else {
                request.setAttribute("retypePass", retypePassword);
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
