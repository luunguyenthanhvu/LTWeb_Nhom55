package nhom55.hcmuaf.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bills {
    private int id;
    private LocalDateTime orderedDate;
    private  String productList;
    private String status;
    private int userId;
    private int payment;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String phoneNumber;
    private String email;
    private double totalPrice;

    public Bills(int id, LocalDateTime orderedDate, String productList, String status, int userId, int payment, String firstName, String lastName, String streetAddress, String city, String phoneNumber, String email, double totalPrice) {
        this.id = id;
        this.orderedDate = orderedDate;
        this.productList = productList;
        this.status = status;
        this.userId = userId;
        this.payment = payment;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.totalPrice=totalPrice;
    }
    public Bills() {

    }

    @Override
    public String toString() {
        return "Bills{" +
                "id=" + id +
                ", orderedDate=" + orderedDate +
                ", productList='" + productList + '\'' +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                ", payment=" + payment +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(LocalDateTime orderedDate) {
        this.orderedDate = orderedDate;
    }

    public String getProductList() {
        return productList;
    }

    public void setProductList(String productList) {
        this.productList = productList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
