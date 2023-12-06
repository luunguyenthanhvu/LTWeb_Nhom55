package nhom55.hcmuaf.controller.page.login;

import nhom55.hcmuaf.services.ForgetPasswordService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "forgetPassword", value = "/forget-password")
public class ForgetPassword extends HttpServlet {
    private ForgetPasswordService forgetPasswordService = new ForgetPasswordService ();
    public ForgetPassword() {
        super();
    }

    /**
     * show forget password page
     * @param request   an {@link HttpServletRequest} object that
     *                  contains the request the client has made
     *                  of the servlet
     *
     * @param response  an {@link HttpServletResponse} object that
     *                  contains the response the servlet sends
     *                  to the client
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext ().getRequestDispatcher ("/WEB-INF/login/forget-password.jsp");
        dispatcher.forward (request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter ("email");
        String result = forgetPasswordService.changePass (email);
        if(result.equals ("FAIL")) {
            request.setAttribute ("result", "Tài khoản không tồn tại!");
            RequestDispatcher dispatcher = this.getServletContext ().getRequestDispatcher ("/WEB-INF/login/forget-password.jsp");
            dispatcher.forward (request,response);
        } else {
            request.setAttribute ("result", "Đổi mật khẩu thành công. Vui lòng Kiểm tra email");
            RequestDispatcher dispatcher = this.getServletContext ().getRequestDispatcher ("/WEB-INF/login/forget-password.jsp");
            dispatcher.forward (request,response);
        }
    }
}