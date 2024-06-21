package com.elthobhy.barbershop.datamodels;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction_order")
public class TransactionOrder extends BaseEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "customerId")
    private int customerId;

    @ManyToOne
    @JoinColumn(name = "customerId", insertable = false, updatable = false)
    private MasterCustomer masterCustomer;

    @Column(name = "orderDate")
    @CreationTimestamp
    private LocalDateTime orderDate;
    @Column(name = "status")
    private StatusOrder status;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MasterCustomer getMasterCustomer() {
        return masterCustomer;
    }

    public void setMasterCustomer(MasterCustomer masterCustomer) {
        this.masterCustomer = masterCustomer;
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
