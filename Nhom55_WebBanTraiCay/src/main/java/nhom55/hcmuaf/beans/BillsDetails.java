package nhom55.hcmuaf.beans;

import java.sql.PreparedStatement;
import nhom55.hcmuaf.database.JDBIConnector;

public class BillsDetails {

  private int quantity;
  private int id;
  private double totalPrice;
  private Products products;
  private Bills bills;

  public BillsDetails(int quantity, int id, double totalPrice, Products products, Bills bills) {
    this.quantity = quantity;
    this.id = id;
    this.totalPrice = totalPrice;
    this.products = products;
    this.bills = bills;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Products getProducts() {
    return products;
  }

  public void setProducts(Products products) {
    this.products = products;
  }

  public Bills getBills() {
    return bills;
  }

  public void setBills(Bills bills) {
    this.bills = bills;
  }

  public BillsDetails() {
  }

  @Override
  public String toString() {
    return "BillsDetails{" +
        "quantity=" + quantity +
        ", id=" + id +
        ", totalPrice=" + totalPrice +
        ", products=" + products +
        ", bills=" + bills +
        '}';
  }

  public static void main(String[] args) {

    BillsDetails billsDetails = JDBIConnector.get().withHandle(handle -> {
      int billsDetailsId = 1;
      String sql =
          "SELECT bd.id, bd.quantity, bd.totalPrice, p.id as idProduct, p.nameOfProduct, p.description, p.price "
              +
              "FROM bill_details bd " +
              "JOIN products p ON bd.idProduct = p.id " +
              "WHERE bd.id = ?";

      // Ánh xạ kết quả vào đối tượng BillsDetails và Product
      return handle.createQuery(sql)
          .bind(0, billsDetailsId)
          .map((rs, ctx) -> {
            BillsDetails bd = new BillsDetails();
            bd.setId(rs.getInt("id"));
            bd.setQuantity(rs.getInt("quantity"));
            bd.setTotalPrice(rs.getDouble("totalPrice"));

            Products p = new Products();
            p.setId(rs.getInt("idProduct"));
            p.setNameOfProduct(rs.getString("nameOfProduct"));
            p.setDescription(rs.getString("description"));
            p.setPrice(rs.getDouble("price"));

            bd.setProducts(p);

            return bd;
          })
          .findFirst()
          .orElse(null);
    });
    System.out.println(billsDetails);
  }

}
