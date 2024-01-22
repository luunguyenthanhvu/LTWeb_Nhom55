package nhom55.hcmuaf.beans.wishlist;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.services.ProductService;

public class WishList {

  private static Map<Integer, Products> data = new HashMap<>();

  public String add(int idProduct) {
    Products p = ProductService.getInstance().getById(idProduct);
    if (p == null) {
      return "Product does not exist";
    } else if (data.containsKey(p.getId())) {
      return "Product in wish list";
    }
    data.put(p.getId(), p);
    return "Success";
  }

  public String remove(int idProduct) {
    Products p = ProductService.getInstance().getById(idProduct);
    if (p == null) {
      return "Product does not exist";
    } else if (data.containsKey(p.getId())) {
      data.remove(idProduct);
      return "Remove success";
    }
    return "Product does not in wish list";
  }

  public Collection<Products> getAllProducts() {
    return data.values();
  }
}
