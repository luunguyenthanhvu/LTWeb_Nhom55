package nhom55.hcmuaf.controller.page.cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.cart.Cart;
import nhom55.hcmuaf.services.ProductService;
import nhom55.hcmuaf.util.MyUtils;

@WebServlet(name = "add", value = "/add-cart")
public class AddCartController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    int id = Integer.parseInt(request.getParameter("id"));
    String quantityParameter = request.getParameter("quantity");
    int quantity = 1;

    if (quantityParameter != null) {
      try {
        quantity = Integer.parseInt(quantityParameter);
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    }
    Products product = ProductService.getInstance().getById(id);
    Cart cart = (Cart) request.getSession().getAttribute("cart");

    cart.add(id,quantity);

    // update cart
    MyUtils.storeCart(session, cart);
    String url = (String) session.getAttribute("previousURL");

    response.sendRedirect(url);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Handle POST requests if needed
  }
}
