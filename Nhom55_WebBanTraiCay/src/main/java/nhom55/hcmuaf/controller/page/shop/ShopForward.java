package nhom55.hcmuaf.controller.page.shop;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import nhom55.hcmuaf.util.MyUtils;

@WebServlet(name = "ShopForward", value = "/ShopForward")
public class ShopForward extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // save url
        HttpSession session = request.getSession();
        MyUtils.setPreviousURL(session, request.getRequestURL().toString());

        ProductDAO productDAO = new ProductDAO();
        String pageStr = request.getParameter("pageId");
        int pageNumber = 0;
        if(pageStr == null) {
            pageNumber =1;
        } else {
            pageNumber = Integer.valueOf(pageStr);
        }

        int quantityDefault =20;
        int totalRow = productDAO.countTotalRowProductInDatabase();
        int haveMaxPage = (totalRow/quantityDefault) +1;
        List<Products> list = productDAO.get20ProductsForEachPage(pageNumber,quantityDefault);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/shop.jsp");
        request.setAttribute("haveMaxPage",haveMaxPage);
        request.setAttribute("listOfProduct",list);
        request.setAttribute("pageId",pageNumber);
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}