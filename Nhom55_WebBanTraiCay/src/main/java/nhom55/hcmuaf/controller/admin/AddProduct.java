package nhom55.hcmuaf.controller.admin;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.beans.Providers;
import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.services.ProductService;
import nhom55.hcmuaf.services.ProviderService;
import nhom55.hcmuaf.util.MyUtils;

@WebServlet(name = "AddProduct", value = "/add-new-product")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10, maxRequestSize =
    1024 * 1024 * 100)
public class AddProduct extends HttpServlet {

  /**
   * @param request  an {@link HttpServletRequest} object that contains the request the client has
   *                 made of the servlet
   * @param response an {@link HttpServletResponse} object that contains the response the servlet
   *                 sends to the client
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // get the provider to add new product
    List<Providers> providerList = ProviderService.getInstance().getAll();
    request.setAttribute("providerList", providerList);

    RequestDispatcher dispatcher = this.getServletContext()
        .getRequestDispatcher("/WEB-INF/admin/add-product.jsp");
    dispatcher.forward(request, response);
  }

  /**
   *
   * @param request   an {@link HttpServletRequest} object that
   *                  contains the request the client has made
   *                  of the servlet
   *
   * @param response  an {@link HttpServletResponse} object that
   *                  contains the response the servlet sends
   *                  to the client
   *
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    Users admin = MyUtils.getLoginedUser(session);

    String productName = request.getParameter("ten_san_pham");
    String description = request.getParameter("mo_ta_san_pham");
    double price = Double.parseDouble(request.getParameter("gia_tien_san_pham"));
    double weightQuantity = Double.parseDouble(request.getParameter("khoi_luong_san_pham"));
    double weightDefault = Double.parseDouble(request.getParameter("so_kg_mac_dinh"));
    String expirationDateString = request.getParameter("ngay_het_han");
    int provider = Integer.parseInt(request.getParameter("provider"));
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date expirationDate = null;
    try {
      expirationDate = dateFormat.parse(expirationDateString);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    String imgProduct = "";
    Part filePart = request.getPart("upload_file_san_pham");

    String fileName = filePart.getSubmittedFileName();
    ServletContext servletContext = getServletContext();

    File root = new File(servletContext.getRealPath("/") + "/data");

    if(!root.exists()) root.mkdirs();
    for(Part part : request.getParts()) {
      part.write(root.getAbsolutePath() + '/' + fileName);
      imgProduct = "/data/" + fileName;
    }

    LocalDateTime localDateTime = LocalDateTime.now();
    Date dateImport = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    ProductService.getInstance()
        .addNewProduct(productName, description, price, weightQuantity, weightDefault, dateImport,
            expirationDate, imgProduct, admin.getId(),provider);
    response.sendRedirect(request.getContextPath() + "/add-new-product");
  }
}