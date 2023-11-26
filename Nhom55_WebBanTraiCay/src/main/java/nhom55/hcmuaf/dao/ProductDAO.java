package nhom55.hcmuaf.dao;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.database.JDBIConnector;
import org.jdbi.v3.core.Handle;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDAO {

    // lấy ra 8 sản phẩm trong danh sách
    public List<Products> getProduct() {
        return JDBIConnector.get().withHandle(h ->
                h.createQuery("SELECT * FROM Products ORDER BY id ASC LIMIT 8")
                        .mapToBean(Products.class)
                        .stream()
                        .collect(Collectors.toList())
        );
    }

    public List<Products> getListProducts() {
        return JDBIConnector.get().withHandle(h ->
                h.createQuery("SELECT * FROM products ")
                        .mapToBean(Products.class)
                        .stream()
                        .collect(Collectors.toList())
        );
    }
    public int countResultSearchingProduct(String txtSearch) {
        return JDBIConnector.get().withHandle(h ->
                h.select("SELECT count(*)  FROM products where nameOfProduct like ?","%"+txtSearch+"%")
                        .mapTo(Integer.class)
                        .one()

        );
    }

    public List<Products> search(String search, int index, int sizePage) {
        List<Products> result = JDBIConnector.get().withHandle(handle -> {
            // Mở kết nối đến cơ sở dữ liệu
            handle.begin();
            try {
                // Thực hiện câu lệnh SQL với giá trị của index và sizePage thay thế trực tiếp
                List<Products> resultList = handle.createQuery("with testThu as (select ROW_NUMBER() over (order by dateOfImporting ASC) as r,id, nameOfProduct, description, price, weight, weightDefault, dateOfImporting, expriredDay, img, adminCreate, provider from products where nameOfProduct like ?)\n" +
                                "\n" +
                                "select * FROM testThu where r between " + (index * sizePage - 19) + " and " + (index * sizePage))
                        .bind(0, "%" + search + "%")
                        .mapToBean(Products.class)
                        .list();
                // Commit kết nối
                handle.commit();
                return resultList;
            } catch (Exception e) {
                // Xử lý ngoại lệ và rollback kết nối nếu có lỗi
                handle.rollback();
                throw e;
            }
        });
        return result;
    }


    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        List<Products> products = productDAO.search("Chuối",1,20);
        for(Products p: products) {
            System.out.println(p.toString());
        }
//        System.out.println(productDAO.countResultSearchingProduct("Dưa Hấu"));
    }
}
