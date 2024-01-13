package nhom55.hcmuaf.controller.page.cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.cart.Cart;
import nhom55.hcmuaf.services.ProductService;
import nhom55.hcmuaf.util.MyUtils;

@WebServlet(name = "add", value = "/add-cart")
public class AddCartController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    Users users = MyUtils.getLoginedUser(session);
    // check if user doesn't login
    System.out.println("ok");
    if (users == null) {
      System.out.println("User is not logged in. Redirecting to login page.");
      response.getWriter().write("{\"status\":\"error\",\"message\":\"Vui Lòng đăng nhập.\"}");
    } else {
      int id = Integer.parseInt(request.getParameter("productId"));
      int quantity = Integer.parseInt(request.getParameter("quantity"));

      Products product = ProductService.getInstance().getById(id);
      Cart cart = (Cart) request.getSession().getAttribute("cart");

      cart.add(id, quantity);

      // update cart
      MyUtils.storeCart(session, cart);

      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      response.getWriter()
          .write("{ \"status\": \"success\", \"message\": \"Product added to cart.\" }");

    }
  }
}
