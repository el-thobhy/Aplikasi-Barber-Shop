package com.elthobhy.barbershop.web.viewmodel;

import java.time.LocalDateTime;
import java.util.List;

public class OrderViewModel {
    private int id;
    private int customerId;
    private CustomerViewModel masterCustomer;
    private List<OrderServicesViewModel> orderServices;
    private OrderTeamViewModel orderTeams;
    private LocalDateTime orderDate;
    private StatusOrder status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public CustomerViewModel getMasterCustomer() {
        return masterCustomer;
    }

    public void setMasterCustomer(CustomerViewModel masterCustomer) {
        this.masterCustomer = masterCustomer;
    }

    public List<OrderServicesViewModel> getOrderServices() {
        return orderServices;
    }

    public void setOrderServices(List<OrderServicesViewModel> orderServices) {
        this.orderServices = orderServices;
    }

    public OrderTeamViewModel getOrderTeams() {
        return orderTeams;
    }

    public void setOrderTeams(OrderTeamViewModel orderTeams) {
        this.orderTeams = orderTeams;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOrder status) {
        this.status = status;
    }
}
