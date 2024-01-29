package com.github.group37.roadmap.percistance.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "roadmapRecources", schema = "roadmapProject")
public class RoadmapRecources {

    @Column(name="id",nullable = false,unique = true,length = 36,columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;


    @ManyToOne
    @JoinColumn(name = "id")
    private RoadmapDao roadmapDao;

    @ManyToOne
    @JoinColumn(name = "id")
    private RevisionRecourceDao revisionRecourceDao;

}
