package nhom55.hcmuaf.controller.admin;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.services.UserService;
import nhom55.hcmuaf.util.MyUtils;
import nhom55.hcmuaf.util.UserValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UpdateUser", value = "/updateUser")


public class UpdateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        List<Users> listUser = UserService.getInstance().showInfoUser();
        Users users = new Users();
        for (Users u : listUser) {
            if (u.getId() == id) {
                users = u;
                break;
            }
        }
        request.setAttribute("user", users);
        RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/WEB-INF/admin/update-user.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users admin = MyUtils.getLoginedUser(session);

        String parameterValue = request.getParameter("id_nguoi_dung");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNum");
        String dateOfBirth = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String statusParam = request.getParameter("status");
        String roleParam = request.getParameter("role");

        if (parameterValue != null && !parameterValue.isEmpty()) { // Kiểm tra xem giá trị có null không
            int id = Integer.parseInt(parameterValue);

            if (checkValidate(request, response, username, email, address, phoneNumber, dateOfBirth)) {
                int status = Integer.parseInt(statusParam);
                int role = Integer.parseInt(roleParam);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date myBirthDay = null;
                try {
                    myBirthDay = dateFormat.parse(dateOfBirth);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                UserService.getInstance().updateProfile(id, username, email, address, phoneNumber, myBirthDay, gender, status, role);

                // Nếu thay đổi email
                if(!admin.getEmail().equals(email)) {
                    request.setAttribute("result", "Đổi email thành công. Vui lòng đăng nhập lại!");
                    // xoa session hien tai
                    MyUtils.removeLoginedUser(session);
                    RequestDispatcher dispatcher = this.getServletContext()
                                .getRequestDispatcher("/WEB-INF/login/login.jsp");
                    dispatcher.forward(request, response);
                }
                response.sendRedirect(request.getContextPath() + "/userList");
                // không checkValidate
            } else {
                List<Users> listUser = UserService.getInstance().showInfoUser();
                Users users = new Users();
                for (Users u : listUser) {
                    if (u.getId() == id) {
                        users = u;
                        break;
                    }
                }

                request.setAttribute("user", users);
                RequestDispatcher dispatcher = this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/admin/update-user.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    /**
     * check validate for form input
     *
     * @param userName
     * @param email
     * @param address
     * @param phoneNumber
     * @param dateOfBirth
     * @return
     */

    private static boolean checkValidate(HttpServletRequest request, HttpServletResponse response,
                                         String userName, String email, String address,
                                         String phoneNumber, String dateOfBirth) {

        String checkName = UserValidator.validateName(userName);
        String checkEmail = UserValidator.validateEmail(email);
        String checkAddress = UserValidator.validateAddress(address);
        String checkPhoneNumber = UserValidator.validatePhoneNumber(phoneNumber);
        String checkDateOfBirth = UserValidator.validateDateOfBirth(dateOfBirth);
//        String checkGender = UserValidator.validateGender(gender);
        // count for validate
        int count = 0;

        if (!checkName.isEmpty()) {
            count++;
            request.setAttribute("error_name", checkName);
        } else {
            request.setAttribute("name_user", userName);
        }

        if (!checkEmail.isEmpty()) {
            count++;
            request.setAttribute("error_email", checkEmail);
        } else {
            request.setAttribute("emailUser", email);
        }

        if (!checkAddress.isEmpty()) {
            count++;
            request.setAttribute("error_address", checkAddress);
        } else {
            request.setAttribute("address_user", address);
        }

        if (!checkPhoneNumber.isEmpty()) {
            count++;
            request.setAttribute("error_phoneNumber", checkPhoneNumber);
        } else {
            request.setAttribute("phoneNumber_user", phoneNumber);
        }

        if (!checkDateOfBirth.isEmpty()) {
            count++;
            request.setAttribute("error_dob", checkDateOfBirth);
        } else {
            request.setAttribute("dateOfBirth_user", dateOfBirth);
        }

        if (count > 0) {
            return false;
        }
        return true;
    }


}
