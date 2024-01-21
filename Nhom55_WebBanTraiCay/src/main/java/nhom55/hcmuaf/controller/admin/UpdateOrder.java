package nhom55.hcmuaf.controller.admin;

import nhom55.hcmuaf.beans.BillDetail;
import nhom55.hcmuaf.beans.Bills;
import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.dao.BillDao;
import nhom55.hcmuaf.dao.BillDaoImpl;
import nhom55.hcmuaf.dao.ProductDaoImpl;
import nhom55.hcmuaf.util.MyUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateOrder", value = "/UpdateOrder")
public class UpdateOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idBill = Integer.valueOf(request.getParameter("idOrder"));
        HttpSession session = request.getSession();
        Users admin = MyUtils.getLoginedUser(session);
        BillDao orderDao = new BillDaoImpl();
        ProductDaoImpl productDao = new ProductDaoImpl();
        List<BillDetail> detailList = orderDao.getListProductInABill(idBill);
        List<String> linkAnhSp = new ArrayList<>();
        for(BillDetail bd: detailList) {
            Products products = productDao.getProductById(bd.getId());
            String temp = products.getExpriredDay().toString();
            linkAnhSp.add(temp);
        }
        Bills bill = orderDao.getABill(idBill);
        request.setAttribute("admin", admin);
        request.setAttribute("bill",bill);
        request.setAttribute("detailList",detailList);
        request.setAttribute("linkAnhSp",linkAnhSp);
        request.setAttribute("idBill",idBill);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin/update-order.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idBill = Integer.valueOf(request.getParameter("idBill"));
        String status = request.getParameter("selectedStatus");
        BillDao billDao = new BillDaoImpl();
        billDao.updateStatusABill(idBill,status);
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderList");
        dispatcher.forward(request,response);
    }
}