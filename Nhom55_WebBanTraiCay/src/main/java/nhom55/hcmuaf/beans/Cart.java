package nhom55.hcmuaf.beans;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.beans.Users;
import nhom55.hcmuaf.services.ProductService;

public class Cart {
  Map<Integer, Products> data = new HashMap<>();
  Users customer;
  long total;
  int quantity;

  public Cart() {
    this.data = new HashMap<>();
    this.customer = new Users();
    this.total = 0;
    this.quantity = 0;
  }

  public Cart(Users customer, long total, int quantity) {
    this.data = new HashMap<>();
    this.customer = customer;
    this.total = total;
    this.quantity = quantity;
  }
  public void put(Products product) {
    if(data.containsKey(product.getId())) {
      Products p1 = data.get(product.getId());
      p1.setQuantity(p1.getQuantity() + 1);
      data.put(product.getId(), p1);
    } else {
      data.put(product.getId(), product);
    }
    updateTotalMoneyAndQuantity();
  }
  public void put(String key, int quantity) {
   if(data.containsKey(key)) {
      Products p1 = data.get(key);
      p1.setQuantity(quantity);
      data.put(Integer.valueOf(key),p1);
   }
   updateTotalMoneyAndQuantity();
  }

  public void update(Products product) {
    if(data.containsKey(product.getId())) {
      data.put(product.getId(), product);
    }
    updateTotalMoneyAndQuantity();
  }
  public void remove (int key) {
    data.remove(key);
    updateTotalMoneyAndQuantity();
  }
  private void updateTotalMoneyAndQuantity() {
    total = 0;
    quantity = 0;
    for(Products p : data.values()) {
      total += p.getQuantity() * p.getPrice();
      quantity += p.getQuantity();
    }
  }
  public Collection<Products> getListProduct() {
    return data.values();
  }
  public int getQuantity() {
    return quantity;
  }
}
