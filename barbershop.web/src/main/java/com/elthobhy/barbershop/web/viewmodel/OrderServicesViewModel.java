package com.elthobhy.barbershop.web.viewmodel;

public class OrderServicesViewModel {
    private int id;
    private int orderId;
    private int serviceId;
    private OrderViewModel transactionOrder;
    private ServicesViewModel masterServices;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public OrderViewModel getTransactionOrder() {
        return transactionOrder;
    }

    public void setTransactionOrder(OrderViewModel transactionOrder) {
        this.transactionOrder = transactionOrder;
    }

    public ServicesViewModel getMasterServices() {
        return masterServices;
    }

    public void setMasterServices(ServicesViewModel masterServices) {
        this.masterServices = masterServices;
    }

}
