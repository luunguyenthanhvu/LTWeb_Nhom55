package nhom55.hcmuaf.controller.page.cart;

import java.util.Collection;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import nhom55.hcmuaf.cart.Cart;
import nhom55.hcmuaf.cart.CartProduct;

@WebServlet(name = "QuantityIncDec", value = "/quantity-inc-dec")
public class QuantityIncDec extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String action = request.getParameter("action");
    int id = Integer.parseInt(request.getParameter("id"));

    HttpSession session = request.getSession();
    Cart cart = (Cart) session.getAttribute("cart");

    if (action != null && id >= 1) {
      if (action.equals("inc")) {
        cart.add(id);
        response.sendRedirect("cart");
      } else if (action.equals("dec")) {
        cart.remove(id);
        response.sendRedirect("cart");
      }
    } else {
      response.sendRedirect("cart");
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}