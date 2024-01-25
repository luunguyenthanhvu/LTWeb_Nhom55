package nhom55.hcmuaf.controller.admin.provider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminAddProvider", value = "/admin/provider/admin-add-provider")
public class AdminAddProvider extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         RequestDispatcher requestDispatcher = this.getServletContext()
                 .getRequestDispatcher("/WEB-INF/admin/add-provider.jsp");
         requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}