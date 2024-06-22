package com.elthobhy.barbershop.datamodels;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    @OneToMany(mappedBy = "transactionOrder")
    private List<TransactionOrderServices> orderServices;

    @OneToOne(mappedBy = "transactionOrder")
    private TransactionOrderTeam orderTeams;

    @Column(name = "orderDate")
    private LocalDateTime orderDate;
    @Column(name = "status")
    private StatusOrder status;

    public TransactionOrderTeam getOrderTeams() {
        return orderTeams;
    }

    public void setOrderTeams(TransactionOrderTeam orderTeams) {
        this.orderTeams = orderTeams;
    }

    public List<TransactionOrderServices> getOrderServices() {
        return orderServices;
    }

    public void setOrderServices(List<TransactionOrderServices> orderServices) {
        this.orderServices = orderServices;
    }

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
