package nhom55.hcmuaf.controller;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.ProductDAO;
import nhom55.hcmuaf.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/home"})
public class Home extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public Home() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // Dẫn đến đường link trang chủ hiển thị ra 8 sản phẩm
    List<Products> products = ProductService.getInstance().getProduct();
    request.setAttribute("listProducts", products);
    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
    dispatcher.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

}