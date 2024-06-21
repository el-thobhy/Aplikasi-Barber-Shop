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
@Table(name = "transaction_order_team")
public class TransactionOrderTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "teamId")
    private int teamId;
    @Column(name = "orderId")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "teamId", nullable = false, insertable = false, updatable = false)
    private MasterTeam masterTeam;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false, insertable = false, updatable = false)
    private TransactionOrder transactionOrder;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MasterTeam getMasterTeam() {
        return masterTeam;
    }

    public void setMasterTeam(MasterTeam masterTeam) {
        this.masterTeam = masterTeam;
    }

    public TransactionOrder getTransactionOrder() {
        return transactionOrder;
    }

    public void setTransactionOrder(TransactionOrder transactionOrder) {
        this.transactionOrder = transactionOrder;
    }
}
