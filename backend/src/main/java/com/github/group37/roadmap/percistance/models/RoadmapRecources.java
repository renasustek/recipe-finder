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


    @ManyToOne
    @JoinColumn(name = "roadmapId", referencedColumnName = "id")
    private RoadmapDao roadmapDao;

    @ManyToOne
    @JoinColumn(name = "revisionRecourceId", referencedColumnName = "id")
    private RevisionRecourceDao revisionRecourceDao;

}
