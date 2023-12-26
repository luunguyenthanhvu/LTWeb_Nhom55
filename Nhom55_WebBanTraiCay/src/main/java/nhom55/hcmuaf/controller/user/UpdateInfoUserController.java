package nhom55.hcmuaf.controller.user;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.services.UserService;
import nhom55.hcmuaf.util.MyUtils;
import nhom55.hcmuaf.util.UserValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateInfoUserController", value = "/updateInfoUserController")

public class UpdateInfoUserController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("userProfile");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = MyUtils.getLoginedUser(session);


        String username = request.getParameter("ten_nguoi_dung");
        String email = request.getParameter("email_nguoi_dung");
        String gender = request.getParameter("gender");
        String address = request.getParameter("dia_chi_nguoi_dung");
        String phoneNumber = request.getParameter("so_dien_thoai_nguoi_dung");
        String dateOfBirth = request.getParameter("dob");
        Part filePart = request.getPart("avatar");
        String filePartString = filePart.getSubmittedFileName();


        if (checkValidate(request, response, username, email, address, phoneNumber, dateOfBirth, filePartString)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date myBirthDay = null;
            try {
                myBirthDay = dateFormat.parse(dateOfBirth);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String imgUser = "";

            String fileName = filePart.getSubmittedFileName();
            ServletContext servletContext = getServletContext();

            File root = new File(servletContext.getRealPath("/") + "/data");

            // create a new folder if not exists
            if (!root.exists()) {
                root.mkdirs();
            }
            // save img to data folder
            for (Part part : request.getParts()) {
                part.write(root.getAbsolutePath() + '/' + fileName);
                imgUser = "/data/" + fileName;
            }

            String result = UserService.getInstance().updateProfileWithImage(user.getId(), username, email, address, phoneNumber, myBirthDay, imgUser, gender);

            // Người dùng không thay đổi email
            if (user.getEmail().equals(email)) {
                if (result.equals("SUCCESS")) {
                    // lấy ra thông tin mới của người dùng
                    Users users = UserService.getInstance().getUserById(user.getId());
                    request.setAttribute("userUpdate", users);
                    request.setAttribute("result", "Cập nhật thành công");
                    RequestDispatcher dispatcher = this.getServletContext()
                            .getRequestDispatcher("/WEB-INF/user/user-profile.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("result", "Cập nhật thất bại");
                    RequestDispatcher dispatcher = this.getServletContext()
                            .getRequestDispatcher("/WEB-INF/user/chinh-sua-thong-tin-user.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                // Nếu email được thay đổi
                if (result.equals("SUCCESS")) {
                    request.setAttribute("result", "Đổi email thành công. Vui lòng đăng nhập lại!");
                    // xoa session hien tai
                    MyUtils.removeLoginedUser(session);
                    RequestDispatcher dispatcher = this.getServletContext()
                            .getRequestDispatcher("/WEB-INF/login/login.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("result", "Cập nhật thất bại");
                    RequestDispatcher dispatcher = this.getServletContext()
                            .getRequestDispatcher("/WEB-INF/user/chinh-sua-thong-tin-user.jsp");
                    dispatcher.forward(request, response);
                }
            }
            // không checkValidate
        } else {
            RequestDispatcher dispatcher = this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/user/chinh-sua-thong-tin-user.jsp");
            dispatcher.forward(request, response);
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
                                         String phoneNumber, String dateOfBirth, String img) {

        String checkName = UserValidator.validateName(userName);
        String checkEmail = UserValidator.validateEmail(email);
        String checkAddress = UserValidator.validateAddress(address);
        String checkPhoneNumber = UserValidator.validatePhoneNumber(phoneNumber);
        String checkDateOfBirth = UserValidator.validateDateOfBirth(dateOfBirth);
        String checkImg = UserValidator.validateFileUpload(img);
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

        if (!checkImg.isEmpty()) {
            count++;
            request.setAttribute("file_anh_error", checkImg);
        }

        if (count > 0) {
            return false;
        }
        return true;
    }
}

