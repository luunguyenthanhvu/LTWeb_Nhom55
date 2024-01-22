package nhom55.hcmuaf.controller.page.login;

import nhom55.hcmuaf.beans.LoginBean;
import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.cart.Cart;
import nhom55.hcmuaf.cart.UserCart;
import nhom55.hcmuaf.dao.LoginDao;
import nhom55.hcmuaf.dao.UsersDao;
import nhom55.hcmuaf.dao.UsersDaoImpl;
import nhom55.hcmuaf.util.MyUtils;
import nhom55.hcmuaf.util.UserValidator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {

    private LoginDao loginDao = new LoginDao();
    private UsersDao usersDao = new UsersDaoImpl();

    public Login() {
        super();
    }

    /**
     * Show Login page.
     *
     * @param request  an {@link HttpServletRequest} object that contains the request the client has
     *                 made of the servlet
     * @param response an {@link HttpServletResponse} object that contains the response the servlet
     *                 sends to the client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/WEB-INF/login/login.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * When the user enters userName & password, and click Submit. This method will be executed.
     *
     * @param request  an {@link HttpServletRequest} object that contains the request the client has
     *                 made of the servlet
     * @param response an {@link HttpServletResponse} object that contains the response the servlet
     *                 sends to the client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (checkValidate(request, response, email, password)) {
            LoginBean loginBean = new LoginBean(email, password, MyUtils.encodePass(password));

            String result = loginDao.authorizeLogin(loginBean);
            if (result.equals("FAIL")) {
                request.setAttribute("result", "Sai Email hoặc sai mật khẩu!");
                RequestDispatcher dispatcher = this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/login/login.jsp");
                dispatcher.forward(request, response);
            } else if (result.equals("ACCOUNT INACTIVE")) {
                request.setAttribute("result",
                        "Tài khoản đã bị khóa vui lòng liên hệ admin để được mở khóa!");
                RequestDispatcher dispatcher = this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/login/login.jsp");
                dispatcher.forward(request, response);
            } else {
                HttpSession session = request.getSession();
                Users user = usersDao.getUserByEmail(email);
                MyUtils.storeLoginedUser(session, user);

                // create a new cart
                Cart cart = UserCart.getUserCart(user.getId());
                MyUtils.storeCart(session, cart);

                if (result.equals("ADMIN")) {
                    // redirect to admin page
                    MyUtils.setUserRole(session, result);
                    response.sendRedirect(request.getContextPath() + "/admin-profile");
                } else if (result.equals("USER")) {
                    // redirect to home
                    MyUtils.setUserRole(session, result);
                    response.sendRedirect(request.getContextPath() + "/home");
                }
            }
        }
        // khong checkValidate
        else {
            RequestDispatcher dispatcher = this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/login/login.jsp");
            dispatcher.forward(request, response);
        }
    }
    /**
     * check validate for form input
     *
     * @param email
     * @param password
     * @return
     */
    private static boolean checkValidate(HttpServletRequest request, HttpServletResponse response,
                                         String email, String password) {
        String checkEmail = UserValidator.validateEmail(email);
        String checkPassword = UserValidator.validateMatKhau(password);

        // count for validate
        int count = 0;

        if (!checkEmail.isEmpty()) {
            count++;
            request.setAttribute("error_email", checkEmail);
        } else {
            request.setAttribute("email_user", email);
        }

        if (!checkPassword.isEmpty()) {
            count++;
            request.setAttribute("error_password", checkPassword);
        } else {
            request.setAttribute("pass_user", password);
        }

        if (count > 0) {
            return false;
        }
        return true;
    }
}