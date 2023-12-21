package nhom55.hcmuaf.controller.admin;

import nhom55.hcmuaf.services.ProviderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet(name = "DeleteProviderController", value = "/DeleteProviderController")
public class DeleteProviderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            int idProvider = Integer.valueOf(request.getParameter("id"));
            ProviderService.getInstance().deleteProvider(idProvider);
            response.sendRedirect("ProviderList");

        }
        catch(Exception e)
        {
//            Trong trường hợp Nhà cung cấp này hiện đang nằm trong danh sách sản phẩm trái cây thì không thể xóa được
            request.setAttribute("notifyError","lỗi");
               RequestDispatcher requestDispatcher = request.getRequestDispatcher("ProviderList");
               requestDispatcher.forward(request,response);


        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}