package nhom55.hcmuaf.cart;

import nhom55.hcmuaf.beans.Products;

public class CartProduct {

  private int quantity;
  private Products products;

  public CartProduct(int quantity, Products products) {
    this.quantity = quantity;
    this.products = products;
  }

  public CartProduct() {
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Products getProducts() {
    return products;
  }

  public void setProducts(Products products) {
    this.products = products;
  }

  public void increQuantity(int quantity) {
    this.quantity += quantity;
  }
  public void decreQuantity(int quantity) {
    this.quantity -= quantity;
    if(quantity <= 0) {
      this.quantity += quantity;
    }
  }

  @Override
  public String toString() {
    return "CartProduct{" +
        "quantity=" + quantity +
        ", products=" + products +
        '}';
  }
}
