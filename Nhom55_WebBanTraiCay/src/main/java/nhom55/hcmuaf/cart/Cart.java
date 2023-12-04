package nhom55.hcmuaf.cart;

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
    getAll();
    return true;
  }

  public int getTotal() {
    return data.size();
  }

  public void getAll() {
    for(CartProduct c : data.values()) {
      System.out.println(c);
    }
  }

}
