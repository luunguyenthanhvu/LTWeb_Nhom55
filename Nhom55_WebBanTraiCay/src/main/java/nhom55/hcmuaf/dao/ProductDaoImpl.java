package nhom55.hcmuaf.dao;

import java.util.Date;
import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.database.JDBIConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDaoImpl implements ProductDao {

  /**
   * get product by id
   *
   * @return
   */
  @Override
  public Products getProductById(int id) {
    return JDBIConnector.get().withHandle(handle -> {
      return handle.createQuery("SELECT * FROM products where ID = :productId")
          .bind("productId", id)
          .mapToBean(Products.class)
          .findOne()
          .orElse(null);
    });
  }

  // Xuất ra toàn bộ sản phẩm lấy từ database
  // In ra 8 sản phẩm trên trang index
  @Override
  public List<Products> getProduct() {
    return JDBIConnector.get().withHandle(h ->
        h.createQuery("SELECT * FROM Products ORDER BY id ASC LIMIT 8")
            .mapToBean(Products.class)
            .stream()
            .collect(Collectors.toList())
    );
  }


  // hiển thị chi tiết sản phẩm
  @Override
  public Products showProductDetails(int productId) {
    return JDBIConnector.get().withHandle(h ->
        // hiển thị sản phẩm vs id được truyền vào
        h.createQuery(
                "SELECT id, nameOfProduct, description, price, img, weight, weightDefault FROM Products WHERE id = :id")
            .bind("id", productId)
            .mapToBean(Products.class)
            .findFirst()
            .orElse(null)); // không tìm thấy id trả về null
  }


  @Override
  public List<Products> getListProducts() {
    return JDBIConnector.get().withHandle(h ->
        h.createQuery("SELECT * FROM products ")
            .mapToBean(Products.class)
            .stream()
            .collect(Collectors.toList())
    );
  }

  //    Đếm số sản phầm tìm được
  @Override
  public int countResultSearchingProduct(String txtSearch) {
    return JDBIConnector.get().withHandle(h ->
        h.select("SELECT count(*)  FROM products where nameOfProduct like ?", "%" + txtSearch + "%")
            .mapTo(Integer.class)
            .one()

    );
  }

  //   tìm kiếm của shop
  @Override
  public List<Products> search(String search, int index, int sizePage) {
    List<Products> result = JDBIConnector.get().withHandle(handle -> {
      // Mở kết nối đến cơ sở dữ liệu
      handle.begin();
      try {
        // Thực hiện câu lệnh SQL với giá trị của index và sizePage thay thế trực tiếp
        List<Products> resultList = handle.createQuery(
                "with testThu as (select ROW_NUMBER() over (order by " + "dateOfImporting"
                    + "  desc) as r,id, nameOfProduct, description, price, weight, weightDefault, dateOfImporting, expriredDay, img, adminCreate, provider from products where nameOfProduct like ?)\n"
                    +
                    "\n" +
                    "select * FROM testThu where r between " + (index * sizePage - 19) + " and " + (
                    index * sizePage))
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

  @Override
  public List<Products> searchFilter(String sortBy, String order, String search, int index,
      int sizePage) {
    List<Products> resultList = JDBIConnector.get().withHandle(h ->
        h.createQuery("with testThu as (select ROW_NUMBER() over (order by " + sortBy + " " + order
                + ") as r, id, nameOfProduct, description, price, weight, weightDefault, dateOfImporting, expriredDay, img, adminCreate, provider from products where nameOfProduct like :search)\n"
                +
                "\n" +
                "select * FROM testThu where r between :startIndex and :endIndex")
            .bind("search", "%" + search + "%")
            .bind("startIndex", (index * sizePage - 19))
            .bind("endIndex", (index * sizePage))
            .mapToBean(Products.class)
            .list());

    return resultList;
  }

  //    Lấy 20 sản phẩm cho mỗi trang
  @Override
  public List<Products> get20ProductsForEachPage(int index, int quantityDefault) {
    List<Products> result = new ArrayList<>();
    int start = (index - 1) * quantityDefault;

    result = JDBIConnector.get().withHandle(h ->
        h.createQuery(
                "SELECT * FROM products ORDER BY dateOfImporting DESC LIMIT :start, :quantityDefault")
            .bind("start", start)
            .bind("quantityDefault", quantityDefault)
            .mapToBean(Products.class)
            .list()
    );

    return result;
  }


  //    Đếm Số dòng record của tất cả sản phẩm trong database
  @Override
  public int countTotalRowProductInDatabase() {
    return JDBIConnector.get().withHandle(h ->
        h.createQuery("SELECT COUNT(id) FROM products").mapTo(Integer.class).one()
    );
  }

  //    Filter
//    Sắp xếp theo điều kiện filter (option: tên, giá, ngày nhập khẩu, filter:asc,desc)
  @Override
  public List<Products> sortByFilter(int index, int quantityDefault, String sortBy, String order) {
    List<Products> result = new ArrayList<>();
    int start = (index - 1) * quantityDefault;

    String orderByClause = "";
    switch (sortBy) {
      case "nameOfProduct":
      case "dateOfImporting":
      case "price":

        orderByClause = String.format("ORDER BY %s %s", sortBy, order);
        break;

    }

    String query = String.format("SELECT * FROM products %s LIMIT :start, :quantityDefault",
        orderByClause);

    result = JDBIConnector.get().withHandle(h ->
        h.createQuery(query)
            .bind("start", start)
            .bind("quantityDefault", quantityDefault)
            .mapToBean(Products.class)
            .list()
    );

    return result;
  }

  @Override
  public void addNewProduct(String productName, String description, double price,
      double weightQuantity, double weightDefault, Date dateImport, Date expirationDate,
      String imgProduct, int adminId, int provider) {
    Products products = JDBIConnector.get().withHandle(h -> {
      return h.createQuery("SELECT * FROM products WHERE nameOfProduct = :name")
          .bind("name", productName)
          .mapToBean(Products.class)
          .findFirst()
          .orElse(null); // hoặc thực hiện xử lý khi không tìm thấy dữ liệu
    });

    // if products != null update product
    if (products != null) {

    } else {
      JDBIConnector.get().withHandle(h -> {
        return h.createUpdate(
                "INSERT INTO products(nameOfProduct, description, price, weight, weightDefault, dateOfImporting, expriredDay, img, adminCreate, provider) "
                    + "VALUES (:nameOfProduct, :description, :price, :weight, :weightDefault, :dateOfImporting, :expriredDay, :img, :adminCreate, :provider)")
            .bind("nameOfProduct", productName)
            .bind("description", description)
            .bind("price", price)
            .bind("weight", weightQuantity)
            .bind("weightDefault", weightDefault)
            .bind("dateOfImporting", dateImport)
            .bind("expriredDay", expirationDate)
            .bind("img", imgProduct)
            .bind("adminCreate", adminId)
            .bind("provider", provider)
            .execute();
      });
    }
  }
}