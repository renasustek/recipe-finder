package com.github.group37.roadmap.Models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="users", schema="roadmapProject")

public class User {
    @Id
    private UUID id;

    @Column(name="name", nullable=false, unique=false)
    private String name;

    @Column(name="password", nullable=false, unique=false)
    private String password;

    public User(UUID id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
