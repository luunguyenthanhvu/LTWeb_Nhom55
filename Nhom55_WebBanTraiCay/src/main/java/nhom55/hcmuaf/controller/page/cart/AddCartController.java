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
//    int quantity = Integer.parseInt(request.getParameter("quantity"));
    Products product = ProductService.getInstance().getById(id);
    Cart cart = (Cart) request.getSession().getAttribute("cart");
//    if(quantity <= 0) {
//      if (quantity == 1) {
//        cart.add(id);
//      } else {
//        cart.add(id,quantity);
//      }
//    }
    cart.add(id);

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
