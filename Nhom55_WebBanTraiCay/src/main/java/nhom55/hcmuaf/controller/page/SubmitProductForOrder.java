package nhom55.hcmuaf.controller.page;

import java.util.Arrays;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;

@WebServlet(name = "SubmitProductForOrder", value = "/submit-selected-products")
public class SubmitProductForOrder extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      // Đọc danh sách ID sản phẩm từ form
      String selectedProductIdsJson = request.getParameter("selectedProductIds");
      List<String> selectedProductIds = Arrays.asList(new ObjectMapper().readValue(selectedProductIdsJson, String[].class));

      // Lưu danh sách ID sản phẩm vào session
      HttpSession session = request.getSession();
      session.setAttribute("selectedProductIds", selectedProductIds);

      // chuyển hướng sang trang check out để tiến hành thanh toán
      response.sendRedirect(request.getContextPath() + "/check-out");
  }
}