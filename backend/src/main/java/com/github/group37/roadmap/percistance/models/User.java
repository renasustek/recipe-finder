package com.github.group37.roadmap.percistance.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.util.UUID;

@Entity
@Table(name = "users", schema = "roadmap_project")
public class User {
    @Column(name = "uuid", columnDefinition = "VARCHAR(36)", nullable = false, unique = true, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Id
    @Column(name = "username", nullable = false, unique = true, length = 36)
    @Size(min = 3, max = 36)
    private String username;

    @Column(name = "password", nullable = false, unique = false, length = 100)
    @Size(min = 6, max = 100)
    private String password;

    @Column(name = "enabled", nullable = false, unique = false)
    private boolean enabled;

    public User(UUID id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = true;
    }

    public User() {
        // ignore, created to keep spring auth happy
    }

    public User(UUID uuid, String abdi, String smith, boolean b) {}

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + username + '\'' + ", password='" + password + '\'' + '}';
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
