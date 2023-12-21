package nhom55.hcmuaf.controller.page;

import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckOut", value = "/check-out")
public class CheckOut extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    List<String> selectedProductIds = (List<String>) session.getAttribute("selectedProductIds");
    for(String s : selectedProductIds) {
      System.out.println(s);
    }
    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/checkout.jsp");
    dispatcher.forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}