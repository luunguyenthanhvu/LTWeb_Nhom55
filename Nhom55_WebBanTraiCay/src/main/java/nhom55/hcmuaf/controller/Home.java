package nhom55.hcmuaf.controller;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.HomeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/" })
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

        HomeDao homeDao = new HomeDao();
        List<Products> products = homeDao.get8Products();
        request.setAttribute("list8Product", products);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
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

