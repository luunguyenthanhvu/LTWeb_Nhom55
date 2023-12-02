package nhom55.hcmuaf.beans;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class Cart {
  private TreeMap<Integer, Products> data;

  public Cart() {
    data = new TreeMap<Integer, Products>();
  }

  /**
   * get the size of user cart
   * @return cart size
   */
  public int size() {
    return data.size();
  }

  /**
   * get total money user add to cart
   * @return total money
   */
  public double total() {
    Collection<Products> listProduct = data.values();
    Iterator<Products> items = listProduct.iterator();
    double total = 0;
    Products product = null;
    while (items.hasNext()) {
      product = items.next();
      total += (product.getWeight() * product.getPrice());
    }
    return total;
  }

  /**
   * user add new product to his/her cart
   * @param product
   * @return result boolean
   */
  public boolean addProduct(Products product) {
    Products valid = data.get(product.getId());
    if(valid == null) {
      data.put(product.getId(), product);
      return true;
    }
    return false;
  }

  /**
   * remove product from cart
   * @param id
   * @return result boolean
   */
  public boolean deleteProduct(int id) {
    return data.remove(id) == null ? false : true;
  }

  /**
   *
   * @param id
   * @param count
   * @return
   */
  public boolean update(Long id, int count) {
    Products product = data.get(id);
    if(product != null) {
      product.setWeight(count);
      return true;
    }
    return false;
  }
}
