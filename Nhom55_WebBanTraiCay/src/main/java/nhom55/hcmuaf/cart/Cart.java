package nhom55.hcmuaf.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.services.ProductService;

public class Cart {

  private Map<Integer, CartProduct> data = new HashMap<>();

  public boolean add(int add) {
    return add(add, 1);
  }

  public boolean add(int add, int quantity) {
    Products p = ProductService.getInstance().getById(add);
    if (p == null) {
      return false;
    }
    CartProduct cartProduct = null;
    if (data.containsKey(add)) {
      cartProduct = data.get(add);
      cartProduct.increQuantity(quantity);
    } else {
      cartProduct = new CartProduct(quantity, p);
    }
    data.put(add, cartProduct);
    return true;
  }
  public boolean remove(int id) {
    return remove(id, 1);
  }
  public boolean remove(int id, int quantity) {
    Products p = ProductService.getInstance().getById(id);
    if (p == null) {
      return false;
    }
    CartProduct cartProduct = null;
    if (data.containsKey(id)) {
      cartProduct = data.get(id);
      cartProduct.decreQuantity(quantity);
    } else {
      return false;
    }
    data.put(id, cartProduct);
    return true;
  }
  public boolean deleteProduct(int id) {
    if(data.containsKey(id)) {
      data.remove(id);
      return true;
    }
    return false;
  }

  public int getTotal() {
    return data.size();
  }

  public Collection<CartProduct> getCartProduct() {
    return data.values();
  }

}
