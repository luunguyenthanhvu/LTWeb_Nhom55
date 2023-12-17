package nhom55.hcmuaf.controller.admin;

import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.services.UpdateProductServiceForAdmin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10, maxRequestSize =
        1024 * 1024 * 100)
@WebServlet(name = "UpdateProductController", value = "/UpdateProductController")
public class UpdateProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("product-list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("loginedUser");
        int idSanPham = Integer.valueOf(request.getParameter("id_san_pham"));
        String tenSanPham = request.getParameter("ten_san_pham");
        String moTa = request.getParameter("mo_ta_san_pham");
        double price = Double.valueOf(request.getParameter("gia_tien_san_pham"));
        double khoiLuong = Double.valueOf(request.getParameter("khoi_luong_san_pham"));
        double soKGMacDinh = Double.valueOf(request.getParameter("so_kg_mac_dinh"));
        String ngayNhapHang = request.getParameter("ngay_nhap_hang");
        String ngayHetHan = request.getParameter("ngay_het_han");
        int idNhaCungCap = Integer.valueOf(request.getParameter("selectedProviderID"));
        Part filePart = request.getPart("file");
        if (filePart == null || filePart.getSize() == 0) {
            // Người dùng không chọn file, xử lý tại đây

            UpdateProductServiceForAdmin.getInstance().editProductNoImage(idSanPham, tenSanPham, moTa, price, khoiLuong, soKGMacDinh, Date.valueOf(ngayNhapHang), Date.valueOf(ngayHetHan), user.getId(), idNhaCungCap);
            doGet(request,response);
        } else {
            String linkAnhSanPham ="";
            String fileName = filePart.getSubmittedFileName();
            ServletContext servletContext = getServletContext();
            File root = new File(servletContext.getRealPath("/") + "/data");
            if (!root.exists()) root.mkdirs();
            for (Part part : request.getParts()) {
                part.write(root.getAbsolutePath() + "/" + fileName);
                linkAnhSanPham ="/data/" + fileName;
            }
            UpdateProductServiceForAdmin.getInstance().editProductHaveImage(idSanPham, tenSanPham, moTa, price, khoiLuong, soKGMacDinh, Date.valueOf(ngayNhapHang), Date.valueOf(ngayHetHan),linkAnhSanPham, user.getId(), idNhaCungCap);
            doGet(request,response);
        }
    }
}