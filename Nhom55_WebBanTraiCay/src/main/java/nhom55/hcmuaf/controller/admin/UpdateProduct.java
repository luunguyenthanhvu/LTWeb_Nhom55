package nhom55.hcmuaf.controller.admin;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.beans.Provider;
import nhom55.hcmuaf.dao.ProviderDAO;
import nhom55.hcmuaf.services.ProductService;
import nhom55.hcmuaf.services.ShopService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.DoubleBuffer;
import java.util.List;

@WebServlet(name = "UpdateProduct", value = "/update-product")
public class UpdateProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int idSanPham = Integer.valueOf(request.getParameter("id"));
        List<Products> listProduct = ShopService.getInstance().getListProducts();
        Products products = new Products();
        for(Products p: listProduct) {
            if(p.getId() == idSanPham) {
                products =p;
                break;
            }
        }
        ProviderDAO dao = new ProviderDAO();
        List<Provider> listProvider = dao.getProvider();
        RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/WEB-INF/admin/update-product.jsp");
        request.setAttribute("product",products);
        request.setAttribute("listProvider",listProvider);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}