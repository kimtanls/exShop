package com.example.EXshop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users_roles")
public class User_Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "roleId",referencedColumnName = "id")
    private Role role;

    public User_Role() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User_Role(Integer id, User user, Role role) {
        super();
        this.id = id;
        this.user = user;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
