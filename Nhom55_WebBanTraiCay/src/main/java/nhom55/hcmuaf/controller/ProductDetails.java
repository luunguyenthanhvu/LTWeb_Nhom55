package nhom55.hcmuaf.controller;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.ProductDAO;
import nhom55.hcmuaf.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "productDetails", value = "/productDetails")
public class ProductDetails extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String parameterValue = request.getParameter("id"); // Lấy giá trị từ tham số truy vấn

            if(parameterValue != null && !parameterValue.isEmpty()) { // Kiểm tra xem giá trị có null không
                int productId = Integer.parseInt(request.getParameter("id"));

                Products product = ProductService.getInstance().showProductDetails(productId);  // Gọi phương thức để lấy chi tiết sản phẩm

                if (product != null) {
                    request.setAttribute("showProduct", product);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/product-single.jsp");
                    dispatcher.forward(request, response);
                } else {
                    // Trường hợp không tìm thấy sản phẩm có ID đã cho
                    response.sendRedirect("index.jsp");
                }
            } else {
                // Trường hợp không cung cấp ID sản phẩm đã cho
                response.sendRedirect("index.jsp");
                System.out.println("null");
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}