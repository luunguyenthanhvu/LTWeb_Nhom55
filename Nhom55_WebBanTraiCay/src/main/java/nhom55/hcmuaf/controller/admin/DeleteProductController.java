package nhom55.hcmuaf.controller.admin;

import nhom55.hcmuaf.services.DeleteProductServiceForAdmin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteProductController", value = "/delete-productController")
public class DeleteProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int idProduct = Integer.valueOf(request.getParameter("id"));
        DeleteProductServiceForAdmin.getInstance().deleteProduct(idProduct);
        response.sendRedirect("product-list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}