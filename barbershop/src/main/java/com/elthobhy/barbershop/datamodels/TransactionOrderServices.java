package com.elthobhy.barbershop.datamodels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction_order_services")
public class TransactionOrderServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "orderId")
    private int orderId;
    @Column(name = "serviceId")
    private int serviceId;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false, insertable = false, updatable = false)
    private TransactionOrder transactionOrder;

    @ManyToOne
    @JoinColumn(name = "serviceId", nullable = false, insertable = false, updatable = false)
    private MasterServices masterServices;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTransactionOrder(TransactionOrder transactionOrder) {
        this.transactionOrder = transactionOrder;
    }

    public MasterServices getMasterServices() {
        return masterServices;
    }

    public void setMasterServices(MasterServices masterServices) {
        this.masterServices = masterServices;
    }

}
