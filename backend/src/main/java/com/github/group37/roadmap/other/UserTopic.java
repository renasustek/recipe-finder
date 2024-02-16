package com.github.group37.roadmap.other;

import java.util.UUID;

public record UserTopic (UUID id, UUID topicId, String username, String confidenceInTopic){
}
