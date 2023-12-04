package nhom55.hcmuaf.services;


import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.dao.ProductDAO;
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
    static Map<String, String> data = new HashMap<>();
    private ProductDAO productDAO;

    private ProductService() {
        productDAO = new ProductDAO();
    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    /**
     * get product by product id
     * @param productId
     * @return
     */
    public Products getById(int productId) {
        return productDAO.getProductById(productId);
    }

//    public Product getById(int productId) {
//        return JDBIConnector.get().withHandle(handle -> {
//            return handle.createQuery("SELECT * FROM products")
//                    .mapToBean(Product.class).
//        });
//    }

    // In ra 8 sản phẩm trên trang index
    public List<Products> getProduct() {
        // Gọi phương thức getProduct từ ProductDAO
        ProductDAO productDAO = new ProductDAO();
        return productDAO.getProduct();
    }

    // hiển thị chi tiết sản phẩm
    public Products showProductDetails(int productId) {
        // Gọi phương thức showProductDetails từ ProductDAO
        ProductDAO productDAO = new ProductDAO();
        return productDAO.showProductDetails(productId);
    }
    public static void main(String[] args) {
        List<Products> listProducts = new ArrayList<>();
        for(Products p : listProducts) {
            System.out.println(p.toString());
        }

        int productIdToDisplay = 1; // ID của sản phẩm bạn muốn hiển thị chi tiết
        Products productDetails = ProductService.getInstance().showProductDetails(productIdToDisplay);
        if (productDetails != null) {
            System.out.println("Product Details: " + productDetails.toString());
        } else {
            System.out.println("Product not found with ID: " + productIdToDisplay);
        }
    }

}