package nhom55.hcmuaf.cart;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.dao.ProductDAO;
import nhom55.hcmuaf.services.ProductService;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    Map<Integer, CartProducts> cartProducts = new HashMap<>();

    public Cart(){

    }

    public boolean add(int productId, int quantity) {
        Products products = ProductService.getInstance().getById(productId);
        if(products==null) return false;
        if(cartProducts.containsKey(productId)) {
            return cartProducts.get(productId).increase(quantity);
        }
        cartProducts.put(productId, new CartProducts(products,quantity));
        return true;
    }

    public boolean remove(int productId) {
        if(!cartProducts.containsKey(productId)) return false;
        cartProducts.remove(productId);
        return true;
    }

    public boolean update(int productId, int quantity) {
        if(!cartProducts.containsKey(productId)) return false;
        CartProducts cart = cartProducts.get(productId);
        return cart.update(quantity);
    }

    public int getQuantity() {
        return cartProducts.size();
    }
}
