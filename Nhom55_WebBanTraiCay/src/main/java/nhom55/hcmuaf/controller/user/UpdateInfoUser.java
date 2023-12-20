package nhom55.hcmuaf.controller.user;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.services.UserService;
import nhom55.hcmuaf.util.UpdatedProductValidator;
import nhom55.hcmuaf.util.UserValidator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "updateInfoUser", value = "/updateInfoUser")
public class UpdateInfoUser extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("loginedUser");

            Users users = UserService.getInstance().getUserById(user.getId());
            request.setAttribute("user", users);
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
        String address = request.getParameter("dia_chi_nguoi_dung");
        String phoneNumber = request.getParameter("so_dien_thoai_nguoi_dung");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dob"));
        Part filePart = request.getPart("avatar");

            if (checkValidate(request,response,username,email,address,phoneNumber,dateOfBirth)) {
                if (filePart == null || filePart.getSize() == 0) {
                    // Người dùng không chọn ảnh ,xử lý tại đây
                    UserService.getInstance().updateProfileNoImage(user.getId(), username, email, address, phoneNumber, dateOfBirth);
                    doGet(request,response);
                } else {
                    // Người dùng chọn ảnh ,xử lý tại đây
                    String linkImg = "";
                    String fileName = filePart.getSubmittedFileName();
                    ServletContext servletContext = getServletContext();
                    File root = new File(servletContext.getRealPath("/") + "/data");
                    if (!root.exists()) root.mkdirs();
                    for (Part part : request.getParts()) {
                        part.write(root.getAbsolutePath() + "/" + fileName);
                        linkImg = "/data/" + fileName;
                    }
                    UserService.getInstance().updateProfileWithImage(user.getId(), username, email, address, phoneNumber, dateOfBirth, linkImg);
                    doGet(request,response);
                }

                Users users = UserService.getInstance().getUserById(user.getId());
                request.setAttribute("user", users);
                request.setAttribute("message", " Cập nhật thành công");
                RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/user/user-profile.jsp");
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
                                             String phoneNumber, LocalDate dateOfBirth) {

            String checkName = UserValidator.validateName(userName);
            String checkEmail = UserValidator.validateEmail(email);
            String checkAddress = UserValidator.validateAddress(address);
            String checkPhoneNumber = UserValidator.validatePhoneNumber(phoneNumber);
            String checkDateOfBirth = UserValidator.validateDateOfBirth(dateOfBirth);

            // count for validate
            int count = 0;

            if (!checkName.isEmpty()) {
                count++;
                request.setAttribute("username-error", checkName);
            } else {
                request.setAttribute("ten_nd-error", userName);
            }

            if (!checkEmail.isEmpty()) {
                count++;
                request.setAttribute("email-error", checkEmail);
            } else {
                request.setAttribute("email_nd", email);
            }

            if (!checkAddress.isEmpty()) {
                count++;
                request.setAttribute("address-error", checkAddress);
            } else {
                request.setAttribute("dc_nd", address);
            }

            if (!checkPhoneNumber.isEmpty()) {
                count++;
                request.setAttribute("phoneNumber-error", checkPhoneNumber);
            } else {
                request.setAttribute("sdt_nd", phoneNumber);
            }

            if (!checkDateOfBirth.isEmpty()) {
                count++;
                request.setAttribute("dob-error", checkDateOfBirth);
            } else {
                request.setAttribute("dob", dateOfBirth);
            }

            if (count > 0) {
                return false;
            }
            return true;
        }




}
