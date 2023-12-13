package nhom55.hcmuaf.cart;

import nhom55.hcmuaf.beans.Products;

public class CartProduct {

  private int quantity;
  private Products products;
  private double price;

  public CartProduct(int quantity, Products products) {
    this.quantity = quantity;
    this.products = products;
    this.price = products.getPrice() * quantity;
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

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void increQuantity(int quantity) {
    this.quantity += quantity;
    this.price += products.getPrice() * quantity;
  }
  public void decreQuantity(int quantity) {
    this.quantity -= quantity;
    this.price -= products.getPrice() * quantity;
  }

  @Override
  public String toString() {
    return "CartProduct{" +
        "quantity=" + quantity +
        ", products=" + products +
        '}';
  }
}