package nhom55.hcmuaf.controller.page.shop;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import nhom55.hcmuaf.util.MyUtils;

@WebServlet(name = "FilterForSearchProduct", value = "/FilterForSearchProduct")
public class FilterForSearchProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // save url
        HttpSession session = request.getSession();
        MyUtils.setPreviousURL(session, request.getRequestURL().toString());

        String txtSearch = request.getParameter("txtSearch");
        String sortBy = request.getParameter("sortBy");
        String order = request.getParameter("order");
        ProductDAO productDAO = new ProductDAO();
        int quantity = productDAO.countResultSearchingProduct(txtSearch);
//        số lượng mặc định 1 trang
        int defaultQuantityProductOnAPage = 20;
//        index user bấm vào phân trang
        String indexPage = request.getParameter("pageId");
        if (indexPage == null) {
            indexPage = "1";
        }
        int indexInitial = Integer.parseInt(indexPage);
        System.out.println(indexInitial);
        int indexEnd = quantity / defaultQuantityProductOnAPage;
        if (quantity % defaultQuantityProductOnAPage != 0) {
            indexEnd++;
        }
        List<Products> listSearch = productDAO.searchFilter(sortBy,order,txtSearch, indexInitial,
                defaultQuantityProductOnAPage);

        for (Products p : listSearch) {
            System.out.println(p.toString());
        }
        request.setAttribute("listSearch", listSearch);
        request.setAttribute("indexEnd", indexEnd);
        request.setAttribute("txtSearch", txtSearch);
        request.setAttribute("sortBy", sortBy);
        request.setAttribute("order", order);
        request.getRequestDispatcher("WEB-INF/searchProductResult.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}