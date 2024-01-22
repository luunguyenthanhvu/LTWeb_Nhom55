package nhom55.hcmuaf.beans.wishlist;

import java.util.HashMap;
import java.util.Map;

public class UserWishList {
  private static Map<Integer, WishList> data = new HashMap<>();

  public static WishList getUserWishList(int id) {
    if(data.containsKey(id)) {
      return data.get(id);
    }
    WishList wishList = new WishList();
    data.put(id,wishList);
    return wishList;
  }
}
