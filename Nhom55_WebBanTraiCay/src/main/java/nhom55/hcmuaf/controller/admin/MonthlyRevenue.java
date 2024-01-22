package nhom55.hcmuaf.controller.admin;

import java.text.NumberFormat;
import java.util.Locale;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import nhom55.hcmuaf.services.ProductService;

@WebServlet(name = "MonthlyRevenue", value = "/monthly-revenue")
public class MonthlyRevenue extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    double totalMoneyMonth1 = ProductService.getInstance().getTotalMoneyMonth(1);
    double totalMoneyMonth2 = ProductService.getInstance().getTotalMoneyMonth(2);
    double totalMoneyMonth3 = ProductService.getInstance().getTotalMoneyMonth(3);
    double totalMoneyMonth4 = ProductService.getInstance().getTotalMoneyMonth(4);
    double totalMoneyMonth5 = ProductService.getInstance().getTotalMoneyMonth(5);
    double totalMoneyMonth6 = ProductService.getInstance().getTotalMoneyMonth(6);
    double totalMoneyMonth7 = ProductService.getInstance().getTotalMoneyMonth(7);
    double totalMoneyMonth8 = ProductService.getInstance().getTotalMoneyMonth(8);
    double totalMoneyMonth9 = ProductService.getInstance().getTotalMoneyMonth(9);
    double totalMoneyMonth10 = ProductService.getInstance().getTotalMoneyMonth(10);
    double totalMoneyMonth11 = ProductService.getInstance().getTotalMoneyMonth(11);
    double totalMoneyMonth12 = ProductService.getInstance().getTotalMoneyMonth(12);

    request.setAttribute("totalMoneyMonth1", currencyFormatter.format(totalMoneyMonth1));
    request.setAttribute("totalMoneyMonth2", currencyFormatter.format(totalMoneyMonth2));
    request.setAttribute("totalMoneyMonth3", currencyFormatter.format(totalMoneyMonth3));
    request.setAttribute("totalMoneyMonth4", currencyFormatter.format(totalMoneyMonth4));
    request.setAttribute("totalMoneyMonth5", currencyFormatter.format(totalMoneyMonth5));
    request.setAttribute("totalMoneyMonth6", currencyFormatter.format(totalMoneyMonth6));
    request.setAttribute("totalMoneyMonth7", currencyFormatter.format(totalMoneyMonth7));
    request.setAttribute("totalMoneyMonth8", currencyFormatter.format(totalMoneyMonth8));
    request.setAttribute("totalMoneyMonth9", currencyFormatter.format(totalMoneyMonth9));
    request.setAttribute("totalMoneyMonth10", currencyFormatter.format(totalMoneyMonth10));
    request.setAttribute("totalMoneyMonth11", currencyFormatter.format(totalMoneyMonth11));
    request.setAttribute("totalMoneyMonth12", currencyFormatter.format(totalMoneyMonth12));

    RequestDispatcher dispatcher = this.getServletContext()
        .getRequestDispatcher("/WEB-INF/admin/monthly-revenue.jsp");
    dispatcher.forward(request, response);
  }
}