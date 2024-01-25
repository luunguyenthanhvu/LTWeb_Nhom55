package nhom55.hcmuaf.controller.page.bill;

import nhom55.hcmuaf.beans.Bills;
import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.dao.BillDao;
import nhom55.hcmuaf.dao.BillDaoImpl;
import nhom55.hcmuaf.util.MyUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListBills", value = "/page/bill/list-bills")
public class ListBills extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bills> listBills = (List<Bills>)request.getAttribute("listBills");
        if(listBills ==null) {
            HttpSession session = request.getSession();
            Users users = MyUtils.getLoginedUser(session);
            BillDao orderDao = new BillDaoImpl();
            listBills = orderDao.getListBills(users.getId());
            request.setAttribute("listBills",listBills);
            request.setAttribute("user",users);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/danh-sach-hoa-don.jsp");
            dispatcher.forward(request,response);
        } else {
            request.setAttribute("listBills",listBills);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/danh-sach-hoa-don.jsp");
            dispatcher.forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
}