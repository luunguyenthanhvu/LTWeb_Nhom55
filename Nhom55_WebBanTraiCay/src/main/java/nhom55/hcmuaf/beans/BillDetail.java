package nhom55.hcmuaf.beans;

public class BillDetail {
    private int id;
    private String img;
    private String nameOfProduct;
    private String description;
    private double price;
    private int quantity;
    private double totalPrice;


    public BillDetail(int id,String img, String nameOfProduct, String description, double price, int quantity, double totalPrice) {
        this.img = img;
        this.nameOfProduct = nameOfProduct;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.id = id;
    }
    public BillDetail() {

    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "img='" + img + '\'' +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", idProduct=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
