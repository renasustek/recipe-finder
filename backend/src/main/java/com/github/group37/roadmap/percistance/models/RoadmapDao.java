package com.github.group37.roadmap.percistance.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "roadmap", schema = "roadmap_project")
public class RoadmapDao {

    @Id
    @Column(name="id",nullable = false,unique = true,length = 36,columnDefinition = "VARBINARY(36)")
    private UUID id;

    @Column(name="username", nullable=false, unique=true,length = 36)
    @Size(min = 3, max = 36)
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


}
