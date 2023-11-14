package com.github.group37.roadmap.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import jakarta.validation.*;
import java.util.UUID;

@Entity
@Table(name="users", schema="roadmapProject")

public class User {
    @Id
    @Column(name="id",nullable = false,unique = true,length = 36,columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)

    private UUID id;

    @Column(name="name", nullable=false, unique=false,length = 36)
    @Size(min = 3, max = 36)
    private String name;

    @Column(name="password", nullable=false, unique=false,length = 36)
    @Size(min = 6, max = 36)
    private String password;

    public User(UUID id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(){

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
