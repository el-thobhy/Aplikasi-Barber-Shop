package com.elthobhy.barbershop.web.viewmodel;

public class TeamViewModel {
    private int id;
    private String name;
    private RoleTeam role;
    private String phone;
    private String email;
    private TeamStatus status;

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

    public RoleTeam getRole() {
        return role;
    }

    public void setRole(RoleTeam role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TeamStatus getStatus() {
        return status;
    }

    public void setStatus(TeamStatus status) {
        this.status = status;
    }
}
