package nhom55.hcmuaf.controller.page.cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import nhom55.hcmuaf.cart.Cart;
import nhom55.hcmuaf.util.MyUtils;

@WebServlet(name = "RemoveCartController", value = "/remove-product-cart")
public class RemoveCartController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();

    int id = Integer.parseInt(request.getParameter("id"));

    Cart cart = (Cart) request.getSession().getAttribute("cart");
    cart.deleteProduct(id);

    // update cart
    MyUtils.storeCart(session, cart);
    response.sendRedirect(request.getContextPath() + "/cart");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}