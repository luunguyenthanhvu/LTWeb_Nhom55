package nhom55.hcmuaf.controller.page.order;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import nhom55.hcmuaf.cart.Cart;
import nhom55.hcmuaf.cart.CartProduct;
import nhom55.hcmuaf.util.MyUtils;

@WebServlet(name = "CheckOut", value = "/check-out")
public class CheckOut extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    double subTotalPrice = 0;
    // get selected Product for buy
    List<String> selectedProductIds = (List<String>) session.getAttribute("selectedProductIds");
    Cart cart = (Cart) session.getAttribute("cart");
    if(cart != null && selectedProductIds != null) {
      // get product list selected from cart
      List<CartProduct> selectedProducts = cart.getSelectedProducts(selectedProductIds);
      subTotalPrice = getTotalPrice(selectedProducts);
    }

//    String formattedAmount = MyUtils.formatAmount(subTotalPrice);
    request.setAttribute("subTotalPrice", subTotalPrice);
    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/checkout.jsp");
    dispatcher.forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
  private static double getTotalPrice(List<CartProduct> selectedProducts) {
    double result = 0;
    for(CartProduct product : selectedProducts) {
      result += product.getPrice();
    }
    return result;
  }
}