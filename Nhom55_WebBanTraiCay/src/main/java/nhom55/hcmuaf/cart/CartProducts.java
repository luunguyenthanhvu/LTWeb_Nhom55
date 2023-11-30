package nhom55.hcmuaf.cart;

import nhom55.hcmuaf.beans.Products;
import nhom55.hcmuaf.beans.Users;

public class CartProducts {
    private int id;
    private int numOfKg;
    private float totalPrice;
    private int quantity;
    private Users user;
    private Products products;

    public CartProducts(int id, int numOfKg, float totalPrice, int quantity, Users user, Products products) {
        this.id = id;
        this.numOfKg = numOfKg;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.user = user;
        this.products = products;
    }


    public CartProducts(Products products, int quantity) {
        this.products = products;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumOfKg() {
        return numOfKg;
    }

    public void setNumOfKg(int numOfKg) {
        this.numOfKg = numOfKg;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CartProducts{" +
                "id=" + id +
                ", numOfKg=" + numOfKg +
                ", totalPrice=" + totalPrice +
                ", quantity=" + quantity +
                ", user=" + user +
                ", products=" + products +
                '}';
    }

    public boolean increase(int quantity) {
        int num = quantity++;
        if (num <= 0) {
            return false;
        }
        return true;
    }

    public boolean update(int quantity) {
        if(quantity<=0) {
            return false;
        }
        return true;
    }
}