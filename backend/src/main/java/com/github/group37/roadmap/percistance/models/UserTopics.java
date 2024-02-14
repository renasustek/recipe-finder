package com.github.group37.roadmap.percistance.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

public class UserTopics {
    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36)", nullable = false, unique = true, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(name = "topic_id", columnDefinition = "VARCHAR(36)", nullable = false, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID topicId;

    @Column(name = "confidence_in_topic", columnDefinition = "VARCHAR(36)", nullable = false, length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String confidenceInTopic;


}
