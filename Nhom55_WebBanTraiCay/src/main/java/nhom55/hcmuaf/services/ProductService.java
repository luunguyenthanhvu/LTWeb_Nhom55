package nhom55.hcmuaf.services;


import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.database.JDBIConnector;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    private static ProductService instance;


    private ProductService() {
    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    public Products getById(int productId) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT id=? FROM products")
                    .bind("productId", productId)
                    .mapToBean(Products.class)
                    .findOne()
                    .orElse(null);
        });
    }

//    public Product getById(int productId) {
//        return JDBIConnector.get().withHandle(handle -> {
//            return handle.createQuery("SELECT * FROM products")
//                    .mapToBean(Product.class).
//        });
//    }

    public static void main(String[] args) {
        List<Products> listProducts = new ArrayList<>();
        for(Products p : listProducts) {
            System.out.println(p.toString());
        }
    }

}