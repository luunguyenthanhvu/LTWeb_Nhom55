package nhom55.hcmuaf.controller.user;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "updateInfoUser", value = "/updateInfoUser")
public class UpdateInfoUser extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            int id = Integer.parseInt(request.getParameter("id"));

            Users users = UserService.getInstance().showInfoUser(id);
            request.setAttribute("showUser", users);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/user/chinh-sua-thong-tin-user.jsp");
            dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            int id = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("ten_nguoi_dung");
            String email = request.getParameter("email_nguoi_dung");
            String address = request.getParameter("dia_chi_nguoi_dung");
            String phoneNumber = request.getParameter("so_dien_thoai_nguoi_dung");
            LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dob"));

            Users users_update = UserService.getInstance().updateProfile(id, username, email, address, phoneNumber, dateOfBirth);

            Users users = UserService.getInstance().showInfoUser(id);
            if (users != null) {
                request.setAttribute("showUser", users);
                RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/user/user-profile.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/userProfile");
            }
        }




}
