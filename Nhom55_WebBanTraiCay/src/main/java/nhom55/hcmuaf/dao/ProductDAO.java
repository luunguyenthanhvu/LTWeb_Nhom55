package nhom55.hcmuaf.dao;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.database.JDBIConnector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDAO {

    //    Xuất ra toàn bộ sản phẩm lấy từ database
    // In ra 8 sản phẩm trên trang index
    public List<Products> getProduct() {
        return JDBIConnector.get().withHandle(h ->
                h.createQuery("SELECT id,nameOfProduct,price,img,dateOfImporting FROM Products ORDER BY dateOfImporting DESC LIMIT 8")
                        .mapToBean(Products.class)
                        .stream()
                        .collect(Collectors.toList())
        );
    }


    // hiển thị chi tiết sản phẩm
    public Products showProductDetails(int productId) {
        return JDBIConnector.get().withHandle(h ->
                // hiển thị sản phẩm vs id được truyền vào
                h.createQuery("SELECT nameOfProduct, description, price, img, weight, weightDefault FROM Products WHERE id = :id")
                        .bind("id", productId)
                        .mapToBean(Products.class)
                        .findFirst()
                        .orElse(null)); // không tìm thấy id trả về null
    }


    public List<Products> getListProducts() {
        return JDBIConnector.get().withHandle(h ->
                h.createQuery("SELECT * FROM products ")
                        .mapToBean(Products.class)
                        .stream()
                        .collect(Collectors.toList())
        );
    }

    //    Đếm số sản phầm tìm được
    public int countResultSearchingProduct(String txtSearch) {
        return JDBIConnector.get().withHandle(h ->
                h.select("SELECT count(*)  FROM products where nameOfProduct like ?","%"+txtSearch+"%")
                        .mapTo(Integer.class)
                        .one()

        );
    }
//   tìm kiếm của shop
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
//    Lấy 20 sản phẩm cho mỗi trang
public List<Products> get20ProductsForEachPage(int started, int quantityDefault) {
    List<Products> result = new ArrayList<>();
    int offset = (started - 1) * quantityDefault;

    result = JDBIConnector.get().withHandle(h ->
            h.createQuery("SELECT * FROM products LIMIT :offset, :limit")
                    .bind("offset", offset)
                    .bind("limit", quantityDefault)
                    .mapToBean(Products.class)
                    .list()
    );


return result;

}
    //    Đếm Số dòng record của tất cả sản phẩm trong database
    public int countTotalRowProductInDatabase() {
        return JDBIConnector.get().withHandle(h ->
                h.createQuery("SELECT COUNT(id) FROM products").mapTo(Integer.class).one()
        );
    }

    //    Filter
//    Sắp xếp tên tăng dần
    public List<Products> sortByNameIncrease(List<Products> list) {
        List<Products> result = list;

        Collections.sort(result, new Comparator<Products>() {
            @Override
            public int compare(Products o1, Products o2) {
                return o1.getNameOfProduct().compareTo(o2.getNameOfProduct());
            }
        });


        return  result;
    }
//    Sắp xếp tên giảm dần
    public List<Products> sortByNameDecrease(List<Products> list) {
        List<Products> result = list;

        Collections.sort(result, new Comparator<Products>() {
            @Override
            public int compare(Products o1, Products o2) {
                return o2.getNameOfProduct().compareTo(o1.getNameOfProduct());
            }
        });


        return  result;
    }
//    Sắp xếp theo giá tăng dần
public List<Products> sortByPriceIncrease(List<Products> list) {
    List<Products> result = list;

    Collections.sort(result, new Comparator<Products>() {
        @Override
        public int compare(Products o1, Products o2) {
            return (int) (o1.getPrice()-o2.getPrice());
        }
    });


    return  result;
}
    //    Sắp xếp theo giá giảm dần
    public List<Products> sortByPriceDecrease(List<Products> list) {
        List<Products> result = list;

        Collections.sort(result, new Comparator<Products>() {
            @Override
            public int compare(Products o1, Products o2) {
                return (int) (o2.getPrice()-o1.getPrice());
            }
        });


        return  result;
    }
    //    Sắp xếp theo ngày nhập khẩu
    public List<Products> sortByDateImporting(List<Products> list) {
        List<Products> result = list;

        Collections.sort(result, new Comparator<Products>() {
            @Override
            public int compare(Products o1, Products o2) {
                return o2.getDateOfImporting().compareTo(o1.getDateOfImporting());
            }
        });


        return  result;
    }

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        List<Products> products = productDAO.search("Chuối",1,20);
//        for(Products p: products) {
//            System.out.println(p.toString());
//        }
//        System.out.println(productDAO.countResultSearchingProduct("Dưa Hấu"));
        System.out.println(productDAO.countTotalRowProductInDatabase());
    }
}
