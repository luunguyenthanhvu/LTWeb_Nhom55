package nhom55.hcmuaf.controller;

import java.util.Collection;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.beans.Cart;

@WebServlet(name = "show", value = "/cart/show")
public class Show extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Cart cart = (Cart) request.getSession().getAttribute("cart");
    if(cart == null) {
        request.setAttribute("message", "Giỏ hàng trống");
      response.getWriter().println("Dell có giỏ hàng");
    } else {
      Collection<Products> list = cart.getListProduct();
      for(Products p : list) {
        response.getWriter().println(p);
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}