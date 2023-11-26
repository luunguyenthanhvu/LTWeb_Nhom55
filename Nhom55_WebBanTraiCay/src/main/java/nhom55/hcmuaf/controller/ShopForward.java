package nhom55.hcmuaf.controller;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShopForward", value = "/ShopForward")
public class ShopForward extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDAO productDAO = new ProductDAO();
        List<Products> products = productDAO.getListProducts();
        request.setAttribute("listOfProduct",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher ("WEB-INF/shop.jsp");
        dispatcher.forward (request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}