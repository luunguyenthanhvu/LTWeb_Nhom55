package nhom55.hcmuaf.controller.page.shop;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.ProductDAO;
import nhom55.hcmuaf.services.ShopService;

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
        String sortBy = request.getParameter("sortBy");
        String order = request.getParameter("order");
        String pageStr = request.getParameter("pageId");

//        Sẽ có 2 trường hợp. 1 là khi vừa mới load vô trang Shop thì sortBy và order sẽ null. 2 là khi người chuyển sang
//        trang mới nhưng chưa chọn bất kì lựa chọn filter nào thì sortBy và order sẽ nhận giá trị "" do Tomcat
        if(sortBy == null && order==null || ("".equals(sortBy) && "".equals(order))) {

            int pageNumber = 0;
            if(pageStr == null) {
                pageNumber =1;
            } else {
                pageNumber = Integer.valueOf(pageStr);
            }

            int quantityDefault =20;
            int totalRow = ShopService.getInstance().countTotalRowProductInDatabase();
            int haveMaxPage = (totalRow/quantityDefault) +1;
            List<Products> list = ShopService.getInstance().get20ProductsForEachPage(pageNumber,quantityDefault);

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/shop.jsp");
            request.setAttribute("haveMaxPage",haveMaxPage);
            request.setAttribute("listOfProduct",list);
            request.setAttribute("pageId",pageNumber);
            rd.forward(request,response);
        }
//        Đây là trường hợp người dùng đã chọn Filter sẽ đưa FilterForAllProduct xử lý
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("FilterForAllProduct");
            request.setAttribute("pageId",pageStr);
            request.setAttribute("sortBy",sortBy);
            request.setAttribute("order",order);
            dispatcher.forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}