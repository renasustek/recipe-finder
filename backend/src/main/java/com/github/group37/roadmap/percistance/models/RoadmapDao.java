package com.github.group37.roadmap.percistance.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "roadmap", schema = "roadmapProject")
public class RoadmapDao {

    @Id
    @Column(name="id",nullable = false,unique = true,length = 36,columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(name="username", nullable=false, unique=true,length = 36)
    @Size(min = 3, max = 36)
    private String userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private User user;

    @OneToMany(mappedBy = "roadmap")
    private Set<RoadmapRecources> roadmapRecources = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
