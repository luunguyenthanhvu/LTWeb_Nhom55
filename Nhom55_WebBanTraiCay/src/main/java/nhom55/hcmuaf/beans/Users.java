package nhom55.hcmuaf.beans;

import java.io.Serializable;
import java.time.LocalDate;

public class Users implements Serializable {
    private int id;
    private String username;
    private String password;
    private String hash;
    private String email;
    private String address;
    private String phoneNumber;
    private int status;
    private String img;
    private LocalDate dateOfBirth;
    private String sexual;
    private int role;

    public Users( String username, String password, String email, String address, String phoneNum, int status, String img, LocalDate date, String sexual, int role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNum;
        this.status = status;
        this.img = img;
        this.dateOfBirth = date;
        this.sexual = sexual;
        this.role = role;
    }

    public Users(String username, String password,String hash, String email, String address, String phoneNum, int status) {
        this.username = username;
        this.password = password;
        this.hash = hash;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNum;
        this.status = status;
    }

    public Users( String email, String hash,int status) {
        this.hash = hash;
        this.email = email;
        this.status = status;
    }

    public Users() {
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNum) {
        this.phoneNumber = phoneNum;
    }

    public int getstatus() {
        return status;
    }

    public void setstatus(int status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate date) {
        this.dateOfBirth = date;
    }

    public String getSexual() {
        return sexual;
    }

    public void setSexual(String sexual) {
        this.sexual = sexual;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
