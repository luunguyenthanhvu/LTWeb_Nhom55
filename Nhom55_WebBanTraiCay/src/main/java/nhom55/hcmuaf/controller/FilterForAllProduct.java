package nhom55.hcmuaf.controller;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FilterForAllProduct", value = "/FilterForAllProduct")
public class FilterForAllProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//     index là chỉ số được đặt theo thứ mục của filter
       int index = Integer.valueOf(request.getParameter("index"));
        ProductDAO productDAO = new ProductDAO();
 // pageSTR(pageNumber là kiểu int khi chuyển từ String PageSTr),  là số mà người dùng bấm vào số mà muốn chuyển trang
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
        List<Products> lay20SanPhamDuaVaoPageNumber = productDAO.get20ProductsForEachPage(pageNumber,quantityDefault);
        if(index ==1) {
            List<Products> list = productDAO.sortByPriceIncrease(lay20SanPhamDuaVaoPageNumber);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/shop.jsp");
            request.setAttribute("haveMaxPage",haveMaxPage);
            request.setAttribute("listOfProduct",list);
            request.setAttribute("pageId",pageNumber);
            rd.forward(request,response);
        }
        if(index ==2) {
            List<Products> list = productDAO.sortByPriceDecrease(lay20SanPhamDuaVaoPageNumber);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/shop.jsp");
            request.setAttribute("haveMaxPage",haveMaxPage);
            request.setAttribute("listOfProduct",list);
            request.setAttribute("pageId",pageNumber);
            rd.forward(request,response);
        }
        if(index ==3) {
            List<Products> list = productDAO.sortByNameIncrease(lay20SanPhamDuaVaoPageNumber);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/shop.jsp");
            request.setAttribute("haveMaxPage",haveMaxPage);
            request.setAttribute("listOfProduct",list);
            request.setAttribute("pageId",pageNumber);
            rd.forward(request,response);
        }
        if(index ==4) {
            List<Products> list = productDAO.sortByNameDecrease(lay20SanPhamDuaVaoPageNumber);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/shop.jsp");
            request.setAttribute("haveMaxPage",haveMaxPage);
            request.setAttribute("listOfProduct",list);
            request.setAttribute("pageId",pageNumber);
            rd.forward(request,response);
        }
        if(index ==5) {
            List<Products> list = productDAO.sortByDateImporting(lay20SanPhamDuaVaoPageNumber);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/shop.jsp");
            request.setAttribute("haveMaxPage",haveMaxPage);
            request.setAttribute("listOfProduct",list);
            request.setAttribute("pageId",pageNumber);
            rd.forward(request,response);
        }

    }
}