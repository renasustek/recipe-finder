package com.github.group37.roadmap.percistance.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "roadmap_resources", schema = "roadmap_project")
public class Topic {
    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36)", nullable = false, unique = true, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(name = "subject", columnDefinition = "VARCHAR(36)", nullable = false, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID subject;

    @Column(name = "topic", columnDefinition = "VARCHAR(36)", nullable = false, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String topic;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSubject() {
        return subject;
    }

    public void setSubject(UUID subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
