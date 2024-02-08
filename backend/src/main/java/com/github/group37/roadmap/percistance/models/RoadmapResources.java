package com.github.group37.roadmap.percistance.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "roadmap_resources", schema = "roadmap_project")
public class RoadmapResources {

    @Id
    @Column(name="id",nullable = false,unique = true,length = 36,columnDefinition = "VARBINARY(36)")
    private UUID id;


    @Column(name = "roadmap_id", nullable=false,length = 36)
    private UUID roadmapId;

    @Column(name = "revision_resource_id", nullable=false,length = 36)
    private UUID revisionResourceId;


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

    public UUID getRevisionResourceId() {
        return revisionResourceId;
    }

    public void setRevisionResourceId(UUID revisionResourceId) {
        this.revisionResourceId = revisionResourceId;
    }
}
