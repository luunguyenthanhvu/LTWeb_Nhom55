package nhom55.hcmuaf.controller.page.cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import nhom55.hcmuaf.cart.Cart;
import nhom55.hcmuaf.util.MyUtils;

@WebServlet(name = "getCartAmount", value = "/get-cart-amount")
public class getCartAmount extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Cart cart = (Cart) request.getSession().getAttribute("cart");
    int cartCount = (cart != null) ? cart.getTotal() : 0;
    response.getWriter().write(String.valueOf(cartCount));
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}