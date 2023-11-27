package nhom55.hcmuaf.controller;

import nhom55.hcmuaf.beans.LoginBean;
import nhom55.hcmuaf.dao.LoginDao;
import nhom55.hcmuaf.util.MyUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    private LoginDao loginDao = new LoginDao ();
    private MyUtils myUtils = new MyUtils ();
    public Login() {
        super();
    }

    /**
     *  Show Login page.
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
        RequestDispatcher dispatcher = this.getServletContext ().getRequestDispatcher ("/WEB-INF/login/login.jsp");
        dispatcher.forward (request,response);
    }

    /**
     * When the user enters userName & password, and click Submit.
     * This method will be executed.
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter ("email");
        String password = request.getParameter ("password");

        LoginBean loginBean = new LoginBean (email,password, myUtils.encodePass (password));

        String result = loginDao.authorizeLogin (loginBean);
        if(result.equals ("FAIL")) {
            request.setAttribute ("result", "Sai Email hoặc sai mật khẩu!");
            RequestDispatcher dispatcher = this.getServletContext ().getRequestDispatcher ("/WEB-INF/login/login.jsp");
            dispatcher.forward (request,response);
        } else if(result.equals ("ACCOUNT INACTIVE")) {
            request.setAttribute ("result", "Tài khoản đã bị khóa vui lòng liên hệ admin để được mở khóa!");
            RequestDispatcher dispatcher = this.getServletContext ().getRequestDispatcher ("/WEB-INF/login/login.jsp");
            dispatcher.forward (request,response);
        } else if(result.equals ("ADMIN")) {
            // redirect to admin page
            response.sendRedirect (request.getContextPath () + "/adminProfile");
        } else {
            // redirect to index page
            response.sendRedirect (request.getContextPath () + "/");
        }
    }
}