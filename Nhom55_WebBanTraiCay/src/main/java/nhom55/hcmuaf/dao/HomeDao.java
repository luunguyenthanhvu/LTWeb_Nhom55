package nhom55.hcmuaf.dao;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.database.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class HomeDao {
    public List<Products> get8Products() {
        return JDBIConnector.get().withHandle(h ->
                h.createQuery("SELECT TOP 8 * FROM products ")
                        .mapToBean(Products.class)
                        .stream()
                        .collect(Collectors.toList())
        );
    }
}
