package nhom55.hcmuaf.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.beans.Cart;
import nhom55.hcmuaf.services.ProductService;

@WebServlet(name = "add", value = "/cart/add")
public class Add extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    Products product = ProductService.getInstance().getById(id);
    product.setQuantity(1);
    Cart cart = (Cart) request.getSession().getAttribute("cart");
    if (cart == null) {
      cart = new Cart();
    }
    cart.put(product);
    request.getSession().setAttribute("cart", cart);
    response.sendRedirect("show");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}