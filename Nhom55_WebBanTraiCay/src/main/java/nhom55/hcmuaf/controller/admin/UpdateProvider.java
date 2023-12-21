package nhom55.hcmuaf.controller.admin;

import nhom55.hcmuaf.beans.Providers;
import nhom55.hcmuaf.services.ProviderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateProvider", value = "/UpdateProvider")
public class UpdateProvider extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          int idProvider = Integer.valueOf(request.getParameter("id"));
        List<Providers> list = ProviderService.getInstance().getAll();
        Providers provider =null;
        for(Providers p: list) {
            if(p.getId() == idProvider) {
                provider =p;
                break;
            }
        }
             request.setAttribute("provider",provider);
             RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin/update-provider.jsp");
             dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}