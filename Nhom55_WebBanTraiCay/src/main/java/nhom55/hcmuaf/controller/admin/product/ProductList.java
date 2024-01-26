package nhom55.hcmuaf.controller.admin.product;

import java.text.NumberFormat;
import java.util.Locale;
import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.services.ProductService;
import nhom55.hcmuaf.services.ShopService;
import nhom55.hcmuaf.util.MyUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductList", value = "/product-list")
public class ProductList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users admin = MyUtils.getLoginedUser(session);
        String pageStr = request.getParameter("pageId");
        int pageNumber = 0;
        if(pageStr == null) {
            pageNumber =1;
        } else {
            pageNumber = Integer.valueOf(pageStr);
        }

        int quantityDefault =20;
        int totalRow = ShopService.getInstance().countTotalRowProductInDatabase();
        int haveMaxPage = (totalRow/quantityDefault) +1;
        List<Products> listProduct = ShopService.getInstance().get20ProductsForEachPage(pageNumber,quantityDefault);
        RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/WEB-INF/admin/product-list.jsp");
        request.setAttribute("admin", admin);
        request.setAttribute("listProduct",listProduct);
        request.setAttribute("haveMaxPage",haveMaxPage);
        request.setAttribute("pageId",pageNumber);
        dispatcher.forward(request, response);


  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}