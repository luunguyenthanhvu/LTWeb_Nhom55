package nhom55.hcmuaf.controller.upload;

import java.io.File;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import javax.servlet.jsp.PageContext;

@WebServlet(name = "UploadController", value = "/upload-controller")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10, maxRequestSize =
    1024 * 1024 * 100)
public class UploadController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = this.getServletContext ().getRequestDispatcher ("/WEB-INF/test.jsp");
    dispatcher.forward (request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Part filePart = request.getPart("file");

    String fileName = filePart.getSubmittedFileName();
    ServletContext servletContext = getServletContext();

    File root = new File(servletContext.getRealPath("/") + "/data");

    if(!root.exists()) root.mkdirs();
    System.out.println(root.getAbsolutePath());
    for(Part part : request.getParts()) {
      part.write(root.getAbsolutePath() + "/" + fileName);
    }
    response.getWriter().println("File upload successfully");
  }
}