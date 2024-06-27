package com.elthobhy.barbershop.web.viewmodel;

public class OrderTeamViewModel {
    private int id;
    private int teamId;
    private int orderId;
    private TeamViewModel masterTeam;
    private OrderViewModel transactionOrder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public TeamViewModel getMasterTeam() {
        return masterTeam;
    }

    public void setMasterTeam(TeamViewModel masterTeam) {
        this.masterTeam = masterTeam;
    }

    public OrderViewModel getTransactionOrder() {
        return transactionOrder;
    }

    public void setTransactionOrder(OrderViewModel transactionOrder) {
        this.transactionOrder = transactionOrder;
    }

}
