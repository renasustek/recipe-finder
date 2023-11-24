package com.github.group37.roadmap.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Random;
import java.util.UUID;

@Entity
@Table(name="users", schema="roadmapProject")

public class User {
//    @Id
//    @Column(name="id",nullable = false,unique = true,length = 36,columnDefinition = "VARCHAR(36)")
//    @JdbcTypeCode(SqlTypes.VARCHAR)
//    private UUID id;

    @Id
    @Column(name="username", nullable=false, unique=true,length = 36)
    @Size(min = 3, max = 36)
    private String username;

    @Column(name="password", nullable=false, unique=false,length = 100)
    @Size(min = 6, max = 100)
    private String password;

    @Column(name = "enabled", nullable = false,unique = false)
    private boolean enabled;

    private UUID id;

    public User(UUID id, String username, String password){
        this.username = username;
        this.password = password;
        this.enabled = true;
    }

    public User(){
     //ignore, created to keep spring auth happy
    }
    @Override
    public String toString() {
        return "User{" +

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
