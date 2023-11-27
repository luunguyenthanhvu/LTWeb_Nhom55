package nhom55.hcmuaf.controller;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Home", value = "/")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Home() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to /WEB-INF/views/homeView.jsp
        // Dẫn đến đường link trang chủ hiển thị ra 8 sản phẩm
        // (Users can not access directly into JSP pages placed in WEB-INF)

        ProductDAO productDAO = new ProductDAO();
        List<Products> products = productDAO.getProduct();
        request.setAttribute("listProducts", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher ("WEB-INF/index.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        HomeDao homeDao = new HomeDao();
//        List<Products> list = homeDao.get8Products();
//
//        for(Products p: list) {
//            System.out.println(list.toString());
//        }
//
//        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
    }

}