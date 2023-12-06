package nhom55.hcmuaf.controller.page.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import nhom55.hcmuaf.beans.Users;

import nhom55.hcmuaf.cart.Cart;
import nhom55.hcmuaf.cart.UserCart;
import nhom55.hcmuaf.util.MyUtils;

@WebServlet(name = "logout", value = "/logout")
public class Logout extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    Cart cart = (Cart) session.getAttribute("cart");
    Users user = (Users) session.getAttribute("loginedUser");

//    UserCart.updateCart(user.getId(),cart);
    session.invalidate();

    RequestDispatcher dispatcher = this.getServletContext()
        .getRequestDispatcher("/WEB-INF/login/login.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}