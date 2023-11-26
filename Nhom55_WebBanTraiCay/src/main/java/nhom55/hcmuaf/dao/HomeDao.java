package nhom55.hcmuaf.dao;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.database.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class HomeDao {
    public List<Products> getProduct() {
        return JDBIConnector.get().withHandle(h ->
                // lấy ra 8 sản phẩm trong danh sách
                h.createQuery("SELECT * FROM Products ORDER BY id ASC LIMIT 8")
                        .mapToBean(Products.class)
                        .stream()
                        .collect(Collectors.toList())
        );
    }
}
