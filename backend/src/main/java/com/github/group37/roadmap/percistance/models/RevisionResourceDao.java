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
@Table(name = "revision_resource", schema = "roadmap_project")
public class RevisionResourceDao {
    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36)", nullable = false, unique = true, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(name = "topic", nullable = false, length = 100)
    @Size(min = 3, max = 20)
    private String topic;

    @Column(name = "resource_name", nullable = false, length = 100)
    @Size(min = 3, max = 20)
    private String resourceName;

    @Column(name = "description", nullable = false, length = 100)
    @Size(min = 10, max = 100)
    private String description;

    @Column(name = "where_to_access", nullable = false, length = 100)
    @Size(min = 10, max = 100)
    private String whereToAccess; // could be a link if a website, could be a book name and a page number, could be
    // whatever you want, as long as it has instructions on how to access a specific revision resource


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

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
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