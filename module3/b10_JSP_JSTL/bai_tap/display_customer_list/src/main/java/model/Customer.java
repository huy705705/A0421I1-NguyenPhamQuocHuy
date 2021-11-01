package model;

import java.util.Date;

public class Customer {
    String name;
    String birthday;
    String address;
    String describe;

    public Customer() {
    }

    public Customer(String name, String birthday, String address, String describe) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
