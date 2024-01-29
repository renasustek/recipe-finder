package com.github.group37.roadmap.percistance.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "revisionRecource", schema = "roadmapProject")
public class RevisionRecourceDao {
    @Id
    @Column(name="id",nullable = false,unique = true,length = 36,columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(name="topic", nullable=false, unique=false,length = 100)
    @Size(min = 3, max = 20)
    private String topic;

    @Column(name="name", nullable=false, unique=false,length = 100)
    @Size(min = 3, max = 20)
    private String name;

    @Column(name="description", nullable=false, unique=false,length = 100)
    @Size(min = 10, max = 100)
    private String description;

    @Column(name="whereToAccess", nullable=false, unique=false,length = 100)
    @Size(min = 10, max = 100)
    private String whereToAccess;//could be a link if a website, could be a book name and a page number, could be
    // whatever you want, as long as it has instructions on how to access a specific revision recource

    @OneToMany(mappedBy = "revisionRecource")
    private Set<RoadmapRecources> roadmapRecources = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWhereToAccess() {
        return whereToAccess;
    }

    public void setWhereToAccess(String whereToAccess) {
        this.whereToAccess = whereToAccess;
    }
}
