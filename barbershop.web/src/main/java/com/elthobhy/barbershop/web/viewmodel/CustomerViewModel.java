package com.elthobhy.barbershop.web.viewmodel;

import java.util.List;

public class CustomerViewModel {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;

    private List<OrderViewModel> orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderViewModel> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderViewModel> orders) {
        this.orders = orders;
    }
}
