package com.github.group37.roadmap.percistance.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "roadmapRecources", schema = "roadmapProject")
public class RoadmapRecources {

    @Id
    @Column(name="id",nullable = false,unique = true,length = 36,columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;


    @Column(name = "roadmapId")
    private UUID roadmapId;

    @Column(name = "revisionRecourceId")
    private UUID revisionRecourceId;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRoadmapId() {
        return roadmapId;
    }

    public void setRoadmapId(UUID roadmapId) {
        this.roadmapId = roadmapId;
    }

    public UUID getRevisionRecourceId() {
        return revisionRecourceId;
    }

    public void setRevisionRecourceId(UUID revisionRecourceId) {
        this.revisionRecourceId = revisionRecourceId;
    }
}
