package nhom55.hcmuaf.controller.admin;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.ProductDaoImpl;
import nhom55.hcmuaf.services.ShopService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManageExpiredProduct", value = "/manage-expired-product")
public class ManageExpiredProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        List<Products> listProduct = new ProductDaoImpl().printExpiredProduct();
        RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/WEB-INF/admin/time-expired-product.jsp");
        request.setAttribute("listProduct",listProduct);
        request.setAttribute("haveMaxPage",haveMaxPage);
        request.setAttribute("pageId",pageNumber);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}