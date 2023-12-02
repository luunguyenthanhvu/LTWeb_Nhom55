package nhom55.hcmuaf.controller;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "paging", value = "/paging")
public class Paging extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index = request.getParameter("index");
        if(index==null) { // nếu bị null trả về trang số 1
            index = "1";
        }

        int indexPage = Integer.parseInt(index);
        ProductDAO productDao = new ProductDAO();

        int numberPage = productDao.getNumberPage(); // đếm số trang
        request.setAttribute("numberPage", numberPage);

        List<Products> listProducts = productDao.getPaging(indexPage); // phân trang
        request.setAttribute("listPaging", listProducts);
        request.setAttribute("indexPage", indexPage);


        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/shop.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}