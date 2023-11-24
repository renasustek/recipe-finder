package com.github.group37.roadmap.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name="users", schema="roadmapProject")

public class User {
    @Id
    @Column(name="id",nullable = false,unique = true,length = 36,columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(name="username", nullable=false, unique=true,length = 36)
    @Size(min = 3, max = 36)
    private String username;

    @Column(name="password", nullable=false, unique=false,length = 100)
    @Size(min = 6, max = 100)
    private String password;

    @Column(name = "enabled", nullable = false,unique = false)
    private boolean enabled;

    public User(UUID id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
