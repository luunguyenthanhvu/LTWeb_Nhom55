package nhom55.hcmuaf.beans.cart;

import java.util.HashMap;
import java.util.Map;

public class UserCart {
  private static Map<Integer, Cart> userCart = new HashMap<>();

  public static Cart getUserCart(int userId) {
    if(userCart.containsKey(userId)) {
      return userCart.get(userId);
    }
    Cart cart = new Cart();
    userCart.put(userId,cart);
    return cart;
  }
  public static void updateCart(int userId, Cart cart) {
    // Cập nhật giỏ hàng trong map
    userCart.put(userId, cart);
  }
}
