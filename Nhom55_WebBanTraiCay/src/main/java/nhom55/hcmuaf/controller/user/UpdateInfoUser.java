package nhom55.hcmuaf.controller.user;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.services.UserService;
import nhom55.hcmuaf.util.UserValidator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10, maxRequestSize =
        1024 * 1024 * 100)
@WebServlet(name = "updateInfoUser", value = "/updateInfoUser")
public class UpdateInfoUser extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("loginedUser");

            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/user/chinh-sua-thong-tin-user.jsp");
            dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("loginedUser");

        String username = request.getParameter("ten_nguoi_dung");
        String email = request.getParameter("email_nguoi_dung");
        String gender = request.getParameter("gioi_tinh_nd");
        String address = request.getParameter("dia_chi_nguoi_dung");
        String phoneNumber = request.getParameter("so_dien_thoai_nguoi_dung");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dob"));
        Part filePart = request.getPart("avatar");
        String filePartString = filePart.getSubmittedFileName();

            if (checkValidate(request, response, username, email, address, phoneNumber, dateOfBirth, filePartString, gender)) {
                if (filePart == null || filePart.getSize() == 0) {
                    // Người dùng không chọn file ảnh, xử lý tại đây
                    UserService.getInstance().updateProfileNoImage(user.getId(), username, email, address, phoneNumber, dateOfBirth, gender);

                    response.sendRedirect(request.getContextPath() + "/userProfile");
                    request.setAttribute("message", "Cập nhật thành công");
//                    RequestDispatcher dispatcher = request
//                            .getRequestDispatcher("/WEB-INF/user/user-profile.jsp");
//                    dispatcher.forward(request, response);


                } else {
                    // Người dùng chọn file ảnh
                    String imgUser ="";
                    String fileName = filePart.getSubmittedFileName();
                    ServletContext servletContext = getServletContext();
                    File root = new File(servletContext.getRealPath("/") + "/data");
                    if (!root.exists()) root.mkdirs();
                    for (Part part : request.getParts()) {
                        part.write(root.getAbsolutePath() + "/" + fileName);
                        imgUser ="/data/" + fileName;
                    }
                    Users userUpdate = UserService.getInstance().updateProfileWithImage(user.getId(), username, email, address, phoneNumber, dateOfBirth,imgUser, gender);

                    request.setAttribute("message", "Cập nhật thành công");
                    RequestDispatcher dispatcher = request
                            .getRequestDispatcher("/WEB-INF/user/user-profile.jsp");
                    dispatcher.forward(request, response);

                }
            }
    }

        /**
         * check validate for form input
         *
         * @param userName
         * @param email
         * @param gender
         * @param address
         * @param phoneNumber
         * @param dateOfBirth
         * @return
         */

        private static boolean checkValidate(HttpServletRequest request, HttpServletResponse response,
                                             String userName, String email, String address,
                                             String phoneNumber, LocalDate dateOfBirth, String filePart, String gender) {

            String checkName = UserValidator.validateName(userName);
            String checkEmail = UserValidator.validateEmail(email);
            String checkAddress = UserValidator.validateAddress(address);
            String checkPhoneNumber = UserValidator.validatePhoneNumber(phoneNumber);
            String checkDateOfBirth = UserValidator.validateDateOfBirth(dateOfBirth);
            String checkFilePart = UserValidator.validateFileUpload(filePart);
            String checkGender = UserValidator.validateGender(gender);
            // count for validate
            int count = 0;

            if (!checkName.isEmpty()) {
                count++;
                request.setAttribute("error_name", checkName);
            } else {
                request.setAttribute("name", userName);
            }

            if (!checkEmail.isEmpty()) {
                count++;
                request.setAttribute("error_email", checkEmail);
            } else {
                request.setAttribute("email", email);
            }

            if (!checkAddress.isEmpty()) {
                count++;
                request.setAttribute("error_address", checkAddress);
            } else {
                request.setAttribute("dc_nd", address);
            }

            if (!checkPhoneNumber.isEmpty()) {
                count++;
                request.setAttribute("error_phoneNumber", checkPhoneNumber);
            } else {
                request.setAttribute("phoneNumber", phoneNumber);
            }

            if (!checkDateOfBirth.isEmpty()) {
                count++;
                request.setAttribute("error_dob", checkDateOfBirth);
            } else {
                request.setAttribute("dateOfBirth", dateOfBirth);
            }

            if (!checkFilePart.isEmpty()) {
                count++;
                request.setAttribute("file_anh_error", checkFilePart);
            }

            if (!checkGender.isEmpty()) {
                count++;
                request.setAttribute("error_gender", checkGender);
            } else {
                request.setAttribute("gender", gender);
            }

            if (count > 0) {
                return false;
            }
            return true;
        }




}
