package nhom55.hcmuaf.controller;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txtSearch = request.getParameter("searchProduct");
        ProductDAO productDAO = new ProductDAO();
        int quantity = productDAO.countResultSearchingProduct(txtSearch);
        int defaultQuantityProductOnAPage = 20;
        int indexInitial = Integer.valueOf(request.getParameter("index"));
        System.out.println(indexInitial);
        int indexEnd = quantity/defaultQuantityProductOnAPage;
        if(quantity % defaultQuantityProductOnAPage !=0) {
            indexEnd++;
        }
        List<Products> listSearch = productDAO.search(txtSearch,indexInitial,defaultQuantityProductOnAPage);

        for(Products p: listSearch) {
            System.out.println(p.toString());
        }
        request.setAttribute("listSearch",listSearch);
        request.setAttribute("indexEnd",indexEnd);
        request.getRequestDispatcher("WEB-INF/searchProductResult.jsp").forward(request,response);

    }
}