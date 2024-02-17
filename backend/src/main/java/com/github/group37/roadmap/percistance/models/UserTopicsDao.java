package com.github.group37.roadmap.percistance.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;
@Entity
@Table(name = "user_topics", schema = "roadmap_project")
public class  UserTopicsDao {

    @Id
    @Column(name = "uuid", columnDefinition = "VARCHAR(36)", nullable = false, unique = true, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(name = "topic_id", columnDefinition = "VARCHAR(36)", nullable = false, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID topicId;

    @Column(name = "username", columnDefinition = "VARCHAR(50)", nullable = false, length = 50)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String username;

    @Column(name = "confidence_in_topic", columnDefinition = "VARCHAR(36)", nullable = false, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String confidenceInTopic;

    public UserTopicsDao(UUID id, UUID topicId, String username, String confidenceInTopic) {
        this.id = id;
        this.topicId = topicId;
        this.username = username;
        this.confidenceInTopic = confidenceInTopic;
    }

    public UserTopicsDao() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(UUID topicId) {
        this.topicId = topicId;
    }

    public String getConfidenceInTopic() {
        return confidenceInTopic;
    }

    public void setConfidenceInTopic(String confidenceInTopic) {
        this.confidenceInTopic = confidenceInTopic;
    }
}
