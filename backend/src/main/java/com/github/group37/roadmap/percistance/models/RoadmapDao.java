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
@Table(name = "roadmap", schema = "roadmap_project")
public class RoadmapDao {

    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36)", nullable = false, unique = true, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(name = "username", nullable = false, unique = true, length = 36)
    @Size(min = 3, max = 36)
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
