package nhom55.hcmuaf.controller.page.shop;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShopController", value = "/ShopController")
public class ShopController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String txtSearch = request.getParameter("txtSearch");
    String sortBy = request.getParameter("sortBy");
    String order = request.getParameter("order");
    ProductDAO productDAO = new ProductDAO();
    int quantity = productDAO.countResultSearchingProduct(txtSearch);
//        số lượng mặc định 1 trang
    int defaultQuantityProductOnAPage = 20;
//        index user bấm vào phân trang
    String indexPage = request.getParameter("index");
    if (indexPage == null) {
      indexPage = "1";
    }
    int indexInitial = Integer.parseInt(indexPage);
    System.out.println(indexInitial);
    int indexEnd = quantity / defaultQuantityProductOnAPage;
    if (quantity % defaultQuantityProductOnAPage != 0) {
      indexEnd++;
    }
    List<Products> listSearch = null;
    if (sortBy == null & order == null) {
      listSearch = productDAO.search(txtSearch, indexInitial,
          defaultQuantityProductOnAPage);
    } else {
      listSearch = productDAO.searchFilter(sortBy, order, txtSearch, indexInitial,
          defaultQuantityProductOnAPage);
    }

    request.setAttribute("listSearch", listSearch);
    request.setAttribute("indexEnd", indexEnd);
    request.setAttribute("txtSearch", txtSearch);
    request.getRequestDispatcher("WEB-INF/searchProductResult.jsp").forward(request, response);

  }
}