package nhom55.hcmuaf.cart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.services.ProductService;

public class Cart {

  private Map<Integer, CartProduct> data = new HashMap<>();

  public String add(int add) {
    return add(add, 1);
  }

  public String add(int add, int quantity) {
    Products p = ProductService.getInstance().getById(add);
    if (p == null) {
      return "Product does not exist";
    }
    CartProduct cartProduct = null;
    if (data.containsKey(add)) {
      cartProduct = data.get(add);
      if(cartProduct.getQuantity() + quantity < cartProduct.getProducts().getWeight()) {
        cartProduct.increQuantity(quantity);
      } else {
        return "Out of quantity";
      }
    } else {
      cartProduct = new CartProduct(quantity, p);
    }
    data.put(add, cartProduct);
    return "Success";
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
      if(cartProduct.getQuantity() == 1) {
        deleteProduct(id);
        return true;
      } else {
        cartProduct.decreQuantity(quantity);
      }
    } else {
      return false;
    }
    data.put(id, cartProduct);
    return true;
  }
  public void deleteProduct(int id) {
    if(data.containsKey(id)) {
      data.remove(id);
    }
  }

  public int getTotal() {
    return data.size();
  }

  public Collection<CartProduct> getCartProduct() {
    return data.values();
  }
  public List<CartProduct> getSelectedProducts(List<String> selectedProductIds) {
    List<CartProduct> result = new ArrayList<>();
    for(String id : selectedProductIds) {
      if(data.containsKey(Integer.parseInt(id))) {
        result.add(data.get(Integer.parseInt(id)));
      }
    }
    return result;
  }

}
